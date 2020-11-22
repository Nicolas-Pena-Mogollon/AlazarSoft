package co.edu.unbosque.model.persistence;

import java.io.Serializable;

public class JuegosDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombreJuego = "";
	private String tipoJuego = "";
	private long presupuesto = 0;
	
	public JuegosDTO() {
		
	}
	
	/**
	 * @param nombreJuego
	 * @param tipoJuego
	 * @param presupuesto
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
