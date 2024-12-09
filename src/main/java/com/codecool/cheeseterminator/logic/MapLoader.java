package com.codecool.cheeseterminator.logic;

import com.codecool.cheeseterminator.data.Cell;
import com.codecool.cheeseterminator.data.GameElement;
import com.codecool.cheeseterminator.data.GameElementType;
import com.codecool.cheeseterminator.data.GameMap;
import com.codecool.cheeseterminator.data.items.Cheese;
import com.codecool.cheeseterminator.data.player.Hero;
import com.codecool.cheeseterminator.ui.Tile;

import java.io.InputStream;
import java.util.*;

public class MapLoader {

    public static final Tile DEFAULT_TILE = Tile.FLOOR;
    public static final GameElementType DEFAULT_GAME_ELEMENT_TYPE = GameElementType.FLOOR;

    public static GameMap createGameMapFromFile(String fileName) {
        InputStream is = MapLoader.class.getResourceAsStream(fileName);
        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        List<String> lines = new ArrayList<>();
        scanner.nextLine(); // empty line

        GameMap gameMap = new GameMap(width, height, DEFAULT_TILE);

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
                        cell.setHero(new Hero(gameElementType));
                        cell.setStructure(new GameElement(DEFAULT_GAME_ELEMENT_TYPE));
                    }
                    case CHEESE -> {
                        cell.setItem(new Cheese(gameElementType));
                        cell.setStructure(new GameElement(DEFAULT_GAME_ELEMENT_TYPE));
                    }
                    default -> cell.setStructure(new GameElement(gameElementType));
                }
            }
        }
        gameMap.setCellTiles();
    }
}
