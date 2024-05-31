package com.codecool.cheeseterminator.data.actors;

import com.codecool.cheeseterminator.data.Cell;
import com.codecool.cheeseterminator.data.items.Cheese;
import com.codecool.cheeseterminator.data.items.Helmet;
import com.codecool.cheeseterminator.data.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Player extends Actor {
    public List<Item> inventory;

    private boolean hasSword;
    private boolean hasArmor;
    private boolean hasHelmet;
    private String playerApperience;

    public Player(Cell cell) {


        super(cell, 5, 25);

        this.inventory = new ArrayList<>();
        this.hasSword = false;
        this.hasArmor = false;
        this.hasHelmet = false;
        playerApperience = "player";
    }

    public String getTileName() {
        return playerApperience;
    }


    private void equipHelmet(Helmet helmet) {
        addAttack(helmet.getAttackBonus());
        addHealth(helmet.getHealthBonus());
        this.hasHelmet = true;
    }


    public void setHasSword(boolean hasSword) {
        this.hasSword = hasSword;
    }

    public void setHasArmor(boolean hasArmor) {
        this.hasArmor = hasArmor;
    }

    public void setHasHelmet(boolean hasHelmet) {
        this.hasHelmet = hasHelmet;
    }

    public void addItemWithoutEquip(Item item) {
        this.inventory.add(item);
    }

    private void removeItem(Item item) {
        this.inventory.remove(item);
    }

    public String getInventory() {
        StringBuilder stringBuilder = new StringBuilder("Inventory:\n");
        for (Item item : inventory) {
            stringBuilder.append(item.getTileName()).append("\n");
        }
        return String.valueOf(stringBuilder);
    }

    public List<String> getInventoryList() {
        List<String> inventoryList = new ArrayList<>();
        for (Item item : inventory) {
            inventoryList.add(item.getTileName());
        }
        return inventoryList;
    }

    public Item getItem(String itemName) {
        for (Item item : inventory) {
            if (itemName.equals(item.getTileName())) return item;
        }
        return null;
    }

    @Override
    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        Item item = nextCell.getItem();
        boolean allowToMove = true;
        Actor actor = nextCell.getActor();
        if (actor != null) allowToMove = false;
        if (item != null) {
            allowToMove = handleItemEncounter(item, nextCell, dx, dy);
        }
        if (allowToMove) super.move(dx, dy);
    }


    public boolean handleItemEncounter(Item item, Cell nextCell, int dx, int dy) {
        if (item instanceof Cheese) return ((Cheese) item).move(nextCell, dx, dy);
        return false;
    }

    public void setPlayerApperience(String playerApperience) {
        this.playerApperience = playerApperience;
    }
}
