package com.codecool.cheeseterminator.ui.elements;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;

public class MainStage {
    private Canvas canvas;
    private Scene scene;
    private StatusPane statusPane;

    public MainStage(Canvas canvas) {
        this.canvas = canvas;
        statusPane = new StatusPane();
        scene = setUpScene();
    }

    private Scene setUpScene() {
        BorderPane borderPane = statusPane.build();
        borderPane.setCenter(canvas);
        Scene scene = new Scene(borderPane);
        return scene;
    }

    public Scene getScene() {
        return scene;
    }


    public void setGameMessage(String text) {
        statusPane.setGameMessage(text);
    }

    public void setLevelText(String text) {
        statusPane.setLevelText(text);
    }

    public void setNumberOfCheesesValue(String text) {
        statusPane.setNumberOfCheesesValue(text);
    }

    public void setNumberToPlaceValue(String text) {
        statusPane.setNumberToPlaceValue(text);
    }
}
