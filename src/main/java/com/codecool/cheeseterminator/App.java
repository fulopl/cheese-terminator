package com.codecool.cheeseterminator;

import com.codecool.cheeseterminator.data.DAO.DbManager;
import com.codecool.cheeseterminator.logic.Game;

public class App {
    public static void main(String[] args) {
        DbManager dbManager = new DbManager();
        //dbManager.run();

        Game.main(args);
    }
}
