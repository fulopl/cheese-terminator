package com.codecool.cheeseterminator.logic;

import com.codecool.cheeseterminator.data.Cell;
import com.codecool.cheeseterminator.data.CellType;
import com.codecool.cheeseterminator.data.GameMap;
import com.codecool.cheeseterminator.data.actors.Player;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class GameLogic {
    private GameMap map;
    private int level;
    private long numberOfCheese;
    private long numberOfCheeseScored;
    private boolean levelUp = false;

    public GameLogic() {
        this.map = MapLoader.createGameMapFromFile("/level_1.txt");
        level = 1;
    }

    public double getMapWidth() {
        return map.getWidth();
    }

    public double getMapHeight() {
        return map.getHeight();
    }

    public Cell getCell(int x, int y) {
        return map.getCell(x, y);
    }

    public int getLevel() {
        return level;
    }

    public long getNumberOfCheese() {
        return numberOfCheese;
    }

    public long getNumberOfCheeseScored() {
        return numberOfCheeseScored;
    }

    public boolean isLevelUp() {
        return levelUp;
    }

    private boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < getMapWidth() && y >= 0 && y < getMapHeight();
    }

    public void setupLevel() {
        String filename = "/level_" + level + ".txt";
        map = MapLoader.createGameMapFromFile(filename);
        numberOfCheese = map.getCheeseNumber();
        numberOfCheeseScored = 0;
    }

    public void checkForRestart() {
        Player player = map.getPlayer();
        CellType cellType = player.getCell().getType();
    }


    public void getWin() {
        if (map.getPlayer().getItem("crown") != null) {
            winScreen();
        }
    }


    private void deadScreen() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        map = MapLoader.createGameMapFromFile("/dead.txt");
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

    public void checkForLoadSave() {
        Player player = map.getPlayer();
        Cell playerCell = player.getCell();
        CellType cellType = playerCell.getType();
    }

    public void doChecksAfterKeypress(KeyEvent keyEvent) {
        numberOfCheeseScored = map.getNumberOfCheeseScored();
        if (numberOfCheeseScored == numberOfCheese) levelUp = true;
        if (keyEvent.getCode().equals(KeyCode.SPACE) && levelUp) nextLevel();
    }

    private void nextLevel() {
        level++;
        levelUp = false;
        setupLevel();
    }


}
