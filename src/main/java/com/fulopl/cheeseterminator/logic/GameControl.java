package com.fulopl.cheeseterminator.logic;

public interface GameControl {
    void refreshAfterKeyPress();

    void nextPhase();

    void setupLevel();

    void quit();
}
