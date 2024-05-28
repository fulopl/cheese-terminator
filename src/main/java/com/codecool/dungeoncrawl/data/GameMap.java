package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.Player;

import java.util.List;

public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;
    private List<Actor> enemyList;
    private Player player;

    public GameMap(int width, int height, CellType defaultCellType, List<Actor> enemyList) {
        this.width = width;
        this.height = height;
        this.enemyList = enemyList;
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, x, y, defaultCellType);
            }
        }
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Actor> getEnemyList() {
        return enemyList;
    }
}
