package com.codecool.cheeseterminator.model;

import com.codecool.cheeseterminator.model.player.Hero;
import com.codecool.cheeseterminator.ui.Tile;

import java.util.ArrayList;
import java.util.List;

public class GameMap {
    private final int mapWidth;
    private final int mapHeight;
    private final Cell[][] cells;
    private Hero hero;

    public GameMap(int mapWidth, int mapHeight, Tile defaultTile) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        cells = new Cell[mapWidth][mapHeight];
        for (int x = 0; x < mapWidth; x++) {
            for (int y = 0; y < mapHeight; y++) {
                cells[x][y] = new Cell(this, x, y, defaultTile);
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
        for (int x = 0; x < mapWidth; x++) {
            for (int y = 0; y < mapHeight; y++) {
                if (cells[x][y].getHero() != null) {
                    cells[x][y].setTile(cells[x][y].getHero().getTile());
                } else if (cells[x][y].getItem() != null) {
                    cells[x][y].setTile(cells[x][y].getItem().getTile());
                } else cells[x][y].setTile(cells[x][y].getStructure().getTile());
            }
        }
    }
}
