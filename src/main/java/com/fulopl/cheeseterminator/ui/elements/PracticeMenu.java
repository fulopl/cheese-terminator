package com.fulopl.cheeseterminator.ui.elements;

import com.fulopl.cheeseterminator.controller.InputManager;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;

public class PracticeMenu {
    InputManager inputManager;
    boolean startButtonDisabled;
    ChoiceBox<String> choiceBox;
    Button button;
    Button button1;
    VBox vBox;


    public PracticeMenu(InputManager inputManager, boolean startButtonDisabled) {
        this.startButtonDisabled = startButtonDisabled;
        this.inputManager = inputManager;
        choiceBox = new ChoiceBox<String>();
        choiceBox.getItems().add("Select level...");
        for (int i = 1; i <= 50; i++) {
            choiceBox.getItems().add("Level " + i);
        }
        choiceBox.setValue("Select level...");

        Button button0 = new Button("Start practice");
        choiceBox.setOnAction((event) -> {
            int selectedIndex = choiceBox.getSelectionModel().getSelectedIndex();
            Object selectedItem = choiceBox.getSelectionModel().getSelectedItem();

            System.out.println("Selection made: [" + selectedIndex + "] " + selectedItem);

            if (selectedIndex > 0) button0.setDisable(false);
        });
        choiceBox.setTooltip(new Tooltip("Select level..."));

        button0.setDisable(startButtonDisabled);
        button0.setOnAction(event -> inputManager.onStartPractice(choiceBox.getSelectionModel().getSelectedIndex()));
        Button button1 = new Button("Quit to main menu");
        button1.setOnAction((event) -> inputManager.onQuitToMain());

        choiceBox.setPrefWidth(150);
        button0.setPrefWidth(150);
        button1.setPrefWidth(150);

        VBox vBox = new VBox(15, choiceBox, button0, button1);
        vBox.setAlignment(Pos.CENTER);
    }
}
