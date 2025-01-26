package com.fulopl.cheeseterminator.logic;

import com.fulopl.cheeseterminator.model.GameMap;
import com.fulopl.cheeseterminator.ui.UI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;

class GameLogicTest {
    private GameLogic underTest;

    private final UI mockUI = mock(UI.class);
    private final InputManager mockInputManager = mock(InputManager.class);

    @BeforeEach
    void setUp() {
        underTest = new GameLogic(mockUI, mockInputManager);

        UI ui = mock(UI.class);

    }

    @Test
    void setupScreen() {
   // try (MockedStatic<MapLoader> mockedStaticMapLoader = mockStatic(MapLoader.class)) {
        //arrange
       // mockedStaticMapLoader.when(() -> MapLoader.createGameMapFromFile("welcome.txt")).thenReturn(new GameMap(10,10, null));
        //act
      //  underTest.setupScreen("welcome.txt", "Welcome!");
        //assert
       // mockedStaticMapLoader.verify(() -> MapLoader.createGameMapFromFile("welcome.txt"));
      //  }
    }
}