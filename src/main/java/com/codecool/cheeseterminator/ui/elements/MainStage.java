package com.codecool.cheeseterminator.ui.elements;

import com.codecool.cheeseterminator.ui.Tile;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;

public class MainStage {
    private GraphicsContext context;
    private Canvas canvas;
    private BorderPane borderPane;

    public void setUpMainScreen(int mapWidth, int mapHeight) {
        canvas = new Canvas(
                mapWidth * Tile.TILE_WIDTH,
                mapHeight * Tile.TILE_WIDTH);
        context = canvas.getGraphicsContext2D();
        borderPane = new BorderPane();
        borderPane.setCenter(canvas);

    }

    public BorderPane getBorderPane() {
        return borderPane;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public GraphicsContext getContext() {
        return context;
    }
}
