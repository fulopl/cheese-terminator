package com.fulopl.cheeseterminator.logic;

import com.fulopl.cheeseterminator.model.GameMap;
import com.fulopl.cheeseterminator.model.player.Direction;
import com.fulopl.cheeseterminator.model.player.Hero;
import javafx.scene.input.KeyCode;

import java.util.HashMap;
import java.util.Map;

public class InputManager {
    private final Map<KeyCode, Runnable> keyHandlers = new HashMap<>();
    private Hero hero;   //TODO get Player from gameLogic
    private GameLogic gameLogic;

    public InputManager() {
        keyHandlers.put(KeyCode.DOWN, () -> {
            if (hero != null) hero.move(Direction.SOUTH);
            gameLogic.refreshAfterKeyPress();
        });

        keyHandlers.put(KeyCode.LEFT, () -> {
            if (hero != null) hero.move(Direction.WEST);
            gameLogic.refreshAfterKeyPress();
        });

        keyHandlers.put(KeyCode.UP, () -> {
            if (hero != null) hero.move(Direction.NORTH);
            gameLogic.refreshAfterKeyPress();
        });

        keyHandlers.put(KeyCode.RIGHT, () -> {
            if (hero != null) hero.move(Direction.EAST);
            gameLogic.refreshAfterKeyPress();
        });

        keyHandlers.put(KeyCode.SPACE, () -> gameLogic.nextPhase());  //TODO GameLogic interface
        keyHandlers.put(KeyCode.R, () -> gameLogic.setupLevel());
        keyHandlers.put(KeyCode.Q, () -> gameLogic.quit());
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setGameLogic(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    public Map<KeyCode, Runnable> getKeyHandlers() {
        return keyHandlers;
    }
}
