package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.ArchivoConfiguracionCasaApuestas;
import co.edu.unbosque.model.persistence.JuegosDAO;
import co.edu.unbosque.model.persistence.JuegosDTO;

public class Juego {

	private JuegosDAO juegosDAO;
	private ArchivoConfiguracionCasaApuestas archivo;

	public Juego() {
		this.juegosDAO = new JuegosDAO();
		this.archivo = new ArchivoConfiguracionCasaApuestas();
	}

	public boolean verificarPresupuesto(ArrayList<JuegosDTO> lista, long presupuesto) {
		boolean verificar = false;
		long suma = 0;
		long total = 0;
		String[] datos = archivo.leerConfiguracionCasaApuestas();
		long maximo = Long.parseLong(datos[2]);
		for (int i = 0; i < lista.size(); i++) {
			suma += lista.get(i).getPresupuesto();
		}
		total = suma + presupuesto;
		System.out.println(total);
		System.out.println(suma);
		if (total > maximo) {
			verificar = true;
		} else {
			verificar = false;
		}
		return verificar;
	}

	public long presupuestoDisponible(ArrayList<JuegosDTO> lista) {
		long presupuesto = 0;
		long suma = 0;
		String[] datos = archivo.leerConfiguracionCasaApuestas();
		long maximo = Long.parseLong(datos[2]);
		for (int i = 0; i < lista.size(); i++) {
			suma += lista.get(i).getPresupuesto();
		}
		presupuesto = maximo - suma;
		return presupuesto;
	}

	/**
	 * @return the juegosDAO
	 */
	public JuegosDAO getJuegosDAO() {
		return juegosDAO;
	}

	/**
	 * @param juegosDAO the juegosDAO to set
	 */
	public void setJuegosDAO(JuegosDAO juegosDAO) {
		this.juegosDAO = juegosDAO;
	}

}
