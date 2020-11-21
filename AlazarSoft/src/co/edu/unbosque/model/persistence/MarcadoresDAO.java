package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.Date;

public class MarcadoresDAO {

	private ArrayList<MarcadoresDTO> listaMarcadores;
	private ArchivoApuesta archivo;

	public MarcadoresDAO() {
		this.archivo = new ArchivoApuesta();
		this.archivo.asignarRutaArchivoMarcador(this.archivo.getRUTA_MARCADORES());
		this.listaMarcadores = this.archivo.leerArchivoMarcadores(this.archivo.getFileMarcador());
	}

	public MarcadoresDTO buscarApuesta(String cedula, Date fecha) {
		MarcadoresDTO encontrado = null;
		for (int i = 0; i < listaMarcadores.size(); i++) {
			if (listaMarcadores.get(i).getCedula().equals(cedula) && listaMarcadores.get(i).getFecha().equals(fecha)) {
				encontrado = listaMarcadores.get(i);
			}
		}
		return encontrado;
	}

	public boolean crearApuestas(String nombre, String cedula, Date fecha, double valorApuesta, String partido,
			String resultado) {
		MarcadoresDTO marcadoresDTO;
		marcadoresDTO = new MarcadoresDTO(nombre, cedula, fecha, valorApuesta, partido, resultado);
		listaMarcadores.add(marcadoresDTO);
		archivo.escribirArchivoMarcadores(listaMarcadores);
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

	public boolean eliminarApuesta(String cedula, Date fecha) {
		boolean verificar = false;
		MarcadoresDTO marcadoresDTO = buscarApuesta(cedula, fecha);
		if (marcadoresDTO != null) {
			listaMarcadores.remove(marcadoresDTO);
			archivo.escribirArchivoMarcadores(listaMarcadores);
			verificar = true;
		} else {
			verificar = false;
		}
		return verificar;
	}

	public boolean editarApuesta(String cedula, Date fecha, String nombreSede, double valorApuesta) {
		boolean verificar = false;
		for (int i = 0; i < listaMarcadores.size(); i++) {
			if (cedula.equals(listaMarcadores.get(i).getCedula()) && fecha.equals(listaMarcadores.get(i).getFecha())) {
				listaMarcadores.get(i).setNombreSede(nombreSede);
				listaMarcadores.get(i).setValorApuesta(valorApuesta);
				archivo.escribirArchivoMarcadores(listaMarcadores);
				return verificar = true;
			} else {
				verificar = false;
			}
		}
		return verificar;
	}

	/**
	 * @return the listaMarcadores
	 */
	public ArrayList<MarcadoresDTO> getListaMarcadores() {
		return listaMarcadores;
	}

	/**
	 * @param listaMarcadores the listaMarcadores to set
	 */
	public void setListaMarcadores(ArrayList<MarcadoresDTO> listaMarcadores) {
		this.listaMarcadores = listaMarcadores;
	}

	/**
	 * @return the archivo
	 */
	public ArchivoApuesta getArchivo() {
		return archivo;
	}

	/**
	 * @param archivo the archivo to set
	 */
	public void setArchivo(ArchivoApuesta archivo) {
		this.archivo = archivo;
	}

}
