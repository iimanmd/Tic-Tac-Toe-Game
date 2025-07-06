import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
    }

    @Test
    public void testIsCellEmpty_Positive() {
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    public void testPlaceAndIsCellEmpty_Negative() {
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    public void testIsFull_Positive() {
        // Fülle das Board komplett
        for(int i = 0; i < 3; i++) {
            for(int j=0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    public void testIsFull_Negative() {
        assertFalse(board.isFull());
    }

    @Test
    public void testClear() {
        board.place(0, 0, 'O');
        board.clear();
        assertTrue(board.isCellEmpty(0, 0));
    }
}
