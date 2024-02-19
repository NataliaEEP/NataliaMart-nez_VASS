import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class T01PrepararTERTest {

	private static final int TAM = 3;
	private static final String N = System.lineSeparator();

	/**
   |   |   
---+---+---
   |   |   
---+---+---
   |   |     	
	 */
	private static final String PINTAR_VACIO = "   |   |   " + N + "---+---+---" + N + "   |   |   " + N + "---+---+---" + N + "   |   |   " + N + "";

	@Test
	void inicializarTableroTest() {
		char[][] tablero = TresEnRaya.inicializarTablero(TAM);
		assertEquals(TAM, tablero.length);
		for (int i = 0; i < tablero.length; i++) {
			assertEquals(TAM, tablero[i].length);
			for (int j = 0; j < tablero.length; j++) {
				assertEquals(' ', tablero[i][j]);
			}
		}
	}
	
	@Test
	void pintarTableroVacioTest() {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));
		
		char[][] tablero = TresEnRaya.inicializarTablero(TAM);
		TresEnRaya.pintarTablero(tablero);
		String salida = bos.toString();
		assertEquals(PINTAR_VACIO, salida);
		
		System.setOut(originalOut);
	}
}
