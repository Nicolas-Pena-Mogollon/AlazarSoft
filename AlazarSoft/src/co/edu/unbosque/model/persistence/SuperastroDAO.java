package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class SuperastroDAO {

	private ArchivoApuesta archivo;

	public SuperastroDAO() {
		this.archivo = new ArchivoApuesta();
	}

	public SuperastroDTO buscarApuesta(String cedula, Date fecha, ArrayList<SuperastroDTO> lista) {
		SuperastroDTO encontrado = null;
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getCedula().equals(cedula) && lista.get(i).getFecha() == fecha) {
				encontrado = lista.get(i);
			}
		}
		return encontrado;
	}

	public boolean crearApuestas(String nombre, String cedula, Date fecha, double valorApuesta, String numeroJuego,
			ArrayList<SuperastroDTO> lista, File file) {
		SuperastroDTO superastroDTO;
		superastroDTO = new SuperastroDTO(nombre, cedula, fecha, valorApuesta, numeroJuego);
		lista.add(superastroDTO);
		archivo.escribirArchivoSuperastro(lista, file);
		return true;
	}

	public String mostrarApuestaBusqueda(String cedula, Date fecha, ArrayList<SuperastroDTO> lista) {
		String mensaje = "";
		for (int i = 0; i < lista.size(); i++) {
			if (cedula.equals(lista.get(i).getCedula()) && fecha == lista.get(i).getFecha()) {
				mensaje += "Sede: " + lista.get(i).getNombreSede() + "\n" + "Cedula: " + lista.get(i).getCedula() + "\n"
						+ "Fecha: " + lista.get(i).getFecha() + "\n" + "Valor: " + lista.get(i).getValorApuesta()
						+ "Numero de juego: " + lista.get(i).getNumeroJuego() + "\n\n";
			}
		}
		return mensaje;
	}

	public boolean eliminarApuesta(String cedula, Date fecha, ArrayList<SuperastroDTO> lista, File file) {
		boolean verificar = false;
		SuperastroDTO superastroDTO = buscarApuesta(cedula, fecha, lista);
		if (superastroDTO != null) {
			lista.remove(superastroDTO);
			file.delete();
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			archivo.escribirArchivoSuperastro(lista, file);
			verificar = true;
		} else {
			verificar = false;
		}
		return verificar;
	}

	public boolean editarApuesta(String cedula, Date fecha, String nombreSede, double valorApuesta,
			ArrayList<SuperastroDTO> lista, File file) {
		boolean verificar = false;
		for (int i = 0; i < lista.size(); i++) {
			if (cedula.equals(lista.get(i).getCedula()) && fecha == lista.get(i).getFecha()) {
				lista.get(i).setNombreSede(nombreSede);
				lista.get(i).setValorApuesta(valorApuesta);
				file.delete();
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				archivo.escribirArchivoSuperastro(lista, file);
				return verificar = true;
			} else {
				verificar = false;
			}
		}
		return verificar;
	}

}
