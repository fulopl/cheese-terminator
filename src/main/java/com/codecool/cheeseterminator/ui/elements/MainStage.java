package com.codecool.cheeseterminator.ui.elements;

import com.codecool.cheeseterminator.ui.Tile;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;

public class MainStage {
    private GraphicsContext context;
    private Canvas canvas;
    private Scene scene;
    private BorderPane borderPane;
    private StatusPane statusPane;

    public MainStage(int mapWidth, int mapHeight) {
        canvas = new Canvas(
                mapWidth * Tile.TILE_WIDTH,
                mapHeight * Tile.TILE_WIDTH);
        context = canvas.getGraphicsContext2D();
        borderPane = new BorderPane();
        borderPane.setCenter(canvas);

        //Scene scene = new Scene(borderPane);
        //System.out.println(scene);
    }

    private Scene setUpScene() {
        //BorderPane borderPane = statusPane.build();
        //borderPane.setCenter(canvas);
        Scene scene = new Scene(borderPane);
        return scene;
    }

    public BorderPane getBorderPane() {
        return borderPane;
    }

    public Scene getScene() {
        return scene;
    }

    public void setGameMessage(String text) {
        statusPane.setGameMessage(text);
    } //TODO: get out

    public void setLevelText(String text) {
        statusPane.setLevelText(text);
    } //TODO: get out

    public void setNumberOfCheesesValue(String text) {
        statusPane.setNumberOfCheesesValue(text);
    }//TODO: get out

    public void setNumberToPlaceValue(String text) {
        statusPane.setNumberToPlaceValue(text);
    }//TODO: get out
}
