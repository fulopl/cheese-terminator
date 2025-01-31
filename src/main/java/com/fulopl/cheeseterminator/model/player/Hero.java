package com.fulopl.cheeseterminator.model.player;

import com.fulopl.cheeseterminator.model.Cell;
import com.fulopl.cheeseterminator.model.GameElement;
import com.fulopl.cheeseterminator.model.GameElementType;
import com.fulopl.cheeseterminator.model.item.Item;
import com.fulopl.cheeseterminator.ui.Tile;

public class Hero extends GameElement{
    private Cell cell;


    public Hero(GameElementType gameElementType, Cell cell) {
        super(gameElementType);
        this.cell = cell;
    }

    public void move(Direction movingDirection) {
        Cell nextCell = cell.getNeighbor(movingDirection.getDx(), movingDirection.getDy());
        setDirection(movingDirection);
        Item item = nextCell.getItem();
        boolean allowToMove = true;
        if (item != null) {
            allowToMove = item.handleItemEncounter(movingDirection);
        }
        if (allowToMove) {
            if (nextCell.isPassable()) {
                cell.setHero(null);
                nextCell.setHero(this);
                cell = nextCell;
            }
        }
    }

    private void setDirection(Direction movingDirection) {
        switch (movingDirection) {
            case WEST -> tile = Tile.MOUSE_WEST;
            case SOUTH -> setTile(Tile.MOUSE_SOUTH);  // TODO and so on...
            case EAST -> setTile(Tile.MOUSE_EAST);
            case NORTH -> setTile(Tile.MOUSE_NORTH);
        }
    }
}
