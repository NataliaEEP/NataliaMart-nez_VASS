package tresenraya;

/**
 * Clase que representa una partida del juego "Tres en raya".
 * 
 * Esta clase gestiona el estado de una partida, incluyendo el tablero, el turno
 * actual y proporciona métodos para realizar jugadas, determinar si la partida
 * ha terminado y obtener el ganador.
 * 
 * @author Natalia Martínez
 * @version 2.0
 */
public class Partida {

	/**
	 * Tablero de juego.
	 */
	private Tablero tablero;

	/**
	 * Ficha del jugador que tiene el turno actual.
	 */
	private Ficha turnoActual;

	/**
	 * Constructor de la clase Partida.
	 * 
	 * @param tam Tamaño del tablero (número de filas y columnas).
	 */
	public Partida(int tam) {
		this.tablero = new Tablero(tam);
		this.turnoActual = Ficha.X;
	}

	/**
	 * Realiza una jugada en la partida.
	 * 
	 * @param fila    Número de fila en la que se realiza la jugada.
	 * @param columna Número de columna en la que se realiza la jugada.
	 */
	public void jugar(int fila, int columna) {
		StringBuilder casillaOcupada = new StringBuilder();
		if (tablero.jugar(turnoActual, fila, columna)) {
			cambiarTurno();
		} else {
			System.err.println(casillaOcupada.append("Casilla ").append("[")
					.append(fila).append(", ").append(columna).append("] ")
					.append("ocupada, vuelve a jugar ").append(turnoActual));
		}
	}

	/**
	 * Cambia el turno actual al siguiente jugador.
	 */
	private void cambiarTurno() {
		turnoActual = turnoActual.siguiente();
	}

	/**
	 * Verifica si la partida ha terminado.
	 * 
	 * @return true si la partida ha terminado, false de lo contrario.
	 */
	public boolean terminada() {
		return tablero.estaLleno() || ganador() != null;
	}

	/**
	 * Determina la ficha ganadora en la partida actual.
	 * 
	 * @return La ficha del jugador ganador (Ficha.X o Ficha.O) si hay un ganador, o
	 *         null si no hay un ganador en la partida.
	 */
	public Ficha ganador() {
		if (tablero.gana(Ficha.X)) {
			return Ficha.X;
		} else if (tablero.gana(Ficha.O)) {
			return Ficha.O;
		} else {
			return null;
		}
	}

	/**
	 * Devuelve una representación en cadena del estado actual de la partida.
	 * 
	 * @return Una cadena que representa el estado actual de la partida.
	 */
	@Override
	public String toString() {
		StringBuilder estadoPartida = new StringBuilder();
		estadoPartida.append(tablero.toString()).append(Tablero.N).append(" Turno: ")
		.append(turnoActual);
		return estadoPartida.toString();
	}
}
