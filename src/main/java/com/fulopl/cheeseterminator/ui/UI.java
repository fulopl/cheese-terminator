package com.fulopl.cheeseterminator.ui;

import com.fulopl.cheeseterminator.controller.InputManager;
import com.fulopl.cheeseterminator.model.Cell;
import com.fulopl.cheeseterminator.ui.elements.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UI {

    private final InputManager inputManager;
    private final BorderPane root;
    private final Scene scene;
    private GameBoard gameBoard;
    private StatusPane statusPane;
    private PracticeMenu practiceMenu;
    private final MainBackGround mainBackGround;

    public UI(Stage primaryStage, InputManager inputManager) {
        this.inputManager = inputManager;
        root = new BorderPane();
        mainBackGround = new MainBackGround();

        Text text = new Text("Cheese Terminator Reborn");
        text.setStroke(Color.BLUE);
        text.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        Button button = new Button("Play!");
        button.setPrefWidth(150);
        button.setOnAction(e -> inputManager.onGo());
        VBox vBox = new VBox(15, text, button);
        vBox.setAlignment(Pos.CENTER);
        vBox.setBackground(new Background(mainBackGround.getBackgroundImage()));
        root.setCenter(vBox);
        root.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        scene = new Scene(root, 600, 500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Cheese Terminator Reborn");
        primaryStage.show();

        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            //System.out.println(event.getCode().getName());
            inputManager.handleKeyInput(event.getCode());
        });
    }

    public void showMainMenu(boolean isContGameButtonDisabled) {
        Button button0 = new Button("New Game");
        Button button1 = new Button("Continue Game");
        button1.setDisable(isContGameButtonDisabled);
        Button button2 = new Button("Practice Level");
        Button button3 = new Button("Exit & Save");

        VBox vBox = new VBox(15, button0, button1, button2, button3);
        vBox.setBackground(new Background(mainBackGround.getBackgroundImage()));
        for (Node node : vBox.getChildren()) {
            Button button = (Button) node;
            button.setPrefWidth(150);
        }
        vBox.setAlignment(Pos.CENTER);
        root.getChildren().clear();
        root.setCenter(vBox);

        button0.setOnAction(e -> inputManager.onNewGame());
        button1.setOnAction(e -> inputManager.onContinueGame());
        button2.setOnAction(e -> inputManager.onPracticeLevel());
        button3.setOnAction(e -> inputManager.onExit());
    }

    public void initGameScreen(int mapWidth, int mapHeight) {
        gameBoard = new GameBoard(mapWidth, mapHeight);
        statusPane = new StatusPane(inputManager);

        root.setCenter(gameBoard.getCanvas());
        root.setRight(statusPane.getPane());
    }

    public void initPracticeMenu() {
        practiceMenu = new PracticeMenu(inputManager, mainBackGround);
        root.setCenter(practiceMenu.getvBox());
    }

    public void refreshGameBoard(Cell[][] cells) {
        gameBoard.refreshGameBoard(cells);
    }

    public void initStatusPaneNormalFinish(int actualLevel) {
        statusPane.setNormalLevelFinish(actualLevel);
    }

    public void initStatusPanePracticeFinish(int actualLevel) {
        statusPane.setPracticeLevelFinish(actualLevel);
    }

    public void refreshStatusDisplay(int level, int cheeseTotal, int cheeseToScore) {
        statusPane.setLevelText(String.valueOf(level));
        statusPane.setNumberOfCheesesValue(String.valueOf(cheeseTotal));
        statusPane.setNumberToPlaceValue(String.valueOf(cheeseToScore));
    }

    public boolean initAlertBox(String title, String header, String text) {
        AlertBox alertBox = new AlertBox(title, header, text);
        return alertBox.show();
    }

    public boolean initQuestionBox(String title, String mainContent, String noLabel, String yesLabel) {
        QuestionBox questionBox = new QuestionBox(title, mainContent, noLabel, yesLabel);
        return questionBox.show();
    }
}
