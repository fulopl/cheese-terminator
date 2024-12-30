package com.codecool.cheeseterminator.model.player;

import com.codecool.cheeseterminator.model.Cell;
import com.codecool.cheeseterminator.model.GameElement;
import com.codecool.cheeseterminator.model.GameElementType;
import com.codecool.cheeseterminator.model.item.Item;

public class Hero extends GameElement{
    private Direction direction;
    private Cell cell;

    public Hero(GameElementType gameElementType, Cell cell) {
        super(gameElementType);
        this.cell = cell;
        this.direction = Direction.EAST;
    }

//    public Hero(Cell cell, Tile tile) {
//        this.tile = tile;
//        this.cell.setPlayer(this);
//        direction = Direction.EAST;
//    }


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
