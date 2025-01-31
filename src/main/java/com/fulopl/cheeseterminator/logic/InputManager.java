package com.fulopl.cheeseterminator.logic;

import com.fulopl.cheeseterminator.model.GameMap;
import com.fulopl.cheeseterminator.model.player.Direction;
import javafx.scene.input.KeyCode;

import java.util.HashMap;
import java.util.Map;

public class InputManager {
    private final Map<KeyCode, Runnable> keyHandlers = new HashMap<>();
    private GameMap map;   //TODO get Player from gameLogic
    private GameLogic gameLogic;

    public InputManager() {
        keyHandlers.put(KeyCode.DOWN, () -> {
            if (map.getHero() != null) map.getHero().move(Direction.SOUTH);
            gameLogic.refreshAfterKeyPress();
        });

        keyHandlers.put(KeyCode.LEFT, () -> {
            if (map.getHero() != null) map.getHero().move(Direction.WEST);
            gameLogic.refreshAfterKeyPress();
        });

        keyHandlers.put(KeyCode.UP, () -> {
            if (map.getHero() != null) map.getHero().move(Direction.NORTH);
            gameLogic.refreshAfterKeyPress();
        });

        keyHandlers.put(KeyCode.RIGHT, () -> {
            if (map.getHero() != null) map.getHero().move(Direction.EAST);
            gameLogic.refreshAfterKeyPress();
        });

        keyHandlers.put(KeyCode.SPACE, () -> gameLogic.nextPhase());  //TODO GameLogic interface
        keyHandlers.put(KeyCode.R, () -> gameLogic.setupLevel());
        keyHandlers.put(KeyCode.Q, () -> gameLogic.quit());
    }

    public void setMap(GameMap map) {
        this.map = map;
    }

    public void setGameLogic(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    public Map<KeyCode, Runnable> getKeyHandlers() {
        return keyHandlers;
    }
}
