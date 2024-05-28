package com.codecool.dungeoncrawl.data.DAO;

import com.codecool.dungeoncrawl.data.GameMap;
import credentials.Credentials;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbManager {

    private static DataSource connect() throws SQLException {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setDatabaseName("dungeon");
        dataSource.setUser("postgres");
        dataSource.setPassword(Credentials.pw);

        System.out.println("Trying to connect...");
        dataSource.getConnection().close();
        System.out.println("Connection OK");

        return dataSource;
    }

    public static void saveGame(List<String> lines, int width, int height, int playerHealth, int playerAttack, List<String> inventoryList) {
        try {
            DataSource dataSource = connect();
            DaoJdbc daoJdbc = new DaoJdbc(dataSource);
            daoJdbc.saveMap(lines);
            daoJdbc.saveMapDimensions(width, height);
            daoJdbc.savePlayer(playerHealth, playerAttack);
            daoJdbc.saveInventory(inventoryList);
        } catch (SQLException throwables) {
            System.err.println("Could not connect to the database.");
        }
    }
    public static List<String> loadMap() {
            List<String> lines = new ArrayList<>();
        try {
            DataSource dataSource = connect();
            DaoJdbc daoJdbc = new DaoJdbc(dataSource);
            lines = daoJdbc.loadMap();
        } catch (SQLException throwables) {
            System.err.println("Could not connect to the database.");
        }
        return lines;
    }
    public static Map<String, Integer> loadMapDimensions() {
        Map<String, Integer> mapDimensions = new HashMap<>();
        try {
            DataSource dataSource = connect();
            DaoJdbc daoJdbc = new DaoJdbc(dataSource);
            mapDimensions = daoJdbc.loadMapDimensions();
        } catch (SQLException throwables) {
            System.err.println("Could not connect to the database.");
        }
        return mapDimensions;
    }
    public static List<String> loadPlayer(GameMap map) {
        Map<String, Integer> playerAttributes = new HashMap<>();
        List<String> inventoryList = new ArrayList<>();
        try {
            DataSource dataSource = connect();
            DaoJdbc daoJdbc = new DaoJdbc(dataSource);
            playerAttributes = daoJdbc.loadPlayerAttributes();
            inventoryList = daoJdbc.loadInventory();
        } catch (SQLException throwables) {
            System.err.println("Could not connect to the database.");
        }
        map.getPlayer().setHealth(playerAttributes.get("health"));
        map.getPlayer().setBaseAttack(playerAttributes.get("attack"));
        return inventoryList;
    }
}
