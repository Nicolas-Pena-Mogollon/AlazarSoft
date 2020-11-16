package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.ArchivoConfiguracionCasaApuestas;

public class CasaDeApuestas {

	private String nombreCasaApuestas;
	private int numeroSedes;
	private double presupuestoTotal;
	private ArchivoConfiguracionCasaApuestas archivoConfiguracionCasaApuestas;

	public CasaDeApuestas() {

		archivoConfiguracionCasaApuestas = new ArchivoConfiguracionCasaApuestas();
	}

	public void guardarConfiguracionCasaDeApuestas(String nombre, int numeroSedes, double presupuestoTotal) {
		this.nombreCasaApuestas = nombre;
		this.numeroSedes = numeroSedes;
		this.presupuestoTotal = presupuestoTotal;

		String[] datos = { nombre, String.valueOf(numeroSedes), String.valueOf(presupuestoTotal) };
		archivoConfiguracionCasaApuestas.escribirConfiguracionCasaApuestas(datos);
	}

	public String getNombreCasaApuestas() {
		return nombreCasaApuestas;
	}

	public void setNombreCasaApuestas(String nombreCasaApuestas) {
		this.nombreCasaApuestas = nombreCasaApuestas;
	}

	public int getNumeroSedes() {
		return numeroSedes;
	}

	public void setNumeroSedes(int numeroSedes) {
		this.numeroSedes = numeroSedes;
	}

	public double getPresupuestoTotal() {
		return presupuestoTotal;
	}

	public void setPresupuestoTotal(double presupuestoTotal) {
		this.presupuestoTotal = presupuestoTotal;
	}

	public ArchivoConfiguracionCasaApuestas getArchivoConfiguracionCasaApuestas() {
		return archivoConfiguracionCasaApuestas;
	}

	public void setArchivoConfiguracionCasaApuestas(ArchivoConfiguracionCasaApuestas archivoConfiguracionCasaApuestas) {
		this.archivoConfiguracionCasaApuestas = archivoConfiguracionCasaApuestas;
	}

}
