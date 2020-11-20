package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.ArchivoConfiguracionCasaApuestas;

public class CasaDeApuestas {

	private Apostador apostadores;
	private String nombreCasaApuestas;
	private int numeroSedes;
	private Long presupuestoTotal;
	private ArchivoConfiguracionCasaApuestas archivoConfiguracionCasaApuestas;

	public CasaDeApuestas() {
		this.archivoConfiguracionCasaApuestas = new ArchivoConfiguracionCasaApuestas();
		this.apostadores = new Apostador();
	}

//Falta Condicional para campos vacios
	public void guardarConfiguracionCasaDeApuestas(String nombre, int numeroSedes, Long presupuestoTotal) {
		this.nombreCasaApuestas = nombre;
		this.numeroSedes = numeroSedes;
		this.presupuestoTotal = presupuestoTotal;

		String[] datos = { nombre, String.valueOf(numeroSedes), String.valueOf(presupuestoTotal) };
		archivoConfiguracionCasaApuestas.escribirConfiguracionCasaApuestas(datos);
	}

	/**
	 * @return the apostadores
	 */
	public Apostador getApostadores() {
		return apostadores;
	}

	/**
	 * @param apostadores the apostadores to set
	 */
	public void setApostadores(Apostador apostadores) {
		this.apostadores = apostadores;
	}

	/**
	 * @return the nombreCasaApuestas
	 */
	public String getNombreCasaApuestas() {
		return nombreCasaApuestas;
	}

	/**
	 * @param nombreCasaApuestas the nombreCasaApuestas to set
	 */
	public void setNombreCasaApuestas(String nombreCasaApuestas) {
		this.nombreCasaApuestas = nombreCasaApuestas;
	}

	/**
	 * @return the numeroSedes
	 */
	public int getNumeroSedes() {
		return numeroSedes;
	}

	/**
	 * @param numeroSedes the numeroSedes to set
	 */
	public void setNumeroSedes(int numeroSedes) {
		this.numeroSedes = numeroSedes;
	}

	/**
	 * @return the presupuestoTotal
	 */
	public Long getPresupuestoTotal() {
		return presupuestoTotal;
	}

	/**
	 * @param presupuestoTotal the presupuestoTotal to set
	 */
	public void setPresupuestoTotal(Long presupuestoTotal) {
		this.presupuestoTotal = presupuestoTotal;
	}

	/**
	 * @return the archivoConfiguracionCasaApuestas
	 */
	public ArchivoConfiguracionCasaApuestas getArchivoConfiguracionCasaApuestas() {
		return archivoConfiguracionCasaApuestas;
	}

	/**
	 * @param archivoConfiguracionCasaApuestas the archivoConfiguracionCasaApuestas
	 *                                         to set
	 */
	public void setArchivoConfiguracionCasaApuestas(ArchivoConfiguracionCasaApuestas archivoConfiguracionCasaApuestas) {
		this.archivoConfiguracionCasaApuestas = archivoConfiguracionCasaApuestas;
	}

}
