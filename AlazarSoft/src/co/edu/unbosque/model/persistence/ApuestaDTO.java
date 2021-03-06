/**
 * Paquete persistencia
 */
package co.edu.unbosque.model.persistence;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase ApuestaDTO
 */
public class ApuestaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	protected String nombreSede = "";
	protected String cedula = "";
	protected Date fecha = null;
	protected double valorApuesta = 0;

	/**
	 * Constructor vacio
	 */
	public ApuestaDTO() {

	}

	/**
	 * Constructor específico
	 * 
	 * @param nombreSede,   es el nombre de la sede; sede != null.
	 * @param cedula,       es la cedula del apostador; cedula != null.
	 * @param fecha,        es la fecha de la apuesta; fecha != null.
	 * @param valorApuesta, es el valor de la apuesta; != null.
	 */

	public ApuestaDTO(String nombreSede, String cedula, Date fecha, double valorApuesta) {
		this.nombreSede = nombreSede;
		this.cedula = cedula;
		this.fecha = fecha;
		this.valorApuesta = valorApuesta;
	}

	/**
	 * @return the nombreSede
	 */
	public String getNombreSede() {
		return nombreSede;
	}

	/**
	 * @param nombreSede the nombreSede to set
	 */
	public void setNombreSede(String nombreSede) {
		this.nombreSede = nombreSede;
	}

	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the valorApuesta
	 */
	public double getValorApuesta() {
		return valorApuesta;
	}

	/**
	 * @param valorApuesta the valorApuesta to set
	 */
	public void setValorApuesta(double valorApuesta) {
		this.valorApuesta = valorApuesta;
	}

}
