import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class T04SinGanadorTERTest {

	private static final int TAM = 3;

	private static final String RELLENAR = "ABCDEFGHI";
	
	/**
	 * En el tablero recién inicializado no hay ganador.
	 */
	@Test
	void ganadorVacioTest() {
		char[][] tablero = TresEnRaya.inicializarTablero(TAM);
		boolean ganadorX = TresEnRaya.comprobarGanador(tablero, 'X');
		assertFalse(ganadorX);
		boolean ganadorO = TresEnRaya.comprobarGanador(tablero, 'O');
		assertFalse(ganadorO);
	}

	/**
	 * En el tablero lleno de letras no hay ganador.
	 */
	@Test
	void ganadorLlenoTest() {
		char[][] tablero = TresEnRaya.inicializarTablero(TAM);
		char[] obj = RELLENAR.toCharArray();
		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				char letra = obj[i * TAM + j];
				TresEnRaya.jugar(tablero, i, j, letra);
				boolean ganador = TresEnRaya.comprobarGanador(tablero, 'A');
				assertFalse(ganador);
			}
		}
		
		for (char c : obj) {
			boolean ganador = TresEnRaya.comprobarGanador(tablero, c);
			assertFalse(ganador);
		}
	}
}
