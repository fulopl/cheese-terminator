package com.codecool.cheeseterminator.logic;

import com.codecool.cheeseterminator.ui.UI;
import javafx.application.Application;
import javafx.stage.Stage;

public class Game extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        UI ui = new UI(primaryStage);
        InputManager inputManager = new InputManager();
        GameLogic logic = new GameLogic(ui, inputManager);
        logic.init();
    }
}
