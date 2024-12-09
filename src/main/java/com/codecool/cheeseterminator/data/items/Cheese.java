package com.codecool.cheeseterminator.data.items;

import com.codecool.cheeseterminator.data.Cell;
import com.codecool.cheeseterminator.data.GameElementType;
import com.codecool.cheeseterminator.ui.Tile;

public class Cheese extends Item {


    public Cheese(GameElementType gameElementType) {
        super(gameElementType);
    }

    public boolean move(Cell nextCell, int dx, int dy) {
        Cell nextCellToCheese = nextCell.getNeighbor(dx, dy);
        if (nextCellToCheese.getTile().isPassable()
                && nextCellToCheese.getItem() == null) {
            nextCellToCheese.setItem(this);
            nextCell.setItem(null);
            cell = nextCellToCheese;
            return true;
        }
        return false;
    }

    public boolean isOnHole() {
        return cell.getTile() == Tile.HOLE;
    }
}
