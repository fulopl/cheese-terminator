package com.codecool.cheeseterminator.ui;

import com.codecool.cheeseterminator.data.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Tiles {
 //   public static int TILE_WIDTH = 32;

  //  private static final Image tileset = new Image("/tiles.png", 543 * 2, 543 * 2, true, false);
//    private static final Map<String, Tile> tileMap = new HashMap<>();
//
//    public static class Tile {
//        public final int x, y, w, h;

//        Tile(int i, int j) {
//            x = i * (TILE_WIDTH + 2);
//            y = j * (TILE_WIDTH + 2);
//            w = TILE_WIDTH;
//            h = TILE_WIDTH;
//        }
    //   }

//    static {
//        for (TileType tileType : TileType.values()) {
//            tileMap.put(tileType.getTileName(), new Tile(tileType.getImgCoordinateX(), tileType.getImgCoordinateY()));
//        }
//        tileMap.put("empty", new Tile(0, 0));
//        tileMap.put("wall", new Tile(10, 17));
//        tileMap.put("floor", new Tile(2, 0));
//        tileMap.put("cheese", new Tile(18, 28));
//        tileMap.put("hole", new Tile(23, 25));
//        tileMap.put("player", new Tile(31, 8));
    //   }

//    public static void drawTile(GraphicsContext context, Drawable drawable, int x, int y) {
//        //Tile tile = tileMap.get(drawable.getTileName());
//        //context.drawImage(tileset, tile.x, tile.y, tile.w, tile.h, x * TILE_WIDTH, y * TILE_WIDTH, TILE_WIDTH, TILE_WIDTH);
//        TileType tileType = TileType.valueOf(drawable.getTileName().toUpperCase());
//        context.drawImage(tileset
//                , tileType.getColumnIndex() * (TILE_WIDTH + 2)
//                , tileType.getRowIndex() * (TILE_WIDTH + 2)
//                , TILE_WIDTH
//                , TILE_WIDTH
//                , x * TILE_WIDTH
//                , y * TILE_WIDTH
//                , TILE_WIDTH
//                , TILE_WIDTH);
//    }
}
