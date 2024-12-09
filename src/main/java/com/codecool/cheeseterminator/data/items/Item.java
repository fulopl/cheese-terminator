package com.codecool.cheeseterminator.data.items;

import com.codecool.cheeseterminator.data.Cell;
import com.codecool.cheeseterminator.data.Drawable;
import com.codecool.cheeseterminator.data.GameElement;
import com.codecool.cheeseterminator.data.GameElementType;
import com.codecool.cheeseterminator.ui.Tile;

public abstract class Item extends GameElement {
    protected boolean collectable;

    public Item(GameElementType gameElementType) {
        super(gameElementType);
    }
}
