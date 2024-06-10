package com.codecool.cheeseterminator.ui;

public enum TileType {
    EMPTY("empty", false, 0, 0, ' '),
    FLOOR("floor", true, 2, 0, '.'),
    HOLE("hole", true, 23, 25, 'h'),
    WALL("wall", false, 10, 17, '#'),
    CHEESE("cheese", false, 18, 28, 'c'),
    MOUSE("mouse", false, 31, 8, '@'),
    ;

    private final String tileName;
    private final boolean passable;
    private final int fileCoordinateX;
    private final int fileCoordinateY;
    private final char mapCharacter;

    TileType(String tileName, boolean passable, int fileCoordinateX, int fileCoordinateY, char mapCharacter) {
        this.tileName = tileName;
        this.passable = passable;
        this.fileCoordinateX = fileCoordinateX;
        this.fileCoordinateY = fileCoordinateY;
        this.mapCharacter = mapCharacter;
    }

    public String getTileName() {
        return tileName;
    }

    public boolean isPassable() {
        return passable;
    }

    public int getFileCoordinateX() {
        return fileCoordinateX;
    }

    public int getFileCoordinateY() {
        return fileCoordinateY;
    }

    public char getMapCharacter() {
        return mapCharacter;
    }
}
