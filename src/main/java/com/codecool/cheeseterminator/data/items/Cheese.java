package com.codecool.cheeseterminator.data.items;

import com.codecool.cheeseterminator.data.Cell;
import com.codecool.cheeseterminator.ui.Tile;

public class Cheese extends Item {
    public Cheese(Cell cell) {
        super(cell, true, false, Tile.CHEESE);
    }


    public boolean move(Cell nextCell, int dx, int dy) {
        Cell nextCellToCheese = nextCell.getNeighbor(dx, dy);
        if (nextCellToCheese.getType().isPassable()
                && nextCellToCheese.getItem() == null) {
            nextCellToCheese.setItem(this);
            nextCell.setItem(null);
            cell = nextCellToCheese;
            return true;
        }
        return false;
    }

    public boolean isOnHole() {
        return cell.getType() == Tile.HOLE;
    }
}
