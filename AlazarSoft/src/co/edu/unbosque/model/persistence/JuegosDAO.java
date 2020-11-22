package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

public class JuegosDAO {

	private ArrayList<JuegosDTO> listaJuegos;
	private ArchivoJuegos archivoJuegos;

	public JuegosDAO() {
		this.archivoJuegos = new ArchivoJuegos();
		this.archivoJuegos.asignarRutaArchivoJuegos(archivoJuegos.getRUTA_JUEGOS());
		this.listaJuegos = this.archivoJuegos.leerArchivo(this.archivoJuegos.getFileArchivo());
	}

	public JuegosDTO buscarJuego(String nombre) {
		JuegosDTO encontrado = null;
		for (int i = 0; i < listaJuegos.size(); i++) {
			if (nombre.equals(listaJuegos.get(i).getNombreJuego())) {
				encontrado = listaJuegos.get(i);
			}
		}
		return encontrado;
	}

	public boolean agregarJuego(String nombreJuego, String tipoJuego, long presupuesto) {
		boolean verificar = false;
		JuegosDTO juegos;
		juegos = new JuegosDTO(nombreJuego, tipoJuego, presupuesto);
		if (buscarJuego(nombreJuego) == null) {
			listaJuegos.add(juegos);
			archivoJuegos.escribirArchivo(listaJuegos);
			verificar = true;
		} else {
			verificar = false;
		}
		return verificar;
	}
}
