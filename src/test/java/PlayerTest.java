import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    public void testGetMarker() {
        Player player = new Player('X');
        assertEquals('X', player.getMarker());
    }
}
