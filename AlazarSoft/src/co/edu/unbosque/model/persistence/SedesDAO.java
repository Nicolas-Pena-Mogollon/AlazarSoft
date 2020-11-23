package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

public class SedesDAO {

	private ArrayList<SedesDTO> dataSedes;
	private SedeFile sedeFile;

	public SedesDAO() {
		dataSedes = new ArrayList<SedesDTO>();
		sedeFile = new SedeFile();
		leerSede();
	}

	public void crearRegistroBase() {

	}

	public String crearSede(SedesDTO nuevaSede) {
		dataSedes.add(nuevaSede);
		sedeFile.escribirRegistroSede(dataSedes);
		return "Proceso correcto";
	}

	public ArrayList<SedesDTO> leerSede() {
		if (sedeFile.leerRegistroSede() == null) {
			crearRegistroBase();
		} else {
			dataSedes = (sedeFile.leerRegistroSede());
		}
		return dataSedes;
	}
	
	public String actualizarSede(int IdUbicacion, String ubicacion, int empleados) {
		for (int i = 0; i < dataSedes.size(); i++) {
			if (IdUbicacion == dataSedes.get(i).getIdUbicacion()) {
				if (!ubicacion.equals("")) {
					dataSedes.get(i).setUbicacion(ubicacion);;
				}
				if (empleados != -8) {
					dataSedes.get(i).setEmpleados(empleados);;

				}
			}
		}
		sedeFile.escribirRegistroSede(dataSedes);
		return "Registro actualizado";

	}

	public ArrayList<SedesDTO> getDataSedes() {
		return dataSedes;
	}

	public void setDataSedes(ArrayList<SedesDTO> dataSedes) {
		this.dataSedes = dataSedes;
	}

	public SedeFile getSedeFile() {
		return sedeFile;
	}

	public void setSedeFile(SedeFile sedeFile) {
		this.sedeFile = sedeFile;
	}

}
