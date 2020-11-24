/**
 * Paquete persistencia
 */
package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Clase ArchivoApuesta
 */
public class ArchivoApuesta {

	private File fileBaloto;
	private File fileSuperastro;
	private File fileMarcador;
	private final String RUTA_BALOTO = "Data\\apuestas-baloto.dat";
	private final String RUTA_SUPERASTRO = "Data\\apuestas-superastro.dat";
	private final String RUTA_MARCADORES = "Data\\apuestas-marcadores.dat";

	/**
	 * es la entrada de los datos
	 */
	private ObjectInputStream entrada;
	/**
	 * es la salida de los datos
	 */
	private ObjectOutputStream salida;

	/**
	 * constructor vacio
	 */
	public ArchivoApuesta() {

	}

	/**
	 * se encarga de escribir en el archivo la informacion que recibe de la lista de
	 * apuestas de baloto. <b>pre</b> Que exista la lista de apuestas de baloto y el
	 * archivo<br>
	 * <b>post</b>Se agrega correctamente la apuesta al archivo<br>
	 * 
	 * @param balotoDTO, es la lista de apuestas de baloto de donde se tomará la
	 *                   información para escribirla en el archivo; balotoDTO !=
	 *                   null.
	 */
	public void escribirArchivoBaloto(ArrayList<BalotoDTO> balotoDTO) {
		if (!fileBaloto.exists()) {
			try {
				fileBaloto.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			fileBaloto.delete();
			System.out.println(fileBaloto);
			salida = new ObjectOutputStream(new FileOutputStream(fileBaloto));
			salida.writeObject(balotoDTO);
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Este metodo se encarga de leer la lista de apuestas de baloto del archivo.
	 * <b>pre</b> Que exista el archivo<br>
	 * <b>Devuelve la lista de apuestas de baloto del archivo</b><br>
	 * 
	 * @param file, es el archivo en donde sen encuentran los apostadores; file !=
	 *              null.
	 * @return retorna la lista de apuestas de baloto del archivo.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<BalotoDTO> leerArchivoBaloto(File file) {
		ArrayList<BalotoDTO> balotoDTO = new ArrayList<BalotoDTO>();
		if (file.length() != 0) {
			try {
				entrada = new ObjectInputStream(new FileInputStream(file));
				balotoDTO = (ArrayList<BalotoDTO>) entrada.readObject();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return balotoDTO;
	}

	/**
	 * Se encarga de escribir en el archivo la informacion que recibe de la lista de
	 * apuestas de superastro. <b>pre</b> Que exista la lista de apuestas de
	 * superastro y el archivo<br>
	 * <b>post</b>Se agrega correctamente la apuesta de superastro al archivo<br>
	 * 
	 * @param superastroDTO, es la lista de apuestas de superastro de donde se
	 *                       tomará la información para escribirla en el archivo;
	 *                       superastroDTO != null.
	 */
	public void escribirArchivoSuperastro(ArrayList<SuperastroDTO> superastroDTO) {
		if (!fileSuperastro.exists()) {
			try {
				fileSuperastro.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			fileSuperastro.delete();
			System.out.println(fileSuperastro);
			salida = new ObjectOutputStream(new FileOutputStream(fileSuperastro));
			salida.writeObject(superastroDTO);
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Este metodo se encarga de leer la lista de apuestas de superastro del
	 * archivo. <b>pre</b> Que exista el archivo<br>
	 * <b>Devuelve la lista de apuestas de superastro del archivo</b><br>
	 * 
	 * @param file, es el archivo en donde sen encuentran las apuestas de
	 *              superastro; file != null.
	 * @return retorna la lista de apuestas de superastro del archivo.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<SuperastroDTO> leerArchivoSuperastro(File file) {
		ArrayList<SuperastroDTO> superastroDTO = new ArrayList<SuperastroDTO>();
		if (file.length() != 0) {
			try {
				entrada = new ObjectInputStream(new FileInputStream(file));
				superastroDTO = (ArrayList<SuperastroDTO>) entrada.readObject();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return superastroDTO;
	}

	/**
	 * Se encarga de escribir en el archivo la informacion que recibe de la lista de
	 * apuestas de marcadores. <b>pre</b> Que exista la lista de apuestas de
	 * marcadores y el archivo<br>
	 * <b>post</b>Se agrega correctamente la apuesta de marcadores al archivo<br>
	 * 
	 * @param marcadoresDTO, es la lista de apuestas de marcadores de donde se
	 *                       tomará la información para escribirla en el archivo;
	 *                       marcadoresDTO != null.
	 */
	public void escribirArchivoMarcadores(ArrayList<MarcadoresDTO> marcadoresDTO) {
		if (!fileMarcador.exists()) {
			try {
				fileMarcador.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			fileMarcador.delete();
			System.out.println(fileMarcador);
			salida = new ObjectOutputStream(new FileOutputStream(fileMarcador));
			salida.writeObject(marcadoresDTO);
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Este metodo se encarga de leer la lista de apuestas de marcadores del
	 * archivo. <b>pre</b> Que exista el archivo<br>
	 * <b>Devuelve la lista de apuestas de marcadores del archivo</b><br>
	 * 
	 * @param file, es el archivo en donde sen encuentran las apuestas de
	 *              marcadores; file != null.
	 * @return retorna la lista de apuestas de marcadores del archivo.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<MarcadoresDTO> leerArchivoMarcadores(File file) {
		ArrayList<MarcadoresDTO> marcadoresDTO = new ArrayList<MarcadoresDTO>();
		if (file.length() != 0) {
			try {
				entrada = new ObjectInputStream(new FileInputStream(file));
				marcadoresDTO = (ArrayList<MarcadoresDTO>) entrada.readObject();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return marcadoresDTO;
	}

	/**
	 * Este metodo se encarga de asignar la ruta del archivo e inicializar
	 * fileBaloto
	 * 
	 * @param ruta, es la ruta del archivo; ruta != null.
	 */
	public void asignarRutaArchivoBaloto(String ruta) {
		fileBaloto = new File(ruta);
	}

	/**
	 * Este metodo se encarga de asignar la ruta del archivo e inicializar
	 * fileSuperastro
	 * 
	 * @param ruta, es la ruta del archivo; ruta != null.
	 */
	public void asignarRutaArchivoSupeastro(String ruta) {
		fileSuperastro = new File(ruta);
	}

	/**
	 * Este metodo se encarga de asignar la ruta del archivo e inicializar
	 * fileMarcador
	 * 
	 * @param ruta, es la ruta del archivo; ruta != null.
	 */

	public void asignarRutaArchivoMarcador(String ruta) {
		fileMarcador = new File(ruta);
	}

	/**
	 * @return the fileBaloto
	 */
	public File getFileBaloto() {
		return fileBaloto;
	}

	/**
	 * @param fileBaloto the fileBaloto to set
	 */
	public void setFileBaloto(File fileBaloto) {
		this.fileBaloto = fileBaloto;
	}

	/**
	 * @return the fileSuperastro
	 */
	public File getFileSuperastro() {
		return fileSuperastro;
	}

	/**
	 * @param fileSuperastro the fileSuperastro to set
	 */
	public void setFileSuperastro(File fileSuperastro) {
		this.fileSuperastro = fileSuperastro;
	}

	/**
	 * @return the fileMarcador
	 */
	public File getFileMarcador() {
		return fileMarcador;
	}

	/**
	 * @param fileMarcador the fileMarcador to set
	 */
	public void setFileMarcador(File fileMarcador) {
		this.fileMarcador = fileMarcador;
	}

	/**
	 * @return the rUTA_BALOTO
	 */
	public String getRUTA_BALOTO() {
		return RUTA_BALOTO;
	}

	/**
	 * @return the rUTA_SUPERASTRO
	 */
	public String getRUTA_SUPERASTRO() {
		return RUTA_SUPERASTRO;
	}

	/**
	 * @return the rUTA_MARCADORES
	 */
	public String getRUTA_MARCADORES() {
		return RUTA_MARCADORES;
	}

}