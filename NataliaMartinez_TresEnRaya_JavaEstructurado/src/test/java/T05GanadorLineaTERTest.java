import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class T05GanadorLineaTERTest {

	private static final int TAM = 3;

	@Test
	void ganadorLineaHTest() {
		char[][] tablero = TresEnRaya.inicializarTablero(TAM);
		for (int i = 0; i < tablero.length; i++) {
			TresEnRaya.jugar(tablero, 0, i, '#');
		}
		boolean ganador = TresEnRaya.comprobarGanador(tablero, '#');
		assertTrue(ganador);
		boolean perdedor = TresEnRaya.comprobarGanador(tablero, '?');
		assertFalse(perdedor);
	}

	@Test
	void ganadorLineaVTest() {
		char[][] tablero = TresEnRaya.inicializarTablero(TAM);
		for (int i = 0; i < tablero.length; i++) {
			TresEnRaya.jugar(tablero, i, 1, 'S');
		}
		boolean ganador = TresEnRaya.comprobarGanador(tablero, 'S');
		assertTrue(ganador);
		boolean perdedor = TresEnRaya.comprobarGanador(tablero, 'I');
		assertFalse(perdedor);
	}
}
