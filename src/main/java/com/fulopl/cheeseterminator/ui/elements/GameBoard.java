package com.fulopl.cheeseterminator.ui.elements;

import com.fulopl.cheeseterminator.model.Cell;
import com.fulopl.cheeseterminator.ui.Tile;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameBoard {
    private GraphicsContext context;
    private Canvas canvas;

    public GameBoard(int mapWidth, int mapHeight) {
        canvas = new Canvas(
                mapWidth * Tile.TILE_WIDTH,
                mapHeight * Tile.TILE_WIDTH);
        context = canvas.getGraphicsContext2D();
    }

    public void refreshGameBoard(Cell[][] cells) {
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        int mapWidth = cells.length;
        int mapHeight = cells[0].length;
        for (int x = 0; x < mapWidth; x++) {
            for (int y = 0; y < mapHeight; y++) {
                Cell cell = cells[x][y];
                Tile.drawTile(context, cell, x, y);
            }
        }
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public GraphicsContext getContext() {
        return context;
    }
}
