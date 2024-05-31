package com.codecool.cheeseterminator.ui.elements;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class StatusPane {
    public static final int RIGHT_PANEL_WIDTH = 200;
    public static final int RIGHT_PANEL_PADDING = 10;
    private GridPane ui;

    private Label gameMessage;
    private Label levelText;
    private Label numberOfCheesesLabel;
    private Label numberOfCheesesValue;
    private Label numberToPlaceLabel;
    private Label numberToPlaceValue;
    private Label keyMapText;


    public StatusPane() {
        ui = new GridPane();
        gameMessage = new Label();
        levelText = new Label();
        numberOfCheesesLabel = new Label("Number of cheeses: ");
        numberOfCheesesValue = new Label();
        numberToPlaceLabel = new Label("Number to place: ");
        numberToPlaceValue = new Label();
        keyMapText = new Label("\nUse ARROW KEYS to move,\npush 'R' to retry level,\npush 'Q' to quit game");
    }

    public BorderPane build() {
        ui.setPrefWidth(RIGHT_PANEL_WIDTH);
        ui.setPadding(new Insets(RIGHT_PANEL_PADDING));

        ui.add(gameMessage, 0, 0);
        ui.add(levelText, 0, 1);
        ui.add(numberOfCheesesLabel, 0, 2);
        ui.add(numberOfCheesesValue, 1, 2);
        ui.add(numberToPlaceLabel, 0, 3);
        ui.add(numberToPlaceValue, 1, 3);
        ui.add(keyMapText, 0, 4);

        BorderPane borderPane = new BorderPane();
        borderPane.setRight(ui);
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




