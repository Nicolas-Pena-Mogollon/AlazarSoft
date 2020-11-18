package co.edu.unbosque.model.persistence;

import java.io.Serializable;

public class ApostadorDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	String nombre = "";
	String cedula = "";
	String sede = "";
	String direccion = "";
	String celular = "";

	/**
	 * Constructor vacio
	 */
	public ApostadorDTO() {

	}

	/**
	 * Constructor especifico
	 * 
	 * @param nombre,    es el nombre del apostador; nombre != null.
	 * @param cedula,    es la cedula del apostador; cedula != null.
	 * @param sede,      es la sede donde está jugando; sede != null.
	 * @param direccion, es la dirección del apostador; direccion != null.
	 * @param celular,   es el celular del apostador; celular != null.
	 */
	public ApostadorDTO(String nombre, String cedula, String sede, String direccion, String celular) {
		this.nombre = nombre;
		this.cedula = cedula;
		this.sede = sede;
		this.direccion = direccion;
		this.celular = celular;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	 * @return the sede
	 */
	public String getSede() {
		return sede;
	}

	/**
	 * @param sede the sede to set
	 */
	public void setSede(String sede) {
		this.sede = sede;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * @param celular the celular to set
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

}
