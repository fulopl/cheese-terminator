package com.fulopl.cheeseterminator.logic;

import com.fulopl.cheeseterminator.model.player.Direction;
import com.fulopl.cheeseterminator.model.player.Hero;
import javafx.scene.input.KeyCode;

import java.util.HashMap;
import java.util.Map;

public class InputManager {
    private final Map<KeyCode, Runnable> keyHandlers = new HashMap<>();
    private Hero hero;
    private GameControl gameControl;

    public InputManager() {
        keyHandlers.put(KeyCode.DOWN, () -> {
            gameControl.checkLevelVictory();
            if (hero != null) hero.move(Direction.SOUTH);
            gameControl.refreshAfterKeyPress();
        });

        keyHandlers.put(KeyCode.LEFT, () -> {
            gameControl.checkLevelVictory();
            if (hero != null) hero.move(Direction.WEST);
            gameControl.refreshAfterKeyPress();
        });

        keyHandlers.put(KeyCode.UP, () -> {
            gameControl.checkLevelVictory();
            if (hero != null) hero.move(Direction.NORTH);
            gameControl.refreshAfterKeyPress();
        });

        keyHandlers.put(KeyCode.RIGHT, () -> {
            gameControl.checkLevelVictory();
            if (hero != null) hero.move(Direction.EAST);
            gameControl.refreshAfterKeyPress();
        });

        keyHandlers.put(KeyCode.SPACE, () -> gameControl.nextPhase());
        keyHandlers.put(KeyCode.R, () -> gameControl.setupLevel());
        keyHandlers.put(KeyCode.Q, () -> gameControl.quit());
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setGameControl(GameControl gameControl) {
        this.gameControl = gameControl;
    }

    public Map<KeyCode, Runnable> getKeyHandlers() {
        return keyHandlers;
    }
}
