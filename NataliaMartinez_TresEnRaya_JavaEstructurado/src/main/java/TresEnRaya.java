/**
 * Código capaz de representar una partida de tres en raya, pero no de jugarla
 * 
 * @author 	Natalia Martínez
 * @version	1.0 
 */
public class TresEnRaya {
	
	/**
	 * Separador vertical entre casillas del tablero
	 */
	private static final String VERT = "|";
	
	/**
	 * Espacios vacíos laterales de cada casilla
	 */
	private static final String SEP = " ";
	
	/**
	 * Separador horizontal del tablero
	 */
	private static final String HORT = "---";
	
	/**
	 * Separador intersección del tablero
	 */
	private static final String CRUZ = "+";
	
	
	/**
	 * Tamaño del tablero
	 */
	private static final int TAM = 3;
	
	/**
	 * Jugador X
	 */
	private static final char X = 'X';
	
	/**
	 * Jugador O
	 */
	private static final char O = 'O';
	
	/**
	 * Casilla vacía del tablero
	 */
	private static final char VACIA = ' ';
	
	
	/**
	 * Método principal, en el cual llamamos a los distintos métodos creados, 
	 * para que vayan haciendo jugadas, pintando tablero con las mismas, 
	 * comprobando ganadores.
	 */
	public static void main(String[] args) {
		char[][] tablero = TresEnRaya.inicializarTablero(TAM);
		pintarTablero(tablero);
		System.out.println();
		
		if (jugar(tablero, 1, 1, X)) {
			System.out.println("buena jugada");
			pintarTablero(tablero);
		} else {
			System.err.println("casilla ocupada");
		}
		if (jugar(tablero, 1, 1, O)) {
			System.out.println("buena jugada");
			pintarTablero(tablero);
		} else {
			System.err.println("casilla ocupada");
		}
		if (jugar(tablero, 0, 0, O)) {
			System.out.println("buena jugada");
			pintarTablero(tablero);
		} else {
			System.err.println("casilla ocupada");
		}	
		boolean gana = comprobarGanador(tablero, X);
		if (gana) {
			System.out.println("Ha ganado " + X);
		} else {
			System.out.println("Aún no hay ganador");
		}
		if (jugar(tablero, 2, 0, X)) {
			System.out.println("buena jugada");
			pintarTablero(tablero);
		} else {
			System.err.println("casilla ocupada");
		}
		if (jugar(tablero, 0, 1, O)) {
			System.out.println("buena jugada");
			pintarTablero(tablero);
		} else {
			System.err.println("casilla ocupada");
		}
		boolean gana2 = comprobarGanador(tablero, O);
		if (gana2) {
			System.out.println("Ha ganado " + O);
		} else {
			System.out.println("Aún no hay ganador");
		}
		if (jugar(tablero, 0, 2, X)) {
			System.out.println("buena jugada");
			pintarTablero(tablero);
		} else {
			System.err.println("casilla ocupada");
		}
		boolean gana3 = comprobarGanador(tablero, X);
		if (gana3) {
			System.out.println("Ha ganado " + X);
		} else {
			System.out.println("Aún no hay ganador");
		}
	}
	
	/**
	 * Método que  inicializa una matriz de caracteres rellena de espacios
	 * 
	 * @param 	tam el entero que me da la dimensión del tablero
	 * @return 	devuelve la matriz tablero vacía
	 */
	protected static char[][] inicializarTablero(int tam) {
		char[][] tablero = new char[tam][tam];
		for (int i = 0; i < tablero.length; i++) {
			for ( int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = VACIA;
			}
		}
		return tablero;
	}
	
	/**
	 * Método que pinta por la consola el tablero en función de su contenido 
	 * y con las correspondientes rayas de separación
	 * 
	 * @param 	tablero matriz de chars para pintar tablero
	 */
	protected static void pintarTablero(char[][] tablero) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (j < tablero[i].length - 1) {
					System.out.print(SEP + tablero[i][j] + SEP + VERT);
				} else {
					System.out.print(SEP + tablero[i][j] + SEP);
				}
			}
			System.out.println();
			if (i < tablero.length - 1) {
				for (int k = 0; k < tablero[i].length; k++) {
					if (k < tablero[i].length - 1) {
						System.out.print(HORT + CRUZ);
					} else {
						System.out.println(HORT);
					}
				}
			}
		}
	}
	
	/**
	 * Método que chequea si la casilla no está ocupada en el tablero, y si está vacía, 
	 * nos coloca la ficha indicada en la posición indicada. 
	 * Este método nos devuelve un booleano indicando si se ha podido jugar.
	 * 
	 * @param tablero 	recibimos la matriz tablero
	 * @param fila 		recibimos el número de fila en la que el jugador jugará
	 * @param columna 	recibimos el número de columna en la que el jugador jugará
	 * @param jugador 	recibimos la ficha que quiere jugar el jugador
	 * @return 			Devolver true si la jugada fue válida (casilla vacía), 
	 * 					de lo contrario, devolver false 
	 */
	protected static boolean jugar(char[][] tablero, int fila, int columna, 
			char jugador) {
		boolean jugada = tablero[fila][columna] == VACIA;
		if (jugada) {
			tablero[fila][columna] = jugador;
		} else {
			return false;
		}
		return jugada;
	}
	
	/**
	 * Método, que nos comprueba, si todas las casillas del tablero están ocupadas
	 * 
	 * @param tablero	recibimos, la matriz tablero, con las jugadas
	 * @return			devolvemos, verdadero si está lleno, o falso si está vacío
	 */
	protected static boolean tableroLleno(char[][] tablero) {
		boolean lleno = true;
		for (int i = 0; i < tablero.length && lleno; i++) {
			for (int j = 0; j < tablero[i].length && lleno; j++) {
				if (tablero[i][j] == VACIA) {
					lleno = false;
				}
			}
		}
		return lleno;
	}
	
	/**
	 * Método, que llama a otros métodos, que comprueban si el jugador
	 * recibido como parámetro, es el ganador del juego
	 * 
	 * @param tablero 	recibimos la matriz tablero con las jugadas
	 * @param jugador 	recibimos, que jugador vamos a comprobar, si ha ganado
	 * @return 			devolvemos si es cierto o falso que ha ganado	
	 */
	protected static boolean comprobarGanador(char[][] tablero, char jugador) {
		return comprobarGanadorHorizontal(tablero, jugador) 
				|| comprobarGanadorVertical(tablero, jugador) 
				|| comprobarGanadorDiagonalPrincipal(tablero, jugador) 
				|| comprobarGanadorDiagonalSecundaria(tablero, jugador);
	}
	
	/**
	 * Método que comprueba si existe ganador en las horizontales
	 * 
	 * @param tablero	recibimos, la matriz tablero, con las jugadas
	 * @param jugador	recibimos, que jugador vamos a comprobar, si ha ganado
	 * @return			devolvemos, si es verdadero o falso, que haya ganado
	 */
	protected static boolean comprobarGanadorHorizontal(char[][] tablero, 
			char jugador) {
		boolean esGanador = false;
		for (int i = 0; i < tablero.length && !esGanador; i++) {
			boolean ganaFila = true;
			for (int j = 0; j < tablero[i].length && ganaFila; j++) {
				if (tablero[i][j] != jugador) {
					ganaFila = false;
				}
			}
			if(ganaFila) {
				esGanador = true;
			}
		}
		return esGanador;
	}
	
	/**
	 * Método que comprueba si existe ganador en las verticales
	 * 
	 * @param tablero	recibimos, la matriz tablero, con las jugadas
	 * @param jugador	recibimos, que jugador vamos a comprobar, si ha ganado
	 * @return			devolvemos, si es verdadero o falso, que haya ganado
	 */
	protected static boolean comprobarGanadorVertical(char[][] tablero, 
			char jugador) {
		boolean esGanador = false;
		for (int i = 0; i < tablero.length && !esGanador; i++) {
			boolean ganaColumna = true;
			for (int j = 0; j < tablero[i].length && ganaColumna; j++) {
				if (tablero[j][i] != jugador) {
					ganaColumna = false;
				}
			}
			if(ganaColumna) {
				esGanador = true;
			}
		}
		return esGanador;
	}
	
	/**
	 * Método que comprueba si hay ganador en la diagonal principal
	 * 
	 * @param tablero	recibimos, la matriz tablero, con las jugadas
	 * @param jugador	recibimos, que jugador vamos a comprobar, si ha ganado 
	 * @return			devolvemos, si es verdadero o falso, que haya ganado
	 */
	protected static boolean comprobarGanadorDiagonalPrincipal(char[][] tablero, 
			char jugador) {
		boolean esGanador = true;
		for (int i = 0; i < tablero.length && esGanador; i++) {
			if (tablero[i][i] != jugador) {
				esGanador = false;
			}
		}
		return esGanador;
	}
	
	/**
	 * Método que comprueba si hay ganador en la diagonal secundaria
	 * 
	 * @param tablero	recibimos, la matriz tablero, con las jugadas
	 * @param jugador	recibimos, que jugador vamos a comprobar, si ha ganado
	 * @return			devolvemos, si es verdadero o falso, que haya ganado
	 */
	protected static boolean comprobarGanadorDiagonalSecundaria(char[][] tablero, 
			char jugador) {
		boolean esGanador = true;
		for (int i = 0; i < tablero.length && esGanador; i++) {
			if (tablero[i][(tablero.length - 1) - i] != jugador) {
				esGanador = false;
			}
		}
		return esGanador;
	}
}