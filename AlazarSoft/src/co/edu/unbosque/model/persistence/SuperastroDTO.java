/**
 * Paquete persistencia
 */
package co.edu.unbosque.model.persistence;

/**
 * Clase SuperastroDTO
 */
public class SuperastroDTO extends ApuestaDTO {

	private static final long serialVersionUID = 1L;
	private String numeroJuego = "";
	private String signo = "";

	/**
	 * Constructor de la super Clase
	 * 
	 * @param nombreSede,   es el nombre de la sede; sede != null.
	 * @param cedula,       es la cedula del apostador; cedula != null.
	 * @param fecha,        es la fecha de la apuesta; fecha != null.
	 * @param valorApuesta, es el valor de la apuesta; != null.
	 * @param numeroJuego,  es el número del juego; numeroJuego != null.
	 * @param signo,        es el signo de la apuesta; signo != null.
	 */
	public SuperastroDTO(String nombreSede, String cedula, java.util.Date fecha, double valorApuesta,
			String numeroJuego, String signo) {
		super(nombreSede, cedula, fecha, valorApuesta);
		// TODO Auto-generated constructor stub
		this.numeroJuego = numeroJuego;
		this.signo = signo;
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

	/**
	 * @return the signo
	 */
	public String getSigno() {
		return signo;
	}

	/**
	 * @param signo the signo to set
	 */
	public void setSigno(String signo) {
		this.signo = signo;
	}

}
