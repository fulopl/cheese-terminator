package com.codecool.cheeseterminator.data;

import com.codecool.cheeseterminator.data.player.Hero;
import com.codecool.cheeseterminator.data.items.Item;
import com.codecool.cheeseterminator.ui.Tile;

public class Cell implements Drawable {
    private Tile tile;
    private Hero hero;
    private Item item;
    private GameMap gameMap;
    private int x, y;

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

    public void setPlayer(Hero hero) {
        this.hero = hero;
    }
    public void setItem(Item item) {this.item = item; }

    public Hero getPlayer() {
        return hero;
    }
    public Item getItem() { return item; }

    public Cell getNeighbor(int dx, int dy) {
        return gameMap.getCell(x + dx, y + dy);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
