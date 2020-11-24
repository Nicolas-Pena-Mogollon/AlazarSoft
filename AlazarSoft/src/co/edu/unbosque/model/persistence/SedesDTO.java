/**
 * Paquete persistencia
 */
package co.edu.unbosque.model.persistence;

import java.io.Serializable;

/**
 * Clase SedesDTO
 */
public class SedesDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idUbicacion;
	private String ubicacion;
	private int empleados;

	/**
	 * Constructor específico
	 * 
	 * @param idUbicacion, es el id de la ubicación; idUbicacion != null.
	 * @param ubicacion,   es la ubicación de la sede; ubicacion != null.
	 * @param empleados,   es el número de empleados de la sede; empleados != null.
	 */
	public SedesDTO(int idUbicacion, String ubicacion, int empleados) {
		this.ubicacion = ubicacion;
		this.empleados = empleados;
		this.idUbicacion = idUbicacion;
	}

	/**
	 * @return the idUbicacion
	 */
	public int getIdUbicacion() {
		return idUbicacion;
	}

	/**
	 * @param idUbicacion the idUbicacion to set
	 */
	public void setIdUbicacion(int idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	/**
	 * @return the ubicacion
	 */
	public String getUbicacion() {
		return ubicacion;
	}

	/**
	 * @param ubicacion the ubicacion to set
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	/**
	 * @return the empleados
	 */
	public int getEmpleados() {
		return empleados;
	}

	/**
	 * @param empleados the empleados to set
	 */
	public void setEmpleados(int empleados) {
		this.empleados = empleados;
	}

}
