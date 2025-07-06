import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {
    private TicTacToe game;

    @BeforeEach
    public void setup() {
        game = new TicTacToe();
       
    }

    @Test
    public void testWinningMove_Row() {
        game.makeMove(0, 0); // X
        game.switchCurrentPlayer();
        game.makeMove(1, 0); // O
        game.switchCurrentPlayer();
        game.makeMove(0, 1); // X
        game.switchCurrentPlayer();
        game.makeMove(1, 1); // O
        game.switchCurrentPlayer();
        game.makeMove(0, 2); // X wins

        assertTrue(game.hasWinner());
        assertEquals('X', game.getCurrentPlayer().getMarker());
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
