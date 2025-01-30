package com.fulopl.cheeseterminator.model.item;

import com.fulopl.cheeseterminator.model.Cell;
import com.fulopl.cheeseterminator.model.GameElement;
import com.fulopl.cheeseterminator.model.GameElementType;
import com.fulopl.cheeseterminator.model.player.Direction;

public abstract class Item extends GameElement {
    protected boolean collectable;
    protected Cell cell;

    public Item(GameElementType gameElementType, Cell cell) {
        super(gameElementType);
        this.cell = cell;
    }

    public abstract boolean handleItemEncounter(Direction direction);
}
