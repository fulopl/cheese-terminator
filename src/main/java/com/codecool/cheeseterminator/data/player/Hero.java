package com.codecool.cheeseterminator.data.player;

import com.codecool.cheeseterminator.data.Cell;
import com.codecool.cheeseterminator.data.GameElement;
import com.codecool.cheeseterminator.data.GameElementType;
import com.codecool.cheeseterminator.data.items.Cheese;
import com.codecool.cheeseterminator.data.items.Item;

public class Hero extends GameElement{
    private Direction direction;

    public Hero(GameElementType gameElementType) {
        super(gameElementType);
        this.direction = Direction.EAST;
    }

//    public Hero(Cell cell, Tile tile) {
//        this.cell = cell;
//        this.tile = tile;
//        this.cell.setPlayer(this);
//        direction = Direction.EAST;
//    }


    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        Item item = nextCell.getItem();
        boolean allowToMove = true;
        if (item != null) {
            allowToMove = handleItemEncounter(item, nextCell, dx, dy);
        }
        if (allowToMove) {
            if (nextCell.getTile().isPassable()) {
                cell.setHero(null);
                nextCell.setHero(this);
                cell = nextCell;
            }
        }
    }

    public boolean handleItemEncounter(Item item, Cell nextCell, int dx, int dy) {
        if (item instanceof Cheese) return ((Cheese) item).move(nextCell, dx, dy);
        return false;
    }
}
