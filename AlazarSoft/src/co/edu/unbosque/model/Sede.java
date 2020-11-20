package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.SedesDAO;

public class Sede {

	private SedesDAO sedesDao;

	public Sede() {
		sedesDao = new SedesDAO();

	}

	public int generarIdSede() {
		int idSede = sedesDao.getDataSedes().get(sedesDao.getDataSedes().size() - 1).getIdUbicacion() + 1;
		return idSede;
	}

	public String[][] crearTablaSede() {
		String[][] registro = new String[sedesDao.getDataSedes().size()][3];
		for (int i = 0; i < sedesDao.getDataSedes().size(); i++) {
			registro[i][0] = String.valueOf(sedesDao.getDataSedes().get(i).getIdUbicacion());
			registro[i][1] = sedesDao.getDataSedes().get(i).getUbicacion();
			registro[i][2] = String.valueOf(sedesDao.getDataSedes().get(i).getEmpleados());
		}
		return registro;
	}

	public String[] llenarTablaSede() {
		String[] cadena = new String[sedesDao.getDataSedes().size()];
		for (int i = 0; i < cadena.length; i++) {
			cadena[i] = String.valueOf(sedesDao.getDataSedes().get(i).getIdUbicacion());
		}
		return cadena;
	}

}
