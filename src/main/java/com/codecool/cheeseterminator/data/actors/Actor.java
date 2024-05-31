package com.codecool.cheeseterminator.data.actors;

import com.codecool.cheeseterminator.data.Cell;
import com.codecool.cheeseterminator.data.Drawable;

public abstract class Actor implements Drawable {
    protected Cell cell;

    private int baseAttack;
    private int health;

    public Actor(Cell cell, int baseAttack, int baseHealth) {
        this.cell = cell;
        this.cell.setActor(this);
        this.health = baseHealth;
        this.baseAttack = baseAttack;
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.getType().isPassable()) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }


    public void addAttack(int attackBonus) {
        this.baseAttack += attackBonus;
    }

    public int getHealth() {
        if (health < 0) {
            return 0;
        }
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }


    protected void addHealth(int healthBonus) {
        this.health += healthBonus;
    }


    public boolean isDead() {
        return health <= 0;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

}
