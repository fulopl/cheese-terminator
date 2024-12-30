package com.codecool.cheeseterminator.ui.elements;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class StatusPane {
    public static final int RIGHT_PANEL_WIDTH = 200;
    public static final int RIGHT_PANEL_PADDING = 10;
    private GridPane gridPane;

    private Label gameMessage;
    private Label levelText;
    private Label numberOfCheesesLabel;
    private Label numberOfCheesesValue;
    private Label numberToPlaceLabel;
    private Label numberToPlaceValue;
    private Label keyMapText;


    public StatusPane() {
        setUpStatusPane();
    }

    public void setUpStatusPane() {
        gridPane = new GridPane();
        gridPane.setPrefWidth(RIGHT_PANEL_WIDTH);
        gridPane.setPadding(new Insets(RIGHT_PANEL_PADDING));

        gameMessage = new Label();
        gridPane.add(gameMessage, 0, 0);
    }

    public void setupForLevels() {
        levelText = new Label();
        numberOfCheesesLabel = new Label("Number of cheeses: ");
        numberOfCheesesValue = new Label();
        numberToPlaceLabel = new Label("Number to place: ");
        numberToPlaceValue = new Label();
        keyMapText = new Label("\nUse ARROW KEYS to move,\npush 'R' to retry level,\npush 'Q' to quit game");
        gridPane.add(levelText, 0, 1);
        gridPane.add(numberOfCheesesLabel, 0, 2);
        gridPane.add(numberOfCheesesValue, 1, 2);
        gridPane.add(numberToPlaceLabel, 0, 3);
        gridPane.add(numberToPlaceValue, 1, 3);
        gridPane.add(keyMapText, 0, 4);
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public void setGameMessage(String text) {
        gameMessage.setText(text);
    }

    public void setLevelText(String text) {
        levelText.setText(text);
    }

    public void setNumberOfCheesesValue(String text) {
        numberOfCheesesValue.setText(text);
    }

    public void setNumberToPlaceValue(String text) {
        numberToPlaceValue.setText(text);
    }

}




