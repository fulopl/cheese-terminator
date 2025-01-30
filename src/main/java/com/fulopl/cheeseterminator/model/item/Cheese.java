package com.fulopl.cheeseterminator.model.item;

import com.fulopl.cheeseterminator.model.Cell;
import com.fulopl.cheeseterminator.model.GameElementType;
import com.fulopl.cheeseterminator.model.player.Direction;
import com.fulopl.cheeseterminator.ui.Tile;

public class Cheese extends Item {
    private static int cheeseTotal = 0;
    private static int cheeseInHole = 0;

    private boolean inHole;

    public Cheese(GameElementType gameElementType, Cell cell, boolean inHole) {
        super(gameElementType, cell);
        cheeseTotal++;
        this.inHole = inHole;
        if (inHole) {
            cheeseInHole++;
            setTile(Tile.CHEESE_ON_HOLE);
        }
    }

    public static void reset() {
        cheeseTotal = 0;
        cheeseInHole = 0;
    }

    public boolean move(Direction direction) {
        Cell nextCell = cell.getNeighbor(direction.getDx(), direction.getDy());
        if (nextCell.isPassable() && nextCell.getItem() == null) {
            cell.setItem(null);
            nextCell.setItem(this);
            cell = nextCell;
            if (!inHole && isStructureHole()) {
                cheeseInHole++;
                inHole = true;
                setTile(Tile.CHEESE_ON_HOLE);
            }
            else if (inHole && !isStructureHole()) {
                cheeseInHole--;
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

    public static int getCheeseTotal() {
        return cheeseTotal;
    }

    public static int getCheeseInHole() {
        return cheeseInHole;
    }

    @Override
    public boolean handleItemEncounter(Direction direction) {
        return move(direction);
    }
}
