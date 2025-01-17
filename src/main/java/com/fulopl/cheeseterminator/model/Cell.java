package com.fulopl.cheeseterminator.model;

import com.fulopl.cheeseterminator.model.item.Item;
import com.fulopl.cheeseterminator.model.player.Hero;
import com.fulopl.cheeseterminator.ui.Tile;

public class Cell implements Drawable {
    private Tile tile;
    private GameElement structure;
    private Item item;
    private Hero hero;
    private final GameMap gameMap;
    private final int x;
    private final int y;

    public Cell(GameMap gameMap, int x, int y, Tile tile) {
        this.gameMap = gameMap;
        this.x = x;
        this.y = y;
        this.tile = tile;
    }

    @Override
    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public GameElement getStructure() {
        return structure;
    }

    public void setStructure(GameElement structure) {
        this.structure = structure;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Cell getNeighbor(int dx, int dy) {
        return gameMap.getCell(x + dx, y + dy);
    }

    public boolean isPassable() {
        return structure.isPassable();
    }
}
