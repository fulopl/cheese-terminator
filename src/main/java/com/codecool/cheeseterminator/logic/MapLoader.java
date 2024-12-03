package com.codecool.cheeseterminator.logic;

import com.codecool.cheeseterminator.data.Cell;
import com.codecool.cheeseterminator.ui.TileType;
import com.codecool.cheeseterminator.data.GameMap;
import com.codecool.cheeseterminator.data.player.Hero;
import com.codecool.cheeseterminator.data.items.Cheese;

import java.io.InputStream;
import java.util.ArrayList;
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

        GameMap map = new GameMap(width, height, TileType.EMPTY);

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
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ':
                            cell.setType(TileType.EMPTY);
                            break;
                        case '#':
                            cell.setType(TileType.WALL);
                            break;
                        case '.':
                            cell.setType(TileType.FLOOR);
                            break;
                        case 'h':
                            cell.setType(TileType.HOLE);
                            break;
                        case 'c':
                            cell.setType(TileType.FLOOR);
                            new Cheese(cell);
                            map.incrementCheeseNumber();
                            break;
                        case '@':
                            cell.setType(TileType.FLOOR);
                            map.setPlayer(new Hero(cell, TileType.MOUSE));
                            break;
                        default:
                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
    }
}
