package com.codecool.cheeseterminator.logic;

import com.codecool.cheeseterminator.data.GameMap;
import com.codecool.cheeseterminator.data.player.Direction;
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
            gameLogic.doChecksAfterKeypress();
        });
        addKeyHandler(KeyCode.LEFT, () -> {
            if (map.getHero() != null) map.getHero().move(Direction.WEST);
            gameLogic.doChecksAfterKeypress();
        });
        addKeyHandler(KeyCode.UP, () -> {
            if (map.getHero() != null) map.getHero().move(Direction.NORTH);
            gameLogic.doChecksAfterKeypress();
        });
        addKeyHandler(KeyCode.RIGHT, () -> {
            if (map.getHero() != null) map.getHero().move(Direction.EAST);
            gameLogic.doChecksAfterKeypress();
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
