package com.codecool.cheeseterminator.logic;

import com.codecool.cheeseterminator.data.Cell;
import com.codecool.cheeseterminator.data.GameMap;
import com.codecool.cheeseterminator.data.items.Cheese;
import com.codecool.cheeseterminator.ui.UI;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class GameLogic {
    private int level;
    private boolean levelUp = false;
    private GameMap map;
    private UI ui;


    public GameLogic(UI ui) {
        level = 1;
        this.ui = ui;
    }

    public void initiate() {
        map = MapLoader.createGameMapFromFile("/welcome.txt");
        ui.initiateMainStage(map.getMapWidth(), map.getMapHeight());
        ui.displayMessage("Welcome to Cheese Terminator!\n\n" +
                "Press SPACE to start the game!\n ");
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

    public void setupLevel() {
        String filename = "/level_" + level + ".txt";
        map = MapLoader.createGameMapFromFile(filename);
        ui.setUpPane();
    }

    public void setupWelcomeScreen() {
        map = MapLoader.createGameMapFromFile("/welcome.txt");
        ui.setUpPane();
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


    public void doChecksAfterKeypress(KeyEvent keyEvent) {
        if (Cheese.getCheeseTotal() == Cheese.getCheeseInHole()) levelUp = true;
        if (keyEvent.getCode().equals(KeyCode.SPACE) && levelUp) nextLevel();
        else if (keyEvent.getCode().equals(KeyCode.R)) setupLevel();
        else if (keyEvent.getCode().equals(KeyCode.Q)) {
            System.out.println("See ya soon!");
            System.exit(0);
        }
    }

    private void nextLevel() {
        level++;
        levelUp = false;
        setupLevel();
    }


}
