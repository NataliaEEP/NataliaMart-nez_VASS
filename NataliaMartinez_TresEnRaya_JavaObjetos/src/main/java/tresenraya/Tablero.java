package tresenraya;

/**
 * Clase que representa el tablero del juego "Tres en raya".
 * 
 * Esta clase se utiliza para gestionar el estado del tablero y realizar
 * operaciones relacionadas con el juego, como inicializar el tablero, realizar
 * movimientos de fichas y verificar el estado del juego.
 * 
 * @author [Natalia Martínez]
 * @version 2.0
 */
public class Tablero {

	/**
	 * Separador vertical entre casillas del tablero.
	 */
	private static final String VERT = "|";

	/**
	 * Espacios vacíos laterales de cada casilla.
	 */
	private static final String SEP = " ";

	/**
	 * Separador horizontal del tablero.
	 */
	private static final String HORT = "---";

	/**
	 * Separador intersección del tablero.
	 */
	private static final String CRUZ = "+";

	/**
	 * Representa el separador de líneas del sistema, utilizado para crear una nueva
	 * línea.
	 * 
	 * La variable N se inicializa con el valor de System.lineSeparator(), que es el
	 * separador de líneas del sistema operativo en el que se ejecuta la aplicación.
	 */
	protected static final String N = System.lineSeparator();

	/**
	 * Matriz que representa el estado del tablero con fichas.
	 */
	private Ficha[][] tablero;

	/**
	 * Constructor de la clase Tablero.
	 *
	 * @param tam Tamaño del tablero (número de filas y columnas).
	 */
	public Tablero(int tam) {
		this.tablero = new Ficha[tam][tam];
		inicializarTablero();
	}

	/**
	 * Inicializa el tablero con fichas nulas.
	 */
	private void inicializarTablero() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = null;
			}
		}
	}

	/**
	 * Realiza un movimiento en el tablero al colocar la ficha en la posición
	 * especificada.
	 * 
	 * El método verifica si la posición especificada en el tablero está vacía
	 * (null). Si la posición está vacía, coloca la ficha en esa posición y devuelve
	 * true indicando que la jugada fue exitosa. Si la posición ya está ocupada, el
	 * método devuelve false.
	 * 
	 * @param ficha   La ficha que se desea colocar en el tablero (X u O).
	 * @param fila    La fila en la que se realizará el movimiento.
	 * @param columna La columna en la que se realizará el movimiento.
	 * @return true si la jugada fue exitosa, false si la posición ya estaba
	 *         ocupada.
	 */
	public boolean jugar(Ficha ficha, int fila, int columna) {
		boolean jugada = tablero[fila][columna] == null;
		if (jugada) {
			tablero[fila][columna] = ficha;
		} else {
			return false;
		}
		return jugada;
	}

	/**
	 * Verifica si el tablero está completamente lleno, es decir, no hay casillas
	 * vacías.
	 * 
	 * El método recorre todas las casillas del tablero y devuelve true si todas
	 * están ocupadas, y false si al menos una casilla está vacía.
	 *
	 * @return true si el tablero está completamente lleno, false si hay al menos
	 *         una casilla vacía.
	 */
	public boolean estaLleno() {
		boolean lleno = true;
		for (int i = 0; i < tablero.length && lleno; i++) {
			for (int j = 0; j < tablero[i].length && lleno; j++) {
				if (tablero[i][j] == null) {
					lleno = false;
				}
			}
		}
		return lleno;
	}

	/**
	 * Verifica si el jugador ha ganado en el tablero, ya sea en horizontal,
	 * vertical o en las diagonales.
	 *
	 * @param jugador Ficha del jugador que se está verificando (X o O).
	 * @return true si el jugador ha ganado, false en caso contrario.
	 */
	public boolean gana(Ficha jugador) {
		return ganaHorizontal(jugador) || ganaVertical(jugador) 
				|| ganaDiagonalDirecta(jugador)
				|| ganaDiagonalInversa(jugador);
	}

	/**
	 * Verifica si el jugador ha ganado en una línea horizontal.
	 *
	 * @param jugador Ficha del jugador que se está verificando (X u O).
	 * @return true si el jugador ha ganado en alguna línea horizontal, false en
	 *         caso contrario.
	 */
	protected boolean ganaHorizontal(Ficha jugador) {
		boolean esGanador = false;
		for (int i = 0; i < tablero.length && !esGanador; i++) {
			boolean ganaFila = true;
			for (int j = 0; j < tablero[i].length && ganaFila; j++) {
				if (tablero[i][j] != jugador) {
					ganaFila = false;
				}
			}
			if (ganaFila) {
				esGanador = true;
			}
		}
		return esGanador;
	}

	/**
	 * Verifica si el jugador ha ganado en una línea vertical.
	 *
	 * @param jugador Ficha del jugador que se está verificando (X u O).
	 * @return true si el jugador ha ganado en alguna línea vertical, false en caso
	 *         contrario.
	 */
	protected boolean ganaVertical(Ficha jugador) {
		boolean esGanador = false;
		for (int i = 0; i < tablero.length && !esGanador; i++) {
			boolean ganaColumna = true;
			for (int j = 0; j < tablero[i].length && ganaColumna; j++) {
				if (tablero[j][i] != jugador) {
					ganaColumna = false;
				}
			}
			if (ganaColumna) {
				esGanador = true;
			}
		}
		return esGanador;
	}

	/**
	 * Verifica si el jugador ha ganado en la diagonal principal.
	 *
	 * @param jugador Ficha del jugador que se está verificando (X u O).
	 * @return true si el jugador ha ganado en la diagonal principal, false en caso
	 *         contrario.
	 */
	protected boolean ganaDiagonalDirecta(Ficha jugador) {
		boolean esGanador = true;
		for (int i = 0; i < tablero.length && esGanador; i++) {
			if (tablero[i][i] != jugador) {
				esGanador = false;
			}
		}
		return esGanador;
	}

	/**
	 * Verifica si el jugador ha ganado en la diagonal inversa.
	 *
	 * @param jugador Ficha del jugador que se está verificando (X u O).
	 * @return true si el jugador ha ganado en la diagonal inversa, false en caso
	 *         contrario.
	 */
	protected boolean ganaDiagonalInversa(Ficha jugador) {
		boolean esGanador = true;
		for (int i = 0; i < tablero.length && esGanador; i++) {
			if (tablero[i][(tablero[i].length - 1) - i] != jugador) {
				esGanador = false;
			}
		}
		return esGanador;
	}

	/**
	 * Devuelve una representación en cadena del tablero.
	 *
	 * El método construye una cadena que representa visualmente el estado actual
	 * del tablero. Cada casilla contiene el contenido de la ficha en esa posición o
	 * un espacio en blanco si la casilla está vacía. Se utiliza un formato de
	 * cuadrícula con separadores y líneas para mejorar la visualización del
	 * tablero.
	 * 
	 * @return Una cadena que representa el tablero en formato visual.
	 */
	@Override
	public String toString() {
		StringBuilder pintarTablero = new StringBuilder();
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				pintarTablero.append(SEP).append(fichaVacia(i, j)).append(SEP);
				if (j < tablero[i].length - 1) {
					pintarTablero.append(VERT);
				}
			}
			pintarTablero.append(N);
			if (i < tablero.length - 1) {
				for (int k = 0; k < tablero[i].length; k++) {
					pintarTablero.append(HORT);
					if (k < tablero[i].length - 1) {
						pintarTablero.append(CRUZ);
					}
				}
				pintarTablero.append(N);
			}
		}
		return pintarTablero.toString();
	}

	/**
	 * Obtiene el contenido de una casilla en el tablero.
	 * 
	 * El método devuelve el contenido de la casilla en la posición especificada. Si
	 * la casilla está vacía, se devuelve un espacio en blanco.
	 * 
	 * @param i La fila de la casilla.
	 * @param j La columna de la casilla.
	 * @return El contenido de la casilla en la posición especificada.
	 */
	private Object fichaVacia(int i, int j) {
		return tablero[i][j] == null ? " " : tablero[i][j];
	}
}
