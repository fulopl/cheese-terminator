package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class Sword extends Item{
    private final int attackBonus;
    public Sword(Cell cell) {
        super(cell, true, true);
        attackBonus = 5;
    }
    @Override
    public String getTileName() {
        return "sword";
    }

    public int getAttackBonus() {
        return this.attackBonus;
    }
}
