/**
 * Paquete persistencia
 */
package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

/**
 * clase ApostadorDAO
 */
public class ApostadorDAO {

	private ArrayList<ApostadorDTO> listaApostador;
	private ArchivoApostadores archivoApostadores;

	/**
	 * constructor vacio
	 */
	public ApostadorDAO() {
		this.archivoApostadores = new ArchivoApostadores();
		this.archivoApostadores.asignarRutaArchivoApostadores(archivoApostadores.getRUTA_APOSTADORES());
		this.listaApostador = archivoApostadores.leerArchivo(archivoApostadores.getFileArchivo());
	}

	/**
	 * Se encarga de buscar dentro del ArrayList de apostadores, el apostador exacto
	 * con que est� identificando la cedula. <b>pre</b> Que exista la lista en la
	 * cual se van a buscar los apostadores <br>
	 * <b>post</b> Que haya un lugar donde se pueda enviar el apostador dentro de la
	 * lista <br>
	 * 
	 * @param cedula, es la cedula del apostador; cedula != null
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
	 * @param sede,      es la sede donde est� jugando; sede != null.
	 * @param direccion, es la direcci�n del apostador; direccion != null.
	 * @param celular,   es el celular del apostador; celular != null.
	 * @return retorna true si todos los datos est�n correctos dando a entender que
	 *         se agrego correctamente, o retorna false si hubo alg�n dato equivado
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
	 * <b>post</b>Elimina al apostador<br>
	 * 
	 * @param cedula, es la cedula del apostador; cedula != null.
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

	/**
	 * Este m�todo se encarga de editar a un apostador de la lista de apostadores.
	 * <b>pre</b>Que exista la lista de apostadores de donde se va a tomar el
	 * apostador<br>
	 * <b>post</b>Edita al apostador<br>
	 * 
	 * @param cedula,    es la cedula del apostador; cedula != null.
	 * @param nombre,    es el nombre del apostador; nombre != null.
	 * @param sede,      es la sede en donde se encuentra el apostador; sede !=
	 *                   null.
	 * @param direccion, es la direcci�n del apostador; direccion != null.
	 * @param celular,   es el n�mero telef�nico del apostador; celular != null.
	 * @return retorna true si el apostador se ha editado, retorna false si el
	 *         apostador no existe dentro de la lista.
	 */
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

	/**
	 * Este m�todo se encarga de verificar de que no se repitan n�meros telef�nicos.
	 * 
	 * @param listaA,  es la lista de donde se van a verificar los telefonos; listaA
	 *                 != null.
	 * @param celular, es el n�mero telef�nico a verificar; celular != null.
	 * @return retorna true si el telefono existe dentro de la lista, retorna false
	 *         si no se encuentra dentro de la lista.
	 */
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