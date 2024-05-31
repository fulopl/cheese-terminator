package com.codecool.cheeseterminator.logic;

import com.codecool.cheeseterminator.data.Cell;
import com.codecool.cheeseterminator.data.CellType;
import com.codecool.cheeseterminator.data.GameMap;
import com.codecool.cheeseterminator.data.actors.Actor;
import com.codecool.cheeseterminator.data.actors.Player;
import com.codecool.cheeseterminator.data.items.Cheese;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MapLoader {

    public static GameMap createGameMapFromFile(String fileName) {
        InputStream is = MapLoader.class.getResourceAsStream(fileName);
        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        List<Actor> enemyList = new ArrayList<>();
        List<String> lines = new ArrayList<>();
        scanner.nextLine(); // empty line

        GameMap map = new GameMap(width, height, CellType.EMPTY, enemyList);

        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            lines.add(line);
        }
        buildMap(map, lines, enemyList);
        return map;
    }

    public static void buildMap(GameMap map, List<String> lines, List<Actor> enemyList) {

        int height = lines.size();
        for (int y = 0; y < height; y++) {
            String line = lines.get(y);
            int width = line.length();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case '#':
                            cell.setType(CellType.WALL);
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case 'h':
                            cell.setType(CellType.HOLE);
                            break;
                        case 'c':
                            cell.setType(CellType.FLOOR);
                            new Cheese(cell);
                            map.incrementCheeseNumber();
                            break;
                        case '@':
                            cell.setType(CellType.FLOOR);
                            map.setPlayer(new Player(cell));
                            break;
                        default:
                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
    }
}
