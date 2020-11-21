package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.Date;

public class BalotoDAO {

	private ArchivoApuesta archivo;
	private ArrayList<BalotoDTO> listaBaloto;

	public BalotoDAO() {
		this.archivo = new ArchivoApuesta();
		this.archivo.asignarRutaArchivoBaloto(this.archivo.getRUTA_BALOTO());
		this.listaBaloto = this.archivo.leerArchivoBaloto(this.archivo.getFileBaloto());
	}

	public BalotoDTO buscarApuesta(String cedula, Date fecha) {
		BalotoDTO encontrado = null;
		for (int i = 0; i < listaBaloto.size(); i++) {
			if (listaBaloto.get(i).getCedula().equals(cedula) && listaBaloto.get(i).getFecha().equals(fecha)) {
				encontrado = listaBaloto.get(i);
			}
		}
		return encontrado;
	}

	public boolean crearApuestas(String nombre, String cedula, Date fecha, double valorApuesta, String numeroJuego) {
		BalotoDTO balotoDTO;
		balotoDTO = new BalotoDTO(nombre, cedula, fecha, valorApuesta, numeroJuego);
		listaBaloto.add(balotoDTO);
		archivo.escribirArchivoBaloto(listaBaloto);
		return true;
	}

	public String mostrarApuestaBusqueda(ArrayList<BalotoDTO> lista) {
		String mensaje = "";
		for (int i = 0; i < lista.size(); i++) {

			mensaje += "Sede: " + lista.get(i).getNombreSede() + "\n" + "Cedula: " + lista.get(i).getCedula() + "\n"
					+ "Fecha: " + lista.get(i).getFecha() + "\n" + "Valor: " + lista.get(i).getValorApuesta() + "\n"
					+ "Numero de juego: " + lista.get(i).getNumeroJuego() + "\n\n";

		}
		return mensaje;
	}

	public boolean eliminarApuesta(String cedula, Date fecha) {
		boolean verificar = false;
		BalotoDTO balotoDTO = buscarApuesta(cedula, fecha);
		if (balotoDTO != null) {
			listaBaloto.remove(balotoDTO);
			archivo.escribirArchivoBaloto(listaBaloto);
			verificar = true;
		} else {
			verificar = false;
		}
		return verificar;
	}

	public boolean editarApuesta(String cedula, Date fecha, String nombreSede, double valorApuesta) {
		boolean verificar = false;
		for (int i = 0; i < listaBaloto.size(); i++) {
			if (cedula.equals(listaBaloto.get(i).getCedula()) && fecha.equals(listaBaloto.get(i).getFecha())) {
				listaBaloto.get(i).setNombreSede(nombreSede);
				listaBaloto.get(i).setValorApuesta(valorApuesta);
				archivo.escribirArchivoBaloto(listaBaloto);
				return verificar = true;
			} else {
				verificar = false;
			}
		}
		return verificar;
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

	/**
	 * @return the listaBaloto
	 */
	public ArrayList<BalotoDTO> getListaBaloto() {
		return listaBaloto;
	}

	/**
	 * @param listaBaloto the listaBaloto to set
	 */
	public void setListaBaloto(ArrayList<BalotoDTO> listaBaloto) {
		this.listaBaloto = listaBaloto;
	}

}
