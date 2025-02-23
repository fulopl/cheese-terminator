package com.fulopl.cheeseterminator.util;


import java.io.*;
import java.util.Arrays;

public class LevelEditor {
    private static String fileName;

    public static void main(String[] args) {
        for (int level = 1; level <= 50; level++) {
            fileName = "src\\main\\resources\\maps\\level_" + level + ".txt";
            System.out.println(fileName);
            //writeStringsToFile(addBlancLine(readFileToStrings()));
        }
    }

    private static void writeStringsToFile(String[] strings) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : strings) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private static String[] addBlancLine(String[] strings) {
        int width = Integer.parseInt(strings[0].split(" ")[0]);
        int height = Integer.parseInt(strings[0].split(" ")[1]);
        height++;
        String[] result = new String[height + 1];
        result[0] = width + " " + height;
        result[1] = "#".repeat(width);
        for (int i = 2; i < result.length; i++) {
            result[i] = strings[i - 1];
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    private static String[] readFileToStrings() {
        String[] result = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String dimensions = reader.readLine();
            int numberOfLines = Integer.parseInt(dimensions.split(" ")[1]);
            result = new String[numberOfLines + 1];
            result[0] = dimensions;
            for (int i = 1; i < numberOfLines + 1; i++) {
                result[i] = reader.readLine();
            }
            System.out.println(Arrays.toString(result));
        } catch (IOException e) {
            System.out.println("IO error: " + e.toString());
            e.printStackTrace();
        }
        return result;
    }
}
