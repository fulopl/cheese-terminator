package com.codecool.cheeseterminator.data;

import com.codecool.cheeseterminator.ui.Tile;

public class GameElement implements Drawable{
    private boolean passable;
    private final Role role;
    private final char mapCharacter;
    private Tile tile;
    protected Cell cell;

    public GameElement(GameElementType gameElementType) {
        this.passable = gameElementType.isPassable();
        this.role = gameElementType.getRole();
        this.mapCharacter = gameElementType.getMapCharacter();
        this.tile = gameElementType.getInitialTile();
    }

    @Override
    public Tile getTile() {
        return tile;
    }
}
