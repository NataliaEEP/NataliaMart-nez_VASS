package tresenraya;

public class TresEnRaya {

	private static final int TAM = 3;

	public static void main(String[] args) {
		// Fichas
		System.out.println("FICHAS");
		for (Ficha f : Ficha.values()) {
			System.out.println(f);
		}

		// Tablero
		System.out.println("TABLERO");
		Tablero tablero = new Tablero(TAM);
		System.out.println(tablero);
		
		// Partida
		System.out.println("PARTIDA");
		Partida partida = new Partida(TAM);
		while (true) {
			int i = (int)(Math.random() * TAM);
			int j = (int)(Math.random() * TAM);
			partida.jugar(i, j);
			System.out.println(partida);				
			if (partida.terminada()) {
				System.out.println("Partida terminada");
				Ficha ganador = partida.ganador();
				if (ganador != null) {
					System.out.println("Ha ganado " + ganador);
				} else {
					System.out.println("Tablas");
				}
				return;
			}
		}
	}

}