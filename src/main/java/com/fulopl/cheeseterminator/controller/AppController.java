package com.fulopl.cheeseterminator.controller;

import com.fulopl.cheeseterminator.ui.UI;
import javafx.application.Application;
import javafx.stage.Stage;

public class AppController extends Application {
    private InputManager inputManager;
    private UI ui;
    private GameLogic gameLogic;
    private int actualLevel;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        inputManager = new InputManager(this);
        ui = new UI(primaryStage, inputManager);
        inputManager.setSpaceAndQuitKeyMap(this::initMainMenu);
        actualLevel = loadSavedLevel();
    }

    private int loadSavedLevel() {
        return 1;
    }

    private void saveLevel() {
    }

    public void initMainMenu() {
        boolean noLevelProgress = actualLevel == 1;
        ui.ShowMainMenu(noLevelProgress);
    }

    public void startNewGame() {
        inputManager.setGameKeyMap();
        gameLogic = new GameLogic(ui, inputManager, 1);
    }

    public void continueGame() {
        inputManager.setGameKeyMap();
        gameLogic = new GameLogic(ui, inputManager, actualLevel);

    }

    public void practiceLevel() {
        inputManager.setGameKeyMap();
        int chosenLevel = 2;
        gameLogic = new GameLogic(ui, inputManager, chosenLevel);
    }

    public void exitApp() {
        saveLevel();
        System.out.println("Your most recently reached level has been saved!");
        System.out.println("See ya later!");
        System.exit(0);
    }

    public void quitToMainMenu() {
        saveLevel();
        initMainMenu();
    }


    public GameLogic getGameLogic() {
        return gameLogic;
    }

    public void setGameLogic(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

}
