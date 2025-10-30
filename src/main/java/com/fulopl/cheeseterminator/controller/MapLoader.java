package com.fulopl.cheeseterminator.controller;

import com.fulopl.cheeseterminator.model.Cell;
import com.fulopl.cheeseterminator.model.GameElement;
import com.fulopl.cheeseterminator.model.GameElementType;
import com.fulopl.cheeseterminator.model.GameMap;
import com.fulopl.cheeseterminator.model.item.Cheese;
import com.fulopl.cheeseterminator.model.player.Hero;

import java.io.InputStream;
import java.util.*;

public class MapLoader {

    public static final GameElementType DEFAULT_GAME_ELEMENT_TYPE = GameElementType.FLOOR;

    public static GameMap createGameMapFromFile(String fileName) {
        InputStream is = MapLoader.class.getResourceAsStream(fileName);
        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        List<String> lines = new ArrayList<>();
        scanner.nextLine();
        GameMap gameMap = new GameMap(width, height);

        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            lines.add(line);
        }
        buildMap(gameMap, lines);
        return gameMap;
    }

    public static void buildMap(GameMap gameMap, List<String> lines) {

        int height = lines.size();
        for (int y = 0; y < height; y++) {
            String line = lines.get(y);
            int width = line.length();
            for (int x = 0; x < width; x++) {
                char mapChar = line.charAt(x);
                Cell cell = gameMap.getCell(x, y);

                GameElementType gameElementType = Arrays.stream(GameElementType.values())
                        .filter(gameElementType1 -> gameElementType1.getMapCharacter() == mapChar)
                        .findFirst()
                        .orElseThrow(() -> new NoSuchElementException("Unrecognized character: '" + mapChar + "'"));
                switch (gameElementType) {
                    case MOUSE -> {
                        Hero hero = new Hero(gameElementType, cell);
                        cell.setHero(hero);
                        gameMap.setHero(hero);
                        cell.setStructure(new GameElement(DEFAULT_GAME_ELEMENT_TYPE));
                    }
                    case CHEESE -> {
                        Cheese cheese = new Cheese(gameElementType, cell, false);
                        cell.setItem(cheese);
                        cell.setStructure(new GameElement(DEFAULT_GAME_ELEMENT_TYPE));
                    }
                    case CHEESE_ON_HOLE -> {
                        Cheese cheese = new Cheese(GameElementType.CHEESE, cell, true);
                        cell.setItem(cheese);
                        cell.setStructure(new GameElement(GameElementType.HOLE));
                    }
                    default -> cell.setStructure(new GameElement(gameElementType));
                }
            }
        }
        gameMap.setCellTiles();
    }
}
