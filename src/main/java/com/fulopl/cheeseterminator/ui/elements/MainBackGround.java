package com.fulopl.cheeseterminator.ui.elements;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class MainBackGround {
    private final BackgroundImage backgroundImage;

    public MainBackGround() {
        Image image = new Image(getClass().getResource("/menu.png").toExternalForm());

        backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, false, true)
        );
    }

    public BackgroundImage getBackgroundImage() {
        return backgroundImage;
    }
}
