package com.codecool.cheeseterminator.data.player;

import com.codecool.cheeseterminator.data.Cell;
import com.codecool.cheeseterminator.data.Drawable;
import com.codecool.cheeseterminator.data.items.Cheese;
import com.codecool.cheeseterminator.data.items.Item;
import com.codecool.cheeseterminator.ui.TileType;

public class Hero implements Drawable {
    private Cell cell;
    private Direction direction;
    private TileType tileType;

    public Hero(Cell cell, TileType tileType) {
        this.cell = cell;
        this.tileType = tileType;
        this.cell.setPlayer(this);
        direction = Direction.EAST;
    }

    @Override
    public String getTileName() {
        return tileType.getTileName();
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        Item item = nextCell.getItem();
        boolean allowToMove = true;
        if (item != null) {
            allowToMove = handleItemEncounter(item, nextCell, dx, dy);
        }
        if (allowToMove) {
            if (nextCell.getType().isPassable()) {
                cell.setPlayer(null);
                nextCell.setPlayer(this);
                cell = nextCell;
            }
        }
    }

    public boolean handleItemEncounter(Item item, Cell nextCell, int dx, int dy) {
        if (item instanceof Cheese) return ((Cheese) item).move(nextCell, dx, dy);
        return false;
    }
}
