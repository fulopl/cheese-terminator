package com.codecool.cheeseterminator.data.items;

import com.codecool.cheeseterminator.data.Cell;

public class Crown extends Item{
    public Crown(Cell cell) {
        super(cell, true, true);
    }

    @Override
    public String getTileName() {
        return "crown";
    }
}
