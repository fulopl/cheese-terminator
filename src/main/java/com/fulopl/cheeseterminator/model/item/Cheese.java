package com.fulopl.cheeseterminator.model.item;

import com.fulopl.cheeseterminator.model.Cell;
import com.fulopl.cheeseterminator.model.GameElementType;
import com.fulopl.cheeseterminator.model.player.Direction;
import com.fulopl.cheeseterminator.ui.Tile;

public class Cheese extends Item {

    private boolean inHole;

    public Cheese(GameElementType gameElementType, Cell cell, boolean inHole) {
        super(gameElementType, cell);
        this.inHole = inHole;
        if (inHole) {
            tile = Tile.CHEESE_ON_HOLE;
        }
    }

    public boolean move(Direction direction) {
        Cell nextCell = cell.getNeighbor(direction.getDx(), direction.getDy());
        if (nextCell.isPassable() && nextCell.getItem() == null) {
            cell.setItem(null);
            nextCell.setItem(this);
            cell = nextCell;
            if (!inHole && isStructureHole()) {
                inHole = true;
                setTile(Tile.CHEESE_ON_HOLE);
            }
            else if (inHole && !isStructureHole()) {
                inHole = false;
                setTile(Tile.CHEESE);
            }
            return true;
        }
        return false;
    }

    public boolean isStructureHole() {
        return cell.getStructure().getGameElementType() == GameElementType.HOLE;
    }

    public boolean isInHole() {
        return inHole;
    }

    @Override
    public boolean handleItemEncounter(Direction direction) {
        return move(direction);
    }
}
