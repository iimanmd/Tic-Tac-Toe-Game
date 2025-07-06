import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicTacToeTest {
    private TicTacToe game;

    @BeforeEach
    public void setup() {
        game = new TicTacToe();
        game.start();  // Oder man initialisiert Spieler & Board manuell
    }

    @Test
    public void testHasWinner_Row() {
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'X');
        game.board.place(0, 2, 'X');
        game.currentPlayer = game.player1;  // Spieler X annehmen
        assertTrue(game.hasWinner());
    }

    @Test
    public void testHasWinner_NoWinner() {
        game.board.place(0, 0, 'X');
        game.board.place(1, 1, 'O');
        game.currentPlayer = game.player1;
        assertFalse(game.hasWinner());
    }
}
