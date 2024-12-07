package com.codecool.cheeseterminator.logic;

import com.codecool.cheeseterminator.data.*;
import com.codecool.cheeseterminator.data.items.Cheese;
import com.codecool.cheeseterminator.data.player.Hero;
import com.codecool.cheeseterminator.ui.Tile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MapLoader {

    public static GameMap createGameMapFromFile(String fileName) {
        InputStream is = MapLoader.class.getResourceAsStream(fileName);
        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        List<String> lines = new ArrayList<>();
        scanner.nextLine(); // empty line

        GameMap map = new GameMap(width, height, Tile.FLOOR);

        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            lines.add(line);
        }
        buildMap(map, lines);
        return map;
    }

    public static void buildMap(GameMap map, List<String> lines) {

        int height = lines.size();
        for (int y = 0; y < height; y++) {
            String line = lines.get(y);
            int width = line.length();
            for (int x = 0; x < width; x++) {
                char mapChar = line.charAt(x);
                Cell cell = map.getCell(x, y);

                GameElementType gameElementType = Arrays.stream(GameElementType.values())
                        .filter(gameElementType1 -> gameElementType1.getMapCharacter() == mapChar)
                        .findFirst()
                        .orElseThrow();
                if (gameElementType.getRole().equals(Role.HERO)) {
                    GameElement hero = new Hero(gameElementType);
                }
                GameElement gameElement = new GameElement(gameElementType);



                boolean hasMatch = false;
                for (Tile tile : Tile.values()) {
                    if (tile.getMapCharacter() == mapChar) {
                        cell.setTile(tile);
                        hasMatch = true;
                        break;
                    }
                }
                if (!hasMatch) throw new RuntimeException("Unrecognized character: '" + mapChar + "'");
                switch (mapChar) {
                    case 'c':
                        cell.setTile(Tile.FLOOR);
                        new Cheese(cell);
                        map.incrementCheeseNumber();
                        break;
                    case '@':
                        cell.setTile(Tile.FLOOR);
                        //map.setHero(new Hero(cell, Tile.MOUSE));
                        break;
                }

            }
        }
    }
}
