package com.fulopl.cheeseterminator.ui.elements;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class AlertBox {
    private final Alert alert;

    public AlertBox(String title, String header, String text) {

        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(text);
        alert.initModality(javafx.stage.Modality.APPLICATION_MODAL);
    }

    public boolean show() {
        Optional<ButtonType> result = alert.showAndWait();

        return result.isPresent() && result.get() == ButtonType.OK;
    }
}
