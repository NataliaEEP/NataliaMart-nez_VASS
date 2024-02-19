package tresenraya;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class T04CasillaOcupadaTest {
	private static final String N = System.lineSeparator();
	private static final int TAM = 3;

	private static final String X_EN_00 = " X |";
	private static final String O_EN_01 = " X | O |";

	private static final String ERROR_00 = "Casilla [0, 0] ocupada, vuelve a jugar O" + N;
	private static final String ERROR_01 = "Casilla [0, 1] ocupada, vuelve a jugar X" + N;

	@Test
	void casilla00Ocupada() {
		PrintStream originalErr = System.err;
		ByteArrayOutputStream bosErr = new ByteArrayOutputStream();
		System.setErr(new PrintStream(bosErr));
		
		Partida partida = new Partida(TAM);
		assertFalse(partida.terminada());
		partida.jugar(0, 0);
		String partida1 = partida.toString();
		assertTrue(partida1.startsWith(X_EN_00));

		partida.jugar(0, 0);
		assertEquals(ERROR_00, bosErr.toString());

		partida.jugar(0, 1);
		String partida2 = partida.toString();
		assertTrue(partida2.startsWith(O_EN_01));

		partida.jugar(0, 1);
		assertEquals(ERROR_00 + ERROR_01, bosErr.toString());
		
		System.setErr(originalErr);
	}

}
