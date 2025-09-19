package com.fulopl.cheeseterminator.logic;

import com.fulopl.cheeseterminator.model.GameElement;
import com.fulopl.cheeseterminator.model.GameElementType;
import com.fulopl.cheeseterminator.model.GameMap;
import com.fulopl.cheeseterminator.model.item.Cheese;
import com.fulopl.cheeseterminator.ui.UI;

import java.util.Arrays;

public class GameLogic implements GameControl {
    private static final int STARTING_NUMBER_OF_LIVES = 3;
    public final int START_LEVEL = 40;
    public final int LAST_LEVEL = 50;
    private int level;
    private int lives;
    private String gamePhase;
    private GameMap map;
    private UI ui;
    private final InputManager inputManager;
    private int cheeseTotal = 1;
    private int cheeseInHole = 0;


    public GameLogic(UI ui, InputManager inputManager) {
        gamePhase = "welcome";
        this.ui = ui;
        this.inputManager = inputManager;
        inputManager.setGameControl(this);
    }

    public void init() {
        ui.initiateMainStage();
        initMap("/maps/welcome_screen.txt");
        setupScreen("Welcome to Cheese Terminator\n" +
                "Reborn!\n\n" +
                "Press SPACE to start the game!\n ");
    }

    public void initMap(String fileName) {
        map = MapLoader.createGameMapFromFile(fileName);
        inputManager.setHero(map.getHero());
    }

    public void setupScreen(String message) {
        ui.setUpScreen(map.getMapWidth(), map.getMapHeight());
        ui.refreshGameBoard(map.getCells());
        ui.setOnKeyPressed(inputManager.getKeyHandlers());
        ui.displayMessage(message);
    }

    public void setupLevel() {
        String filename = "/maps/level_" + level + ".txt";
        initMap(filename);
        setHearts();
        setupScreen("Push all the cheeses \nto the mouse holes!\n ");

        ui.setUpStatusDisplay();
        ui.displayLevel("LEVEL " + level);

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

    @Override
    public void retryLevel() {
        if (gamePhase.equals("level")) {
            if (--lives < 0) gameOver();
            else setupLevel();
        }
    }

    private void gameOver() {
        gamePhase = "gameover";
        initMap("/maps/gameover.txt");
        setupScreen("You have no more lives!\n\n" +
                "Game over!\n\n" +
                "Press 'SPACE' to start\n" +
                " a new game!\n ");
    }

    @Override
    public void checkLevelVictory() {
        if (gamePhase.equals("level") && cheeseTotal == cheeseInHole) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            gamePhase = "levelUp";
            initMap("/maps/levelup.txt");
            setupScreen("Congratulations!\n\nYou have completed LEVEL " + level
                    + "\n\nPress 'SPACE' to proceed!\n ");
        }
    }

    @Override
    public void refreshAfterKeyPress() {
        countCheeses();
        map.setCellTiles();
        ui.refreshGameBoard(map.getCells());
        refreshGameStatus();
    }

    @Override
    public void nextPhase() {
        switch (gamePhase) {
            case "welcome", "gameover" -> {
                gamePhase = "level";
                startNewGame();
            }
            case "levelUp" -> {
                if (level == LAST_LEVEL) {
                    gamePhase = "victory";
                    initMap("/maps/victory.txt");
                    setupScreen("You have won the game!\n\n" +
                            "Press SPACE to exit!\n ");
                } else {
                    gamePhase = "level";
                    level++;
                    setupLevel();
                }
            }
            case "victory" -> quit();
        }
    }

    private void startNewGame() {
        level = START_LEVEL;
        lives = STARTING_NUMBER_OF_LIVES;
        setupLevel();
    }

    @Override
    public void quit() {
        System.out.println("See ya soon!");
        System.exit(0);
    }
}
