package com.fulopl.cheeseterminator.model;

import com.fulopl.cheeseterminator.model.player.Hero;
import com.fulopl.cheeseterminator.ui.Tile;

public class GameMap {
    private final int mapWidth;
    private final int mapHeight;
    private final Cell[][] cells;
    private Hero hero;

    public GameMap(int mapWidth, int mapHeight) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        cells = new Cell[mapWidth][mapHeight];
        for (int x = 0; x < mapWidth; x++) {
            for (int y = 0; y < mapHeight; y++) {
                cells[x][y] = new Cell(this, x, y);
            }
        }
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Hero getHero() {
        return hero;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public void setCellTiles() {
        for (Cell[] columns : cells) {
            for (Cell cell :  columns) {
               cell.setTile();
            }
        }
    }
}
