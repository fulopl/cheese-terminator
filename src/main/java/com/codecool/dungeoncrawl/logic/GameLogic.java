package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.Player;

import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    private GameMap map;
    List<Actor> encounteredEnemies;
    private boolean monsterKilled = false;
    private boolean gameSaved = false;
    private boolean gameLoaded = false;

    public GameLogic() {
        this.map = MapLoader.createGameMapFromFile("/map.txt");
        encounteredEnemies = new ArrayList<>();
    }

    public double getMapWidth() {
        return map.getWidth();
    }

    public void setup() {
    }

    public double getMapHeight() {
        return map.getHeight();
    }

    public Cell getCell(int x, int y) {
        return map.getCell(x, y);
    }

    public String getPlayerHealth() {
        return Integer.toString(map.getPlayer().getHealth());
    }

    public String getPlayerDamage() {
        return Integer.toString(map.getPlayer().getBaseAttack());
    }

    public String getEnemyHealth() {
        if (!encounteredEnemies.isEmpty()) {
            return Integer.toString(encounteredEnemies.get(0).getHealth());
        }
        return null;
    }

    public String getEnemyDamage() {
        if (!encounteredEnemies.isEmpty()) {
            return Integer.toString(encounteredEnemies.get(0).getBaseAttack());
        }
        return null;
    }

    public String getPlayerInventory() {
        return map.getPlayer().getInventory();
    }


    private boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < getMapWidth() && y >= 0 && y < getMapHeight();
    }

    public void checkForRestart() {
        Player player = map.getPlayer();
        CellType cellType = player.getCell().getType();
    }





    public boolean checkMonsterKilled() {
        if (monsterKilled) {
            monsterKilled = false;
            return true;
        }
        return false;
    }

    public void getWin() {
        if (map.getPlayer().getItem("crown") != null) {
            winScreen();
        }
    }


    private void reloadMapAfterDelay() {
        deadScreen();

        //reloadMap();
    }

    public void onPlayerDeath(Player player) {
        if (player.isDead()) {
            reloadMapAfterDelay();
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
        gameSaved = false;
        gameLoaded = false;
        Player player = map.getPlayer();
        Cell playerCell = player.getCell();
        CellType cellType = playerCell.getType();
    }

    public boolean isGameSaved() {
        return gameSaved;
    }

    public boolean isGameLoaded() {
        return gameLoaded;
    }
}
