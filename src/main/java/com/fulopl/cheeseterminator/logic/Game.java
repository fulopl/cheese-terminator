package com.fulopl.cheeseterminator.logic;

import com.fulopl.cheeseterminator.ui.UI;
import com.fulopl.cheeseterminator.ui.JavaFxUI;
import javafx.application.Application;
import javafx.stage.Stage;

public class Game extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        UI ui = new JavaFxUI(primaryStage);
        InputManager inputManager = new InputManager();
        GameLogic logic = new GameLogic(ui, inputManager);
        logic.init();
    }
}
