import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class T10Flexibilidad {

	private static final char X = 'Z';
	private static final char O = 'S';
	private static final String N = System.lineSeparator();

	/**
	   |   |   |   
	---+---+---+---
	   |   |   |   
	---+---+---+---
	   |   |   |   
	---+---+---+---
	   |   |   |   	
	 */
	private static final String PINTAR_1 = "   |   |   |   " + N + "---+---+---+---" + N + "   |   |   |   " + N + "---+---+---+---" + N + "   |   |   |   " + N + "---+---+---+---" + N + "   |   |   |   " + N + "";

	/**
	   |   |   |   
	---+---+---+---
	   |   |   |   
	---+---+---+---
	 S |   |   |   
	---+---+---+---
	   |   |   |    	
	 */
	private static final String PINTAR_2 = "   |   |   |   " + N + "---+---+---+---" + N + "   |   |   |   " + N + "---+---+---+---" + N + " S |   |   |   " + N + "---+---+---+---" + N + "   |   |   |   " + N + "";

	/**
	   |   |   |   
	---+---+---+---
	   |   |   |   
	---+---+---+---
	 S |   |   |   
	---+---+---+---
	   |   |   | Z 	
	 */
	private static final String PINTAR_3 = "   |   |   |   " + N + "---+---+---+---" + N + "   |   |   |   " + N + "---+---+---+---" + N + " S |   |   |   " + N + "---+---+---+---" + N + "   |   |   | Z " + N + "";

	/**
	   |   |   |   
	---+---+---+---
	   |   |   |   
	---+---+---+---
	 S |   |   |   
	---+---+---+---
	 Z | Z | Z | Z 	
	 */
	private static final String PINTAR_4 = "   |   |   |   " + N + "---+---+---+---" + N + "   |   |   |   " + N + "---+---+---+---" + N + " S |   |   |   " + N + "---+---+---+---" + N + " Z | Z | Z | Z " + N + "";

	/**
	   |   
	---+---
	   |   
	 */
	private static final String PINTAR2_1 = "   |   " + N + "---+---" + N + "   |   " + N + "";

	/**
	 S |   
	---+---
	   |   
	 */
	private static final String PINTAR2_2 = " S |   " + N + "---+---" + N + "   |   " + N + "";

	/**
	 S | Z 
	---+---
	   |   
	 */
	private static final String PINTAR2_3 = " S | Z " + N + "---+---" + N + "   |   " + N + "";

	/**
	 S | Z 
	---+---
	   | S 
	 */
	private static final String PINTAR2_4 = " S | Z " + N + "---+---" + N + "   | S " + N + "";

	@Test
	void tablero4x4Test() {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));

		char[][] tablero = TresEnRaya.inicializarTablero(4);
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
		
		TresEnRaya.jugar(tablero, 3, 3, X);
		TresEnRaya.pintarTablero(tablero);
		String salida3 = bos.toString();
		assertEquals(PINTAR_1 + PINTAR_2 + PINTAR_3, salida3);
		
		TresEnRaya.jugar(tablero, 3, 2, X);
		TresEnRaya.jugar(tablero, 3, 1, X);
		TresEnRaya.jugar(tablero, 3, 0, X);
		TresEnRaya.pintarTablero(tablero);
		String salida5 = bos.toString();
		assertEquals(PINTAR_1 + PINTAR_2 + PINTAR_3 + PINTAR_4, salida5);
		boolean ganaO2 = TresEnRaya.comprobarGanador(tablero, O);
		assertFalse(ganaO2);
		boolean ganaX2 = TresEnRaya.comprobarGanador(tablero, X);
		assertTrue(ganaX2);

		boolean lleno = TresEnRaya.tableroLleno(tablero);
		assertFalse(lleno);
		
		System.setOut(originalOut);
	}
	
	@Test
	void tablero2x2Test() {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));

		char[][] tablero = TresEnRaya.inicializarTablero(2);
		TresEnRaya.pintarTablero(tablero);
		String salida = bos.toString();
		assertEquals(PINTAR2_1, salida);
		boolean ganaX = TresEnRaya.comprobarGanador(tablero, X);
		assertFalse(ganaX);

		TresEnRaya.jugar(tablero, 0, 0, O);
		TresEnRaya.pintarTablero(tablero);
		String salida2 = bos.toString();
		assertEquals(PINTAR2_1 + PINTAR2_2, salida2);
		boolean ganaO = TresEnRaya.comprobarGanador(tablero, O);
		assertFalse(ganaO);
		
		TresEnRaya.jugar(tablero, 0, 1, X);
		TresEnRaya.pintarTablero(tablero);
		String salida3 = bos.toString();
		assertEquals(PINTAR2_1 + PINTAR2_2 + PINTAR2_3, salida3);
		
		TresEnRaya.jugar(tablero, 1, 1, O);
		TresEnRaya.pintarTablero(tablero);
		String salida5 = bos.toString();
		assertEquals(PINTAR2_1 + PINTAR2_2 + PINTAR2_3 + PINTAR2_4, salida5);
		boolean ganaO2 = TresEnRaya.comprobarGanador(tablero, O);
		assertTrue(ganaO2);

		boolean lleno = TresEnRaya.tableroLleno(tablero);
		assertFalse(lleno);
		TresEnRaya.jugar(tablero, 1, 0, X);
		assertTrue(TresEnRaya.tableroLleno(tablero));
		
		System.setOut(originalOut);
	}


}
