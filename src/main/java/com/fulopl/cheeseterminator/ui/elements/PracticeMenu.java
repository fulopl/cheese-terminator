package com.fulopl.cheeseterminator.ui.elements;

import com.fulopl.cheeseterminator.controller.InputManager;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;

public class PracticeMenu {
    private InputManager inputManager;
    private ChoiceBox<String> choiceBox;
    private Button button;
    private Button button1;
    private VBox vBox;
    private int selectedIndex;


    public PracticeMenu(InputManager inputManager) {
        this.inputManager = inputManager;
        choiceBox = new ChoiceBox<String>();
        choiceBox.getItems().add("Select level...");
        for (int i = 1; i <= 50; i++) {
            choiceBox.getItems().add("Level " + i);
        }
        choiceBox.setValue("Select level...");

        choiceBox.setOnAction((event) -> {
            selectedIndex = choiceBox.getSelectionModel().getSelectedIndex();
            Object selectedItem = choiceBox.getSelectionModel().getSelectedItem();

            System.out.println("Selection made: [" + selectedIndex + "] " + selectedItem);
            if (selectedIndex > 0) button.setDisable(false);
            else button.setDisable(true);
        });
        choiceBox.setTooltip(new Tooltip("Select level..."));

        button = new Button("Start practice");
        button.setDisable(true);
        button.setOnAction(event -> inputManager.onStartPractice(selectedIndex));

        button1 = new Button("Quit to main menu");
        button1.setOnAction((event) -> inputManager.onQuitToMain());

        choiceBox.setPrefWidth(150);
        button.setPrefWidth(150);
        button1.setPrefWidth(150);

        vBox = new VBox(15, choiceBox, button, button1);
        vBox.setAlignment(Pos.CENTER);
    }

    public VBox getvBox() {
        return vBox;
    }
}
