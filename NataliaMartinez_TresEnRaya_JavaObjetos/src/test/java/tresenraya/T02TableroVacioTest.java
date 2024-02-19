package tresenraya;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class T02TableroVacioTest {
	private static final String N = System.lineSeparator();
	private static final int TAM = 3;

	/**
   |   |   
---+---+---
   |   |   
---+---+---
   |   |     	
	 */
	private static final String PINTAR_VACIO = "   |   |   " + N + "---+---+---" + N + "   |   |   " + N + "---+---+---" + N + "   |   |   " + N + "";


	@Test
	void crearTableroTest() {
		Tablero tablero = new Tablero(TAM);
		assertFalse(tablero.estaLleno());
		for (int i = 0; i < TAM; i++) {
			for (int j = 0; j < TAM; j++) {
				assertTrue(tablero.jugar(Ficha.O, i, j));
			}
		}
	}
	
	@Test
	void pintarTableroVacioTest() {
		Tablero tablero = new Tablero(TAM);
		String salida = tablero.toString();
		assertEquals(PINTAR_VACIO, salida);
	}
}
