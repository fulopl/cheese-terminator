package com.codecool.cheeseterminator.data;

import com.codecool.cheeseterminator.data.player.Player;
import com.codecool.cheeseterminator.data.items.Item;
import com.codecool.cheeseterminator.ui.TileType;

public class Cell implements Drawable {
    private TileType type;
    private Player player;
    private Item item;
    private GameMap gameMap;
    private int x, y;

    public Cell(GameMap gameMap, int x, int y, TileType type) {
        this.gameMap = gameMap;
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public TileType getType() {
        return type;
    }

    public void setType(TileType type) {
        this.type = type;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    public void setItem(Item item) {this.item = item; }

    public Player getPlayer() {
        return player;
    }
    public Item getItem() { return item; }

    public Cell getNeighbor(int dx, int dy) {
        return gameMap.getCell(x + dx, y + dy);
    }

    @Override
    public String getTileName() {
        return type.getTileName();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
