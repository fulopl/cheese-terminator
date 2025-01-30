package com.fulopl.cheeseterminator.ui;

import com.fulopl.cheeseterminator.model.Cell;
import javafx.scene.input.KeyCode;

import java.util.Map;

public interface UI {


    public void initiateMainStage();

    public void setUpScreen(int mapWidth, int mapHeight);

    public void refreshGameBoard(Cell[][] cells);

    public void setOnKeyPressed(Map<KeyCode, Runnable> keyHandlers);

    public void setUpStatusDisplay();

    public void displayMessage(String message);

    public void displayLevel(String message);

    public void displayLevelStatus(int cheeseTotal, int cheeseToScore);
}
