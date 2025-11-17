package com.fulopl.cheeseterminator.ui.elements;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class QuestionBox {
    private Stage stage;
    private boolean answer;

    public QuestionBox(String title, String mainContent, String noLabel, String yesLabel) {
        Button noButton = new Button(noLabel);
        noButton.setPrefWidth(100);
        noButton.setOnAction(e -> {
            answer = false;
            stage.close();
        });
        Button yesButton = new Button(yesLabel);
        yesButton.setPrefWidth(100);
        yesButton.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white;");
        yesButton.setOnMouseEntered(e ->
                yesButton.setStyle("-fx-background-color: #c0392b; -fx-text-fill: white;")
        );

        yesButton.setOnMouseExited(e ->
                yesButton.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white;")
        );

        yesButton.setOnAction(e -> {
            answer = true;
            stage.close();
        });
        HBox hBox = new HBox(15, noButton, yesButton);
        hBox.setAlignment(Pos.CENTER);

        Label label = new Label(mainContent);
        VBox vBox = new VBox(20, label, hBox);
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox, 350, 150);

        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setScene(scene);
    }

    public boolean show() {
        stage.showAndWait();
        return answer;
    }
}
