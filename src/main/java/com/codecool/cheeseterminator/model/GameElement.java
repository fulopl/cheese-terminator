package com.codecool.cheeseterminator.model;

import com.codecool.cheeseterminator.ui.Tile;

public class GameElement implements Drawable{
    private boolean passable;
    private final Role role;
    private final char mapCharacter;
    private Tile tile;
    protected Cell cell;
    private final GameElementType gameElementType;

    public GameElement(GameElementType gameElementType) {
        this.passable = gameElementType.isPassable();
        this.role = gameElementType.getRole();
        this.mapCharacter = gameElementType.getMapCharacter();
        this.tile = gameElementType.getInitialTile();
        this.gameElementType = gameElementType;
    }

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
