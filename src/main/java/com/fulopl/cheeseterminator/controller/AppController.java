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
        inputManager.setBlancKeyMap();
        actualLevel = loadSavedLevel();
    }

    private int loadSavedLevel() {
        return GameSaveManager.loadGame();
    }

    private void saveLevel(int levelToSave) {
        GameSaveManager.saveGame(levelToSave);
        System.out.println("Saving level No." + levelToSave);
    }

    public void initMainMenu() {
        inputManager.setBlancKeyMap();
        boolean noLevelProgress = actualLevel <= 1;
        ui.showMainMenu(noLevelProgress);
    }

    public void startNewGame() {
        if (
                actualLevel <= 1
                        ||
                        ui.initAlertBox("Confirm starting new game", "Do you wish to" +
                                " continue?", "Your current game progress will be lost.")
        ) {
            inputManager.setGameKeyMap();
            gameLogic = new GameLogic(ui, inputManager, GameType.NORMAL_GAME, 1);
        }
    }

    public void continueGame() {
        inputManager.setGameKeyMap();
        gameLogic = new GameLogic(ui, inputManager, GameType.NORMAL_GAME, actualLevel);
    }

    public void practiceLevel() {
        inputManager.setSpaceKeyMap(this::handleQuitToMainMenu);
        ui.initPracticeMenu();
    }

    public void startLevelPractice(int chosenLevel) {
        inputManager.setGameKeyMap();
        gameLogic = new GameLogic(ui, inputManager, GameType.PRACTICE_GAME, chosenLevel);
    }

    public void exitApp() {
        System.out.println("Your most recently reached level has been saved!");
        System.out.println("See ya later!");
        System.exit(0);
    }

    public void handleQuitToMainMenu() {
        if (gameLogic != null && gameLogic.getGameType().equals(GameType.NORMAL_GAME)) {
            actualLevel = gameLogic.getActualLevel();
            saveLevel(actualLevel);
        }
        initMainMenu();
    }


    public GameLogic getGameLogic() {
        return gameLogic;
    }

    public void setGameLogic(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

}
