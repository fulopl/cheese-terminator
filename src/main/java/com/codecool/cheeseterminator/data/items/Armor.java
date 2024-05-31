package com.codecool.cheeseterminator.data.items;

import com.codecool.cheeseterminator.data.Cell;

public class Armor extends Item{
    private final int healthBonus;
    public Armor(Cell cell) {
        super(cell, true, true);
        healthBonus = 20;
    }
    @Override
    public String getTileName() {
        return "armor";
    }

    public int getHealthBonus() {
        return this.healthBonus;
    }
}
