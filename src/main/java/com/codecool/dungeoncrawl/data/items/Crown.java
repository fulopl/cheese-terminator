package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class Crown extends Item{
    public Crown(Cell cell) {
        super(cell, true, true);
    }

    @Override
    public String getTileName() {
        return "crown";
    }
}
