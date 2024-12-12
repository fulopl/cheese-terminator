package com.codecool.cheeseterminator.ui;

import com.codecool.cheeseterminator.data.Cell;
import com.codecool.cheeseterminator.data.items.Cheese;
import com.codecool.cheeseterminator.logic.GameLogic;
import com.codecool.cheeseterminator.ui.elements.MainStage;
import com.codecool.cheeseterminator.ui.elements.StatusPane;
import com.codecool.cheeseterminator.ui.keyeventhandler.*;
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
    private Stage primaryStage;
    private Scene scene;
    private MainStage mainStage;
    private StatusPane statusPane;
    private GameLogic gameLogic;
    private Set<KeyHandler> keyHandlers;


    public UI(Stage primaryStage) {
        this.keyHandlers = Set.of(new Up(), new Down(), new Left(), new Right());
        this.primaryStage = primaryStage;
    }

    public void initiateMainStage(int mapWidth, int mapHeight) {
        primaryStage.setTitle("Cheese Terminator");
        this.mainStage = new MainStage(mapWidth, mapHeight);
        this.statusPane = new StatusPane();
        this.canvas = new Canvas(
                mapWidth * Tile.TILE_WIDTH,
                mapHeight * Tile.TILE_WIDTH);
        this.context = canvas.getGraphicsContext2D();
        scene = new Scene(mainStage.getBorderPane());
        primaryStage.setScene(scene);

        //refresh();
        scene.setOnKeyPressed(this::onKeyPressed);
        primaryStage.show();
    }

    public void setUpPane() {
        this.canvas = new Canvas(
                gameLogic.getMapWidth() * Tile.TILE_WIDTH,
                gameLogic.getMapHeight() * Tile.TILE_WIDTH);
        this.context = canvas.getGraphicsContext2D();
        this.mainStage = new MainStage(5,6);
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

    public void setGameLogic(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
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

        /**********************************
        if (gameLogic.isLevelUp())
            mainStage.setGameMessage("Congratulations!\n\nYou have completed LEVEL " + gameLogic.getLevel()
                    + "\n\nPress 'SPACE' to proceed!\n ");
        else mainStage.setGameMessage("Push all the cheeses \nto the mouse holes!\n ");
        mainStage.setLevelText("LEVEL " + gameLogic.getLevel());

        mainStage.setNumberOfCheesesValue(String.valueOf(Cheese.getCheeseTotal()));
        mainStage.setNumberToPlaceValue(String.valueOf(Cheese.getCheeseTotal() - Cheese.getCheeseInHole()));

        //     mainStage.setHealthLabelText(logic.getPlayerHealth());
        //     mainStage.setAttackValueText(logic.getPlayerDamage());
*///////////////////////////////////////////////////////
    }

    public void displayMessage(String message) {
        statusPane.setGameMessage(message);
    }
}
