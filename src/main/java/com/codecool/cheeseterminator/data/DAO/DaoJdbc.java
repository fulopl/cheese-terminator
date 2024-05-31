package com.codecool.cheeseterminator.data.DAO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DaoJdbc {

    private DataSource dataSource;

    public DaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public void saveMap(List<String> lines) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "DROP TABLE IF EXISTS gamemap;\n" +
                    "CREATE TABLE gamemap (\n" +
                    "    line VARCHAR(50) NOT NULL\n" +
                    ");";
            conn.createStatement().execute(sql);
            for (String line : lines) {
                sql = "INSERT INTO gamemap VALUES ('" + line + "');";
                conn.createStatement().execute(sql);
            }
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException("Error while saving game", e);
        }
    }

    public void saveMapDimensions(int width, int height) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "DROP TABLE IF EXISTS mapdim;\n" +
                    "CREATE TABLE mapdim (\n" +
                    "    width INTEGER,\n" +
                    "    height INTEGER\n" +
                    ");";
            conn.createStatement().execute(sql);
            sql = "INSERT INTO mapdim VALUES (" + width + ", " + height + ");";
            conn.createStatement().execute(sql);
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException("Error while saving game", e);
        }
    }

    public void savePlayer(int playerHealth, int playerAttack) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "DROP TABLE IF EXISTS player;\n" +
                    "CREATE TABLE player (\n" +
                    "    health INTEGER,\n" +
                    "    attack INTEGER\n" +
                    ");";
            conn.createStatement().execute(sql);
            sql = "INSERT INTO public.player VALUES (" + playerHealth + ", " + playerAttack + ");";
            conn.createStatement().execute(sql);
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException("Error while saving game", e);
        }
    }

    public void saveInventory(List<String> inventoryList) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "DROP TABLE IF EXISTS inventory;\n" +
                    "CREATE TABLE inventory (\n" +
                    "    item VARCHAR(50) NOT NULL\n" +
                    ");";
            conn.createStatement().execute(sql);
            for (String item : inventoryList) {
                sql = "INSERT INTO inventory VALUES ('" + item + "');";
                conn.createStatement().execute(sql);
            }
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException("Error while saving game", e);
        }
    }
    public List<String> loadMap() {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT line FROM gamemap";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            List<String> lines = new ArrayList<>();
            while (rs.next()) {
                String line = rs.getString(1);
                lines.add(line);
            }
            return lines;
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException("Error while saving game", e);
        }
    }

    public Map<String, Integer> loadMapDimensions() {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT width, height FROM public.mapdim";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            Map<String, Integer> mapDimensions = new HashMap<>();
            while (rs.next()) {
                mapDimensions.put("width", rs.getInt(1));
                mapDimensions.put("height", rs.getInt(2));
            }
            return mapDimensions;
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException("Error while saving game", e);
        }
    }

    public Map<String, Integer> loadPlayerAttributes() {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT health, attack FROM public.player";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            Map<String, Integer> playerAttributes = new HashMap<>();
            while (rs.next()) {
                playerAttributes.put("health", rs.getInt(1));
                playerAttributes.put("attack", rs.getInt(2));
            }
            return playerAttributes;
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException("Error while saving game", e);
        }
    }
    public List<String> loadInventory() {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT item FROM inventory";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            List<String> inventory = new ArrayList<>();
            while (rs.next()) {
                String line = rs.getString(1);
                inventory.add(line);
            }
            return inventory;
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException("Error while saving game", e);
        }
    }
}

