package com.codecool.dungeoncrawl.ui.elements;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class StatusPane {
    public static final int RIGHT_PANEL_WIDTH = 200;
    public static final int RIGHT_PANEL_PADDING = 10;
    private GridPane ui;
    private Label healthTextLabel;
    private Label healthValueLabel;
    private Label attackTextLabel;
    private Label attackValueLabel;
    private Label inventoryTextLabel;
    private Label inventoryLabel;

    private Label enemyHealthLabel;
    private Label enemyValueLabel;
    private Label enemyAttackTextLabel;
    private Label enemyAttackValueLabel;

    private Label victoryMessageLabel;


    public StatusPane() {
        ui = new GridPane();
        healthTextLabel = new Label("Player Health: ");
        healthValueLabel = new Label();
        attackTextLabel = new Label("Player Attack: ");
        attackValueLabel = new Label();
        enemyAttackTextLabel = new Label("Enemy Attack: ");
        enemyAttackValueLabel = new Label();
        enemyHealthLabel = new Label("Enemy Health: ");
        enemyValueLabel = new Label();
        inventoryTextLabel = new Label("Inventory: ");
        inventoryLabel = new Label();
        victoryMessageLabel = new Label();

    }

    public BorderPane build() {

        ui.setPrefWidth(RIGHT_PANEL_WIDTH);
        ui.setPadding(new Insets(RIGHT_PANEL_PADDING));
        ui.add(healthTextLabel, 0, 0);
        ui.add(healthValueLabel, 1, 0);
        ui.add(attackTextLabel, 0, 1);
        ui.add(attackValueLabel, 1, 1);
        ui.add(enemyHealthLabel, 0, 2);
        ui.add(enemyValueLabel, 4, 2);
        ui.add(enemyAttackTextLabel, 0, 3);
        ui.add(enemyAttackValueLabel, 3, 3);
        ui.add(inventoryTextLabel,0,4);
        ui.add(victoryMessageLabel, 0, 6);

        BorderPane borderPane = new BorderPane();
        borderPane.setRight(ui);
        return borderPane;
    }

    public void setHealthValue(String text) {
        healthValueLabel.setText(text);
    }

    public void setAttackValue(String text) {
        attackValueLabel.setText(text);
    }

    public void setInventory(String text) {
        inventoryTextLabel.setText(text); }
    public void setEnemyHealth(String text) {
        enemyValueLabel.setText(text);
    }

    public void setEnemyDamage(String text) {
        enemyAttackValueLabel.setText(text);
    }

    public void setVictoryMessageLabel(String text) {
        victoryMessageLabel.setText(text);
    }

}




