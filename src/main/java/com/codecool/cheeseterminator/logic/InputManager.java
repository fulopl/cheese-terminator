package com.codecool.cheeseterminator.logic;

import com.codecool.cheeseterminator.data.GameMap;
import com.codecool.cheeseterminator.data.player.Direction;
import javafx.scene.input.KeyCode;

import java.util.HashMap;
import java.util.Map;

public class InputManager {
    private final Map<KeyCode, Runnable> keyHandlers;
    private GameMap map;
    private GameLogic gameLogic;

    public InputManager() {
        this.keyHandlers = new HashMap<>();
    }

    public void addKeyHandler(KeyCode keyCode, Runnable runnable) {
        keyHandlers.put(keyCode, runnable);
    }

    {
        addKeyHandler(KeyCode.DOWN, () -> map.getHero().move(Direction.SOUTH));
        addKeyHandler(KeyCode.LEFT, () -> map.getHero().move(Direction.WEST));
        addKeyHandler(KeyCode.UP, () -> map.getHero().move(Direction.NORTH));
        addKeyHandler(KeyCode.RIGHT, () -> map.getHero().move(Direction.EAST));
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
}
