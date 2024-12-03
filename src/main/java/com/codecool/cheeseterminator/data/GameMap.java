package com.codecool.cheeseterminator.data;

import com.codecool.cheeseterminator.data.player.Hero;
import com.codecool.cheeseterminator.data.items.Cheese;
import com.codecool.cheeseterminator.ui.TileType;

import java.util.Arrays;

public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;
    private Hero hero;
    private int cheeseNumber;

    public GameMap(int width, int height, TileType defaultTileType) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, x, y, defaultTileType);
            }
        }
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void setPlayer(Hero hero) {
        this.hero = hero;
    }

    public Hero getPlayer() {
        return hero;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void incrementCheeseNumber() {
        cheeseNumber++;
    }

    public int getCheeseNumber() {
        return cheeseNumber;
    }

    public long getNumberOfCheeseScored() {
        return Arrays.stream(cells)
                .flatMap(Arrays::stream)
                .map(Cell::getItem)
                .filter(item -> item instanceof Cheese && ((Cheese) item).isOnHole())
                .count();
    }
}
