package co.edu.unbosque.model.persistence;

import java.io.Serializable;

public class SedesDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idUbicacion;
	private String ubicacion;
	private int empleados;
	
	public SedesDTO(int idUbicacion,String ubicacion, int empleados) {
		this.ubicacion = ubicacion;
		this.empleados = empleados;
		this.idUbicacion = idUbicacion;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getEmpleados() {
		return empleados;
	}

	public void setEmpleados(int empleados) {
		this.empleados = empleados;
	}

	public int getIdUbicacion() {
		return idUbicacion;
	}

	public void setIdUbicacion(int idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
