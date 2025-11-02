package com.fulopl.cheeseterminator.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GameSaveManager {

    private static final Path SAVE_PATH = Path.of(
            System.getProperty("user.home"),
            ".cheeseterminator",
            "save.txt"
    );

    public static void saveGame(int score) {
        try {
            Files.createDirectories(SAVE_PATH.getParent());

            Files.writeString(SAVE_PATH, Integer.toString(score));

            System.out.println("Saving level: " + SAVE_PATH);
        } catch (IOException e) {
            System.err.println("Saving failed: " + e.getMessage());
        }
    }

    public static int loadGame() {
        try {
            if (!Files.exists(SAVE_PATH)) {
                System.out.println("No save file. Default value loaded.");
                return 0;
            }

            String content = Files.readString(SAVE_PATH).trim();
            int value = Integer.parseInt(content);
            System.out.println("Saved level loaded: " + value);
            return value;

        } catch (IOException | NumberFormatException e) {
            System.err.println("I/O error: " + e.getMessage());
            return 0;
        }
    }
}

