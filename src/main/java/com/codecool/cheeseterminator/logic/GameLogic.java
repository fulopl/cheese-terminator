package com.codecool.cheeseterminator.logic;

import com.codecool.cheeseterminator.model.GameMap;
import com.codecool.cheeseterminator.model.items.Cheese;
import com.codecool.cheeseterminator.ui.UI;

public class GameLogic {
    public static final int START_LEVEL = 4;
    public static final int LAST_LEVEL = 5;
    private int level;
    private String gamePhase;
    private GameMap map;
    private UI ui;
    private final InputManager inputManager;


    public GameLogic(UI ui, InputManager inputManager) {
        level = START_LEVEL;
        gamePhase = "welcome";
        this.ui = ui;
        this.inputManager = inputManager;
        inputManager.setGameLogic(this);
    }

    public void init() {
        ui.initiateMainStage();
        setupScreen("/welcome.txt", "Welcome to Cheese Terminator\n" +
                "In The Dungeon!\n\n" +
                "Press SPACE to start the game!\n ");
    }

    public void setupScreen(String fileName, String message) {
        map = MapLoader.createGameMapFromFile(fileName);
        ui.setUpScreen(map.getMapWidth(), map.getMapHeight());
        ui.refreshGameBoard(map.getCells());
        inputManager.setMap(map);
        ui.setOnKeyPressed(inputManager.getKeyHandlers());
        ui.displayMessage(message);
    }

    public void setupLevel() {
        String filename = "/level_" + level + ".txt";
        setupScreen(filename, "Push all the cheeses \nto the mouse holes!\n ");

        ui.setUpStatusDisplay();
        ui.displayLevel("LEVEL " + level);

        refreshGameStatus();
    }

    private void refreshGameStatus() {
        ui.displayLevelStatus(Cheese.getCheeseTotal(), Cheese.getCheeseTotal() - Cheese.getCheeseInHole());
    }

    public UI getUi() {
        return ui;
    }

    public void setUi(UI ui) {
        this.ui = ui;
    }

    public void refreshAfterKeyPress() {
        if (Cheese.getCheeseTotal() == Cheese.getCheeseInHole()) {
            gamePhase = "levelUp";
            ui.displayMessage("Congratulations!\n\nYou have completed LEVEL " + level
                    + "\n\nPress 'SPACE' to proceed!\n ");
        }
        map.setCellTiles();
        ui.refreshGameBoard(map.getCells());
        refreshGameStatus();
    }

    private void nextLevel() {
        level++;
        setupLevel();
    }

    public void nextPhase() {
        if (gamePhase.equals("welcome")) {
            gamePhase = "level";
            setupLevel();
        } else if (gamePhase.equals("levelUp")) {
            if (level == LAST_LEVEL) {
                gamePhase = "victory";
                setupScreen("/victory.txt", "You have won the game!\n\n" +
                        "Press SPACE to exit!\n ");
            } else {
                gamePhase = "level";
                nextLevel();
            }
        } else if (gamePhase.equals("victory")) {
            quit();
        }
    }

    public void quit() {
        System.out.println("See ya soon!");
        System.exit(0);
    }


}
