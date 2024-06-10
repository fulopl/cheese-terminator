package com.codecool.cheeseterminator.data.items;

import com.codecool.cheeseterminator.data.Cell;
import com.codecool.cheeseterminator.data.Drawable;
import com.codecool.cheeseterminator.ui.TileType;

public abstract class Item implements Drawable {
    protected Cell cell;
    protected TileType tileType;
    private final boolean passable;
    private boolean collectable;

    public Item(Cell cell, boolean passable, boolean collectable, TileType tileType) {
        this.cell = cell;
        this.passable = passable;
        this.collectable = collectable;
        this.cell.setItem(this);
        this.tileType = tileType;
    }

    public boolean isPassable() {
        return passable;
    }

    public boolean getCollectable() {
        return collectable;
    }

    @Override
    public String getTileName() {
        return tileType.getTileName();
    }
}
