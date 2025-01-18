package com.fulopl.cheeseterminator.model.player;

import com.fulopl.cheeseterminator.model.Cell;
import com.fulopl.cheeseterminator.model.GameElementType;
import com.fulopl.cheeseterminator.model.item.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HeroTest {

    Hero hero;
    Cell mockCell = mock(Cell.class);
    GameElementType mockGameElementType = mock(GameElementType.class);

    Direction mockMovingDirection = mock(Direction.class);
    Cell mockNextCell = mock(Cell.class);
    Item mockItem = mock(Item.class);

    @BeforeEach
    void setup() {
        hero = new Hero(mockGameElementType, mockCell);
    }

    @Test
    void testMove_WhenNoItemIsOnNextCellAndCellIsPassable_ShouldHeroMove() {
        //arrange
        when(mockMovingDirection.getDx()).thenReturn(1);
        when(mockMovingDirection.getDy()).thenReturn(0);
        when(mockCell.getNeighbor(1,0)).thenReturn(mockNextCell);
        when(mockNextCell.getItem()).thenReturn(null);
        when(mockNextCell.isPassable()).thenReturn(true);

        //act
        hero.move(mockMovingDirection);

        //assert
        verify(mockCell).setHero(null);
        verify(mockNextCell).setHero(hero);
        assertEquals(mockNextCell, hero.cell);
    }

    @Test
    void testMove_WhenItemIsOnNextCellAndCellIsPassable_ShouldNotHeroMove() {
        //arrange
        when(mockMovingDirection.getDx()).thenReturn(1);
        when(mockMovingDirection.getDy()).thenReturn(0);
        when(mockCell.getNeighbor(1,0)).thenReturn(mockNextCell);
        when(mockNextCell.getItem()).thenReturn(mockItem);
        when(mockItem.handleItemEncounter(mockMovingDirection)).thenReturn(false);
        when(mockNextCell.isPassable()).thenReturn(true);

        //act
        hero.move(mockMovingDirection);

        //assert
        verify(mockCell, never()).setHero(null);
        verify(mockNextCell, never()).setHero(hero);
        assertEquals(mockCell, hero.cell);
    }

    @Test
    void testMove_WhenNoItemIsOnNextCellAndCellIsNotPassable_ShouldNotHeroMove() {
        //arrange
        when(mockMovingDirection.getDx()).thenReturn(1);
        when(mockMovingDirection.getDy()).thenReturn(0);
        when(mockCell.getNeighbor(1,0)).thenReturn(mockNextCell);
        when(mockNextCell.getItem()).thenReturn(null);
        when(mockNextCell.isPassable()).thenReturn(false);

        //act
        hero.move(mockMovingDirection);

        //assert
        verify(mockCell, never()).setHero(null);
        verify(mockNextCell, never()).setHero(hero);
        assertEquals(mockCell, hero.cell);
    }
}