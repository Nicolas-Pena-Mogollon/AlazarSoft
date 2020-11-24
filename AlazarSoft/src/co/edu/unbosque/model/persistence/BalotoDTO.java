/**
 * Paquete persistencia
 */
package co.edu.unbosque.model.persistence;

/**
 * Clase BalotoDTO
 */
public class BalotoDTO extends ApuestaDTO {

	private static final long serialVersionUID = 1L;

	String numeroJuego = "";

	/**
	 * Constructor de la superClase
	 * 
	 * @param nombreSede,   es el nombre de la sede; sede != null.
	 * @param cedula,       es la cedula del apostador; cedula != null.
	 * @param fecha,        es la fecha de la apuesta; fecha != null.
	 * @param valorApuesta, es el valor de la apuesta; != null.
	 * @param numeroJuego,  es el número a jugar; numeroJuego != null.
	 */
	public BalotoDTO(String nombreSede, String cedula, java.util.Date fecha, double valorApuesta, String numeroJuego) {
		super(nombreSede, cedula, fecha, valorApuesta);
		// TODO Auto-generated constructor stub
		this.numeroJuego = numeroJuego;
	}

	/**
	 * @return the numeroJuego
	 */
	public String getNumeroJuego() {
		return numeroJuego;
	}

	/**
	 * @param numeroJuego the numeroJuego to set
	 */
	public void setNumeroJuego(String numeroJuego) {
		this.numeroJuego = numeroJuego;
	}

}
