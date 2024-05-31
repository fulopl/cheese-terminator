package com.codecool.cheeseterminator.data.items;

import com.codecool.cheeseterminator.data.Cell;

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
