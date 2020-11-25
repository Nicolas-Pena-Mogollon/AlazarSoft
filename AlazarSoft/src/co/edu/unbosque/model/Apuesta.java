/**
 * Paquete modelo
 */
package co.edu.unbosque.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import co.edu.unbosque.model.persistence.BalotoDAO;
import co.edu.unbosque.model.persistence.MarcadoresDAO;
import co.edu.unbosque.model.persistence.SuperastroDAO;

/**
 * Clase Apuesta
 */
public class Apuesta {

	/**
	 * Asociación clase BalotoDAO
	 */
	private BalotoDAO balotoDAO;
	/**
	 * Asociación clase SuperastroDAO
	 */
	private SuperastroDAO superastroDAO;
	/**
	 * Asociación clase MarcadoresDAO
	 */
	private MarcadoresDAO marcadoresDAO;

	/**
	 * Constructor Vacio
	 */

	public Apuesta() {
		balotoDAO = new BalotoDAO();
		superastroDAO = new SuperastroDAO();
		marcadoresDAO = new MarcadoresDAO();
	}

	/**
	 * Este método se encarga de identificar el tipo de apuesta a borrar para luego
	 * borrarlo
	 * 
	 * @param tipoApuesta, es el tipo de apuesta
	 * @param fecha,       es la fecha en la que se realizó la apuesta
	 * @param cedula,      es el número que identifica al apostador y las apuestas
	 *                     de este
	 * @return retorna true si se puedo realizar el borrado de la apuesta
	 * @throws ParseException
	 */
	public boolean borrarApuesta(String tipoApuesta, String fecha, String cedula) throws ParseException {
		SimpleDateFormat dateF = new SimpleDateFormat("hh: mm: ss a dd/MM/yyyy");
		boolean salida = false;
		if (tipoApuesta.equals("Super Astro")) {
			if (superastroDAO.eliminarApuesta(cedula, dateF.parse(fecha))) {
				salida = true;
			} else {
				salida = false;
			}
		} else if (tipoApuesta.equals("Baloto")) {
			if (balotoDAO.eliminarApuesta(cedula, dateF.parse(fecha))) {
				salida = true;
			} else {
				salida = false;
			}
		} else if (tipoApuesta.equals("Fútbol")) {
			if (marcadoresDAO.eliminarApuesta(cedula, dateF.parse(fecha))) {
				salida = true;
			} else {
				salida = false;
			}
		} else {
			salida = false;
		}
		return salida;
	}

	/**
	 * Cuenta la cantidad de registros para una misma sede y tipo de apuesta.
	 * <b>pre</b> que hayan apuestas registradas </br>
	 * 
	 * @param tipoApuesta
	 * @param sede
	 * @return cont Retorna la cantidad de apuestas para una misma sede y tipo de
	 *         apuesta
	 */
	private int contarDatosTipoApuestaYSede(String tipoApuesta, String sede) {
		int cont = 0;
		if (tipoApuesta.equals("Super Astro")) {
			for (int i = 0; i < superastroDAO.getListaSuperastro().size(); i++)
				if (sede.equals(superastroDAO.getListaSuperastro().get(i).getNombreSede()))
					cont++;
		} else if (tipoApuesta.equals("Baloto")) {
			for (int i = 0; i < balotoDAO.getListaBaloto().size(); i++) {
				if (sede.equals(balotoDAO.getListaBaloto().get(i).getNombreSede())) {
					cont++;
				}
			}
		} else if (tipoApuesta.equals("Fútbol")) {
			for (int i = 0; i < marcadoresDAO.getListaMarcadores().size(); i++)
				if (sede.equals(marcadoresDAO.getListaMarcadores().get(i).getNombreSede()))
					cont++;
		}
		return cont;
	}

	/**
	 * Genera un arreglo bidimensional con las apuestas realizadas de un mismo tipo
	 * y una misma sede
	 * 
	 * @param tipoApuesta
	 * @param sede
	 * @return salida Retorna el arreglo bidimensional con los tipos de datos que
	 *         solicita
	 */

	public String[][] generarTablaApuestas(String tipoApuesta, String sede) {
		String[][] salida = new String[this.contarDatosTipoApuestaYSede(tipoApuesta, sede)][4];
		SimpleDateFormat dateF = new SimpleDateFormat("hh: mm: ss a dd/MM/yyyy");
		int cont = 0;
		if (tipoApuesta.equals("Super Astro")) {
			for (int i = 0; i < superastroDAO.getListaSuperastro().size(); i++) {
				if (sede.equals(superastroDAO.getListaSuperastro().get(i).getNombreSede())) {
					salida[cont][0] = dateF.format(superastroDAO.getListaSuperastro().get(i).getFecha());
					salida[cont][1] = superastroDAO.getListaSuperastro().get(i).getCedula();
					salida[cont][2] = superastroDAO.getListaSuperastro().get(i).getNumeroJuego() + "-"
							+ superastroDAO.getListaSuperastro().get(i).getSigno();
					salida[cont][3] = String.valueOf(superastroDAO.getListaSuperastro().get(i).getValorApuesta());
					cont++;
				}
			}
		} else if (tipoApuesta.equals("Baloto")) {
			for (int i = 0; i < balotoDAO.getListaBaloto().size(); i++) {
				if (sede.equals(balotoDAO.getListaBaloto().get(i).getNombreSede())) {
					salida[cont][0] = dateF.format(balotoDAO.getListaBaloto().get(i).getFecha());
					salida[cont][1] = balotoDAO.getListaBaloto().get(i).getCedula();
					salida[cont][2] = balotoDAO.getListaBaloto().get(i).getNumeroJuego();
					salida[cont][3] = String.valueOf(balotoDAO.getListaBaloto().get(i).getValorApuesta());
					cont++;
				}
			}
		} else if (tipoApuesta.equals("Fútbol")) {
			for (int i = 0; i < marcadoresDAO.getListaMarcadores().size(); i++) {
				if (sede.equals(marcadoresDAO.getListaMarcadores().get(i).getNombreSede())) {
					salida[cont][0] = dateF.format(marcadoresDAO.getListaMarcadores().get(i).getFecha());
					salida[cont][1] = marcadoresDAO.getListaMarcadores().get(i).getCedula();
					salida[cont][2] = marcadoresDAO.getListaMarcadores().get(i).getPartido() + "-"
							+ marcadoresDAO.getListaMarcadores().get(i).getResultado();
					salida[cont][3] = String.valueOf(marcadoresDAO.getListaMarcadores().get(i).getValorApuesta());
					cont++;
				}
			}
		}
		return salida;
	}

	/**
	 * Este método verifica que los número de juego de baloto se encuentren en un
	 * rango de 1 - 45.
	 * 
	 * @param primerNumero,  es el primer número; primerNumero != null.
	 * @param segundoNumero, es el segundo número; segundoNumero != null.
	 * @param tercerNumero,  es el tercer número; tercerNumero != null.
	 * @param cuartoNumero,  es el cuarto número; cuartoNumero!= null.
	 * @param quintoNumero,  es el quinto número; quintoNumero != null.
	 * @param sextoNumero,   es el sexto número; sextoNumero != null.
	 * @return retorna true si algún número no se encuentra dentro del rango,
	 *         retorna false si todos los números se encuentran dentro del rango.
	 */
	public boolean verificarRangoNumerosBaloto(int primerNumero, int segundoNumero, int tercerNumero, int cuartoNumero,
			int quintoNumero, int sextoNumero) {
		boolean verificar = false;
		if ((primerNumero < 1 || primerNumero > 45) || (segundoNumero < 1 || segundoNumero > 45)
				|| (tercerNumero < 1 || tercerNumero > 45) || (cuartoNumero < 1 || cuartoNumero > 45)
				|| (quintoNumero < 1 || quintoNumero > 45) || (sextoNumero < 1 || sextoNumero > 45)) {
			verificar = true;
		} else {
			verificar = false;
		}
		return verificar;

	}

	/**
	 * Este método se encarga de verificar que los números de juego de baloto no se
	 * repitan.
	 * 
	 * @param primerNumero,  es el primer número; primerNumero != null.
	 * @param segundoNumero, es el segundo número; segundoNumero != null.
	 * @param tercerNumero,  es el tercer número; tercerNumero != null.
	 * @param cuartoNumero,  es el cuarto número; cuartoNumero!= null.
	 * @param quintoNumero,  es el quinto número; quintoNumero != null.
	 * @param sextoNumero,   es el sexto número; sextoNumero != null.
	 * @return retorna true si algún número se encuentra repetido, retorna false si
	 *         ningún número está repetido.
	 */
	public boolean verificarNumerosIgualesBaloto(int primerNumero, int segundoNumero, int tercerNumero,
			int cuartoNumero, int quintoNumero, int sextoNumero) {
		boolean verificar = false;
		if ((primerNumero == segundoNumero) || (primerNumero == tercerNumero) || (primerNumero == cuartoNumero)
				|| (primerNumero == quintoNumero) || (primerNumero == sextoNumero) || (segundoNumero == tercerNumero)
				|| (segundoNumero == cuartoNumero) || (segundoNumero == quintoNumero) || (segundoNumero == sextoNumero)
				|| (tercerNumero == cuartoNumero) || (tercerNumero == quintoNumero) || (tercerNumero == sextoNumero)
				|| (cuartoNumero == quintoNumero) || (cuartoNumero == sextoNumero) || (quintoNumero == sextoNumero)) {
			verificar = true;

		} else {
			verificar = false;
		}
		return verificar;
	}

	/**
	 * Este método se encaga de verificar que los números de juego de Superastro se
	 * encuentren en un rango de 0 -9.
	 * 
	 * @param primerNumero,  es el primer número; primerNumero != null.
	 * @param segundoNumero, es el segundo número; segundoNumero != null.
	 * @param tercerNumero,  es el tercer número; tercerNumero != null.
	 * @param cuartoNumero,  es el cuarto número; cuartoNumero!= null.
	 * @return retorna true si algún número no se encuentra dentro del rango
	 *         indicado, retorna false si todos los números se encuentran dentro del
	 *         rango indicado.
	 */

	public boolean verificarRangoNumerosSuperastro(int primerNumero, int segundoNumero, int tercerNumero,
			int cuartoNumero) {
		boolean verificar = false;
		if ((primerNumero < 0 || primerNumero > 9) || (segundoNumero < 0 || segundoNumero > 9)
				|| (tercerNumero < 0 || tercerNumero > 9) || (cuartoNumero < 0 || cuartoNumero > 9)) {
			verificar = true;
		} else {
			verificar = false;
		}
		return verificar;
	}

	/**
	 * Método recursivo quicksort.
	 * 
	 * @param numeros, es la matriz de datos a organizar.
	 * @return retorna la matriz ordenada por fecha.
	 * @throws ParseException puede producir un error.
	 */
	public String[][] quicksortRecursivo(String[][] numeros) throws ParseException {
		return quicksort2(numeros, 0, numeros.length - 1);
	}

	/**
	 * Este método se encarga de organizar la matriz por fecha.
	 * 
	 * @param numeros, es la matriz a organizar. numeros != null.
	 * @param izq,     es la primera posición a comparar.
	 * @param der,     es la última posición a comparar dependiendo del pivote.
	 * @return retorna la matriz ordenada por fecha.
	 * @throws ParseException
	 */
	private String[][] quicksort2(String[][] numeros, int izq, int der) throws ParseException {
		SimpleDateFormat simpleDate = new SimpleDateFormat("hh: mm: ss a dd/MM/yyyy");
		if (izq >= der) {
			return numeros;
		}
		int i = izq, d = der;
		if (izq != der) {
			int pivote;

			String[] aux = null;
			pivote = izq;
			while (izq != der) {
				while ((simpleDate.parse(numeros[der][0]).before(simpleDate.parse(numeros[pivote][0]))
						|| simpleDate.parse(numeros[der][0]) == simpleDate.parse(numeros[pivote][0])) && izq < der) {
					der--;

				}
				while (simpleDate.parse(numeros[izq][0]).after(simpleDate.parse(numeros[pivote][0])) && izq < der) {
					izq++;
				}
				if (der != izq) {
					aux = numeros[der];

					numeros[der] = numeros[izq];
					numeros[izq] = aux;
				}
			}
			if (izq == der) {
				quicksort2(numeros, i, izq - 1);
				quicksort2(numeros, izq + 1, d);
			}
		} else {
			return numeros;
		}
		return numeros;
	}

	/**
	 * Obtiene los datos de los juegos registrados los ultimos cinco dias y hace la
	 * sumatoria de los valores si son de la misma fecha y del mismo tipo de juego
	 * 
	 * @return salida Retorna una matriz que contiene los datos de los valores
	 *         totales por juego de los ultimos cinco dias
	 */

	@SuppressWarnings("deprecation")
	public String[][] obtenerInformacionHistoricoVentas() {
		String[][] matrizDatos = new String[this.contarRegistrosUltimosCincoDias()][3];
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		int cont = 0;
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j < this.balotoDAO.getListaBaloto().size(); j++) {
				Date fecha = new Date(date.getTime() + TimeUnit.DAYS.toMillis(-i));
				if (fecha.getYear() == this.balotoDAO.getListaBaloto().get(j).getFecha().getYear()
						&& fecha.getMonth() == this.balotoDAO.getListaBaloto().get(j).getFecha().getMonth()
						&& fecha.getDay() == this.balotoDAO.getListaBaloto().get(j).getFecha().getDay()) {
					matrizDatos[cont][0] = String.valueOf(this.balotoDAO.getListaBaloto().get(j).getValorApuesta());
					matrizDatos[cont][1] = sdf.format(fecha);
					matrizDatos[cont][2] = this.balotoDAO.getListaBaloto().get(j).getNombreSede();
					cont++;
				}
			}
		}
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j < superastroDAO.getListaSuperastro().size(); j++) {
				Date fecha = new Date(date.getTime() + TimeUnit.DAYS.toMillis(-i));
				if (fecha.getYear() == superastroDAO.getListaSuperastro().get(j).getFecha().getYear()
						&& fecha.getMonth() == superastroDAO.getListaSuperastro().get(j).getFecha().getMonth()
						&& fecha.getDay() == superastroDAO.getListaSuperastro().get(j).getFecha().getDay()) {
					matrizDatos[cont][0] = String.valueOf(superastroDAO.getListaSuperastro().get(j).getValorApuesta());
					matrizDatos[cont][1] = sdf.format(fecha);
					matrizDatos[cont][2] = superastroDAO.getListaSuperastro().get(j).getNombreSede();
					cont++;
				}
			}
		}
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j < marcadoresDAO.getListaMarcadores().size(); j++) {
				Date fecha = new Date(date.getTime() + TimeUnit.DAYS.toMillis(-i));
				if (fecha.getYear() == marcadoresDAO.getListaMarcadores().get(j).getFecha().getYear()
						&& fecha.getMonth() == marcadoresDAO.getListaMarcadores().get(j).getFecha().getMonth()
						&& fecha.getDay() == marcadoresDAO.getListaMarcadores().get(j).getFecha().getDay()) {
					matrizDatos[cont][0] = String.valueOf(marcadoresDAO.getListaMarcadores().get(j).getValorApuesta());
					matrizDatos[cont][1] = sdf.format(fecha);
					matrizDatos[cont][2] = marcadoresDAO.getListaMarcadores().get(j).getNombreSede();
					cont++;
				}
			}
		}

		cont = 0;
		String[][] salida = new String[matrizDatos.length][3];
		for (int i = 0; i < salida.length; i++) {
			double valor = 0;
			cont = 0;
			if (!matrizDatos[i][1].equals("")) {
				salida[i][1] = matrizDatos[i][1];
				salida[i][2] = matrizDatos[i][2];
				for (int j = 0; j < salida.length; j++) {
					if (matrizDatos[i][1].equals(matrizDatos[j][1]) && matrizDatos[i][2].equals(matrizDatos[j][2])) {
						valor += Double.parseDouble(matrizDatos[j][0]);
						if (cont == 0) {
							salida[i][0] = String.valueOf(valor);
							cont++;
						} else {
							matrizDatos[j][1] = "";
							matrizDatos[j][2] = "";
							salida[i][0] = String.valueOf(valor);
						}
					}
				}
			}
		}

		return salida;
	}

	/**
	 * Cuenta la cantidad de registros de juegos durante los ultimos cinco dias
	 * 
	 * @return
	 */

	@SuppressWarnings("deprecation")
	private int contarRegistrosUltimosCincoDias() {
		Date date = new Date();
		int cont = 0;
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j < this.balotoDAO.getListaBaloto().size(); j++) {
				Date fecha = new Date(date.getTime() + TimeUnit.DAYS.toMillis(-i));
				if (fecha.getYear() == this.balotoDAO.getListaBaloto().get(j).getFecha().getYear()
						&& fecha.getMonth() == this.balotoDAO.getListaBaloto().get(j).getFecha().getMonth()
						&& fecha.getDay() == this.balotoDAO.getListaBaloto().get(j).getFecha().getDay()) {
					cont++;
				}
			}
		}

		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j < superastroDAO.getListaSuperastro().size(); j++) {
				Date fecha = new Date(date.getTime() + TimeUnit.DAYS.toMillis(-i));
				if (fecha.getYear() == superastroDAO.getListaSuperastro().get(j).getFecha().getYear()
						&& fecha.getMonth() == superastroDAO.getListaSuperastro().get(j).getFecha().getMonth()
						&& fecha.getDay() == superastroDAO.getListaSuperastro().get(j).getFecha().getDay()) {
					cont++;
				}
			}
		}
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j < marcadoresDAO.getListaMarcadores().size(); j++) {
				Date fecha = new Date(date.getTime() + TimeUnit.DAYS.toMillis(-i));
				if (fecha.getYear() == marcadoresDAO.getListaMarcadores().get(j).getFecha().getYear()
						&& fecha.getMonth() == marcadoresDAO.getListaMarcadores().get(j).getFecha().getMonth()
						&& fecha.getDay() == marcadoresDAO.getListaMarcadores().get(j).getFecha().getDay()) {
					cont++;
				}
			}
		}
		return cont;
	}

	public int[] numerosBaloto() {
		int[] resultado = new int[45];
		int[] numeroJuego = new int[6];
		for (int i = 0; i < 45; i++) {
			int rnd = (int) Math.floor(Math.random() * (45 - 1 + 1) + 1);
			resultado[i] = rnd;
		}
		for (int i1 = 0; i1 < 45; i1++) {
			for (int i2 = 0; i2 < 45; i2++) {
				if (resultado[i1] == resultado[i2] && i1 != i2) {
					int rnd = (int) Math.floor(Math.random() * (45 - 1 + 1) + 1);
					resultado[i1] = rnd;
					i1 = 0;
				}
			}
		}
		for (int i = 0; i < numeroJuego.length; i++) {
			numeroJuego[i] = resultado[i];
		}
		return numeroJuego;
	}

	public int[] numerosZodiaco() {
		int[] resultado = new int[9];
		int[] numeroJuego = new int[4];
		for (int i = 0; i < 9; i++) {
			int rnd = (int) Math.floor(Math.random() * (9 - 0 + 1) + 0);
			resultado[i] = rnd;
		}
		for (int i = 0; i < numeroJuego.length; i++) {
			numeroJuego[i] = resultado[i];
		}
		return numeroJuego;
	}

	public String[] signo() {
		String[] signo = new String[12];
		String[] elegido = new String[1];
		int rnd = (int) Math.floor(Math.random() * (11 - 0 + 1) + 0);
		signo[0] = "Aries";
		signo[1] = "Tauro";
		signo[2] = "Geminis";
		signo[3] = "Cancer";
		signo[4] = "Leo";
		signo[5] = "Virgo";
		signo[6] = "Libra";
		signo[7] = "Escorpio";
		signo[8] = "Sagitario";
		signo[9] = "Capricornio";
		signo[10] = "Acuario";
		signo[11] = "Piscis";
		elegido[0] = signo[rnd];
		return elegido;
	}

	public String numeroGanadorSuperastro(int[] numeros, String[] signo) {
		String numeroJuego = "";
		int uno = numeros[0];
		int dos = numeros[1];
		int tres = numeros[2];
		int cuatro = numeros[3];
		String zodiaco = signo[0];
		numeroJuego = uno + "-" + dos + "-" + tres + "-" + cuatro + "-" + zodiaco;
		return numeroJuego;
	}

	public String numeroGanadorBaloto(int[] numeros) {
		String numeroJuego = "";
		int uno = numeros[0];
		int dos = numeros[1];
		int tres = numeros[2];
		int cuatro = numeros[3];
		int cinco = numeros[4];
		int seis = numeros[5];
		numeroJuego = uno + "-" + dos + "-" + tres + "-" + cuatro + "-" + cinco + "-" + seis;
		return numeroJuego;
	}

	public boolean partidoGanador(String[] partido, String resulado) {
		boolean verificar = false;
		String data = "";
		for (int i = 0; i < partido.length; i++) {
			data = partido[i] + "-" + resulado;
		}
		for (int i = 0; i < this.marcadoresDAO.getListaMarcadores().size(); i++) {
			if (data.equals(this.marcadoresDAO.getListaMarcadores().get(i).getPartido() + "-"
					+ this.marcadoresDAO.getListaMarcadores().get(i).getPartido())) {
				verificar = true;
			} else {
				verificar = false;
			}
		}
		return verificar;
	}

	public boolean ganadorApuestaBaloto(String numero) {
		boolean verificar = false;
		String[] parts = this.numeroGanadorBaloto(this.numerosBaloto()).split("-");
		String[] parts2 = numero.split("-");

		if (parts[0].equals(parts2[0]) || parts[1].equals(parts2[1]) || parts[2].equals(parts2[2])
				|| parts[3].equals(parts2[3]) || parts[4].equals(parts2[4]) || parts[5].equals(parts2[5])) {
			verificar = true;
		}
		return verificar;
	}

	public boolean ganadorApuestaSuperastro(String numero) {
		boolean verificar = false;
		String apuesta = this.numeroGanadorSuperastro(this.numerosZodiaco(), this.signo());
		String[] parts = apuesta.split("-");
		String[] parts2 = numero.split("-");

		if ((parts[0].equals(parts2[0]) && parts[4].equals(parts2[4]))
				|| (parts[1].equals(parts2[1]) && parts[4].equals(parts2[4]))
				|| (parts[2].equals(parts2[2]) && parts[4].equals(parts2[4]))
				|| (parts[3].equals(parts2[3]) && parts[4].equals(parts2[4]))) {
			verificar = true;

		}
		return verificar;
	}

	/**
	 * @return the balotoDAO
	 */
	public BalotoDAO getBalotoDAO() {
		return balotoDAO;
	}

	/**
	 * @param balotoDAO the balotoDAO to set
	 */
	public void setBalotoDAO(BalotoDAO balotoDAO) {
		this.balotoDAO = balotoDAO;
	}

	/**
	 * @return the superastroDAO
	 */
	public SuperastroDAO getSuperastroDAO() {
		return superastroDAO;
	}

	/**
	 * @param superastroDAO the superastroDAO to set
	 */
	public void setSuperastroDAO(SuperastroDAO superastroDAO) {
		this.superastroDAO = superastroDAO;

	}

	/**
	 * @return the marcadoresDAO
	 */
	public MarcadoresDAO getMarcadoresDAO() {
		return marcadoresDAO;
	}

	/**
	 * @param marcadoresDAO the marcadoresDAO to set
	 */
	public void setMarcadoresDAO(MarcadoresDAO marcadoresDAO) {
		this.marcadoresDAO = marcadoresDAO;
	}

}
