package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class MarcadoresDAO {

	private ArchivoApuesta archivo;

	public MarcadoresDAO() {
		this.archivo = new ArchivoApuesta();
	}

	public MarcadoresDTO buscarApuesta(String cedula, Date fecha, ArrayList<MarcadoresDTO> lista) {
		MarcadoresDTO encontrado = null;
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getCedula().equals(cedula) && lista.get(i).getFecha() == fecha) {
				encontrado = lista.get(i);
			}
		}
		return encontrado;
	}

	public boolean crearApuestas(String nombre, String cedula, Date fecha, double valorApuesta, String partido,
			String resultado, ArrayList<MarcadoresDTO> lista, File file) {
		MarcadoresDTO marcadoresDTO;
		marcadoresDTO = new MarcadoresDTO(nombre, cedula, fecha, valorApuesta, partido, resultado);
		lista.add(marcadoresDTO);
		archivo.escribirArchivoMarcadores(lista, file);
		return true;
	}

	public String mostrarApuestaBusqueda(String cedula, Date fecha, ArrayList<MarcadoresDTO> lista) {
		String mensaje = "";
		for (int i = 0; i < lista.size(); i++) {
			if (cedula.equals(lista.get(i).getCedula()) && fecha == lista.get(i).getFecha()) {
				mensaje += "Sede: " + lista.get(i).getNombreSede() + "\n" + "Cedula: " + lista.get(i).getCedula() + "\n"
						+ "Fecha: " + lista.get(i).getFecha() + "\n" + "Valor: " + lista.get(i).getValorApuesta() + "\n"
						+ "Numero de juego: " + lista.get(i).getPartido() + "\n" + "Resultado: "
						+ lista.get(i).getResultado() + "\n\n";
			}
		}
		return mensaje;
	}

	public boolean eliminarApuesta(String cedula, Date fecha, ArrayList<MarcadoresDTO> lista, File file) {
		boolean verificar = false;
		MarcadoresDTO marcadoresDTO = buscarApuesta(cedula, fecha, lista);
		if (marcadoresDTO != null) {
			lista.remove(marcadoresDTO);
			file.delete();
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			archivo.escribirArchivoMarcadores(lista, file);
			verificar = true;
		} else {
			verificar = false;
		}
		return verificar;
	}

	public boolean editarApuesta(String cedula, Date fecha, String nombreSede, double valorApuesta, String partido,
			String resultado, ArrayList<MarcadoresDTO> lista, File file) {
		boolean verificar = false;
		for (int i = 0; i < lista.size(); i++) {
			if (cedula.equals(lista.get(i).getCedula()) && fecha == lista.get(i).getFecha()) {
				lista.get(i).setNombreSede(nombreSede);
				lista.get(i).setValorApuesta(valorApuesta);
				lista.get(i).setPartido(partido);
				lista.get(i).setResultado(resultado);
				file.delete();
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				archivo.escribirArchivoMarcadores(lista, file);
				return verificar = true;
			} else {
				verificar = false;
			}
		}
		return verificar;
	}

}
