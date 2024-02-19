package tresenraya;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class T05TableroGanaTest {

	private static final int TAM = 3;

	@Test
	void ganaHorizontalTest() {
		for (int i = 0; i < TAM; i++) {
			Tablero tablero = new Tablero(TAM);
			for (int j = 0; j < TAM; j++) {
				assertTrue(tablero.jugar(Ficha.O, i, j));
			}
			assertTrue(tablero.ganaHorizontal(Ficha.O));
			
			assertFalse(tablero.ganaHorizontal(Ficha.X));
			assertFalse(tablero.ganaVertical(Ficha.X));
			assertFalse(tablero.ganaVertical(Ficha.O));
			assertFalse(tablero.ganaDiagonalDirecta(Ficha.X));
			assertFalse(tablero.ganaDiagonalDirecta(Ficha.O));
			assertFalse(tablero.ganaDiagonalInversa(Ficha.X));
			assertFalse(tablero.ganaDiagonalInversa(Ficha.O));
		}
	}

	@Test
	void ganaVerticalTest() {
		for (int i = 0; i < TAM; i++) {
			Tablero tablero = new Tablero(TAM);
			for (int j = 0; j < TAM; j++) {
				assertTrue(tablero.jugar(Ficha.X, j, i));
			}
			assertTrue(tablero.ganaVertical(Ficha.X));

			assertFalse(tablero.ganaVertical(Ficha.O));
			assertFalse(tablero.ganaHorizontal(Ficha.X));
			assertFalse(tablero.ganaHorizontal(Ficha.O));
			assertFalse(tablero.ganaDiagonalDirecta(Ficha.X));
			assertFalse(tablero.ganaDiagonalDirecta(Ficha.O));
			assertFalse(tablero.ganaDiagonalInversa(Ficha.X));
			assertFalse(tablero.ganaDiagonalInversa(Ficha.O));
		}
	}
	
	@Test
	void ganaDiagonalDirectaTest() {
		Tablero tablero = new Tablero(TAM);
		for (int i = 0; i < TAM; i++) {
			assertTrue(tablero.jugar(Ficha.X, i, i));
		}
		assertTrue(tablero.ganaDiagonalDirecta(Ficha.X));

		assertFalse(tablero.ganaDiagonalDirecta(Ficha.O));
		assertFalse(tablero.ganaHorizontal(Ficha.X));
		assertFalse(tablero.ganaHorizontal(Ficha.O));
		assertFalse(tablero.ganaVertical(Ficha.X));
		assertFalse(tablero.ganaVertical(Ficha.O));
		assertFalse(tablero.ganaDiagonalInversa(Ficha.X));
		assertFalse(tablero.ganaDiagonalInversa(Ficha.O));
	}

	@Test
	void ganaDiagonalInversaTest() {
		Tablero tablero = new Tablero(TAM);
		for (int i = 0; i < TAM; i++) {
			assertTrue(tablero.jugar(Ficha.O, i, TAM-1-i));
		}
		assertTrue(tablero.ganaDiagonalInversa(Ficha.O));
		
		assertFalse(tablero.ganaDiagonalInversa(Ficha.X));
		assertFalse(tablero.ganaHorizontal(Ficha.X));
		assertFalse(tablero.ganaHorizontal(Ficha.O));
		assertFalse(tablero.ganaVertical(Ficha.X));
		assertFalse(tablero.ganaVertical(Ficha.O));
		assertFalse(tablero.ganaDiagonalDirecta(Ficha.X));
		assertFalse(tablero.ganaDiagonalDirecta(Ficha.O));
	}

	@Test
	void ganaTodasTest() {
		Tablero tablero = new Tablero(TAM);
		for (int i = 0; i < TAM; i++) {
			for (int j = 0; j < TAM; j++) {
				assertTrue(tablero.jugar(Ficha.O, i, j));
			}
		}
		assertFalse(tablero.ganaHorizontal(Ficha.X));
		assertTrue(tablero.ganaHorizontal(Ficha.O));		
		assertFalse(tablero.ganaVertical(Ficha.X));
		assertTrue(tablero.ganaVertical(Ficha.O));
		assertFalse(tablero.ganaDiagonalDirecta(Ficha.X));
		assertTrue(tablero.ganaDiagonalDirecta(Ficha.O));
		assertFalse(tablero.ganaDiagonalInversa(Ficha.X));
		assertTrue(tablero.ganaDiagonalInversa(Ficha.O));
	}


}
