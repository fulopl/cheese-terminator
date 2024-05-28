package com.codecool.dungeoncrawl;

import com.codecool.dungeoncrawl.data.DAO.DbManager;
import com.codecool.dungeoncrawl.logic.Game;

public class App {
    public static void main(String[] args) {
        DbManager dbManager = new DbManager();
        //dbManager.run();

        Game.main(args);
    }
}
