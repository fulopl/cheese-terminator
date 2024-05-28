package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class Helmet extends Item{
    private final int healthBonus;
    private final int attackBonus;
    public Helmet(Cell cell) {
        super(cell, true, true);
        healthBonus = 15;
        attackBonus=5;
    }
    @Override
    public String getTileName() {
        return "helmet";
    }

    public int getHealthBonus() {
        return this.healthBonus;
    }

    public int getAttackBonus() {
        return attackBonus;
    }
}
