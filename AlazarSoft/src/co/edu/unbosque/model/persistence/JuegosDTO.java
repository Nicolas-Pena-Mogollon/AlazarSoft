/**
 * Paquete persistencia
 */
package co.edu.unbosque.model.persistence;

import java.io.Serializable;

/**
 * Clase JuegosDTO
 */
public class JuegosDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombreJuego = "";
	private String tipoJuego = "";
	private long presupuesto = 0;

	/**
	 * Constructor vacio
	 */

	public JuegosDTO() {

	}

	/**
	 * Constructor específico.
	 * 
	 * @param nombreJuego, es el nombre del juego; nombreJuego != null.
	 * @param tipoJuego,   es el tipo de juego; tipoJuego != null.
	 * @param presupuesto, es el presupuesto del juego; presupuesto != null.
	 */
	public JuegosDTO(String nombreJuego, String tipoJuego, long presupuesto) {
		this.nombreJuego = nombreJuego;
		this.tipoJuego = tipoJuego;
		this.presupuesto = presupuesto;
	}

	/**
	 * @return the nombreJuego
	 */
	public String getNombreJuego() {
		return nombreJuego;
	}

	/**
	 * @param nombreJuego the nombreJuego to set
	 */
	public void setNombreJuego(String nombreJuego) {
		this.nombreJuego = nombreJuego;
	}

	/**
	 * @return the tipoJuego
	 */
	public String getTipoJuego() {
		return tipoJuego;
	}

	/**
	 * @param tipoJuego the tipoJuego to set
	 */
	public void setTipoJuego(String tipoJuego) {
		this.tipoJuego = tipoJuego;
	}

	/**
	 * @return the presupuesto
	 */
	public long getPresupuesto() {
		return presupuesto;
	}

	/**
	 * @param presupuesto the presupuesto to set
	 */
	public void setPresupuesto(long presupuesto) {
		this.presupuesto = presupuesto;
	}

}
