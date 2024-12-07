package com.codecool.cheeseterminator.data.items;

import com.codecool.cheeseterminator.data.Cell;
import com.codecool.cheeseterminator.data.Drawable;
import com.codecool.cheeseterminator.ui.Tile;

public abstract class Item implements Drawable {
    protected Cell cell;
    protected Tile tile;
    private final boolean passable;
    private boolean collectable;

    public Item(Cell cell, boolean passable, boolean collectable, Tile tile) {
        this.cell = cell;
        this.passable = passable;
        this.collectable = collectable;
        this.cell.setItem(this);
        this.tile = tile;
    }

    public boolean isPassable() {
        return passable;
    }

    public boolean getCollectable() {
        return collectable;
    }

    @Override
    public Tile getTile() {
        return tile;
    }
}
