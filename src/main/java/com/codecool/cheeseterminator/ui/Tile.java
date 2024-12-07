package com.codecool.cheeseterminator.ui;

import com.codecool.cheeseterminator.data.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public enum Tile {
    EMPTY(false, 0, 0, ' '),
    FLOOR(true, 2, 0, '.'),
    HOLE(true, 23, 25, 'h'),
    WALL(false, 10, 17, '#'),
    CHEESE(false, 18, 28, 'c'),
    MOUSE(false, 31, 8, '@'),
    ;

    private final boolean passable;
    private final int columnIndex;
    private final int rowIndex;
    private final char mapCharacter;
    private final int x;
    private final int y;

    public static final int TILE_WIDTH = 32;
    private static final Image tileSet = new Image("/tiles.png", 543 * 2, 543 * 2, true, false);

    Tile(boolean passable, int columnIndex, int rowIndex, char mapCharacter) {
        this.passable = passable;
        this.columnIndex = columnIndex;
        this.rowIndex = rowIndex;
        this.mapCharacter = mapCharacter;
        x = columnIndex * (TILE_WIDTH + 2);
        y = rowIndex * (TILE_WIDTH + 2);
    }

    public static void drawTile(GraphicsContext context, Drawable drawable, int x, int y) {
        Tile tile = drawable.getTile();
        context.drawImage(tileSet
                , tile.getX(), tile.getY()
                , TILE_WIDTH, TILE_WIDTH
                , x * TILE_WIDTH, y * TILE_WIDTH
                , TILE_WIDTH, TILE_WIDTH);
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
