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

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.ui = new UI(primaryStage);
        this.logic = new GameLogic(ui);
        ui.setGameLogic(logic); // TODO: will be taken out
        logic.initiate();
    }
}
