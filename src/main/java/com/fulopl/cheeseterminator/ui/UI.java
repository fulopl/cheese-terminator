package com.fulopl.cheeseterminator.ui;

import com.fulopl.cheeseterminator.controller.InputManager;
import com.fulopl.cheeseterminator.model.Cell;
import com.fulopl.cheeseterminator.ui.elements.GameBoard;
import com.fulopl.cheeseterminator.ui.elements.StatusPane;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UI {

    private final InputManager inputManager;
    private final BorderPane root;
    private final Scene scene;
    private GameBoard gameBoard;
    private StatusPane statusPane;
    private Canvas canvas;
    private GraphicsContext context;

    public UI(Stage primaryStage, InputManager inputManager) {
        this.inputManager = inputManager;
        root = new BorderPane();

        Text text = new Text("Welcome to Cheese Terminator Reborn\nPress SPACE to continue!");
        root.setCenter(text);

        scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cheese Terminator Reborn");
        primaryStage.show();

        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            //System.out.println(event.getCode().getName());
            inputManager.handleKeyInput(event.getCode());
        });
    }

    public void ShowMainMenu(boolean isContGameButtonDisabled) {
        Button button0 = new Button("New Game");
        Button button1 = new Button("Continue Game");
        button1.setDisable(isContGameButtonDisabled);
        Button button2 = new Button("Practice Level");
        Button button3 = new Button("Exit & Save");

        VBox vBox = new VBox(15, button0, button1, button2, button3);
        for (Node node : vBox.getChildren()) {
            Button button = (Button) node;
            button.setPrefWidth(150);
        }
        vBox.setAlignment(Pos.CENTER);
        root.setCenter(vBox);

        button0.setOnAction(e -> inputManager.onNewGame());
        button1.setOnAction(e -> inputManager.onContinueGame());
        button2.setOnAction(e -> inputManager.onPracticeLevel());
        button3.setOnAction(e -> inputManager.onExit());
    }

    public void initGameScreen(int mapWidth, int mapHeight) {
        gameBoard = new GameBoard(mapWidth, mapHeight);
        statusPane = new StatusPane();
        canvas = gameBoard.getCanvas();
        context = gameBoard.getContext();

        root.setCenter(canvas);
        root.setRight(statusPane.getPane());
    }





    public void refreshGameBoard(Cell[][] cells) {
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        int mapWidth = cells.length;
        int mapHeight = cells[0].length;
        for (int x = 0; x < mapWidth; x++) {
            for (int y = 0; y < mapHeight; y++) {
                Cell cell = cells[x][y];
                Tile.drawTile(context, cell, x, y);
            }
        }
    }

    public void setUpStatusDisplay() {
        statusPane.setupGameStatus();
    }

    public void displayMessage(String message) {
        statusPane.setGameMessage(message);
    }

    public void displayLevel(String message) {
        statusPane.setLevelText(message);
    }

    public void displayLevelStatus(int cheeseTotal, int cheeseToScore) {
        statusPane.setNumberOfCheesesValue(String.valueOf(cheeseTotal));
        statusPane.setNumberToPlaceValue(String.valueOf(cheeseToScore));
    }





}
