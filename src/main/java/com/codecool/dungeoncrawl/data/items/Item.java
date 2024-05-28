package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;

public abstract class Item implements Drawable {
    private Cell cell;
    private final boolean passable;
    private boolean collectable;

    public Item(Cell cell, boolean passable, boolean collectable) {
        this.cell = cell;
        this.passable = passable;
        this.collectable = collectable;
        this.cell.setItem(this);
    }

    public boolean getPassable() {
        return passable;
    }

    public boolean getCollectable() {
        return collectable;
    }
}
