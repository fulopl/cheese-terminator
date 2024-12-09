package com.codecool.cheeseterminator.ui.keyeventhandler;

import com.codecool.cheeseterminator.data.GameMap;
import com.codecool.cheeseterminator.data.player.Direction;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Down implements KeyHandler {
    public static final KeyCode code = KeyCode.DOWN;

    @Override
    public void perform(KeyEvent event, GameMap map) {
        if (code.equals(event.getCode()))
            map.getHero().move(Direction.SOUTH);
    }
}
