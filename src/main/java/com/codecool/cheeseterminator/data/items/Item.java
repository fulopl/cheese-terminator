package com.codecool.cheeseterminator.data.items;

import com.codecool.cheeseterminator.data.Cell;
import com.codecool.cheeseterminator.data.Drawable;

public abstract class Item implements Drawable {
    protected Cell cell;
    private final boolean passable;
    private boolean collectable;

    public Item(Cell cell, boolean passable, boolean collectable) {
        this.cell = cell;
        this.passable = passable;
        this.collectable = collectable;
        this.cell.setItem(this);
    }

    public boolean isPassable() {
        return passable;
    }

    public boolean getCollectable() {
        return collectable;
    }

}
