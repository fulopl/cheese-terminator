package com.codecool.cheeseterminator.data;

public enum CellType {
    EMPTY("empty", false),
    FLOOR("floor", true),
    CHEESE("cheese", false),
    HOLE("hole", true),
    WALL("wall", false);


    private final String tileName;
    private final boolean passable;

    CellType(String tileName, boolean passable) {
        this.tileName = tileName;
        this.passable = passable;
    }

    public String getTileName() {
        return tileName;
    }

    public boolean isPassable() {
        return passable;
    }
}
