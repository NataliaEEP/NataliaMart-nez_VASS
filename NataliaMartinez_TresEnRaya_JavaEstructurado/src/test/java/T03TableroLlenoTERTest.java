import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class T03TableroLlenoTERTest {

	private static final int TAM = 3;

	private static final String RELLENAR = "ABCDEFGHI";
	
	/**
	 * El tablero recién inicializado no está lleno.
	 */
	@Test
	void estaLlenoVacioTest() {
		char[][] tablero = TresEnRaya.inicializarTablero(TAM);
		boolean lleno = TresEnRaya.tableroLleno(tablero);
		assertFalse(lleno);
	}

	/**
	 * El tablero, llenándose, solo está lleno al final.
	 */
	@Test
	void estaLlenoAMediasTest() {
		char[][] tablero = TresEnRaya.inicializarTablero(TAM);
		char[] obj = RELLENAR.toCharArray();
		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				char letra = obj[i * TAM + j];
				TresEnRaya.jugar(tablero, i, j, letra);
				boolean lleno = TresEnRaya.tableroLleno(tablero);
				assertEquals(i == TAM-1 && j == TAM-1, lleno);
			}
		}
	}

	/**
	 * El tablero, llenándose, solo está lleno al final, poco importa el orden de llenado.
	 */
	@Test
	void estaLlenoAMediasRevesTest() {
		char[][] tablero = TresEnRaya.inicializarTablero(TAM);
		char[] obj = RELLENAR.toCharArray();
		
		for (int j = tablero.length - 1; j >= 0; j--) {
			for (int i = tablero.length - 1; i >= 0; i--) {
				char letra = obj[i * TAM + j];
				TresEnRaya.jugar(tablero, i, j, letra);
				boolean lleno = TresEnRaya.tableroLleno(tablero);
				assertEquals(i == 0 && j == 0, lleno);
			}
		}
	}
}
