package com.fulopl.cheeseterminator.controller;

public interface GameControl {
    void refreshAfterKeyPress();

    void nextPhase();

    void quit();

    void checkLevelVictory();

    void retryLevel();
}
