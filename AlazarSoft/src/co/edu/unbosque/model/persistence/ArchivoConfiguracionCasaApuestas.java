package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ArchivoConfiguracionCasaApuestas {

	private final String RUTA_ARCHIVO_CONFIG = "./Data/config.properties";
	private Properties prop;
	private File file;
	private FileInputStream fis;
	private FileOutputStream fos;

	public ArchivoConfiguracionCasaApuestas() {
		prop = new Properties();
		file = new File(RUTA_ARCHIVO_CONFIG);
	}

	public void escribirConfiguracionCasaApuestas(String[] datos) {
		try {
			fos = new FileOutputStream(file);
			prop.setProperty("nombreCasaApuestas", datos[0]);
			prop.setProperty("numeroSedes", datos[1]);
			prop.setProperty("presupuestoTotal", datos[2]);
			prop.store(fos, null);
			fos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public String[] leerConfiguracionCasaApuestas() {
		String[] datos = new String[3];
		if (file.exists()) {
			try {
				fis = new FileInputStream(file);
				prop.load(fis);
				datos[0] = prop.getProperty("nombreCasaApuestas");
				datos[1] = prop.getProperty("numeroSedes");
				datos[2] = prop.getProperty("presupuestoTotal");
				fis.close();
			} catch (IOException e) {
				return null;
			}
		}
		return datos;
	}

}
