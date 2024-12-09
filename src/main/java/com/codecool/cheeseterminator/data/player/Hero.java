package com.codecool.cheeseterminator.data.player;

import com.codecool.cheeseterminator.data.Cell;
import com.codecool.cheeseterminator.data.GameElement;
import com.codecool.cheeseterminator.data.GameElementType;
import com.codecool.cheeseterminator.data.items.Cheese;
import com.codecool.cheeseterminator.data.items.Item;

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
