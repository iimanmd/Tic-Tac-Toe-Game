import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    @Test
    public void testWinningMove_Row() {
        TicTacToe game = new TicTacToe();
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

}