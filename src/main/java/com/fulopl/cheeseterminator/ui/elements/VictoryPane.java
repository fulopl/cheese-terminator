package com.fulopl.cheeseterminator.ui.elements;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class VictoryPane {
    private HBox content;

    public VictoryPane() {
        Image image = new Image(getClass().getResource("/victory1.png").toExternalForm());

        BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(602, 500, false, false, false, false)
        );

        content = new HBox();
        content.setBackground(new Background(backgroundImage));
    }

    public HBox getContent() {
        return content;
    }
}
