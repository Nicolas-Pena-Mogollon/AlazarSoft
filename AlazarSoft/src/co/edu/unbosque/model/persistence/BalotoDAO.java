package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class BalotoDAO {

	private ArchivoApuesta archivo;

	public BalotoDAO() {
		this.archivo = new ArchivoApuesta();
	}

	public BalotoDTO buscarApuesta(String cedula, Date fecha, ArrayList<BalotoDTO> lista) {
		BalotoDTO encontrado = null;
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getCedula().equals(cedula) && lista.get(i).getFecha() == fecha) {
				encontrado = lista.get(i);
			}
		}
		return encontrado;
	}

	public boolean crearApuestas(String nombre, String cedula, Date fecha, double valorApuesta, String numeroJuego,
			ArrayList<BalotoDTO> lista, File file) {
		BalotoDTO balotoDTO;
		balotoDTO = new BalotoDTO(nombre, cedula, fecha, valorApuesta, numeroJuego);
		lista.add(balotoDTO);
		archivo.escribirArchivoBaloto(lista, file);
		return true;
	}

	public String mostrarApuestaBusqueda(String cedula, Date fecha, ArrayList<BalotoDTO> lista) {
		String mensaje = "";
		for (int i = 0; i < lista.size(); i++) {
			if (cedula.equals(lista.get(i).getCedula()) && fecha == lista.get(i).getFecha()) {
				mensaje += "Sede: " + lista.get(i).getNombreSede() + "\n" + "Cedula: " + lista.get(i).getCedula() + "\n"
						+ "Fecha: " + lista.get(i).getFecha() + "\n" + "Valor: " + lista.get(i).getValorApuesta()
						+ "\n\n";
			}
		}
		return mensaje;
	}

	public boolean eliminarApuesta(String cedula, Date fecha, ArrayList<BalotoDTO> lista, File file) {
		boolean verificar = false;
		BalotoDTO balotoDTO = buscarApuesta(cedula, fecha, lista);
		if (balotoDTO != null) {
			lista.remove(balotoDTO);
			file.delete();
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			archivo.escribirArchivoBaloto(lista, file);
			verificar = true;
		} else {
			verificar = false;
		}
		return verificar;
	}

	public boolean editarApuesta(String cedula, Date fecha, String nombreSede, double valorApuesta,
			ArrayList<BalotoDTO> lista, File file) {
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
				archivo.escribirArchivoBaloto(lista, file);
				return verificar = true;
			} else {
				verificar = false;
			}
		}
		return verificar;
	}

}
