import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class T07Partida1TERTest {

	private static final int TAM = 3;
	private static final char X = 'X';
	private static final char O = 'O';
	private static final String N = System.lineSeparator();

	/**
	 X | O | X 
	---+---+---
	   |   |   
	---+---+---
	   |   |     	
	 */
	private static final String PINTAR_1 = " X | O | X " + N + "---+---+---" + N + "   |   |   " + N + "---+---+---" + N + "   |   |   " + N + "";

	/**
	 X | O | X 
	---+---+---
	   | O |   
	---+---+---
	   |   |     	
	 */
	private static final String PINTAR_2 = " X | O | X " + N + "---+---+---" + N + "   | O |   " + N + "---+---+---" + N + "   |   |   " + N + "";

	/**
	 X | O | X 
	---+---+---
	   | O |   
	---+---+---
	   | X |     	
	 */
	private static final String PINTAR_3 = " X | O | X " + N + "---+---+---" + N + "   | O |   " + N + "---+---+---" + N + "   | X |   " + N + "";

	/**
	 X | O | X 
	---+---+---
	 O | O |   
	---+---+---
	   | X |     	
	 */
	private static final String PINTAR_5 = " X | O | X " + N + "---+---+---" + N + " O | O |   " + N + "---+---+---" + N + "   | X |   " + N + "";

	/**
	 X | O | X 
	---+---+---
	 O | O | X  
	---+---+---
	   | X |     	
	 */
	private static final String PINTAR_6 = " X | O | X " + N + "---+---+---" + N + " O | O | X " + N + "---+---+---" + N + "   | X |   " + N + "";

	/**
	 X | O | X 
	---+---+---
	 O | O | X  
	---+---+---
	   | X | O    	
	 */
	private static final String PINTAR_7 = " X | O | X " + N + "---+---+---" + N + " O | O | X " + N + "---+---+---" + N + "   | X | O " + N + "";

	/**
	 X | O | X 
	---+---+---
	 O | O | X  
	---+---+---
	 X | X | O    	
	 */
	private static final String PINTAR_8 = " X | O | X " + N + "---+---+---" + N + " O | O | X " + N + "---+---+---" + N + " X | X | O " + N + "";

	@Test
	void partida1Test() {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));

		char[][] tablero = TresEnRaya.inicializarTablero(TAM);
		TresEnRaya.jugar(tablero, 0, 0, X);
		TresEnRaya.jugar(tablero, 0, 1, O);
		
		TresEnRaya.jugar(tablero, 0, 2, X);
		TresEnRaya.pintarTablero(tablero);
		String salida = bos.toString();
		assertEquals(PINTAR_1, salida);
		boolean ganaX = TresEnRaya.comprobarGanador(tablero, X);
		assertFalse(ganaX);

		TresEnRaya.jugar(tablero, 1, 1, O);
		TresEnRaya.pintarTablero(tablero);
		String salida2 = bos.toString();
		assertEquals(PINTAR_1 + PINTAR_2, salida2);
		boolean ganaO = TresEnRaya.comprobarGanador(tablero, O);
		assertFalse(ganaO);
		
		TresEnRaya.jugar(tablero, 2, 1, X);
		TresEnRaya.pintarTablero(tablero);
		String salida3 = bos.toString();
		assertEquals(PINTAR_1 + PINTAR_2 + PINTAR_3, salida3);
		boolean ganaX2 = TresEnRaya.comprobarGanador(tablero, O);
		assertFalse(ganaX2);
		
		TresEnRaya.jugar(tablero, 2, 1, O);
		TresEnRaya.pintarTablero(tablero);
		String salida4 = bos.toString();
		assertEquals(PINTAR_1 + PINTAR_2 + PINTAR_3 + PINTAR_3, salida4);

		TresEnRaya.jugar(tablero, 1, 0, O);
		TresEnRaya.pintarTablero(tablero);
		String salida5 = bos.toString();
		assertEquals(PINTAR_1 + PINTAR_2 + PINTAR_3 + PINTAR_3 + PINTAR_5, salida5);
		boolean ganaO2 = TresEnRaya.comprobarGanador(tablero, O);
		assertFalse(ganaO2);

		TresEnRaya.jugar(tablero, 1, 2, X);
		TresEnRaya.pintarTablero(tablero);
		String salida6 = bos.toString();
		assertEquals(PINTAR_1 + PINTAR_2 + PINTAR_3 + PINTAR_3 + PINTAR_5 + PINTAR_6, salida6);
		boolean ganaX3 = TresEnRaya.comprobarGanador(tablero, X);
		assertFalse(ganaX3);

		TresEnRaya.jugar(tablero, 2, 2, O);
		TresEnRaya.pintarTablero(tablero);
		String salida7 = bos.toString();
		assertEquals(PINTAR_1 + PINTAR_2 + PINTAR_3 + PINTAR_3 + PINTAR_5 + PINTAR_6 + PINTAR_7, salida7);
		boolean ganaO3 = TresEnRaya.comprobarGanador(tablero, O);
		assertFalse(ganaO3);

		TresEnRaya.jugar(tablero, 2, 0, X);
		TresEnRaya.pintarTablero(tablero);
		String salida8 = bos.toString();
		assertEquals(PINTAR_1 + PINTAR_2 + PINTAR_3 + PINTAR_3 + PINTAR_5 + PINTAR_6 + PINTAR_7 + PINTAR_8, salida8);
		boolean ganaX4 = TresEnRaya.comprobarGanador(tablero, X);
		assertFalse(ganaX4);

		boolean lleno = TresEnRaya.tableroLleno(tablero);
		assertTrue(lleno);
		
		System.setOut(originalOut);
	}

}
