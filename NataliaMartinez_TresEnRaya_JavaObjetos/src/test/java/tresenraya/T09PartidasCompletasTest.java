package tresenraya;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class T09PartidasCompletasTest {
	private static final String N = System.lineSeparator();
	private static final int TAM = 3;

	/**
	 X | O | X 
	---+---+---
	   |   |   
	---+---+---
	   |   |     	
	 */
	private static final String PINTAR1_1 = " X | O | X " + N + "---+---+---" + N + "   |   |   " + N + "---+---+---" + N + "   |   |   " + N + N + " Turno: O";

	/**
	 X | O | X 
	---+---+---
	   | O |   
	---+---+---
	   |   |     	
	 */
	private static final String PINTAR1_2 = " X | O | X " + N + "---+---+---" + N + "   | O |   " + N + "---+---+---" + N + "   |   |   " + N + N + " Turno: X";

	/**
	 X | O | X 
	---+---+---
	   | O |   
	---+---+---
	   | X |     	
	 */
	private static final String PINTAR1_3 = " X | O | X " + N + "---+---+---" + N + "   | O |   " + N + "---+---+---" + N + "   | X |   " + N + N + " Turno: O";

	/**
	 X | O | X 
	---+---+---
	 O | O |   
	---+---+---
	   | X |     	
	 */
	private static final String PINTAR1_5 = " X | O | X " + N + "---+---+---" + N + " O | O |   " + N + "---+---+---" + N + "   | X |   " + N + N + " Turno: X";

	/**
	 X | O | X 
	---+---+---
	 O | O | X  
	---+---+---
	   | X |     	
	 */
	private static final String PINTAR1_6 = " X | O | X " + N + "---+---+---" + N + " O | O | X " + N + "---+---+---" + N + "   | X |   " + N + N + " Turno: O";

	/**
	 X | O | X 
	---+---+---
	 O | O | X  
	---+---+---
	   | X | O    	
	 */
	private static final String PINTAR1_7 = " X | O | X " + N + "---+---+---" + N + " O | O | X " + N + "---+---+---" + N + "   | X | O " + N + N + " Turno: X";

	/**
	 X | O | X 
	---+---+---
	 O | O | X  
	---+---+---
	 X | X | O    	
	 */
	private static final String PINTAR1_8 = " X | O | X " + N + "---+---+---" + N + " O | O | X " + N + "---+---+---" + N + " X | X | O " + N + N + " Turno: O";

	@Test
	void partida1Test() {
		Partida partida = new Partida(TAM);
		partida.jugar(0, 0);
		partida.jugar(0, 1);
		partida.jugar(0, 2);
		assertEquals(PINTAR1_1, partida.toString());
		assertNull(partida.ganador());

		partida.jugar(1, 1);
		assertEquals(PINTAR1_2, partida.toString());
		assertNull(partida.ganador());
		
		partida.jugar(2, 1);
		assertEquals(PINTAR1_3, partida.toString());
		assertNull(partida.ganador());
		
		partida.jugar(2, 1);
		assertEquals(PINTAR1_3, partida.toString());
		assertNull(partida.ganador());

		partida.jugar(1, 0);
		assertEquals(PINTAR1_5, partida.toString());
		assertNull(partida.ganador());

		partida.jugar(1, 2);
		assertEquals(PINTAR1_6, partida.toString());
		assertNull(partida.ganador());

		partida.jugar(2, 2);
		assertEquals(PINTAR1_7, partida.toString());
		assertNull(partida.ganador());

		partida.jugar(2, 0);
		assertEquals(PINTAR1_8, partida.toString());
		assertNull(partida.ganador());

		boolean terminada = partida.terminada();
		assertTrue(terminada);
		assertNull(partida.ganador());
	}

	/**
	   |   | O 
	---+---+---
	 X | X |   
	---+---+---
	   |   |     	
	 */
	private static final String PINTAR2_1 = "   |   | O " + N + "---+---+---" + N + " X | X |   " + N + "---+---+---" + N + "   |   |   " + N + N + " Turno: O";

	/**
	   |   | O 
	---+---+---
	 X | X | O 
	---+---+---
	   |   |     	
	 */
	private static final String PINTAR2_2 = "   |   | O " + N + "---+---+---" + N + " X | X | O " + N + "---+---+---" + N + "   |   |   " + N + N + " Turno: X";

	/**
	   |   | O 
	---+---+---
	 X | X | O 
	---+---+---
	   |   | X   	
	 */
	private static final String PINTAR2_3 = "   |   | O " + N + "---+---+---" + N + " X | X | O " + N + "---+---+---" + N + "   |   | X " + N + N + " Turno: O";

	/**
	 O |   | O 
	---+---+---
	 X | X | O 
	---+---+---
	   |   | X   	
	 */
	private static final String PINTAR2_5 = " O |   | O " + N + "---+---+---" + N + " X | X | O " + N + "---+---+---" + N + "   |   | X " + N + N + " Turno: X";

	/**
	 O | X | O 
	---+---+---
	 X | X | O 
	---+---+---
	   |   | X   	
	 */
	private static final String PINTAR2_6 = " O | X | O " + N + "---+---+---" + N + " X | X | O " + N + "---+---+---" + N + "   |   | X " + N + N + " Turno: O";

	/**
	 O | X | O 
	---+---+---
	 X | X | O 
	---+---+---
	 O |   | X   	
	 */
	private static final String PINTAR2_7 = " O | X | O " + N + "---+---+---" + N + " X | X | O " + N + "---+---+---" + N + " O |   | X " + N + N + " Turno: X";

	/**
	 O | X | O 
	---+---+---
	 X | X | O 
	---+---+---
	 O | X | X   	
	 */
	private static final String PINTAR2_8 = " O | X | O " + N + "---+---+---" + N + " X | X | O " + N + "---+---+---" + N + " O | X | X " + N + N + " Turno: O";

	@Test
	void partida2Test() {
		Partida partida = new Partida(TAM);
		partida.jugar(1, 1);
		partida.jugar(0, 2);
		
		partida.jugar(1, 0);
		String salida = partida.toString();
		assertEquals(PINTAR2_1, salida);
		assertNull(partida.ganador());

		partida.jugar(1, 2);
		String salida2 = partida.toString();
		assertEquals(PINTAR2_2, salida2);
		assertNull(partida.ganador());
		
		partida.jugar(2, 2);
		String salida3 = partida.toString();
		assertEquals(PINTAR2_3, salida3);
		assertNull(partida.ganador());
		
		partida.jugar(0, 0);
		String salida5 = partida.toString();
		assertEquals(PINTAR2_5, salida5);
		assertNull(partida.ganador());

		partida.jugar(0, 1);
		String salida6 = partida.toString();
		assertEquals(PINTAR2_6, salida6);
		assertNull(partida.ganador());

		partida.jugar(2, 0);
		String salida7 = partida.toString();
		assertEquals(PINTAR2_7, salida7);
		assertNull(partida.ganador());

		partida.jugar(2, 1);
		String salida8 = partida.toString();
		assertEquals(PINTAR2_8, salida8);
		assertEquals(Ficha.X, partida.ganador());
		
		boolean terminada = partida.terminada();
		assertTrue(terminada);
	}

	/**
	   |   |   
	---+---+---
	   | X |   
	---+---+---
	   |   |     	
	 */
	private static final String PINTAR3_1 = "   |   |   " + N + "---+---+---" + N + "   | X |   " + N + "---+---+---" + N + "   |   |   " + N + N + " Turno: O";

	/**
	   |   |   
	---+---+---
	   | X |   
	---+---+---
	 O |   |     	
	 */
	private static final String PINTAR3_2 = "   |   |   " + N + "---+---+---" + N + "   | X |   " + N + "---+---+---" + N + " O |   |   " + N + N + " Turno: X";

	/**
	 X |   |   
	---+---+---
	   | X |   
	---+---+---
	 O |   |     	
	 */
	private static final String PINTAR3_3 = " X |   |   " + N + "---+---+---" + N + "   | X |   " + N + "---+---+---" + N + " O |   |   " + N + N + " Turno: O";

	/**
	 X |   |   
	---+---+---
	   | X |   
	---+---+---
	 O |   | O   	
	 */
	private static final String PINTAR3_5 = " X |   |   " + N + "---+---+---" + N + "   | X |   " + N + "---+---+---" + N + " O |   | O " + N + N + " Turno: X";

	/**
	 X | X |   
	---+---+---
	   | X |   
	---+---+---
	 O |   | O   	
	 */
	private static final String PINTAR3_6 = " X | X |   " + N + "---+---+---" + N + "   | X |   " + N + "---+---+---" + N + " O |   | O " + N + N + " Turno: O";

	/**
	 X | X |   
	---+---+---
	   | X |   
	---+---+---
	 O | O | O   	
	 */
	private static final String PINTAR3_7 = " X | X |   " + N + "---+---+---" + N + "   | X |   " + N + "---+---+---" + N + " O | O | O " + N + N + " Turno: X";

	@Test
	void partida3Test() {
		Partida partida = new Partida(TAM);
		
		partida.jugar(1, 1);
		String salida = partida.toString();
		assertEquals(PINTAR3_1, salida);
		assertNull(partida.ganador());

		partida.jugar(2, 0);
		String salida2 = partida.toString();
		assertEquals(PINTAR3_2, salida2);
		assertNull(partida.ganador());
		
		partida.jugar(0, 0);
		String salida3 = partida.toString();
		assertEquals(PINTAR3_3, salida3);
		assertNull(partida.ganador());
		
		partida.jugar(2, 2);
		String salida5 = partida.toString();
		assertEquals(PINTAR3_5, salida5);
		assertNull(partida.ganador());

		partida.jugar(0, 1);
		String salida6 = partida.toString();
		assertEquals(PINTAR3_6, salida6);
		assertNull(partida.ganador());

		partida.jugar(2, 1);
		String salida7 = partida.toString();
		assertEquals(PINTAR3_7, salida7);
		assertEquals(Ficha.O, partida.ganador());
		
		boolean terminada = partida.terminada();
		assertTrue(terminada);
	}
}
