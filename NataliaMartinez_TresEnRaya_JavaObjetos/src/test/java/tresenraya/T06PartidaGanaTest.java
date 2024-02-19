package tresenraya;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class T06PartidaGanaTest {

	private static final int TAM = 3;

	@Test
	void ganaHorizontalTest() {
		Partida partida = new Partida(TAM);
		partida.jugar(0, 0); // la X
		partida.jugar(1, 1); // la O
		partida.jugar(0, 1); // la X
		partida.jugar(2, 0); // la O
		
		assertNull(partida.ganador()); // aún no gana nadie
		
		partida.jugar(0, 2); // la X
		
		assertEquals(Ficha.X, partida.ganador());
	}

	@Test
	void ganaVerticalTest() {
		Partida partida = new Partida(TAM);
		partida.jugar(0, 0); // la X
		partida.jugar(1, 1); // la O
		partida.jugar(0, 2); // la X
		partida.jugar(2, 1); // la O
		partida.jugar(2, 2); // la X
		
		assertNull(partida.ganador()); // aún no gana nadie
		
		partida.jugar(0, 1); // la O
		
		assertEquals(Ficha.O, partida.ganador());
	}
	
	@Test
	void ganaDiagonalDirectaTest() {
		Partida partida = new Partida(TAM);
		partida.jugar(0, 0); // la X
		partida.jugar(0, 1); // la O
		partida.jugar(1, 1); // la X
		partida.jugar(1, 0); // la O
		
		assertNull(partida.ganador()); // aún no gana nadie
		
		partida.jugar(2, 2); // la X
		
		assertEquals(Ficha.X, partida.ganador());
	}

	@Test
	void ganaDiagonalInversaTest() {
		Partida partida = new Partida(TAM);
		partida.jugar(0, 0); // la X
		partida.jugar(0, 2); // la O
		partida.jugar(0, 1); // la X
		partida.jugar(1, 1); // la O
		partida.jugar(2, 1); // la X
		
		assertNull(partida.ganador()); // aún no gana nadie
		
		partida.jugar(2, 0); // la O
		
		assertEquals(Ficha.O, partida.ganador());
	}

	@Test
	void ganaTodasTest() {
		Partida partida = new Partida(TAM);
		for (int i = 0; i < TAM; i++) {			
			assertNull(partida.ganador()); // aún no gana nadie
			
			for (int j = 0; j < TAM; j++) {
				partida.jugar(i, j);
			}
		}
		assertEquals(Ficha.X, partida.ganador());
	}


}
