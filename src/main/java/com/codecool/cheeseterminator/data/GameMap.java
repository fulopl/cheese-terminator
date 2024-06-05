package com.codecool.cheeseterminator.data;

import com.codecool.cheeseterminator.data.player.Player;
import com.codecool.cheeseterminator.data.items.Cheese;

import java.util.Arrays;

public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;
    private Player player;
    private int cheeseNumber;

    public GameMap(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
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
