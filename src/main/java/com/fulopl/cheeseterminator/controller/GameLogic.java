package com.fulopl.cheeseterminator.controller;

import com.fulopl.cheeseterminator.model.GameElement;
import com.fulopl.cheeseterminator.model.GameElementType;
import com.fulopl.cheeseterminator.model.GameMap;
import com.fulopl.cheeseterminator.model.item.Cheese;
import com.fulopl.cheeseterminator.model.player.Direction;
import com.fulopl.cheeseterminator.ui.UI;

import java.util.Arrays;

public class GameLogic {
    private static final int STARTING_NUMBER_OF_LIVES = 3;
    private final int FIRST_LEVEL = 1;
    private final int LAST_LEVEL = 50;

    private UI ui;
    private final InputManager inputManager;
    private final GameType gameType;
    private int actualLevel;
    private GameMap map;

    private int lives;
    private String gamePhase;
    private int cheeseTotal = 1;
    private int cheeseInHole = 0;


    public GameLogic(UI ui, InputManager inputManager, GameType gameType, int actualLevel) {
        this.ui = ui;
        this.inputManager = inputManager;
        this.gameType = gameType;
        this.actualLevel = actualLevel;
        setupLevel();

    }

    public void initMap(String fileName) {
        map = MapLoader.createGameMapFromFile(fileName);
        inputManager.setHero(map.getHero());
    }

    public void setupScreen(String message) {
        ui.initGameScreen(map.getMapWidth(), map.getMapHeight());
        ui.refreshGameBoard(map.getCells());
        ui.displayMessage(message);
    }

    public void setupLevel() {
        String filename = "/maps/level_" + actualLevel + ".txt";
        initMap(filename);
        setHearts();
        setupScreen("Push all the cheeses \nto the red mouse holes!\n ");

        ui.setUpStatusDisplay();
        ui.displayLevel("LEVEL " + actualLevel);

        countCheeses();
        refreshGameStatus();
    }

    private void setHearts() {
        for (int i = 1; i <= 3; i++) {
            if (lives >= i) {
                map.getCell(i - 1, 0).setStructure(new GameElement(GameElementType.HEART));
            } else {
                map.getCell(i - 1, 0).setStructure(new GameElement(GameElementType.WALL));
            }
        }
        map.setCellTiles();
    }

    private void countCheeses() {
        cheeseTotal = 0;
        cheeseInHole = 0;
        Arrays.stream(map.getCells())
                .flatMap(cells -> Arrays.stream(cells)
                        .filter(cell -> cell.getItem() != null && cell.getItem().getGameElementType() == GameElementType.CHEESE))
                .forEach(cell -> {
                    cheeseTotal++;
                    if (((Cheese) cell.getItem()).isInHole()) cheeseInHole++;
                });
    }

    private void refreshGameStatus() {
        ui.displayLevelStatus(cheeseTotal, cheeseTotal - cheeseInHole);
    }

    public UI getUi() {
        return ui;
    }

    public void setUi(UI ui) {
        this.ui = ui;
    }

    public void checkLevelVictory() {
        if (cheeseTotal == cheeseInHole) {
            if (gameType.equals(GameType.NORMAL_GAME)) {
                ui.displayMessage("Congratulations!\n\nYou have completed LEVEL " + actualLevel
                        + "\n\nPress 'SPACE' to proceed!\n ");
                actualLevel++;
                inputManager.setSpaceKeyMap(()->{
                    inputManager.setGameKeyMap();
                    setupLevel();
                });
            } else {
                ui.displayMessage("Congratulations!\n\nYou have completed LEVEL " + actualLevel
                        + "\n\nPress 'SPACE' to quit to main menu!\n ");
                inputManager.setSpaceKeyMap(inputManager::onQuitToMain);
            }
        }
    }

    public void refreshAfterKeyPress() {
        countCheeses();
        map.setCellTiles();
        ui.refreshGameBoard(map.getCells());
        refreshGameStatus();
    }

    public void nextPhase() {
        switch (gamePhase) {
            case "welcome", "gameover" -> {
                gamePhase = "level";
                startNewGame();
            }
            case "levelUp" -> {
                if (actualLevel == LAST_LEVEL) {
                    gamePhase = "victory";
                    initMap("/maps/victory.txt");
                    setupScreen("You have won the game!\n\n" +
                            "Press SPACE to exit!\n ");
                } else {
                    gamePhase = "level";
                    actualLevel++;
                    setupLevel();
                }
            }
            case "victory" -> quit();
        }
    }

    private void startNewGame() {
        actualLevel = FIRST_LEVEL;
        lives = STARTING_NUMBER_OF_LIVES;
        setupLevel();
    }

    public void quit() {
        System.out.println("See ya soon!");
        System.exit(0);
    }

    public void moveHero(Direction direction) {
        map.getHero().move(direction);
        refreshAfterKeyPress();
    }

    public void undoMove() {
        map.getHero().undo();
        refreshAfterKeyPress();
    }

    public void handleRetry() {
        setupLevel();
    }

    public GameType getGameType() {
        return gameType;
    }

    public int getActualLevel() {
        return actualLevel;
    }
}
