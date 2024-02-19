package tresenraya;

/**
 * Enumeración que representa las fichas del juego, "Tres en raya", con las
 * fichas X y O. Esta enumeración también proporciona un método para obtener la
 * siguiente ficha.
 * 
 * @author Natalia Martínez
 * @version 2.0
 */
public enum Ficha {

	/**
	 * Representa la ficha X en el juego.
	 */
	X,

	/**
	 * Representa la ficha O en el juego.
	 */
	O;

	/**
	 * Método que devuelve el turno de la Ficha siguiente en el juego. Si la ficha
	 * actual es X, devuelve O; si es O, devuelve X.
	 * 
	 * @return El turno de la ficha siguiente en el juego.
	 */
	public Ficha siguiente() {
		return (this == X) ? O : X;
	}
}
