package com.fulopl.cheeseterminator.model;

import com.fulopl.cheeseterminator.ui.Tile;

public enum GameElementType {
    EMPTY(true, Role.STRUCTURE, ' ', Tile.EMPTY),
    FLOOR(true,Role.STRUCTURE, '.', Tile.FLOOR),
    HOLE(true, Role.STRUCTURE, 'h', Tile.HOLE),
    WALL(false, Role.STRUCTURE, '#', Tile.WALL),
    CHEESE(false, Role.ITEM, 'c', Tile.CHEESE),
    CHEESE_ON_HOLE(false, null, 'x', Tile.CHEESE_ON_HOLE),
    HEART(false,Role.STRUCTURE,'d', Tile.HEART),   // 'd' as dummy
    MOUSE(false, Role.HERO, '@', Tile.MOUSE_WEST),
    N0(false, null, '0', Tile.N0),
    N1(false, null, '1', Tile.N1),
    N2(false, null, '2', Tile.N2),
    N3(false,null, '3', Tile.N3),
    N4(false, null, '4', Tile.N4),
    N5(false, null, '5', Tile.N5),
    N6(false, null, '6', Tile.N6),
    N7(false, null, '7', Tile.N7),
    N8(false, null, '8', Tile.N8),
    N9(false, null, '9', Tile.N9),
    A(false, null, 'A', Tile.A),
    B(false, null, 'B', Tile.B),
    C(false, null, 'C', Tile.C),
    D(false, null, 'D', Tile.D),
    E(false, null, 'E', Tile.E),
    F(false, null, 'F', Tile.F),
    G(false, null, 'G', Tile.G),
    H(false, null, 'H', Tile.H),
    I(false, null, 'I', Tile.I),
    J(false, null, 'J', Tile.J),
    K(false, null, 'K', Tile.K),
    L(false, null, 'L', Tile.L),
    M(false, null, 'M', Tile.M),
    N(false, null, 'N', Tile.N),
    O(false, null, 'O', Tile.O),
    P(false, null, 'P', Tile.P),
    Q(false, null, 'Q', Tile.Q),
    R(false, null, 'R', Tile.R),
    S(false, null, 'S', Tile.S),
    T(false, null, 'T', Tile.T),
    U(false, null, 'U', Tile.U),
    V(false, null, 'V', Tile.V),
    W(false, null, 'W', Tile.W),
    X(false, null, 'X', Tile.X),
    Y(false, null, 'Y', Tile.Y),
    Z(false, null, 'Z', Tile.Z),
    EXCLAMATION(false, null, '!', Tile.EXCLAMATION),
    ;
    private final boolean passable;
    private final Role role;
    private final char mapCharacter;
    private final Tile initialTile;

    GameElementType(boolean passable, Role role, char mapCharacter, Tile initialTile) {
        this.passable = passable;
        this.role = role;
        this.mapCharacter = mapCharacter;
        this.initialTile = initialTile;
    }

    public boolean isPassable() {
        return passable;
    }

    public Role getRole() {
        return role;
    }

    public char getMapCharacter() {
        return mapCharacter;
    }

    public Tile getInitialTile() {
        return initialTile;
    }
}
