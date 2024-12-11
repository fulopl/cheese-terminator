package com.codecool.cheeseterminator.ui;

import com.codecool.cheeseterminator.data.Cell;
import com.codecool.cheeseterminator.data.items.Cheese;
import com.codecool.cheeseterminator.logic.GameLogic;
import com.codecool.cheeseterminator.ui.elements.MainStage;
import com.codecool.cheeseterminator.ui.keyeventhandler.KeyHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Set;

public class UI {
    private Canvas canvas;
    private GraphicsContext context;
    private MainStage mainStage;
    private GameLogic gameLogic;
    private Set<KeyHandler> keyHandlers;
    private Stage primaryStage;


    public UI(GameLogic gameLogic, Set<KeyHandler> keyHandlers, Stage primaryStage) {
        this.gameLogic = gameLogic;
        this.keyHandlers = keyHandlers;
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Cheese Terminator");
        primaryStage.show();
    }

    public void setUpPane() {
        this.canvas = new Canvas(
                gameLogic.getMapWidth() * Tile.TILE_WIDTH,
                gameLogic.getMapHeight() * Tile.TILE_WIDTH);
        this.context = canvas.getGraphicsContext2D();
        this.mainStage = new MainStage(canvas);
        Scene scene = mainStage.getScene();
        primaryStage.setScene(scene);

        refresh();
        scene.setOnKeyPressed(this::onKeyPressed);
    }

    private void onKeyPressed(KeyEvent keyEvent) {
        for (KeyHandler keyHandler : keyHandlers) {
            keyHandler.perform(keyEvent, gameLogic.getMap());
        }
//        logic.checkForRestart();
//        logic.getWin();
//        logic.checkForLoadSave();
        gameLogic.doChecksAfterKeypress(keyEvent);
        refresh();
    }

    public void refresh() {
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gameLogic.getMap().setCellTiles();
        for (int x = 0; x < gameLogic.getMapWidth(); x++) {
            for (int y = 0; y < gameLogic.getMapHeight(); y++) {
                Cell cell = gameLogic.getCell(x, y);
                Tile.drawTile(context, cell, x, y);
            }
        }
//        if (logic.checkMonsterKilled()) {
//            mainStage.setVictorText(VictoryMessage.getRandomMessage().getMessage());
//        }
//        if (logic.isGameSaved()) mainStage.setVictorText("\nGAME SAVED");
//        if (logic.isGameLoaded()) mainStage.setVictorText("\nGAME LOADED");
        if (gameLogic.isLevelUp())
            mainStage.setGameMessage("Congratulations!\n\nYou have completed LEVEL " + gameLogic.getLevel()
                    + "\n\nPress 'SPACE' to proceed!\n ");
        else mainStage.setGameMessage("Push all the cheeses \nto the mouse holes!\n ");
        mainStage.setLevelText("LEVEL " + gameLogic.getLevel());

        mainStage.setNumberOfCheesesValue(String.valueOf(Cheese.getCheeseTotal()));
        mainStage.setNumberToPlaceValue(String.valueOf(Cheese.getCheeseTotal() - Cheese.getCheeseInHole()));

        //      mainStage.setHealthLabelText(logic.getPlayerHealth());
        //     mainStage.setAttackValueText(logic.getPlayerDamage());

    }

}
