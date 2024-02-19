package tresenraya;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class T08PartidaTerminadaTest {

	private static final int TAM = 3;

	@Test
	void terminadaNuevaTest() {
		Partida partida = new Partida(TAM);
		assertFalse(partida.terminada());
	}

	/**
	 *  X | O | X 
	 * ---+---+---
 	 *  O | X | X  
	 * ---+---+---
	 *  O | X | O  
	 */
	@Test
	void terminadaAMediasTest() {
		Partida partida = new Partida(TAM);
		
		for (int i = 0; i < TAM; i++) {
			for (int j = 0; j < TAM - i; j++) {
				partida.jugar(i, j);
				assertFalse(partida.terminada());
			}
		}
		partida.jugar(2, 1); // X
		assertFalse(partida.terminada());
		partida.jugar(2, 2); // O
		assertFalse(partida.terminada());
		partida.jugar(1, 2); // X
		assertTrue(partida.terminada());
		assertNull(partida.ganador());
	}

	/**
	 *  X | O | X 
	 * ---+---+---
 	 *  O | X | O  
	 * ---+---+---
	 *  X | O | X  
	 */
	@Test
	void terminadaAlternosTest() {
		Partida partida = new Partida(TAM);
		int cont = 0;
		
		for (int i = 0; i < TAM; i++) {
			for (int j = 0; j < TAM; j++) {
				partida.jugar(i, j);
				cont ++;
				assertEquals(cont >= 7, partida.terminada());
				assertEquals(cont >= 7 ? Ficha.X : null, partida.ganador());

			}
		}
	}
}
