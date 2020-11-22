/**
a * paquete persistencia, encargado de la permanencia de informacion en el programa
 */
package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

/**
 * clase CotizanteDAO
 */
public class ApostadorDAO {

	/*
	 * Es la instanciación de la clase archivo
	 */
	private ArrayList<ApostadorDTO> listaApostador;

	private ArchivoApostadores archivoApostadores;

	/**
	 * constructor clase ApostadorDAO
	 */
	public ApostadorDAO() {
		this.archivoApostadores = new ArchivoApostadores();
		this.archivoApostadores.asignarRutaArchivoApostadores(archivoApostadores.getRUTA_APOSTADORES());
		this.listaApostador = archivoApostadores.leerArchivo(archivoApostadores.getFileArchivo());
	}

	/**
	 * Se encarga de buscar dentro del ArrayList de apostadores, el apostador exacto
	 * con que está identificando la cedula. <b>pre</b> Que exista la lista en la
	 * cual se van a buscar los apostadores <br>
	 * <b>post</b> Que haya un lugar donde se pueda enviar el apostador dentro de la
	 * lista <br>
	 * 
	 * @param cedula, es la cedula del apostador; cedula =! null
	 * @param listaA, es el arrayList donde se va encontrar el apostador; listaA =!
	 *                null
	 * @return Devuelve el objeto apostador.
	 */
	public ApostadorDTO buscarApostador(String cedula) {
		ApostadorDTO encontrado = null;
		for (int i = 0; i < listaApostador.size(); i++) {
			if (cedula.equals(listaApostador.get(i).getCedula())) {
				encontrado = listaApostador.get(i);
			}
		}
		return encontrado;

	}

	/**
	 * Se encarga de agregar los apostadores dentro del archivo. <b>pre</b> Que
	 * exista el archivo<br>
	 * <b>post</b> Se agrega dentro del archivo<br>
	 *
	 * @param nombre,    es el nombre del apostador; nombre != null.
	 * @param cedula,    es la cedula del apostador; cedula != null.
	 * @param sede,      es la sede donde está jugando; sede != null.
	 * @param direccion, es la dirección del apostador; direccion != null.
	 * @param celular,   es el celular del apostador; celular != null.
	 * @param listaC,    es la lista de apostadores; listaC != null.
	 * @param file,      es el archivo donde se guardaran los apostadores; file !=
	 *                   null.
	 * @return retorna true si todos los datos están correctos dando a entender que
	 *         se agrego correctamente, o retorna false si hubo algún dato equivado
	 *         dando a entender que no se pude registrar.
	 */
	public boolean agregarApostador(String nombre, String cedula, String sede, String direccion, String celular) {
		boolean verificar = false;
		ApostadorDTO alCotizante;
		alCotizante = new ApostadorDTO(nombre, cedula, sede, direccion, celular);
		if (buscarApostador(cedula) == null) {
			listaApostador.add(alCotizante);
			archivoApostadores.escribirArchivo(listaApostador);
			verificar = true;
		} else {
			verificar = false;
		}
		return verificar;

	}

	/**
	 * Se encarga de eliminar un apostador dentro del archivo. <b>pre</b> Que exista
	 * el apostador y el archivo<br>
	 * <b>post</b> Elimina el vehículo<br>
	 * 
	 * @param cedula, es la cedula del apostador; cedula =! null.
	 * @param listaC, es el listado de apostadores en el cual se eliminará el
	 *                apostador registrado; listaC =! null
	 * @param file,   es el archivo donde se elminaran los apostadores; file =! null
	 * @return retorna un true o un false dependiendo las condiciones.
	 */
	public boolean eliminarApostador(String cedula) {
		boolean verificar = false;
		ApostadorDTO apostador = buscarApostador(cedula);
		if (apostador != null) {
			listaApostador.remove(apostador);
			archivoApostadores.escribirArchivo(listaApostador);
			verificar = true;
		} else {
			verificar = false;
		}
		return verificar;

	}


	public boolean editarApostador(String cedula, String nombre, String sede, String direccion, String celular) {
		boolean verificar = false;
		ApostadorDTO apostador = buscarApostador(cedula);
		if (apostador != null) {
			this.eliminarApostador(cedula);
			this.agregarApostador(nombre, cedula, sede, direccion, celular);
			verificar = true;
		} else {
			verificar = false;
		}
		return verificar;
	}

	public boolean verificarNumeroTelefonico(ArrayList<ApostadorDTO> listaA, String celular) {
		boolean verificar = false;
		for (int i = 0; i < listaA.size(); i++) {
			if (celular.equals(listaA.get(i).getCelular())) {
				verificar = true;
			} else {
				verificar = false;
			}

		}
		return verificar;
	}

	/**
	 * @return the listaApostador
	 */
	public ArrayList<ApostadorDTO> getListaApostador() {
		return listaApostador;
	}

	/**
	 * @param listaApostador the listaApostador to set
	 */
	public void setListaApostador(ArrayList<ApostadorDTO> listaApostador) {
		this.listaApostador = listaApostador;
	}

	/**
	 * @return the archivoApostadores
	 */
	public ArchivoApostadores getArchivoApostadores() {
		return archivoApostadores;
	}

	/**
	 * @param archivoApostadores the archivoApostadores to set
	 */
	public void setArchivoApostadores(ArchivoApostadores archivoApostadores) {
		this.archivoApostadores = archivoApostadores;
	}

}