package com.fulopl.cheeseterminator.model;

import com.fulopl.cheeseterminator.ui.Tile;

public enum GameElementType {
    EMPTY(true, Role.STRUCTURE, ' ', Tile.EMPTY),
    FLOOR(true,Role.STRUCTURE, '.', Tile.FLOOR),
    HOLE(true, Role.STRUCTURE, 'h', Tile.HOLE),
    WALL(false, Role.STRUCTURE, '#', Tile.WALL),
    CHEESE(false, Role.ITEM, 'c', Tile.CHEESE),
    CHEESE_ON_HOLE(true, Role.ITEM, 'x', Tile.CHEESE),
    MOUSE(false, Role.HERO, '@', Tile.MOUSE),
    N0(false, Role.STRUCTURE, '0', Tile.N0),
    N1(false, Role.STRUCTURE, '1', Tile.N1),
    N2(false, Role.STRUCTURE, '2', Tile.N2),
    N3(false, Role.STRUCTURE, '3', Tile.N3),
    N4(false, Role.STRUCTURE, '4', Tile.N4),
    N5(false, Role.STRUCTURE, '5', Tile.N5),
    N6(false, Role.STRUCTURE, '6', Tile.N6),
    N7(false, Role.STRUCTURE, '7', Tile.N7),
    N8(false, Role.STRUCTURE, '8', Tile.N8),
    N9(false, Role.STRUCTURE, '9', Tile.N9),
    A(false, Role.STRUCTURE, 'A', Tile.A),
    B(false, Role.STRUCTURE, 'B', Tile.B),
    C(false, Role.STRUCTURE, 'C', Tile.C),
    D(false, Role.STRUCTURE, 'D', Tile.D),
    E(false, Role.STRUCTURE, 'E', Tile.E),
    F(false, Role.STRUCTURE, 'F', Tile.F),
    G(false, Role.STRUCTURE, 'G', Tile.G),
    H(false, Role.STRUCTURE, 'H', Tile.H),
    I(false, Role.STRUCTURE, 'I', Tile.I),
    J(false, Role.STRUCTURE, 'J', Tile.J),
    K(false, Role.STRUCTURE, 'K', Tile.K),
    L(false, Role.STRUCTURE, 'L', Tile.L),
    M(false, Role.STRUCTURE, 'M', Tile.M),
    N(false, Role.STRUCTURE, 'N', Tile.N),
    O(false, Role.STRUCTURE, 'O', Tile.O),
    P(false, Role.STRUCTURE, 'P', Tile.P),
    Q(false, Role.STRUCTURE, 'Q', Tile.Q),
    R(false, Role.STRUCTURE, 'R', Tile.R),
    S(false, Role.STRUCTURE, 'S', Tile.S),
    T(false, Role.STRUCTURE, 'T', Tile.T),
    U(false, Role.STRUCTURE, 'U', Tile.U),
    V(false, Role.STRUCTURE, 'V', Tile.V),
    W(false, Role.STRUCTURE, 'W', Tile.W),
    X(false, Role.STRUCTURE, 'X', Tile.X),
    Y(false, Role.STRUCTURE, 'Y', Tile.Y),
    Z(false, Role.STRUCTURE, 'Z', Tile.Z),
    EXCLAMATION(false, Role.STRUCTURE, '!', Tile.EXCLAMATION),
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
