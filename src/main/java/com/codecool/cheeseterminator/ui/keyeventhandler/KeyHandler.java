package com.codecool.cheeseterminator.ui.keyeventhandler;

import com.codecool.cheeseterminator.data.GameMap;
import javafx.scene.input.KeyEvent;

public interface KeyHandler {
    void perform(KeyEvent event, GameMap map);
}
