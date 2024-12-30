package com.codecool.cheeseterminator.ui;

import com.codecool.cheeseterminator.model.Cell;
import com.codecool.cheeseterminator.ui.elements.MainStage;
import com.codecool.cheeseterminator.ui.elements.StatusPane;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Map;

public class UI {
    private Canvas canvas;
    private GraphicsContext context;
    private final Stage primaryStage;
    private Scene scene;
    private MainStage mainStage;
    private StatusPane statusPane;


    public UI(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void initiateMainStage() {
        primaryStage.setTitle("Cheese Terminator");
        primaryStage.show();
        mainStage = new MainStage();
        statusPane = new StatusPane();
    }

    public void setUpScreen(int mapWidth, int mapHeight) {
        mainStage.setUpMainScreen(mapWidth, mapHeight);
        statusPane.setUpStatusPane();
        canvas = mainStage.getCanvas();
        context = mainStage.getContext();

        mainStage.getBorderPane().setRight(statusPane.getGridPane());

        scene = new Scene(mainStage.getBorderPane());
        primaryStage.setScene(scene);
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

    public void setOnKeyPressed(Map<KeyCode, Runnable> keyHandlers) {
        scene.setOnKeyPressed(event -> onKeyPressed(event, keyHandlers));
    }

    public void onKeyPressed(KeyEvent event, Map<KeyCode, Runnable> keyHandlers) {
        Runnable action = keyHandlers.get(event.getCode());
        if (action != null) action.run();
    }

    public void setUpStatusDisplay() {
        statusPane.setupForLevels();
    }

    public void displayMessage(String message) {
        statusPane.setGameMessage(message);
    }

    public void displayLevel(String message) {
        statusPane.setLevelText(message);
    }

    public void displayLevelStatus(int cheeseTotal, int cheeseToScore) {
        statusPane.setNumberOfCheesesValue(String.valueOf(cheeseTotal));
        statusPane.setNumberToPlaceValue(String.valueOf(cheeseToScore));
    }
}
