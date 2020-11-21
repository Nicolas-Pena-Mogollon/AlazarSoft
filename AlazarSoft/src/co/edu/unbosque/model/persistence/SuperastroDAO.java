package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.Date;

public class SuperastroDAO {

	private ArrayList<SuperastroDTO> listaSuperastro;
	private ArchivoApuesta archivo;

	public SuperastroDAO() {
		this.archivo = new ArchivoApuesta();
		this.archivo.asignarRutaArchivoSupeastro(this.archivo.getRUTA_SUPERASTRO());
		this.listaSuperastro = this.archivo.leerArchivoSuperastro(this.archivo.getFileSuperastro());
	}

	public SuperastroDTO buscarApuesta(String cedula, Date fecha) {
		SuperastroDTO encontrado = null;
		for (int i = 0; i < listaSuperastro.size(); i++) {
			if (listaSuperastro.get(i).getCedula().equals(cedula) && listaSuperastro.get(i).getFecha() == fecha) {
				encontrado = listaSuperastro.get(i);
			}
		}
		return encontrado;
	}

	public boolean crearApuestas(String nombre, String cedula, Date fecha, double valorApuesta, String numeroJuego,
			String signo) {
		SuperastroDTO superastroDTO;
		superastroDTO = new SuperastroDTO(nombre, cedula, fecha, valorApuesta, numeroJuego, signo);
		listaSuperastro.add(superastroDTO);
		archivo.escribirArchivoSuperastro(listaSuperastro);
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

	public boolean eliminarApuesta(String cedula, Date fecha) {
		boolean verificar = false;
		SuperastroDTO superastroDTO = buscarApuesta(cedula, fecha);
		if (superastroDTO != null) {
			listaSuperastro.remove(superastroDTO);
			archivo.escribirArchivoSuperastro(listaSuperastro);
			verificar = true;
		} else {
			verificar = false;
		}
		return verificar;
	}

	public boolean editarApuesta(String cedula, Date fecha, String nombreSede, double valorApuesta) {
		boolean verificar = false;
		for (int i = 0; i < listaSuperastro.size(); i++) {
			if (cedula.equals(listaSuperastro.get(i).getCedula()) && fecha == listaSuperastro.get(i).getFecha()) {
				listaSuperastro.get(i).setNombreSede(nombreSede);
				listaSuperastro.get(i).setValorApuesta(valorApuesta);
				archivo.escribirArchivoSuperastro(listaSuperastro);
				return verificar = true;
			} else {
				verificar = false;
			}
		}
		return verificar;
	}

}
