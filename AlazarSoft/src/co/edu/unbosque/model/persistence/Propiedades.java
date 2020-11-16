package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class Propiedades {
	
	String[] partidos;
	
	public Propiedades() {
		
	}
	
	public Properties cargarInfo(File archivo) throws Exception {
		Properties datos = new Properties();
		FileInputStream in = new FileInputStream(archivo);
		try {
			datos.load(in);
			in.close();
		} catch (Exception e) {
			throw new Exception("Error en properties");
		}
		return datos;
	}
	
	public String[] inicializarDatosPartido(Properties pDatos) {

		partidos = new String[14];

		String partido = "";
		
		for (int i = 1; i < 15; i++) {

			partido = pDatos.getProperty("partido" + i);
			partidos[i] = partido;

		}
		return partidos;

	}

}
