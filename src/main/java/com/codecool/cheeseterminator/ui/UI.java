package com.codecool.cheeseterminator.ui;

import com.codecool.cheeseterminator.data.Cell;
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
    private GameLogic logic;
    private Set<KeyHandler> keyHandlers;


    public UI(GameLogic logic, Set<KeyHandler> keyHandlers) {
        this.canvas = new Canvas(
                logic.getMapWidth() * Tiles.TILE_WIDTH,
                logic.getMapHeight() * Tiles.TILE_WIDTH);
        this.logic = logic;
        this.context = canvas.getGraphicsContext2D();
        this.mainStage = new MainStage(canvas);
        this.keyHandlers = keyHandlers;
    }

    public void setUpPane(Stage primaryStage) {
        Scene scene = mainStage.getScene();
        primaryStage.setScene(scene);
        logic.setupLevel();
        refresh();
        scene.setOnKeyPressed(this::onKeyPressed);
    }

    private void onKeyPressed(KeyEvent keyEvent) {
        for (KeyHandler keyHandler : keyHandlers) {
            keyHandler.perform(keyEvent, logic.getMap());
        }
//        logic.checkForRestart();
//        logic.getWin();
//        logic.checkForLoadSave();
        logic.doChecksAfterKeypress(keyEvent);
        refresh();
    }

    public void refresh() {
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int x = 0; x < logic.getMapWidth(); x++) {
            for (int y = 0; y < logic.getMapHeight(); y++) {
                Cell cell = logic.getCell(x, y);
                if (cell.getActor() != null) {
                    Tiles.drawTile(context, cell.getActor(), x, y);
                } else if (cell.getItem() != null) {
                    Tiles.drawTile(context, cell.getItem(), x, y);
                } else {
                    Tiles.drawTile(context, cell, x, y);
                }
            }
        }
//        if (logic.checkMonsterKilled()) {
//            mainStage.setVictorText(VictoryMessage.getRandomMessage().getMessage());
//        }
//        if (logic.isGameSaved()) mainStage.setVictorText("\nGAME SAVED");
//        if (logic.isGameLoaded()) mainStage.setVictorText("\nGAME LOADED");
        if (logic.isLevelUp())
            mainStage.setGameMessage("Congratulations!\n\nYou have completed LEVEL " + logic.getLevel()
                    + "\n\nPress 'SPACE' to proceed!\n ");
        else mainStage.setGameMessage("Push all cheeses \nto the mouse hole!\n ");
        mainStage.setLevelText("LEVEL " + logic.getLevel());

        mainStage.setNumberOfCheesesValue(String.valueOf(logic.getNumberOfCheese()));
        mainStage.setNumberToPlaceValue(String.valueOf(logic.getNumberOfCheese() - logic.getNumberOfCheeseScored()));

        //      mainStage.setHealthLabelText(logic.getPlayerHealth());
        //     mainStage.setAttackValueText(logic.getPlayerDamage());

    }

}
