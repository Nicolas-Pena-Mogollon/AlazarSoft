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
			if (listaSuperastro.get(i).getCedula().equals(cedula) && listaSuperastro.get(i).getFecha().equals(fecha)) {
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
			System.out.println(fecha);
			System.out.println(listaSuperastro.get(i).getFecha());
			if (cedula.equals(listaSuperastro.get(i).getCedula()) && fecha.equals(listaSuperastro.get(i).getFecha())) {
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

	/**
	 * @return the listaSuperastro
	 */
	public ArrayList<SuperastroDTO> getListaSuperastro() {
		return listaSuperastro;
	}

	/**
	 * @param listaSuperastro the listaSuperastro to set
	 */
	public void setListaSuperastro(ArrayList<SuperastroDTO> listaSuperastro) {
		this.listaSuperastro = listaSuperastro;
	}

}
