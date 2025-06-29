package com.fulopl.cheeseterminator.logic;

public interface GameControl {
    void refreshAfterKeyPress();

    void nextPhase();

    void quit();

    void checkLevelVictory();

    void retryLevel();
}
