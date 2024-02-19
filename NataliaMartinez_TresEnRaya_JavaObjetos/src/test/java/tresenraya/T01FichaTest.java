package tresenraya;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class T01FichaTest {
    @Test
	void siguienteTest() {
        Ficha x = Ficha.X;
        Ficha siguiente = x.siguiente();
        assertNotEquals(x, siguiente);
        assertEquals(Ficha.O, siguiente);
        Ficha otra = siguiente.siguiente();
        assertEquals(Ficha.X, otra);
	}

    @Test
    void longitudTest() {
        assertEquals(2, Ficha.values().length);
    }

    @Test
    void valoresTest() {
        String s = "";
        for (Ficha f : Ficha.values()) {
            s += f;
        }
        assertEquals(2, s.length());
        assertTrue(s.contains("X"));
        assertTrue(s.contains("O"));
    }
}
