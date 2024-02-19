import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class T06GanadorDiagonalesTERTest {

	private static final int TAM = 3;

	@Test
	void ganadorDiagonal1Test() {
		char[][] tablero = TresEnRaya.inicializarTablero(TAM);
		for (int i = 0; i < tablero.length; i++) {
			TresEnRaya.jugar(tablero, i, i, '1');
		}
		boolean ganador = TresEnRaya.comprobarGanador(tablero, '1');
		assertTrue(ganador);
		boolean perdedor = TresEnRaya.comprobarGanador(tablero, '2');
		assertFalse(perdedor);
	}

	
	@Test
	void ganadorDiagonal2Test() {
		char[][] tablero = TresEnRaya.inicializarTablero(TAM);
		for (int i = 0; i < tablero.length; i++) {
			TresEnRaya.jugar(tablero, i, TAM-1-i, 'Z');
		}
		boolean ganador = TresEnRaya.comprobarGanador(tablero, 'Z');
		assertTrue(ganador);
		boolean perdedor = TresEnRaya.comprobarGanador(tablero, 'Y');
		assertFalse(perdedor);
	}
}
