package com.codecool.cheeseterminator.model.items;

import com.codecool.cheeseterminator.model.Cell;
import com.codecool.cheeseterminator.model.GameElementType;
import com.codecool.cheeseterminator.model.player.Direction;

public class Cheese extends Item {
    private static int cheeseTotal = 0;
    private static int cheeseInHole = 0;

    private boolean inHole = false;

    public Cheese(GameElementType gameElementType, Cell cell) {
        super(gameElementType, cell);
        cheeseTotal++;
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
            if (!inHole && isInHole()) {
                cheeseInHole++;
                inHole = true;
            }
            else if (inHole && !isInHole()) {
                cheeseInHole--;
                inHole = false;
            }
            return true;
        }
        return false;
    }

    public boolean isInHole() {
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
