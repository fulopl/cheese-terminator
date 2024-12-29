package com.codecool.cheeseterminator.model.items;

import com.codecool.cheeseterminator.model.Cell;
import com.codecool.cheeseterminator.model.GameElement;
import com.codecool.cheeseterminator.model.GameElementType;
import com.codecool.cheeseterminator.model.player.Direction;

public abstract class Item extends GameElement {
    protected boolean collectable;
    protected Cell cell;

    public Item(GameElementType gameElementType, Cell cell) {
        super(gameElementType);
        this.cell = cell;
    }

    public abstract boolean handleItemEncounter(Direction direction);
}
