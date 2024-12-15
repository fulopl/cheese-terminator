package com.codecool.cheeseterminator.logic;

import com.codecool.cheeseterminator.ui.UI;
import com.codecool.cheeseterminator.ui.keyeventhandler.*;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Set;

public class Game extends Application {
    private UI ui;
    private GameLogic logic;
    private Set<KeyHandler> keyHandlers;
    private InputManager inputManager;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ui = new UI(primaryStage);
        inputManager = new InputManager();
        this.logic = new GameLogic(ui, inputManager);
        inputManager.setGameLogic(logic);
        logic.initiate();
    }
}
