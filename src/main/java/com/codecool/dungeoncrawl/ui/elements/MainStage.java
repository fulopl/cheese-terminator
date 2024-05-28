package com.codecool.dungeoncrawl.ui.elements;

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

    public void setHealthLabelText(String text) {
        this.statusPane.setHealthValue(text);
    }
    public void setAttackValueText(String text) {
        this.statusPane.setAttackValue(text);
    }
    public void setEnemyHealthValueText(String text) {
        this.statusPane.setEnemyHealth(text);
    }
    public void setEnemyDamageValueText(String text) {
        this.statusPane.setEnemyDamage(text);
    }
    public void setInventoryText(String text) {
        this.statusPane.setInventory(text);
    }
    public void setVictorText(String text) {this.statusPane.setVictoryMessageLabel(text);}
}
