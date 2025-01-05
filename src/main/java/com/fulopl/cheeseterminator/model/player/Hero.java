package com.fulopl.cheeseterminator.model.player;

import com.fulopl.cheeseterminator.model.Cell;
import com.fulopl.cheeseterminator.model.GameElement;
import com.fulopl.cheeseterminator.model.GameElementType;
import com.fulopl.cheeseterminator.model.item.Item;

public class Hero extends GameElement{
    private Direction direction;
    private Cell cell;

    public Hero(GameElementType gameElementType, Cell cell) {
        super(gameElementType);
        this.cell = cell;
        this.direction = Direction.EAST;
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
                cell.setHero(null);
                nextCell.setHero(this);
                cell = nextCell;
            }
        }
    }
}
