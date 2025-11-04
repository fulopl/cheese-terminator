package com.fulopl.cheeseterminator.ui.elements;

import com.fulopl.cheeseterminator.controller.InputManager;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.Set;

public class StatusPane {
    public static final int RIGHT_PANEL_WIDTH = 200;
    public static final int RIGHT_PANEL_PADDING = 10;
    public static final int RIGHT_PANEL_VGAP = 10;
    private GridPane gridPane;
    private InputManager inputManager;

    private Label gameMessage;
    private Label levelText;
    private Label numberOfCheesesLabel;
    private Label numberOfCheesesValue;
    private Label numberToPlaceLabel;
    private Label numberToPlaceValue;


    public StatusPane(InputManager inputManager) {
        this.inputManager = inputManager;
        gridPane = new GridPane();
        gridPane.setPrefWidth(RIGHT_PANEL_WIDTH);
        gridPane.setPadding(new Insets(RIGHT_PANEL_PADDING));
        gridPane.setVgap(RIGHT_PANEL_VGAP);
        setGameStatus();
    }

    public void setGameStatus() {
        gameMessage = new Label("Push all the cheeses\nto the red mouse holes!\n" +
                "\nUse the arrow keys\nto move!\n");
        levelText = new Label();
        numberOfCheesesLabel = new Label("Number of cheeses: ");
        numberOfCheesesValue = new Label();
        numberToPlaceLabel = new Label("Number to place: ");
        numberToPlaceValue = new Label();

        Button buttonUndo = new Button("Undo last step");
        buttonUndo.setOnAction(e -> inputManager.onUndo());
        Button buttonRetry = new Button("Retry level");
        buttonRetry.setOnAction(e -> inputManager.onRetry());
        Button buttonQuit = new Button("Quit to main menu");
        buttonQuit.setOnAction(e -> inputManager.onQuitToMain());
        Set<Button> buttonSet = Set.of(buttonUndo, buttonRetry, buttonQuit);
        buttonSet.forEach(item -> {
            item.setPrefWidth(150);
            item.setFocusTraversable(false);
        });

        //keyMapText = new Label("\nUse ARROW KEYS to move,\npush 'U' to undo last step,\npush 'R' to retry level,\npush 'Q' to quit game");
        gridPane.add(gameMessage, 0, 0);
        gridPane.add(levelText, 0, 1);
        gridPane.add(numberOfCheesesLabel, 0, 2);
        gridPane.add(numberOfCheesesValue, 1, 2);
        gridPane.add(numberToPlaceLabel, 0, 3);
        gridPane.add(numberToPlaceValue, 1, 3);
        //gridPane.add(keyMapText, 0, 4);
        gridPane.add(buttonUndo, 0, 5);
        gridPane.add(buttonRetry, 0, 6);
        gridPane.add(buttonQuit, 0, 7);
    }

    public GridPane getPane() {
        return gridPane;
    }

    public void setLevelFinish(String text) {
        gridPane.getChildren().clear();
        gameMessage.setText(text);
        gridPane.add(gameMessage, 0, 0);
    }

    public void setLevelText(String text) {
        levelText.setText("LEVEL " + text);
    }

    public void setNumberOfCheesesValue(String text) {
        numberOfCheesesValue.setText(text);
    }

    public void setNumberToPlaceValue(String text) {
        numberToPlaceValue.setText(text);
    }

}




