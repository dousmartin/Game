package ru.netology.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testWhenSecondPlayerWin() {
        Player igor = new Player(1, "Igor", 100);
        Player mark = new Player(2, "Mark", 120);
        Game game = new Game();

        game.register(igor);
        game.register(mark);

        int expected = 2;
        int actual = game.round("Igor", "Mark");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerWin() {
        Player igor = new Player(1, "Igor", 120);
        Player mark = new Player(2, "Mark", 100);
        Game game = new Game();

        game.register(igor);
        game.register(mark);

        int expected = 1;
        int actual = game.round("Igor", "Mark");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenNobodyWin() {
        Player igor = new Player(1, "Igor", 120);
        Player mark = new Player(2, "Mark", 120);
        Game game = new Game();

        game.register(igor);
        game.register(mark);

        int expected = 0;
        int actual = game.round("Igor", "Mark");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotExist() {
        Player igor = new Player(1, "Igor", 120);
        Player mark = new Player(2, "Mark", 120);
        Game game = new Game();

        game.register(igor);
        game.register(mark);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Anton", "Mark"));
    }

    @Test
    public void testWhenSecondPlayerNotExist() {
        Player igor = new Player(1, "Igor", 120);
        Player mark = new Player(2, "Mark", 120);
        Game game = new Game();

        game.register(igor);
        game.register(mark);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Igor", "Anton"));
    }

    @Test
    public void testWhenAllPlayersNotExist() {
        Player igor = new Player(1, "Igor", 120);
        Player mark = new Player(2, "Mark", 120);
        Game game = new Game();

        game.register(igor);
        game.register(mark);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Sergey", "Anton"));
    }
}