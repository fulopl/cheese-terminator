package com.fulopl.cheeseterminator.model;

import com.fulopl.cheeseterminator.ui.Tile;

import java.util.HashMap;
import java.util.Map;

public class GameElementType {

    private final String name;
    private final boolean passable;
    private final Role role;
    private final char mapCharacter;
    private final Tile initialTile;

    public static final Map<Character, GameElementType> CHARACTER_MAP = new HashMap<>();

    public static GameElementType EMPTY;
    public static GameElementType FLOOR;
    public static GameElementType HOLE;
    public static GameElementType WALL;
    public static GameElementType CHEESE;
    public static GameElementType CHEESE_ON_HOLE;
    public static GameElementType MOUSE;

    public static GameElementType N0, N1, N2, N3, N4, N5, N6, N7, N8, N9;
    public static GameElementType A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z;
    public static GameElementType EXCLAMATION;

    public GameElementType(String name, boolean passable, Role role, char mapCharacter, Tile initialTile) {
        this.name = name;
        this.passable = passable;
        this.role = role;
        this.mapCharacter = mapCharacter;
        this.initialTile = initialTile;
        CHARACTER_MAP.put(mapCharacter, this);
    }

    public static void init() {
        EMPTY = new GameElementType("EMPTY", true, Role.STRUCTURE, ' ', Tile.EMPTY);
        FLOOR = new GameElementType("FLOOR", true, Role.STRUCTURE, '.', Tile.FLOOR);
        HOLE = new GameElementType("HOLE", true, Role.STRUCTURE, 'h', Tile.HOLE);
        WALL = new GameElementType("WALL", false, Role.STRUCTURE, '#', Tile.WALL);
        CHEESE = new GameElementType("CHEESE", false, Role.ITEM, 'c', Tile.CHEESE);
        CHEESE_ON_HOLE = new GameElementType("CHEESE_ON_HOLE", true, Role.ITEM, 'x', Tile.CHEESE);
        MOUSE = new GameElementType("MOUSE", false, Role.HERO, '@', Tile.MOUSE);

        N0 = new GameElementType("N0", false, Role.STRUCTURE, '0', Tile.N0);
        N1 = new GameElementType("N1", false, Role.STRUCTURE, '1', Tile.N1);
        N2 = new GameElementType("N2", false, Role.STRUCTURE, '2', Tile.N2);
        N3 = new GameElementType("N3", false, Role.STRUCTURE, '3', Tile.N3);
        N4 = new GameElementType("N4", false, Role.STRUCTURE, '4', Tile.N4);
        N5 = new GameElementType("N5", false, Role.STRUCTURE, '5', Tile.N5);
        N6 = new GameElementType("N6", false, Role.STRUCTURE, '6', Tile.N6);
        N7 = new GameElementType("N7", false, Role.STRUCTURE, '7', Tile.N7);
        N8 = new GameElementType("N8", false, Role.STRUCTURE, '8', Tile.N8);
        N9 = new GameElementType("N9", false, Role.STRUCTURE, '9', Tile.N9);

        A = new GameElementType("A", false, Role.STRUCTURE, 'A', Tile.A);
        B = new GameElementType("B", false, Role.STRUCTURE, 'B', Tile.B);
        C = new GameElementType("C", false, Role.STRUCTURE, 'C', Tile.C);
        D = new GameElementType("D", false, Role.STRUCTURE, 'D', Tile.D);
        E = new GameElementType("E", false, Role.STRUCTURE, 'E', Tile.E);
        F = new GameElementType("F", false, Role.STRUCTURE, 'F', Tile.F);
        G = new GameElementType("G", false, Role.STRUCTURE, 'G', Tile.G);
        H = new GameElementType("H", false, Role.STRUCTURE, 'H', Tile.H);
        I = new GameElementType("I", false, Role.STRUCTURE, 'I', Tile.I);
        J = new GameElementType("J", false, Role.STRUCTURE, 'J', Tile.J);
        K = new GameElementType("K", false, Role.STRUCTURE, 'K', Tile.K);
        L = new GameElementType("L", false, Role.STRUCTURE, 'L', Tile.L);
        M = new GameElementType("M", false, Role.STRUCTURE, 'M', Tile.M);
        N = new GameElementType("N", false, Role.STRUCTURE, 'N', Tile.N);
        O = new GameElementType("O", false, Role.STRUCTURE, 'O', Tile.O);
        P = new GameElementType("P", false, Role.STRUCTURE, 'P', Tile.P);
        Q = new GameElementType("Q", false, Role.STRUCTURE, 'Q', Tile.Q);
        R = new GameElementType("R", false, Role.STRUCTURE, 'R', Tile.R);
        S = new GameElementType("S", false, Role.STRUCTURE, 'S', Tile.S);
        T = new GameElementType("T", false, Role.STRUCTURE, 'T', Tile.T);
        U = new GameElementType("U", false, Role.STRUCTURE, 'U', Tile.U);
        V = new GameElementType("V", false, Role.STRUCTURE, 'V', Tile.V);
        W = new GameElementType("W", false, Role.STRUCTURE, 'W', Tile.W);
        X = new GameElementType("X", false, Role.STRUCTURE, 'X', Tile.X);
        Y = new GameElementType("Y", false, Role.STRUCTURE, 'Y', Tile.Y);
        Z = new GameElementType("Z", false, Role.STRUCTURE, 'Z', Tile.Z);
        EXCLAMATION = new GameElementType("EXCLAMATION", false, Role.STRUCTURE, '!', Tile.EXCLAMATION);
    }

    public String getName() {
        return name;
    }

    public boolean isPassable() {
        return passable;
    }

    public Tile getInitialTile() {
        return initialTile;
    }
}


//package com.fulopl.cheeseterminator.model;
//
//import com.fulopl.cheeseterminator.ui.Tile;
//
//public enum GameElementType {
//    DUMMY_PASSABLE(true, Role.STRUCTURE, '§', null ),
//    EMPTY(true, Role.STRUCTURE, ' ', Tile.EMPTY),
//    FLOOR(true,Role.STRUCTURE, '.', Tile.FLOOR),
//    HOLE(true, Role.STRUCTURE, 'h', Tile.HOLE),
//    WALL(false, Role.STRUCTURE, '#', Tile.WALL),
//    CHEESE(false, Role.ITEM, 'c', Tile.CHEESE),
//    CHEESE_ON_HOLE(true, Role.ITEM, 'x', Tile.CHEESE),
//    MOUSE(false, Role.HERO, '@', Tile.MOUSE),
//    N0(false, Role.STRUCTURE, '0', Tile.N0),
//    N1(false, Role.STRUCTURE, '1', Tile.N1),
//    N2(false, Role.STRUCTURE, '2', Tile.N2),
//    N3(false, Role.STRUCTURE, '3', Tile.N3),
//    N4(false, Role.STRUCTURE, '4', Tile.N4),
//    N5(false, Role.STRUCTURE, '5', Tile.N5),
//    N6(false, Role.STRUCTURE, '6', Tile.N6),
//    N7(false, Role.STRUCTURE, '7', Tile.N7),
//    N8(false, Role.STRUCTURE, '8', Tile.N8),
//    N9(false, Role.STRUCTURE, '9', Tile.N9),
//    A(false, Role.STRUCTURE, 'A', Tile.A),
//    B(false, Role.STRUCTURE, 'B', Tile.B),
//    C(false, Role.STRUCTURE, 'C', Tile.C),
//    D(false, Role.STRUCTURE, 'D', Tile.D),
//    E(false, Role.STRUCTURE, 'E', Tile.E),
//    F(false, Role.STRUCTURE, 'F', Tile.F),
//    G(false, Role.STRUCTURE, 'G', Tile.G),
//    H(false, Role.STRUCTURE, 'H', Tile.H),
//    I(false, Role.STRUCTURE, 'I', Tile.I),
//    J(false, Role.STRUCTURE, 'J', Tile.J),
//    K(false, Role.STRUCTURE, 'K', Tile.K),
//    L(false, Role.STRUCTURE, 'L', Tile.L),
//    M(false, Role.STRUCTURE, 'M', Tile.M),
//    N(false, Role.STRUCTURE, 'N', Tile.N),
//    O(false, Role.STRUCTURE, 'O', Tile.O),
//    P(false, Role.STRUCTURE, 'P', Tile.P),
//    Q(false, Role.STRUCTURE, 'Q', Tile.Q),
//    R(false, Role.STRUCTURE, 'R', Tile.R),
//    S(false, Role.STRUCTURE, 'S', Tile.S),
//    T(false, Role.STRUCTURE, 'T', Tile.T),
//    U(false, Role.STRUCTURE, 'U', Tile.U),
//    V(false, Role.STRUCTURE, 'V', Tile.V),
//    W(false, Role.STRUCTURE, 'W', Tile.W),
//    X(false, Role.STRUCTURE, 'X', Tile.X),
//    Y(false, Role.STRUCTURE, 'Y', Tile.Y),
//    Z(false, Role.STRUCTURE, 'Z', Tile.Z),
//    EXCLAMATION(false, Role.STRUCTURE, '!', Tile.EXCLAMATION),
//    ;
//    private final boolean passable;
//    private final Role role;
//    private final char mapCharacter;
//    private final Tile initialTile;
//
//    GameElementType(boolean passable, Role role, char mapCharacter, Tile initialTile) {
//        this.passable = passable;
//        this.role = role;
//        this.mapCharacter = mapCharacter;
//        this.initialTile = initialTile;
//    }
//
//    public boolean isPassable() {
//        return passable;
//    }
//
//    public Role getRole() {
//        return role;
//    }
//
//    public char getMapCharacter() {
//        return mapCharacter;
//    }
//
//    public Tile getInitialTile() {
//        return initialTile;
//    }
//}
