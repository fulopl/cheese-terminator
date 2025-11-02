package com.fulopl.cheeseterminator.controller;

import com.fulopl.cheeseterminator.model.player.Direction;
import com.fulopl.cheeseterminator.model.player.Hero;
import javafx.scene.input.KeyCode;

import java.util.HashMap;
import java.util.Map;

public class InputManager {
    private final Map<KeyCode, Runnable> keyHandlers = new HashMap<>();
    private Hero hero;
    private GameLogic gameLogic;
    private AppController appController;
    private Map<KeyCode, Runnable> keyMap;

    public InputManager(AppController appController) {
        this.appController = appController;
        keyHandlers.put(KeyCode.DOWN, () -> {
            gameLogic.checkLevelVictory();
            if (hero != null) hero.move(Direction.SOUTH);
            gameLogic.refreshAfterKeyPress();
        });

        keyHandlers.put(KeyCode.LEFT, () -> {
            gameLogic.checkLevelVictory();
            if (hero != null) hero.move(Direction.WEST);
            gameLogic.refreshAfterKeyPress();
        });

        keyHandlers.put(KeyCode.UP, () -> {
            gameLogic.checkLevelVictory();
            if (hero != null) hero.move(Direction.NORTH);
            gameLogic.refreshAfterKeyPress();
        });

        keyHandlers.put(KeyCode.RIGHT, () -> {
            gameLogic.checkLevelVictory();
            if (hero != null) hero.move(Direction.EAST);
            gameLogic.refreshAfterKeyPress();
        });

        keyHandlers.put(KeyCode.U, () -> {
            gameLogic.checkLevelVictory();
            if (hero != null) hero.undo();
            gameLogic.refreshAfterKeyPress();
        });

        keyHandlers.put(KeyCode.SPACE, () -> gameLogic.nextPhase());
        keyHandlers.put(KeyCode.R, () -> gameLogic.handleRetry());
        keyHandlers.put(KeyCode.Q, () -> gameLogic.quit());
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }


    public void handleKeyInput(KeyCode keyCode) {
        Runnable action = keyMap.get(keyCode);
        if (action != null) action.run();
    }

    public void setKeyMap(Map<KeyCode, Runnable> map){
        keyMap = map;
    }

    public void setSpaceKeyMap(Runnable runnable) {
        keyMap = Map.<KeyCode, Runnable>of(
                KeyCode.SPACE, runnable
        );
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

    }
}
