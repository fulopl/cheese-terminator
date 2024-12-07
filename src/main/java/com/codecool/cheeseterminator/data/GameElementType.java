package com.codecool.cheeseterminator.data;

import com.codecool.cheeseterminator.ui.TileType;

public enum GameElementType {
    EMPTY(true, Role.STRUCTURE, ' ',TileType.EMPTY),
    FLOOR(true,Role.STRUCTURE, '.',TileType.FLOOR),
    HOLE(true, Role.STRUCTURE, 'h',TileType.HOLE),
    WALL(false, Role.STRUCTURE, '#',TileType.WALL),
    CHEESE(false, Role.ITEM, 'c',TileType.CHEESE),
    MOUSE(false, Role.HERO, '@',TileType.MOUSE),
    ;
    private final boolean passable;
    private final Role role;
    private final char mapCharacter;
    private final TileType initialTileType;

    GameElementType(boolean passable, Role role, char mapCharacter, TileType initialTileType) {
        this.passable = passable;
        this.role = role;
        this.mapCharacter = mapCharacter;
        this.initialTileType = initialTileType;
    }
}
