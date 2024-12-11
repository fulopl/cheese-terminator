package com.codecool.cheeseterminator.ui.elements;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
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
        gridPane = new GridPane();
        gameMessage = new Label();
        levelText = new Label();
        numberOfCheesesLabel = new Label("Number of cheeses: ");
        numberOfCheesesValue = new Label();
        numberToPlaceLabel = new Label("Number to place: ");
        numberToPlaceValue = new Label();
        keyMapText = new Label("\nUse ARROW KEYS to move,\npush 'R' to retry level,\npush 'Q' to quit game");
    }

    public BorderPane build() {
        gridPane.setPrefWidth(RIGHT_PANEL_WIDTH);
        gridPane.setPadding(new Insets(RIGHT_PANEL_PADDING));

        gridPane.add(gameMessage, 0, 0);
        gridPane.add(levelText, 0, 1);
        gridPane.add(numberOfCheesesLabel, 0, 2);
        gridPane.add(numberOfCheesesValue, 1, 2);
        gridPane.add(numberToPlaceLabel, 0, 3);
        gridPane.add(numberToPlaceValue, 1, 3);
        gridPane.add(keyMapText, 0, 4);

        BorderPane borderPane = new BorderPane();
        borderPane.setRight(gridPane);
        return borderPane;
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




