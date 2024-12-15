package com.codecool.cheeseterminator.ui;

import com.codecool.cheeseterminator.data.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public enum Tile {
    EMPTY( 0, 0),
    FLOOR(2, 0),
    HOLE( 23, 25),
    WALL( 10, 17),
    CHEESE( 18, 28),
    MOUSE( 31, 8),
    ;

    private final int columnIndex;
    private final int rowIndex;
    private final int x;
    private final int y;

    public static final int TILE_WIDTH = 32;
    private static final Image tileSet = new Image("/tiles.png", 543 * 2, 543 * 2, true, false);

    Tile(int columnIndex, int rowIndex) {
        this.columnIndex = columnIndex;
        this.rowIndex = rowIndex;
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

    public int getColumnIndex() {
        return columnIndex;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
