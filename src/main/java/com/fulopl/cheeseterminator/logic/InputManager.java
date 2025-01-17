package com.fulopl.cheeseterminator.logic;

import com.fulopl.cheeseterminator.model.GameMap;
import com.fulopl.cheeseterminator.model.player.Direction;
import javafx.scene.input.KeyCode;

import java.util.HashMap;
import java.util.Map;

public class InputManager {
    private final Map<KeyCode, Runnable> keyHandlers = new HashMap<>();
    private GameMap map;
    private GameLogic gameLogic;

    public void addKeyHandler(KeyCode keyCode, Runnable runnable) {
        keyHandlers.put(keyCode, runnable);
    }

    {
        addKeyHandler(KeyCode.DOWN, () -> {
            if (map.getHero() != null) map.getHero().move(Direction.SOUTH);
            gameLogic.refreshAfterKeyPress();
        });
        addKeyHandler(KeyCode.LEFT, () -> {
            if (map.getHero() != null) map.getHero().move(Direction.WEST);
            gameLogic.refreshAfterKeyPress();
        });
        addKeyHandler(KeyCode.UP, () -> {
            if (map.getHero() != null) map.getHero().move(Direction.NORTH);
            gameLogic.refreshAfterKeyPress();
        });
        addKeyHandler(KeyCode.RIGHT, () -> {
            if (map.getHero() != null) map.getHero().move(Direction.EAST);
            gameLogic.refreshAfterKeyPress();
        });
        addKeyHandler(KeyCode.SPACE, () -> gameLogic.nextPhase());
        addKeyHandler(KeyCode.R, () -> gameLogic.setupLevel());
        addKeyHandler(KeyCode.Q, () -> gameLogic.quit());
    }

    public void setMap(GameMap map) {
        this.map = map;
    }

    public void setGameLogic(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    public  Map<KeyCode, Runnable> getKeyHandlers() {
        return keyHandlers;
    }
}
