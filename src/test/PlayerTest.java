import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getName() {
        Player player = new Player();
        player.setName("Test Player");
        assertEquals("Test Player", player.getName(), "Name must be equal");
    }

    @Test
    void setName() {
        Player player = new Player();
        player.setName("Test Player");
        assertEquals("Test Player", player.getName(), "Name must be equal");
    }

    @Test
    void getSign() {
        Player player = new Player();
        assertEquals(Sign.cross, player.getSign(), "default should be cross");
    }

    @Test
    void setSign() {
        Player player = new Player();
        player.setSign(Sign.circle);
        assertEquals(Sign.circle, player.getSign(), "Sign could changed");
    }
}