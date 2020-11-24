package co.edu.unbosque.model;

import java.io.File;
import java.util.Properties;

import co.edu.unbosque.model.persistence.Propiedades;
import co.edu.unbosque.model.persistence.SedesDAO;

public class Sede {

	private SedesDAO sedesDao;
	private Propiedades prop;
	private Properties datos;
	private String[] partidos;

	public Sede() {
		sedesDao = new SedesDAO();
		prop = new Propiedades();
		datos = new Properties();
		partidos = new String[14];
	}

	public int generarIdSede() {
		int idSede = 0;
		if (sedesDao.getDataSedes().size() == 0) {
			idSede = 0;
		} else {
			idSede = sedesDao.getDataSedes().get(sedesDao.getDataSedes().size() - 1).getIdUbicacion() + 1;
		}
		return idSede;
	}

	public String[] obtenerSedes() {
		String[] salida = new String[sedesDao.getDataSedes().size()];
		for (int i = 0; i < sedesDao.getDataSedes().size(); i++) {
			salida[i] = sedesDao.getDataSedes().get(i).getUbicacion() + sedesDao.getDataSedes().get(i).getIdUbicacion();
		}
		return salida;
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

	public String[] cargarPartido() {
		try {
			datos = prop.cargarInfo(new File("Data\\partidos.properties"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return this.partidos = prop.inicializarDatosPartido(datos);
	}

	/**
	 * @return the sedesDao
	 */
	public SedesDAO getSedesDao() {
		return sedesDao;
	}

	/**
	 * @param sedesDao the sedesDao to set
	 */
	public void setSedesDao(SedesDAO sedesDao) {
		this.sedesDao = sedesDao;
	}

	/**
	 * @return the partidos
	 */
	public String[] getPartidos() {
		return partidos;
	}

	/**
	 * @param partidos the partidos to set
	 */
	public void setPartidos(String[] partidos) {
		this.partidos = partidos;
	}

}
