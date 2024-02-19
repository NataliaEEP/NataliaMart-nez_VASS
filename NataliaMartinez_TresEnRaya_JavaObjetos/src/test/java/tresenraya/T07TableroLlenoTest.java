package tresenraya;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class T07TableroLlenoTest {

	private static final int TAM = 3;

	/**
	 * El tablero recién inicializado no está lleno.
	 */
	@Test
	void estaLlenoVacioTest() {
		Tablero tablero = new Tablero(TAM);
		boolean lleno = tablero.estaLleno();
		assertFalse(lleno);
	}

	/**
	 * El tablero, llenándose, solo está lleno al final.
	 */
	@Test
	void estaLlenoAMediasTest() {
		Tablero tablero = new Tablero(TAM);
		
		for (int i = 0; i < TAM; i++) {
			for (int j = 0; j < TAM; j++) {
				tablero.jugar((i*j %2 == 0)? Ficha.X : Ficha.O, i, j);
				boolean lleno = tablero.estaLleno();
				assertEquals(i == TAM-1 && j == TAM-1, lleno);
			}
		}
	}

	/**
	 * El tablero, llenándose, solo está lleno al final, poco importa el orden de llenado.
	 */
	@Test
	void estaLlenoAMediasRevesTest() {
		Tablero tablero = new Tablero(TAM);
		
		for (int j = TAM - 1; j >= 0; j--) {
			for (int i = TAM - 1; i >= 0; i--) {
				tablero.jugar((i*j %2 == 0)? Ficha.X : Ficha.O, i, j);
				boolean lleno = tablero.estaLleno();
				assertEquals(i == 0 && j == 0, lleno);
			}
		}
	}
}
