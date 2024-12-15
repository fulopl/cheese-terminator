package com.codecool.cheeseterminator.data;

import com.codecool.cheeseterminator.ui.Tile;

public enum GameElementType {
    EMPTY(true, Role.STRUCTURE, ' ', Tile.EMPTY),
    FLOOR(true,Role.STRUCTURE, '.', Tile.FLOOR),
    HOLE(true, Role.STRUCTURE, 'h', Tile.HOLE),
    WALL(false, Role.STRUCTURE, '#', Tile.WALL),
    CHEESE(false, Role.ITEM, 'c', Tile.CHEESE),
    MOUSE(false, Role.HERO, '@', Tile.MOUSE),
    ;
    private final boolean passable;
    private final Role role;
    private final char mapCharacter;
    private final Tile initialTile;

    GameElementType(boolean passable, Role role, char mapCharacter, Tile initialTile) {
        this.passable = passable;
        this.role = role;
        this.mapCharacter = mapCharacter;
        this.initialTile = initialTile;
    }

    public boolean isPassable() {
        return passable;
    }

    public Role getRole() {
        return role;
    }

    public char getMapCharacter() {
        return mapCharacter;
    }

    public Tile getInitialTile() {
        return initialTile;
    }
}
