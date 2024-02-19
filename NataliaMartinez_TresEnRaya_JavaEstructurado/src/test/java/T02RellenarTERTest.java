import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class T02RellenarTERTest {

	private static final int TAM = 3;
	private static final String N = System.lineSeparator();

	private static final String RELLENAR = "ABCDEFGHI";
	/**
	 A | B | C 
	---+---+---
	 D | E | F 
	---+---+---
	 G | H | I   	
		 */
	private static final String PINTAR_LLENO = " A | B | C " + N + "---+---+---" + N + " D | E | F " + N + "---+---+---" + N + " G | H | I " + N + "";

	/**
	 * Test rellenar una casilla.
	 */
	@Test
	void jugar00Test() {
		char[][] tablero = TresEnRaya.inicializarTablero(TAM);
		boolean res = TresEnRaya.jugar(tablero, 0, 0, 'M');
		assertTrue(res);
		assertEquals('M', tablero[0][0]);
		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				if (i != 0 && j != 0) {
					assertEquals(' ', tablero[i][j]);
				}
			}
		}
	}
	
	/**
	 * Test rellenar todas las casillas.
	 */
	@Test
	void jugarLlenoTest() {
		char[][] tablero = TresEnRaya.inicializarTablero(TAM);
		char[] obj = RELLENAR.toCharArray();
		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				char letra = obj[i * TAM + j];
				boolean res = TresEnRaya.jugar(tablero, i, j, letra);
				assertTrue(res);
				assertEquals(letra, tablero[i][j]);
			}
		}
	}
	
	@Test
	void pintarTableroLlenoTest() {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));
		
		char[][] tablero = TresEnRaya.inicializarTablero(TAM);
		char[] obj = RELLENAR.toCharArray();
		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				char letra = obj[i * TAM + j];
				TresEnRaya.jugar(tablero, i, j, letra);
			}
		}
		TresEnRaya.pintarTablero(tablero);
		String salida = bos.toString();
		assertEquals(PINTAR_LLENO, salida);
		
		System.setOut(originalOut);
	}

	/**
	 * Test intentar rellenar casilla ocupada
	 */
	@Test
	void jugarKoTest() {
		char[][] tablero = TresEnRaya.inicializarTablero(TAM);
		boolean res = TresEnRaya.jugar(tablero, 0, 0, 'X');
		assertTrue(res);
		assertEquals('X', tablero[0][0]);
		boolean resKo = TresEnRaya.jugar(tablero, 0, 0, 'O');
		assertFalse(resKo);
		assertEquals('X', tablero[0][0]);
	}
}
