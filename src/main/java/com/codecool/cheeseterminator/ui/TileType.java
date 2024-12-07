package com.codecool.cheeseterminator.ui;

import com.codecool.cheeseterminator.data.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

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
    private final int columnIndex;
    private final int rowIndex;
    private final char mapCharacter;
    private final int x;
    private final int y;

    public static final int TILE_WIDTH = 32;
    private static final Image tileset = new Image("/tiles.png", 543 * 2, 543 * 2, true, false);

    TileType(String tileName, boolean passable, int columnIndex, int rowIndex, char mapCharacter) {
        this.tileName = tileName;
        this.passable = passable;
        this.columnIndex = columnIndex;
        this.rowIndex = rowIndex;
        this.mapCharacter = mapCharacter;
        x = columnIndex * (TILE_WIDTH + 2);
        y = rowIndex * (TILE_WIDTH + 2);
    }

    public static void drawTile(GraphicsContext context, Drawable drawable, int x, int y) {
        TileType tileType = TileType.valueOf(drawable.getTileName().toUpperCase());
        context.drawImage(tileset
                , tileType.getX(), tileType.getY()
                , TILE_WIDTH, TILE_WIDTH
                ,x * TILE_WIDTH, y * TILE_WIDTH
                , TILE_WIDTH, TILE_WIDTH);
    }

    public String getTileName() {
        return tileName;
    }

    public boolean isPassable() {
        return passable;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public char getMapCharacter() {
        return mapCharacter;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
