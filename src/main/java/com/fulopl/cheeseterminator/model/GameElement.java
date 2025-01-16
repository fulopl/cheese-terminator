package com.fulopl.cheeseterminator.model;

import com.fulopl.cheeseterminator.ui.Tile;

public class GameElement implements Drawable{
    private boolean passable;
    private Tile tile;
    private GameElementType gameElementType;

    public GameElement(GameElementType gameElementType) {
        this.passable = gameElementType.isPassable();
        this.tile = gameElementType.getInitialTile();
        this.gameElementType = gameElementType;
    }

    public GameElement(){
    };

    @Override
    public Tile getTile() {
        return tile;
    }

    public boolean isPassable() {
        return passable;
    }

    public GameElementType getGameElementType() {
        return gameElementType;
    }
}
