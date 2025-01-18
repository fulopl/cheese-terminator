package com.fulopl.cheeseterminator.model.item;

import com.fulopl.cheeseterminator.model.Cell;
import com.fulopl.cheeseterminator.model.GameElement;
import com.fulopl.cheeseterminator.model.GameElementType;
import com.fulopl.cheeseterminator.model.Role;
import com.fulopl.cheeseterminator.model.player.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CheeseTest {

    private Cell mockCell = mock(Cell.class);

    private Cell mockNextCell = mock(Cell.class);

    private Direction mockDirection = mock(Direction.class);

    private GameElement mockGameElement = mock(GameElement.class);

    private GameElementType mockGameElementType = mock(GameElementType.class);

    private Cheese cheese;

    @BeforeEach
    void setUp() {
        //MockitoAnnotations.openMocks(this);
        cheese = new Cheese(mockGameElementType, mockCell);
        Cheese.cheeseTotal = 10;
        Cheese.cheeseInHole = 10;

    }

    @Test
    void testReset_ShouldSetCheeseStaticVariablesToZero() {
        //arrange

        //act
        Cheese.reset();

        //assert
        assertEquals(0, Cheese.getCheeseTotal());
        assertEquals(0, Cheese.getCheeseInHole());
    }

    @Test
    void testMove_WhenNextCellIsPassableAndEmpty_ShouldReturnTrue() {
        //arrange
        when(mockDirection.getDx()).thenReturn(1);
        when(mockDirection.getDy()).thenReturn(0);
        when(mockCell.getNeighbor(1, 0)).thenReturn(mockNextCell);
        when(mockNextCell.isPassable()).thenReturn(true);
        when(mockNextCell.getItem()).thenReturn(null);
        when(mockNextCell.getStructure()).thenReturn(mockGameElement);
        when(mockGameElement.getGameElementType()).thenReturn(GameElementType.FLOOR);

        //act
        boolean result = cheese.move(mockDirection);

        //assert
        assertTrue(result);
        verify(mockCell).setItem(null);
        verify(mockNextCell).setItem(cheese);
    }

    @Test
    void testMove_WhenNextCellIsPassableAndHole_ShouldReturnTrueAndIncrementCheeseInHole() {
        //arrange
        Cell originalCell = mockCell;
        Cell originalNextCell = mockNextCell;
        when(mockCell.getNeighbor(1, 0)).thenReturn(mockNextCell);
        when(mockNextCell.isPassable()).thenReturn(true);
        when(mockNextCell.getItem()).thenReturn(null);
        when(mockNextCell.getStructure()).thenReturn(mockGameElement);
        GameElementType.HOLE = new GameElementType("HOLE", true, Role.STRUCTURE
                , 'h', null);
        when(mockGameElement.getGameElementType()).thenReturn(GameElementType.HOLE);
        //act
        boolean result = cheese.move(Direction.EAST);
        //assert
        verify(originalCell).setItem(null);
        verify(originalNextCell).setItem(cheese);
        assertEquals(mockNextCell, cheese.cell);
        assertEquals(11, Cheese.getCheeseInHole());
        assertTrue(cheese.inHole);
        assertTrue(result);
    }

    @Test
    void testMove_WhenCheeseIsOnHoleAndMovesToNonHole_ShouldReturnTrueAndDecrementCheeseInHole() {
        //arrange
        Cell originalCell = mockCell;
        when(mockDirection.getDx()).thenReturn(1);
        when(mockDirection.getDy()).thenReturn(0);
        when(mockCell.getNeighbor(1, 0)).thenReturn(mockNextCell);
        when(mockNextCell.isPassable()).thenReturn(true);
        when(mockNextCell.getItem()).thenReturn(null);
        cheese.inHole = true;
        when(mockNextCell.getStructure()).thenReturn(mockGameElement);
        when(mockGameElement.getGameElementType()).thenReturn(GameElementType.FLOOR);

        //act
        boolean result = cheese.move(mockDirection);

        //assert
        verify(originalCell).setItem(null);
        verify(mockNextCell).setItem(cheese);
        assertEquals(mockNextCell, cheese.cell);
        assertEquals(9, Cheese.cheeseInHole);
        assertFalse(cheese.inHole);
    }

    @Test
    void testMove_WhenNextCellIsNotPassable_ShouldReturnFalse() {
        //arrange
        Cell originalCell = mockCell;
        when(mockDirection.getDx()).thenReturn(0);
        when(mockDirection.getDy()).thenReturn(1);
        when(mockCell.getNeighbor(0, 1)).thenReturn(mockNextCell);
        when(mockNextCell.isPassable()).thenReturn(false);
        //act
        boolean result = cheese.move(mockDirection);
        //assert
        verify(mockCell, never()).setItem(null);
        verify(mockNextCell, never()).setItem(cheese);
        assertEquals(originalCell, cheese.cell);
        assertFalse(result);
    }

    @Test
    void testIsInHole_WhenCellStructureIsHole_ShouldReturnTrue() {
        //arrange
        when(mockCell.getStructure()).thenReturn(mockGameElement);
        when(mockGameElement.getGameElementType()).thenReturn(GameElementType.HOLE);

        //act
        boolean result = cheese.isInHole();

        //assert
        assertTrue(result);
    }

    @Test
    void testIsInHole_WhenCellStructureIsNotHole_ShouldReturnFalse() {
        //arrange
        when(mockCell.getStructure()).thenReturn(mockGameElement);
        when(mockGameElement.getGameElementType()).thenReturn(new GameElementType("FLOOR", true
                , Role.STRUCTURE, ' ', null));

        //act
        boolean result = cheese.isInHole();

        //assert
        assertFalse(result);
    }
}
