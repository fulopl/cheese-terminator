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
    N0(19,29),
    N1(20,29),
    N2(21,29),
    N3(22,29),
    N4(23,29),
    N5(24,29),
    N6(25,29),
    N7(26,29),
    N8(27,29),
    N9(28,29),
    A(19,30),
    B(20,30),
    C(21,30),
    D(22,30),
    E(23,30),
    F(24,30),
    G(25,30),
    H(26,30),
    I(27,30),
    J(28,30),
    K(29,30),
    L(30,30),
    M(31,30),
    N(19,31),
    O(20,31),
    P(21,31),
    Q(22,31),
    R(23,31),
    S(24,31),
    T(25,31),
    U(26,31),
    V(27,31),
    W(28,31),
    X(29,31),
    Y(30,31),
    Z(31,31),
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
