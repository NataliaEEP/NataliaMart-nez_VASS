import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class T09Partida3TERTest {

	private static final int TAM = 3;
	private static final char X = 'X';
	private static final char O = 'O';
	private static final String N = System.lineSeparator();

	/**
	   |   |   
	---+---+---
	   | X |   
	---+---+---
	   |   |     	
	 */
	private static final String PINTAR_1 = "   |   |   " + N + "---+---+---" + N + "   | X |   " + N + "---+---+---" + N + "   |   |   " + N + "";

	/**
	   |   |   
	---+---+---
	   | X |   
	---+---+---
	 O |   |     	
	 */
	private static final String PINTAR_2 = "   |   |   " + N + "---+---+---" + N + "   | X |   " + N + "---+---+---" + N + " O |   |   " + N + "";

	/**
	 X |   |   
	---+---+---
	   | X |   
	---+---+---
	 O |   |     	
	 */
	private static final String PINTAR_3 = " X |   |   " + N + "---+---+---" + N + "   | X |   " + N + "---+---+---" + N + " O |   |   " + N + "";

	/**
	 X |   |   
	---+---+---
	   | X |   
	---+---+---
	 O |   | O   	
	 */
	private static final String PINTAR_5 = " X |   |   " + N + "---+---+---" + N + "   | X |   " + N + "---+---+---" + N + " O |   | O " + N + "";

	/**
	 X | X |   
	---+---+---
	   | X |   
	---+---+---
	 O |   | O   	
	 */
	private static final String PINTAR_6 = " X | X |   " + N + "---+---+---" + N + "   | X |   " + N + "---+---+---" + N + " O |   | O " + N + "";

	/**
	 X | X |   
	---+---+---
	   | X |   
	---+---+---
	 O | O | O   	
	 */
	private static final String PINTAR_7 = " X | X |   " + N + "---+---+---" + N + "   | X |   " + N + "---+---+---" + N + " O | O | O " + N + "";

	@Test
	void partida1Test() {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));

		char[][] tablero = TresEnRaya.inicializarTablero(TAM);
		
		TresEnRaya.jugar(tablero, 1, 1, X);
		TresEnRaya.pintarTablero(tablero);
		String salida = bos.toString();
		assertEquals(PINTAR_1, salida);
		boolean ganaX = TresEnRaya.comprobarGanador(tablero, X);
		assertFalse(ganaX);

		TresEnRaya.jugar(tablero, 2, 0, O);
		TresEnRaya.pintarTablero(tablero);
		String salida2 = bos.toString();
		assertEquals(PINTAR_1 + PINTAR_2, salida2);
		boolean ganaO = TresEnRaya.comprobarGanador(tablero, O);
		assertFalse(ganaO);
		
		TresEnRaya.jugar(tablero, 0, 0, X);
		TresEnRaya.pintarTablero(tablero);
		String salida3 = bos.toString();
		assertEquals(PINTAR_1 + PINTAR_2 + PINTAR_3, salida3);
		boolean ganaX2 = TresEnRaya.comprobarGanador(tablero, O);
		assertFalse(ganaX2);
		
		TresEnRaya.jugar(tablero, 2, 2, O);
		TresEnRaya.pintarTablero(tablero);
		String salida5 = bos.toString();
		assertEquals(PINTAR_1 + PINTAR_2 + PINTAR_3 + PINTAR_5, salida5);
		boolean ganaO2 = TresEnRaya.comprobarGanador(tablero, O);
		assertFalse(ganaO2);

		TresEnRaya.jugar(tablero, 0, 1, X);
		TresEnRaya.pintarTablero(tablero);
		String salida6 = bos.toString();
		assertEquals(PINTAR_1 + PINTAR_2 + PINTAR_3 + PINTAR_5 + PINTAR_6, salida6);
		boolean ganaX3 = TresEnRaya.comprobarGanador(tablero, X);
		assertFalse(ganaX3);

		TresEnRaya.jugar(tablero, 2, 1, O);
		TresEnRaya.pintarTablero(tablero);
		String salida7 = bos.toString();
		assertEquals(PINTAR_1 + PINTAR_2 + PINTAR_3 + PINTAR_5 + PINTAR_6 + PINTAR_7, salida7);
		boolean ganaO3 = TresEnRaya.comprobarGanador(tablero, O);
		assertTrue(ganaO3);
		
		boolean lleno = TresEnRaya.tableroLleno(tablero);
		assertFalse(lleno);
		
		System.setOut(originalOut);
	}

}
