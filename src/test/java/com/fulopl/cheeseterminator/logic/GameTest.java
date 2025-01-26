package com.fulopl.cheeseterminator.logic;

import com.fulopl.cheeseterminator.model.GameElementType;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameTest {
    Game underTest;

    MockedStatic<GameElementType> mockedStaticGameElementType = mockStatic(GameElementType.class);
    Stage mockStage = mock(Stage.class);

    @BeforeEach
    void setUp() {
        underTest = new Game();
    }

    @Test
    void start() {
        //arrange

        //act
          //  underTest.start(mockStage);
        //assert
    }
}