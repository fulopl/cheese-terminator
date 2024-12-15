package com.codecool.cheeseterminator.logic;

import com.codecool.cheeseterminator.data.Cell;
import com.codecool.cheeseterminator.data.GameMap;
import com.codecool.cheeseterminator.data.items.Cheese;
import com.codecool.cheeseterminator.ui.UI;

public class GameLogic {
    public static final int START_LEVEL = 1;
    public static final int LAST_LEVEL = 3;
    private int level;
    private boolean levelUp = false;
    private String gamePhase;
    private GameMap map;
    private UI ui;
    private InputManager inputManager;


    public GameLogic(UI ui, InputManager inputManager) {
        level = START_LEVEL;
        gamePhase = "welcome";
        this.ui = ui;
        this.inputManager = inputManager;
    }

    public void initiate() {
        map = MapLoader.createGameMapFromFile("/welcome.txt");
        ui.initiateMainStage(map.getMapWidth(), map.getMapHeight());
        ui.refreshGameBoard(map.getCells());
        inputManager.setMap(map);
        ui.setOnKeyPressed(inputManager.getKeyHandlers());
        ui.displayMessage("Welcome to Cheese Terminator!\n\n" +
                "Press SPACE to start the game!\n ");
    }

    public void setupLevel() {
        String filename = "/level_" + level + ".txt";
        map = MapLoader.createGameMapFromFile(filename);
        ui.setUpScreen(map.getMapWidth(), map.getMapHeight());
        ui.setUpStatusDisplay();
        ui.refreshGameBoard(map.getCells());
        inputManager.setMap(map);
        ui.setOnKeyPressed(inputManager.getKeyHandlers());
        ui.displayMessage("Push all the cheeses \nto the mouse holes!\n ");
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

    public double getMapWidth() {
        return map.getMapWidth();
    }

    public double getMapHeight() {
        return map.getMapHeight();
    }

    public Cell getCell(int x, int y) {
        return map.getCell(x, y);
    }

    public int getLevel() {
        return level;
    }

    public boolean isLevelUp() {
        return levelUp;
    }


    private void winScreen() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        map = MapLoader.createGameMapFromFile("/win.txt");
    }

    public GameMap getMap() {
        return map;
    }

    public void setMap(GameMap map) {
        this.map = map;
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
            gamePhase = "level";
            nextLevel();
        }
    }

    public void quit() {
        System.out.println("See ya soon!");
        System.exit(0);
    }
}
