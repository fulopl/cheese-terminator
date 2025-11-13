package com.fulopl.cheeseterminator.controller;

import com.fulopl.cheeseterminator.model.GameElementType;
import com.fulopl.cheeseterminator.model.GameMap;
import com.fulopl.cheeseterminator.model.item.Cheese;
import com.fulopl.cheeseterminator.model.player.Direction;
import com.fulopl.cheeseterminator.ui.UI;

import java.util.Arrays;

public class GameLogic {

    private UI ui;
    private final InputManager inputManager;
    private final GameType gameType;
    private int actualLevel;
    private GameMap map;

    private int cheeseTotal = 1;
    private int cheeseInHole = 0;

    public GameLogic(UI ui, InputManager inputManager, GameType gameType, int actualLevel) {
        this.ui = ui;
        this.inputManager = inputManager;
        this.gameType = gameType;
        this.actualLevel = actualLevel;
        setupLevel();
    }

    public void setupLevel() {
        String fileName = "/maps/level_" + actualLevel + ".txt";
        map = MapLoader.createGameMapFromFile(fileName);
        countCheeses();

        ui.initGameScreen(map.getMapWidth(), map.getMapHeight());
        ui.refreshGameBoard(map.getCells());
        ui.refreshStatusDisplay(actualLevel, cheeseTotal, cheeseTotal - cheeseInHole);
    }

    private void countCheeses() {
        cheeseTotal = 0;
        cheeseInHole = 0;
        Arrays.stream(map.getCells())
                .flatMap(cells -> Arrays.stream(cells)
                        .filter(cell -> cell.getItem() != null && cell.getItem().getGameElementType() == GameElementType.CHEESE))
                .forEach(cell -> {
                    cheeseTotal++;
                    if (((Cheese) cell.getItem()).isInHole()) cheeseInHole++;
                });
    }

    public UI getUi() {
        return ui;
    }

    public void setUi(UI ui) {
        this.ui = ui;
    }

    public void checkLevelVictory() {
        if (cheeseTotal == cheeseInHole) {
            if (gameType.equals(GameType.NORMAL_GAME)) {
                ui.initStatusPaneNormalFinish(actualLevel);
                inputManager.setSpaceKeyMap(inputManager::onNextLevel);
            } else {
                ui.initStatusPanePracticeFinish(actualLevel);
                inputManager.setSpaceKeyMap(inputManager::onQuitToMain);
            }
        }
    }

    public void refreshAfterKeyPress() {
        countCheeses();
        map.setCellTiles();
        ui.refreshGameBoard(map.getCells());
        ui.refreshStatusDisplay(actualLevel, cheeseTotal, cheeseTotal - cheeseInHole);
    }

    public void moveHero(Direction direction) {
        map.getHero().move(direction);
        refreshAfterKeyPress();
    }

    public void undoMove() {
        map.getHero().undo();
        refreshAfterKeyPress();
    }

    public void handleRetry() {
        setupLevel();
    }

    public GameType getGameType() {
        return gameType;
    }

    public int getActualLevel() {
        return actualLevel;
    }

    public void incrementLevel() {
        actualLevel++;
    }
}
