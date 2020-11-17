/**
 * paquete persistencia, encargado de la permanencia de informacion en el programa
 */
package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * clase CotizanteDAO
 */
public class ApostadorDAO {

	/*
	 * Es la instanciación de la clase archivo
	 */
	private Archivo archivo;

	/**
	 * constructor clase ApostadorDAO
	 */
	public ApostadorDAO() {
		this.archivo = new Archivo();

	}

	/**
	 * Se encarga de buscar dentro del ArrayList de apostadores, el apostador exacto
	 * con que está identificado la cedula. <b>pre</b> Que exista la lista en la
	 * cual se van a buscar los apostadores <br>
	 * <b>post</b> Que haya un lugar donde se pueda enviar el apostador dentro de la
	 * lista <br>
	 * 
	 * @param cedula, es la cedula del apostador; cedula =! null
	 * @param listaA, es el arrayList donde se va encontrar el apostador; listaA =!
	 *                null
	 * @return Devuelve el objeto apostador.
	 */
	public ApostadorDTO buscarApostador(String cedula, ArrayList<ApostadorDTO> listaA) {
		ApostadorDTO encontrado = null;
		for (int i = 0; i < listaA.size(); i++) {
			if (cedula.equals(listaA.get(i).getCedula())) {
				encontrado = listaA.get(i);
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
	public boolean agregarApostador(String nombre, String cedula, String sede, String direccion, String celular,
			ArrayList<ApostadorDTO> listaA, File file) {
		boolean verificar = false;
		ApostadorDTO alCotizante;
		alCotizante = new ApostadorDTO(nombre, cedula, sede, direccion, celular);
		if (buscarApostador(cedula, listaA) == null) {
			listaA.add(alCotizante);
			archivo.escribirArchivo(listaA, file);
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
	public boolean eliminarApostador(String cedula, ArrayList<ApostadorDTO> listaC, File file) {
		try {
			ApostadorDTO apostador = buscarApostador(cedula, listaC);
			if (apostador != null) {
				listaC.remove(apostador);
				file.delete();
				file.createNewFile();
				archivo.escribirArchivo(listaC, file);
				return true;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;

	}

	/**
	 * Este metodo se encarga de buscar la información de un vehículo. <b>pre</b>
	 * Que exista la lista de vehiculos<br>
	 * <b>post</b>Muestrar la información del vehículo solicitado<br>
	 * 
	 * @param listaV, es el listado de vehículos que se utilizará para mostrar el
	 *                vehículo consultado; listaV != null
	 * @param placa,  la placa del vehículo a buscar; placa != null
	 * @return Muestra la información del vehículo solicitado por medio de un
	 *         String.
	 */

	public String mostrarApostadorBusqueda(ArrayList<ApostadorDTO> listaA, String cedula) {
		String mensaje = "";
		for (int i = 0; i < listaA.size(); i++) {
			if (cedula.equals(listaA.get(i).getCedula())) {
				mensaje = "";
				mensaje += "Cedula: " + listaA.get(i).getCedula() + "\n" + "Nombre: " + listaA.get(i).getNombre() + "\n"
						+ "Sede: " + listaA.get(i).getSede() + "\n" + "Direccion: " + listaA.get(i).getDireccion()
						+ "\n" + "Celular : " + listaA.get(i).getCelular() + "\n\n";
				return mensaje;
			} else {
				mensaje = "Apostador no encontrado";
			}

		}
		return mensaje;
	}

	public boolean editarApostador(String pCedula, String nombre, String sede, String direccion, String celular,
			ArrayList<ApostadorDTO> listaA, File file) throws IOException {
		boolean verificar = false;
		for (int i = 0; i < listaA.size(); i++) {
			if (listaA.get(i).getCedula().equals(pCedula)) {
				listaA.get(i).setNombre(nombre);
				listaA.get(i).setSede(sede);
				listaA.get(i).setDireccion(direccion);
				listaA.get(i).setCelular(celular);
				file.delete();
				file.createNewFile();
				archivo.escribirArchivo(listaA, file);
				verificar = true;
			} else {
				verificar = false;
			}
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
}