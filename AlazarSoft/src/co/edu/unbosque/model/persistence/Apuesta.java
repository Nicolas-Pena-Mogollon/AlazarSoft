package co.edu.unbosque.model.persistence;

import java.io.Serializable;
import java.sql.Date;

public class Apuesta implements Serializable{
	
	protected String nombreSede = "";
	protected String cedula = "";
	protected Date fecha = null;
	protected String valorApuesta = "";
	
	public Apuesta() {
		
	}
	
	

	public Apuesta(String nombreSede, String cedula, Date fecha, String valorApuesta) {
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
	public String getValorApuesta() {
		return valorApuesta;
	}

	/**
	 * @param valorApuesta the valorApuesta to set
	 */
	public void setValorApuesta(String valorApuesta) {
		this.valorApuesta = valorApuesta;
	}
	
	
}
