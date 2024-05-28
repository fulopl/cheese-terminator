package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.items.Armor;
import com.codecool.dungeoncrawl.data.items.Helmet;
import com.codecool.dungeoncrawl.data.items.Item;
import com.codecool.dungeoncrawl.data.items.Sword;

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



    private void checkForEquipment(Item item) {
        if (item instanceof Sword) {
            Sword sword = (Sword) item;
            equipSword(sword);
        } else if (item instanceof Armor) {
            Armor armor = (Armor) item;
            equipArmor(armor);
        } else if (item instanceof Helmet) {
            Helmet helmet = (Helmet) item;
            equipHelmet(helmet);
        }
    }

    private void equipSword(Sword sword) {
        addAttack(sword.getAttackBonus());
        this.hasSword = true;

    }

    private void equipHelmet(Helmet helmet) {
        addAttack(helmet.getAttackBonus());
        addHealth(helmet.getHealthBonus());
        this.hasHelmet = true;
    }

    private void equipArmor(Armor armor) {
        addHealth(armor.getHealthBonus());
        this.hasArmor = true;
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

    public void addItem(Item item) {
        this.inventory.add(item);
        checkForEquipment(item);
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
        Actor actor=nextCell.getActor();
        if(actor!=null) allowToMove=false;
        if (item != null) {
            allowToMove = handleItemEncounter(item, nextCell);
        }
        if (allowToMove) super.move(dx, dy);
    }


    public boolean handleItemEncounter(Item item, Cell nextCell) {
        if (item.getCollectable()) {
            this.addItem(item);
            nextCell.setItem(null);
        }
        return true;
    }

    public void setPlayerApperience(String playerApperience) {
        this.playerApperience = playerApperience;
    }
}
