/**
 * Paquete persistencia
 */
package co.edu.unbosque.model.persistence;

/**
 * Clase MarcadoresDTO
 */
public class MarcadoresDTO extends ApuestaDTO {

	private static final long serialVersionUID = 1L;
	private String partido = "";
	private String resultado = "";

	/**
	 * Constructor de la super Clase
	 * 
	 * @param nombreSede,   es el nombre de la sede; sede != null.
	 * @param cedula,       es la cedula del apostador; cedula != null.
	 * @param fecha,        es la fecha de la apuesta; fecha != null.
	 * @param valorApuesta, es el valor de la apuesta; != null.
	 * @param partido,      es el partigo a jugar; partido != null.
	 * @param resultado,    es el resultado del partido; resultado != null.
	 */
	public MarcadoresDTO(String nombreSede, String cedula, java.util.Date fecha, double valorApuesta, String partido,
			String resultado) {
		super(nombreSede, cedula, fecha, valorApuesta);
		// TODO Auto-generated constructor stub
		this.partido = partido;
		this.resultado = resultado;
	}

	/**
	 * @return the partido
	 */
	public String getPartido() {
		return partido;
	}

	/**
	 * @param partido the partido to set
	 */
	public void setPartido(String partido) {
		this.partido = partido;
	}

	/**
	 * @return the resultado
	 */
	public String getResultado() {
		return resultado;
	}

	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

}
