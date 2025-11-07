package com.fulopl.cheeseterminator.controller;

import com.fulopl.cheeseterminator.model.player.Direction;
import javafx.scene.input.KeyCode;
import java.util.Map;

public class InputManager {
    private AppController appController;
    private Map<KeyCode, Runnable> keyMap;

    public InputManager(AppController appController) {
        this.appController = appController;
    }

    public void handleKeyInput(KeyCode keyCode) {
        Runnable action = keyMap.get(keyCode);
        if (action != null) action.run();
    }

    public void setSpaceKeyMap(Runnable runnable) {
        keyMap = Map.<KeyCode, Runnable>of(
                KeyCode.SPACE, runnable
        );
    }

    public void setBlancKeyMap() {
        keyMap = Map.<KeyCode, Runnable>of();
    }

    public void setGameKeyMap() {
        keyMap = Map.<KeyCode, Runnable>of(
                KeyCode.UP, () -> {
                    appController.getGameLogic().moveHero(Direction.NORTH);
                    appController.getGameLogic().refreshAfterKeyPress();
                    appController.getGameLogic().checkLevelVictory();
                },
                KeyCode.RIGHT, () -> {
                    appController.getGameLogic().moveHero(Direction.EAST);
                    appController.getGameLogic().refreshAfterKeyPress();
                    appController.getGameLogic().checkLevelVictory();
                },
                KeyCode.DOWN, () -> {
                    appController.getGameLogic().moveHero(Direction.SOUTH);
                    appController.getGameLogic().refreshAfterKeyPress();
                    appController.getGameLogic().checkLevelVictory();
                },
                KeyCode.LEFT, () -> {
                    appController.getGameLogic().moveHero(Direction.WEST);
                    appController.getGameLogic().refreshAfterKeyPress();
                    appController.getGameLogic().checkLevelVictory();
                },
                KeyCode.U, () -> appController.getGameLogic().undoMove(),
                KeyCode.R, () -> appController.getGameLogic().handleRetry(),
                KeyCode.Q, () -> appController.handleQuitToMainMenu()
        );
    }

    public void onNewGame() {
        appController.startNewGame();
    }

    public void onContinueGame() {
        appController.continueGame();
    }

    public void onPracticeLevel() {
        appController.practiceLevel();
    }

    public void onExit() {
        appController.exitApp();
    }

    public void onQuitToMain() {
        appController.handleQuitToMainMenu();
    }

    public void onStartPractice(int level) {
        appController.startLevelPractice(level);
    }

    public void onGo() {
        appController.initMainMenu();
    }

    public void onUndo() {
        appController.getGameLogic().undoMove();
    }

    public void onRetry() {
        appController.getGameLogic().handleRetry();
    }

    public void onNextLevel() {
        setGameKeyMap();
        appController.getGameLogic().setupLevel();
    }
}
