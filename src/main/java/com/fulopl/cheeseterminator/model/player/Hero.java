package com.fulopl.cheeseterminator.model.player;

import com.fulopl.cheeseterminator.model.Cell;
import com.fulopl.cheeseterminator.model.GameElement;
import com.fulopl.cheeseterminator.model.GameElementType;
import com.fulopl.cheeseterminator.model.item.Item;
import com.fulopl.cheeseterminator.ui.Tile;

public class Hero extends GameElement {
    private Cell cell;
    private int tailPosition;

    public Hero(GameElementType gameElementType, Cell cell) {
        super(gameElementType);
        this.cell = cell;
        tailPosition = 0;
    }

    public void move(Direction movingDirection) {
        Cell nextCell = cell.getNeighbor(movingDirection.getDx(), movingDirection.getDy());
        Item item = nextCell.getItem();
        boolean allowToMove = true;
        if (item != null) {
            allowToMove = item.handleItemEncounter(movingDirection);
        }
        if (allowToMove) {
            if (nextCell.isPassable()) {
                setNextTailPosition();
                setTile(movingDirection);
                cell.setHero(null);
                nextCell.setHero(this);
                cell = nextCell;
            }
        }
    }

    private void setTile(Direction movingDirection) {
        switch (movingDirection) {
            case WEST -> tile = tailPosition == 1 ? Tile.MOUSE_WEST_TL : Tile.MOUSE_WEST_TR;
            case SOUTH -> tile = tailPosition == 1 ? Tile.MOUSE_SOUTH_TL : Tile.MOUSE_SOUTH_TR;
            case EAST -> tile = tailPosition == 1 ? Tile.MOUSE_EAST_TL : Tile.MOUSE_EAST_TR;
            case NORTH -> tile = tailPosition == 1 ? Tile.MOUSE_NORTH_TL : Tile.MOUSE_NORTH_TR;
        }
    }

    private void setNextTailPosition() {
        if (tailPosition == 1) tailPosition = 0;
        else tailPosition = 1;
    }
}
