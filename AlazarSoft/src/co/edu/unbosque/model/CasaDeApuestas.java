/**
 * Paquete modelo
 */
package co.edu.unbosque.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import co.edu.unbosque.model.persistence.ArchivoConfiguracionCasaApuestas;
import co.edu.unbosque.model.persistence.ArchivoExcel;
import co.edu.unbosque.model.persistence.ArchivoPDF;
import co.edu.unbosque.model.persistence.LecturaTxt;

/**
 * Clase CasaDeApuestas
 */
public class CasaDeApuestas {

	private Apostador apostadores;
	private Sede sede;
	private Apuesta apuestas;
	private String nombreCasaApuestas;
	private int numeroSedes;
	private double presupuestoTotal;
	private ArchivoConfiguracionCasaApuestas archivoConfiguracionCasaApuestas;
	private ArchivoPDF archivoPDF;
	private ArchivoExcel archivoExcel;
	private Juego juego;
	private LecturaTxt planesPremiacion;

	/**
	 * Constructor vacio
	 */
	public CasaDeApuestas() {
		this.archivoConfiguracionCasaApuestas = new ArchivoConfiguracionCasaApuestas();
		this.apostadores = new Apostador();
		this.apuestas = new Apuesta();
		this.sede = new Sede();
		this.archivoPDF = new ArchivoPDF();
		this.archivoExcel = new ArchivoExcel();
		this.juego = new Juego();
		this.planesPremiacion = new LecturaTxt();
		this.leerConfiguracion();
	}

	/**
	 * Este método se encarga de leer las cofiguraciones de la casa de apuestas.
	 */

	public void leerConfiguracion() {
		String[] datos = this.archivoConfiguracionCasaApuestas.leerConfiguracionCasaApuestas();
		if (datos[0] != null) {
			this.nombreCasaApuestas = datos[0];
			this.numeroSedes = Integer.parseInt(datos[1]);
			this.presupuestoTotal = Double.parseDouble(datos[2]);
		} else {
			this.nombreCasaApuestas = null;
			this.numeroSedes = 0;
			this.presupuestoTotal = 0;
		}
	}

	/**
	 * Este metodo se encarga de editar la configuración de la clase de apuestas.
	 * 
	 * @param nombre,           es el nombre de la sede; nombre != null.
	 * @param numeroSedes,      es el numero de sedes; numeroSedes != null.
	 * @param presupuestoTotal, es el presupuesto total de la casa de apuestas;
	 *                          presupuestoTotal != null.
	 * 
	 */
	public void guardarConfiguracionCasaDeApuestas(String nombre, int numeroSedes, double presupuestoTotal) {

		if (!nombre.equals("")) {
			this.nombreCasaApuestas = nombre;
		}
		if (numeroSedes != -1) {
			this.numeroSedes = numeroSedes;
		}
		if (presupuestoTotal != -1) {
			this.presupuestoTotal = presupuestoTotal;
		}
		String[] datos = { this.nombreCasaApuestas, String.valueOf(this.numeroSedes),
				String.valueOf(this.presupuestoTotal) };
		archivoConfiguracionCasaApuestas.escribirConfiguracionCasaApuestas(datos);
	}

	/**
	 * Este método se encarag de generar datos sobre los reportes y guardaelos en
	 * una matriz.
	 * 
	 * @param tipoReporte, es el tipo de reporte a exportar; tipoReporte != null.
	 * @param fecha,       es la fecha por la cual se va a flitrar. fecha != null.
	 * @param tipoFiltro,  es el formato por la cual se va visualizar al momento de
	 *                     exportarlo.
	 * @return retorna una matriz con todos los datos generados.
	 * @throws ParseException Se puede presentar una excepción.
	 */
	@SuppressWarnings("deprecation")
	public String[][] generarDatosReportes(String tipoReporte, String fecha, String tipoFiltro) throws ParseException {
		String[][] matrizMadre = new String[apuestas.getBalotoDAO().getListaBaloto().size()
				+ apuestas.getSuperastroDAO().getListaSuperastro().size()
				+ apuestas.getMarcadoresDAO().getListaMarcadores().size()][6];
		SimpleDateFormat dateUno = new SimpleDateFormat("hh: mm: ss a dd/MM/yyyy");
		int cont = 0;
		for (int i = 0; i < apuestas.getBalotoDAO().getListaBaloto().size(); i++) {
			if (tipoFiltro.equals("día, mes y año")) {
				if (dateUno.parse(fecha)
						.getDay() == (apuestas.getBalotoDAO().getListaBaloto().get(i).getFecha().getDay())
						&& dateUno.parse(fecha)
								.getMonth() == (apuestas.getBalotoDAO().getListaBaloto().get(i).getFecha().getMonth())
						&& dateUno.parse(fecha)
								.getYear() == (apuestas.getBalotoDAO().getListaBaloto().get(i).getFecha().getYear())) {
					matrizMadre[cont][0] = dateUno.format(apuestas.getBalotoDAO().getListaBaloto().get(i).getFecha());
					matrizMadre[cont][1] = apuestas.getBalotoDAO().getListaBaloto().get(i).getNombreSede();
					matrizMadre[cont][2] = apuestas.getBalotoDAO().getListaBaloto().get(i).getCedula();
					matrizMadre[cont][3] = buscarNombreApostador(
							apuestas.getBalotoDAO().getListaBaloto().get(i).getCedula());// Nombre
					matrizMadre[cont][4] = "Baloto";
					matrizMadre[cont][5] = String
							.valueOf(apuestas.getBalotoDAO().getListaBaloto().get(i).getValorApuesta());
					cont++;
				}
			} else if (tipoFiltro.equals("mes y año")) {
				if (dateUno.parse(fecha)
						.getMonth() == (apuestas.getBalotoDAO().getListaBaloto().get(i).getFecha().getMonth())
						&& dateUno.parse(fecha)
								.getYear() == (apuestas.getBalotoDAO().getListaBaloto().get(i).getFecha().getYear())) {
					matrizMadre[cont][0] = dateUno.format(apuestas.getBalotoDAO().getListaBaloto().get(i).getFecha());
					matrizMadre[cont][1] = apuestas.getBalotoDAO().getListaBaloto().get(i).getNombreSede();
					matrizMadre[cont][2] = apuestas.getBalotoDAO().getListaBaloto().get(i).getCedula();
					matrizMadre[cont][3] = buscarNombreApostador(
							apuestas.getBalotoDAO().getListaBaloto().get(i).getCedula());
					matrizMadre[cont][4] = "Baloto";
					matrizMadre[cont][5] = String
							.valueOf(apuestas.getBalotoDAO().getListaBaloto().get(i).getValorApuesta());
					cont++;
				}
			} else if (tipoFiltro.equals("año")) {
				if (dateUno.parse(fecha)
						.getYear() == (apuestas.getBalotoDAO().getListaBaloto().get(i).getFecha().getYear())) {
					matrizMadre[cont][0] = dateUno.format(apuestas.getBalotoDAO().getListaBaloto().get(i).getFecha());
					matrizMadre[cont][1] = apuestas.getBalotoDAO().getListaBaloto().get(i).getNombreSede();
					matrizMadre[cont][2] = apuestas.getBalotoDAO().getListaBaloto().get(i).getCedula();
					matrizMadre[cont][3] = buscarNombreApostador(
							apuestas.getBalotoDAO().getListaBaloto().get(i).getCedula());
					matrizMadre[cont][4] = "Baloto";
					matrizMadre[cont][5] = String
							.valueOf(apuestas.getBalotoDAO().getListaBaloto().get(i).getValorApuesta());
					cont++;
				}
			}
		}
		for (int i = 0; i < apuestas.getSuperastroDAO().getListaSuperastro().size(); i++) {
			if (tipoFiltro.equals("día, mes y año")) {
				if (dateUno.parse(fecha)
						.getDay() == (apuestas.getSuperastroDAO().getListaSuperastro().get(i).getFecha().getDay())
						&& dateUno.parse(fecha)
								.getMonth() == (apuestas.getSuperastroDAO().getListaSuperastro().get(i).getFecha()
										.getMonth())
						&& dateUno.parse(fecha).getYear() == (apuestas.getSuperastroDAO().getListaSuperastro().get(i)
								.getFecha().getYear())) {
					matrizMadre[cont][0] = dateUno
							.format(apuestas.getSuperastroDAO().getListaSuperastro().get(i).getFecha());
					matrizMadre[cont][1] = apuestas.getSuperastroDAO().getListaSuperastro().get(i).getNombreSede();
					matrizMadre[cont][2] = apuestas.getSuperastroDAO().getListaSuperastro().get(i).getCedula();
					matrizMadre[cont][3] = buscarNombreApostador(
							apuestas.getSuperastroDAO().getListaSuperastro().get(i).getCedula());
					matrizMadre[cont][4] = "Super Astro";
					matrizMadre[cont][5] = String
							.valueOf(apuestas.getSuperastroDAO().getListaSuperastro().get(i).getValorApuesta());
					cont++;
				}
			} else if (tipoFiltro.equals("mes y año")) {
				if (dateUno.parse(fecha)
						.getMonth() == (apuestas.getSuperastroDAO().getListaSuperastro().get(i).getFecha().getMonth())
						&& dateUno.parse(fecha).getYear() == (apuestas.getSuperastroDAO().getListaSuperastro().get(i)
								.getFecha().getYear())) {
					matrizMadre[cont][0] = dateUno
							.format(apuestas.getSuperastroDAO().getListaSuperastro().get(i).getFecha());
					matrizMadre[cont][1] = apuestas.getSuperastroDAO().getListaSuperastro().get(i).getNombreSede();
					matrizMadre[cont][2] = apuestas.getSuperastroDAO().getListaSuperastro().get(i).getCedula();
					matrizMadre[cont][3] = buscarNombreApostador(
							apuestas.getSuperastroDAO().getListaSuperastro().get(i).getCedula());
					matrizMadre[cont][4] = "Super Astro";
					matrizMadre[cont][5] = String
							.valueOf(apuestas.getSuperastroDAO().getListaSuperastro().get(i).getValorApuesta());
					cont++;
				}
			} else if (tipoFiltro.equals("año")) {
				if (dateUno.parse(fecha)
						.getYear() == (apuestas.getSuperastroDAO().getListaSuperastro().get(i).getFecha().getYear())) {
					matrizMadre[cont][0] = dateUno
							.format(apuestas.getSuperastroDAO().getListaSuperastro().get(i).getFecha());
					matrizMadre[cont][1] = apuestas.getSuperastroDAO().getListaSuperastro().get(i).getNombreSede();
					matrizMadre[cont][2] = apuestas.getSuperastroDAO().getListaSuperastro().get(i).getCedula();
					matrizMadre[cont][3] = buscarNombreApostador(
							apuestas.getSuperastroDAO().getListaSuperastro().get(i).getCedula());
					matrizMadre[cont][4] = "Super Astro";
					matrizMadre[cont][5] = String
							.valueOf(apuestas.getSuperastroDAO().getListaSuperastro().get(i).getValorApuesta());
					cont++;
				}
			}
		}
		for (int i = 0; i < apuestas.getMarcadoresDAO().getListaMarcadores().size(); i++) {
			if (tipoFiltro.equals("día, mes y año")) {
				if (dateUno.parse(fecha)
						.getDay() == (apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getFecha().getDay())
						&& dateUno.parse(fecha)
								.getMonth() == (apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getFecha()
										.getMonth())
						&& dateUno.parse(fecha).getYear() == (apuestas.getMarcadoresDAO().getListaMarcadores().get(i)
								.getFecha().getYear())) {
					matrizMadre[cont][0] = dateUno
							.format(apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getFecha());
					matrizMadre[cont][1] = apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getNombreSede();
					matrizMadre[cont][2] = apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getCedula();
					matrizMadre[cont][3] = buscarNombreApostador(
							apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getCedula());
					matrizMadre[cont][4] = "Fútbol";
					matrizMadre[cont][5] = String
							.valueOf(apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getValorApuesta());
					cont++;
				}
			} else if (tipoFiltro.equals("mes y año")) {
				if (dateUno.parse(fecha)
						.getMonth() == (apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getFecha().getMonth())
						&& dateUno.parse(fecha).getYear() == (apuestas.getMarcadoresDAO().getListaMarcadores().get(i)
								.getFecha().getYear())) {
					matrizMadre[cont][0] = dateUno
							.format(apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getFecha());
					matrizMadre[cont][1] = apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getNombreSede();
					matrizMadre[cont][2] = apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getCedula();
					matrizMadre[cont][3] = buscarNombreApostador(
							apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getCedula());
					matrizMadre[cont][4] = "Fútbol";
					matrizMadre[cont][5] = String
							.valueOf(apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getValorApuesta());
					cont++;
				}
			} else if (tipoFiltro.equals("año")) {
				if (dateUno.parse(fecha).getYear() == apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getFecha()
						.getYear()) {
					matrizMadre[cont][0] = dateUno
							.format(apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getFecha());
					matrizMadre[cont][1] = apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getNombreSede();
					matrizMadre[cont][2] = apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getCedula();
					matrizMadre[cont][3] = buscarNombreApostador(
							apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getCedula());
					matrizMadre[cont][4] = "Fútbol";
					matrizMadre[cont][5] = String
							.valueOf(apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getValorApuesta());
					cont++;
				}
			}
		}
		String[][] salidaSinNull = this.quitarCamposNull(matrizMadre);

		if (tipoReporte.equals("Listado de clientes por sede")) {
			String[][] reporteClientes = new String[salidaSinNull.length][4];
			for (int i = 0; i < reporteClientes.length; i++) {
				reporteClientes[i][0] = salidaSinNull[i][0];
				reporteClientes[i][1] = salidaSinNull[i][1];
				reporteClientes[i][2] = salidaSinNull[i][2];
				reporteClientes[i][3] = salidaSinNull[i][3];
			}
			return reporteClientes;
		} else if (tipoReporte.equals("Valor total de apuestas por cliente")) {
			String[][] reporteValorApuestasClientes = new String[salidaSinNull.length][4];
			for (int i = 0; i < reporteValorApuestasClientes.length; i++) {
				reporteValorApuestasClientes[i][0] = salidaSinNull[i][0];
				reporteValorApuestasClientes[i][1] = salidaSinNull[i][2];
				reporteValorApuestasClientes[i][2] = salidaSinNull[i][3];
				reporteValorApuestasClientes[i][3] = salidaSinNull[i][5];
			}
			return reporteValorApuestasClientes;
		} else if (tipoReporte.equals("Detalle de apuestas realizadas por cliente y sede")) {
			String[][] reporteDetalleApuestasClienteSede = new String[salidaSinNull.length][6];
			for (int i = 0; i < reporteDetalleApuestasClienteSede.length; i++) {
				reporteDetalleApuestasClienteSede[i][0] = salidaSinNull[i][0];
				reporteDetalleApuestasClienteSede[i][1] = salidaSinNull[i][1];
				reporteDetalleApuestasClienteSede[i][2] = salidaSinNull[i][2];
				reporteDetalleApuestasClienteSede[i][3] = salidaSinNull[i][3];
				reporteDetalleApuestasClienteSede[i][4] = salidaSinNull[i][4];
				reporteDetalleApuestasClienteSede[i][5] = salidaSinNull[i][5];
			}
			return reporteDetalleApuestasClienteSede;
		} else {
			String[][] apuestasSedesTipo = new String[salidaSinNull.length][4];
			for (int i = 0; i < apuestasSedesTipo.length; i++) {
				apuestasSedesTipo[i][0] = salidaSinNull[i][0];
				apuestasSedesTipo[i][1] = salidaSinNull[i][1];
				apuestasSedesTipo[i][2] = salidaSinNull[i][4];
				apuestasSedesTipo[i][3] = salidaSinNull[i][5];
			}
			cont = 0;
			String[][] reporteTotalApuestasSedeTipo = new String[apuestasSedesTipo.length][4];
			for (int i = 0; i < reporteTotalApuestasSedeTipo.length; i++) {
				cont = 0;
				double valor = 0;
				if (!apuestasSedesTipo[i][1].equals("")) {
					reporteTotalApuestasSedeTipo[i][0] = apuestasSedesTipo[i][0];
					reporteTotalApuestasSedeTipo[i][1] = apuestasSedesTipo[i][1];
					reporteTotalApuestasSedeTipo[i][2] = apuestasSedesTipo[i][2];
					for (int j = i; j < reporteTotalApuestasSedeTipo.length; j++) {
						if (apuestasSedesTipo[i][1].equals(apuestasSedesTipo[j][1])
								&& apuestasSedesTipo[i][2].equals(apuestasSedesTipo[j][2])) {
							valor += Double.parseDouble(apuestasSedesTipo[i][3]);
							if (cont == 0) {
								reporteTotalApuestasSedeTipo[i][3] = String.valueOf(valor);
								cont++;
							} else {
								apuestasSedesTipo[j][1] = "";
								apuestasSedesTipo[j][3] = "0";
								reporteTotalApuestasSedeTipo[i][3] = String.valueOf(valor);
							}
						}
					}
				}
			}
			return quitarCamposNull(reporteTotalApuestasSedeTipo);
		}
	}

	/**
	 * Este método se encarga de llenar los titulos a sus tablas correspondientes.
	 * 
	 * @param tipoReporte, es el tipo de reporte a identificar; tipoReporte!= null.
	 * @return retorna un arreglo con los titulos correscpondientes.
	 */
	public String[] obtenerTitulosReportes(String tipoReporte) {
		if (tipoReporte.equals("Listado de clientes por sede")) {
			String[] salida = { "Fecha", "Sede", "Cédula", "Nombre" };
			return salida;
		} else if (tipoReporte.equals("Valor total de apuestas por cliente")) {
			String[] salida = { "Fecha", "Cédula", "Nombre", "Valor" };
			return salida;
		} else if (tipoReporte.equals("Detalle de apuestas realizadas por cliente y sede")) {
			String[] salida = { "Fecha", "Sede", "Cédula", "Nombre", "Tipo de apuesta", "Valor" };
			return salida;
		} else if (tipoReporte.equals("Total de apuestas por sede y tipo de juego")) {
			String[] salida = { "Fecha", "Sede", "Tipo de apuesta", "Valor" };
			return salida;
		} else {
			return null;
		}
	}

	/**
	 * Este método se encarga de quitar los campos null de un arreglo bidimencional.
	 * 
	 * @param matrizPrincipal, es la matriz a la cual se l van a borrar los campos
	 *                         null.
	 * @return retorna una matriz sin campos null.s
	 */
	public String[][] quitarCamposNull(String[][] matrizPrincipal) {
		if (matrizPrincipal.length != 0) {
			int contadorSinNull = 0;
			for (int i = 0; i < matrizPrincipal.length; i++) {
				if (matrizPrincipal[i][0] != null) {
					contadorSinNull++;
				}
			}
			String[][] matrizSalida = new String[contadorSinNull][matrizPrincipal[0].length];
			contadorSinNull = 0;
			for (int i = 0; i < matrizPrincipal.length; i++) {
				if (matrizPrincipal[i][0] != null) {
					matrizSalida[contadorSinNull] = matrizPrincipal[i];
					contadorSinNull++;
				}
			}
			return matrizSalida;
		} else {
			return matrizPrincipal;
		}
	}

	/**
	 * Este método se encarga de obtener los cinco clientes con las apuestas más
	 * ganadas.
	 * 
	 * @return retorna toda la información respectiva con los cinco clientes.
	 */
	public String[][] generarCincoClientesMayoresApuestas() {
		String[][] ganadores = new String[this.apostadores.getApostadorDao().getListaApostador().size() * 3][3];
		int cont = 0;
		for (int i = 0; i < this.apostadores.getApostadorDao().getListaApostador().size(); i++) {
			cont = 0;
			ganadores[i][0] = this.apostadores.getApostadorDao().getListaApostador().get(i).getCedula();
			ganadores[i][1] = "";
			for (int j = 0; j < this.apuestas.getBalotoDAO().getListaBaloto().size(); j++) {
				if (this.apostadores.getApostadorDao().getListaApostador().get(i).getCedula()
						.equals(this.apuestas.getBalotoDAO().getListaBaloto().get(j).getCedula())) {
					if (this.apuestas.ganadorApuestaBaloto(
							this.apuestas.getBalotoDAO().getListaBaloto().get(j).getNumeroJuego())) {
						cont++;
					}
				}
			}
			ganadores[i][2] = String.valueOf(cont);
		}

		int pos = this.apostadores.getApostadorDao().getListaApostador().size();
		cont = 0;
		for (int i = 0; i < this.apostadores.getApostadorDao().getListaApostador().size(); i++) {
			cont = 0;
			ganadores[pos][0] = this.apostadores.getApostadorDao().getListaApostador().get(i).getCedula();
			ganadores[pos][1] = "";
			for (int j = 0; j < this.apuestas.getSuperastroDAO().getListaSuperastro().size(); j++) {
				if (this.apostadores.getApostadorDao().getListaApostador().get(i).getCedula()
						.equals(this.apuestas.getSuperastroDAO().getListaSuperastro().get(j).getCedula())) {
					if (this.apuestas.ganadorApuestaSuperastro(
							this.apuestas.getSuperastroDAO().getListaSuperastro().get(j).getNumeroJuego() + "-"
									+ this.apuestas.getSuperastroDAO().getListaSuperastro().get(j).getSigno())) {
						cont++;
					}
				}
			}
			ganadores[pos][2] = String.valueOf(cont);
			pos++;
		}
		pos = this.apostadores.getApostadorDao().getListaApostador().size() * 2;
		cont = 0;
		for (int i = 0; i < this.apostadores.getApostadorDao().getListaApostador().size(); i++) {
			cont = 0;
			ganadores[pos][0] = this.apostadores.getApostadorDao().getListaApostador().get(i).getCedula();
			ganadores[pos][1] = "";
			for (int j = 0; j < this.apuestas.getMarcadoresDAO().getListaMarcadores().size(); j++) {
				if (this.apostadores.getApostadorDao().getListaApostador().get(i).getCedula()
						.equals(this.apuestas.getMarcadoresDAO().getListaMarcadores().get(j).getCedula())) {
					if (this.apuestas.partidoGanador(this.sede.cargarPartido(),
							(this.apuestas.getMarcadoresDAO().getListaMarcadores().get(j).getPartido() + "-"
									+ this.apuestas.getMarcadoresDAO().getListaMarcadores().get(j).getResultado()))) {
						cont++;
					}
				}
			}
			ganadores[pos][2] = String.valueOf(cont);
			pos++;
		}

		String[][] matrizDeSumatoria = new String[ganadores.length][3];
		cont = 0;

		for (int i = 0; i < matrizDeSumatoria.length; i++) {
			cont = 0;
			double valor = 0;
			if (!ganadores[i][0].equals("")) {
				matrizDeSumatoria[i][0] = ganadores[i][0];
				matrizDeSumatoria[i][1] = ganadores[i][1];
				for (int j = 0; j < matrizDeSumatoria.length; j++) {
					if (ganadores[i][0].equals(ganadores[j][0])) {
						valor += Double.parseDouble(ganadores[j][2]);
						if (cont == 0) {
							matrizDeSumatoria[i][2] = String.valueOf(valor);
							cont++;
						} else {
							ganadores[j][0] = "";
							ganadores[j][1] = "";
							matrizDeSumatoria[i][2] = String.valueOf(valor);
						}
					}
				}
			}
		}

		String[][] matrizSinNull = this.quitarCamposNull(matrizDeSumatoria);
		String[][] temp = new String[1][3];
		for (int i = 0; i < matrizSinNull.length; i++) {
			for (int j = 0; j < matrizSinNull.length; j++) {
				if (Double.parseDouble(matrizSinNull[i][2]) > Double.parseDouble(matrizSinNull[j][2])) {
					temp[0] = matrizSinNull[i];
					matrizSinNull[i] = matrizSinNull[j];
					matrizSinNull[j] = temp[0];
				}
			}
		}
		String[][] matrizDeResultados = new String[5][3];
		for (int i = 0; i < matrizSinNull.length; i++) {
			if (i < 5) {
				matrizDeResultados[i] = matrizSinNull[i];
			}
		}
		return this.quitarCamposNull(matrizDeResultados);
	}

	/**
	 * Este método se encarga de obtener los tres tipos de apuestas en la cual se va
	 * a obtener la cantidad de ganadores por cada una de estas.
	 * 
	 * @return retorna toda la información respectiva ya antes mencionada.
	 */
	public String[][] generarTresTiposApuestaMayoresGanadores() {

		String[][] ganadores = new String[3][3];
		int cont = 0;
		for (int i = 0; i < this.apuestas.getBalotoDAO().getListaBaloto().size(); i++) {
			if (this.apuestas
					.ganadorApuestaBaloto(this.apuestas.getBalotoDAO().getListaBaloto().get(i).getNumeroJuego())) {
				cont++;
			}
		}

		ganadores[0][0] = "Baloto";
		ganadores[0][1] = "";
		ganadores[0][2] = String.valueOf(cont);
		cont = 0;
		for (int i = 0; i < this.apuestas.getSuperastroDAO().getListaSuperastro().size(); i++) {
			if (this.apuestas.ganadorApuestaSuperastro(
					this.apuestas.getSuperastroDAO().getListaSuperastro().get(i).getNumeroJuego() + "-"
							+ this.apuestas.getSuperastroDAO().getListaSuperastro().get(i).getSigno())) {
				cont++;
			}
		}
		ganadores[1][0] = "Super Astro";
		ganadores[1][1] = "";
		ganadores[1][2] = String.valueOf(cont);

		cont = 0;
		for (int i = 0; i < this.apuestas.getMarcadoresDAO().getListaMarcadores().size(); i++) {
			if (this.apuestas.partidoGanador(this.sede.cargarPartido(),
					(this.apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getPartido() + "-"
							+ this.apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getResultado()))) {
				cont++;
			}
		}
		ganadores[2][0] = "Fútbol";
		ganadores[2][1] = "";
		ganadores[2][2] = String.valueOf(cont);

		return ganadores;
	}

	/**
	 * Este método se encarga de obtener las cinco sedes con mayor venta.
	 * 
	 * @return retorna una matriz con toda esta información.
	 */
	public String[][] obtenerCincoSedesConMayorVenta() {
		String[][] salida = new String[5][3];
		double[] valorTotalSedes = new double[this.sede.getSedesDao().getDataSedes().size()];
		String[] arregloSedes = new String[this.sede.getSedesDao().getDataSedes().size()];

		for (int i = 0; i < this.sede.getSedesDao().getDataSedes().size(); i++) {
			for (int j = 0; j < this.apuestas.getBalotoDAO().getListaBaloto().size(); j++) {
				if (this.apuestas.getBalotoDAO().getListaBaloto().get(j).getNombreSede()
						.equals(this.sede.getSedesDao().getDataSedes().get(i).getUbicacion()
								+ this.sede.getSedesDao().getDataSedes().get(i).getIdUbicacion())) {
					valorTotalSedes[i] = valorTotalSedes[i]
							+ this.apuestas.getBalotoDAO().getListaBaloto().get(j).getValorApuesta();
				}
			}
			for (int j = 0; j < this.apuestas.getSuperastroDAO().getListaSuperastro().size(); j++) {
				if (this.apuestas.getSuperastroDAO().getListaSuperastro().get(j).getNombreSede()
						.equals(this.sede.getSedesDao().getDataSedes().get(i).getUbicacion()
								+ this.sede.getSedesDao().getDataSedes().get(i).getIdUbicacion())) {
					valorTotalSedes[i] = valorTotalSedes[i]
							+ this.apuestas.getSuperastroDAO().getListaSuperastro().get(j).getValorApuesta();
				}
			}
			for (int j = 0; j < this.apuestas.getMarcadoresDAO().getListaMarcadores().size(); j++) {
				if (this.apuestas.getMarcadoresDAO().getListaMarcadores().get(j).getNombreSede()
						.equals(this.sede.getSedesDao().getDataSedes().get(i).getUbicacion()
								+ this.sede.getSedesDao().getDataSedes().get(i).getIdUbicacion())) {
					valorTotalSedes[i] = valorTotalSedes[i]
							+ this.apuestas.getMarcadoresDAO().getListaMarcadores().get(j).getValorApuesta();
				}
			}
			arregloSedes[i] = this.sede.getSedesDao().getDataSedes().get(i).getUbicacion()
					+ this.sede.getSedesDao().getDataSedes().get(i).getIdUbicacion();
		}

		for (int i = 0; i < valorTotalSedes.length; i++) {
			for (int j = 0; j < valorTotalSedes.length; j++) {
				if (valorTotalSedes[i] > valorTotalSedes[j]) {
					String tempSede = arregloSedes[i];
					arregloSedes[i] = arregloSedes[j];
					arregloSedes[j] = tempSede;
					double tempValor = valorTotalSedes[i];
					valorTotalSedes[i] = valorTotalSedes[j];
					valorTotalSedes[j] = tempValor;
				}
			}
		}
		for (int i = 0; i < valorTotalSedes.length; i++) {
			if (i < 5) {
				salida[i][0] = String.valueOf(valorTotalSedes[i]);
				salida[i][1] = "";
				salida[i][2] = arregloSedes[i];
			}
		}
		return this.quitarCamposNull(salida);
	}

	/**
	 * Este método se encarga de buscar el nombre del apostador con la cedula.
	 * 
	 * @param cedula, es la cedula del apostador != null.
	 * @return retonar el nombre del apostador.
	 */
	private String buscarNombreApostador(String cedula) {
		String salida = "";
		for (int i = 0; i < this.apostadores.getApostadorDao().getListaApostador().size(); i++) {
			if (cedula.equals(this.apostadores.getApostadorDao().getListaApostador().get(i).getCedula())) {
				salida = this.apostadores.getApostadorDao().getListaApostador().get(i).getNombre();
			}
		}
		return salida;
	}

	/**
	 * Este método se encarga de generar la información para mostrarlo en la
	 * pantalla.
	 * 
	 * @param tipoReporte, es el tipo de reporte a mostrar; tipoReporte != null.
	 * @param fecha,       es la fecha en la cual se va realizar la consulta; fecha
	 *                     != null.
	 * @param tipoFiltro,  es el tipo de filtro por el cual se va a realizar la
	 *                     busqueda, tipoFiltro != null.
	 * @return retorna toda la información por medio de una matriz.
	 * @throws ParseException se puede presentar algún error en la fecha.
	 */
	public String[][] generarInformacionReportesPantalla(String tipoReporte, String fecha, String tipoFiltro)
			throws ParseException {
		return this.apuestas.quicksortRecursivo(this.generarDatosReportes(tipoReporte, fecha, tipoFiltro));
	}

	/**
	 * Este método se encarga de exportar la información a forma pdf;
	 * 
	 * @param tipoReporte, es el tipo de reporte; tipoReporte != null.
	 * @param fecha,       es la fecha en la cual se va realizar la consulta; fecha
	 *                     != null.
	 * @param tipoFiltro,  es el tipo de filtro por el cual se va a realizar la
	 *                     exportación, tipoFiltro != null.
	 * @param tipoArchivo, es el tipo de archivo a exportar; tipoArchivo != null.
	 * @return retorna true si todo se encuentra bien.
	 * @throws ParseException se puede presentar algún error en la fecha.
	 */
	public boolean exportar(String tipoReporte, String fecha, String tipoFiltro, String tipoArchivo)
			throws ParseException {
		String[][] datos = this.apuestas.quicksortRecursivo(this.generarDatosReportes(tipoReporte, fecha, tipoFiltro));
		if (datos.length > 0) {
			if (tipoArchivo.equals("PDF")) {
				archivoPDF.exportar(datos, tipoReporte);
			} else {
				archivoExcel.exportar(datos, tipoReporte);
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @return the apostadores
	 */
	public Apostador getApostadores() {
		return apostadores;
	}

	/**
	 * @param apostadores the apostadores to set
	 */
	public void setApostadores(Apostador apostadores) {
		this.apostadores = apostadores;
	}

	/**
	 * @return the nombreCasaApuestas
	 */
	public String getNombreCasaApuestas() {
		return nombreCasaApuestas;
	}

	/**
	 * @param nombreCasaApuestas the nombreCasaApuestas to set
	 */
	public void setNombreCasaApuestas(String nombreCasaApuestas) {
		this.nombreCasaApuestas = nombreCasaApuestas;
	}

	/**
	 * @return the numeroSedes
	 */
	public int getNumeroSedes() {
		return numeroSedes;
	}

	/**
	 * @param numeroSedes the numeroSedes to set
	 */
	public void setNumeroSedes(int numeroSedes) {
		this.numeroSedes = numeroSedes;
	}

	/**
	 * @return the presupuestoTotal
	 */
	public double getPresupuestoTotal() {
		return presupuestoTotal;
	}

	/**
	 * @param presupuestoTotal the presupuestoTotal to set
	 */
	public void setPresupuestoTotal(double presupuestoTotal) {
		this.presupuestoTotal = presupuestoTotal;
	}

	/**
	 * @return the archivoConfiguracionCasaApuestas
	 */
	public ArchivoConfiguracionCasaApuestas getArchivoConfiguracionCasaApuestas() {
		return archivoConfiguracionCasaApuestas;
	}

	/**
	 * @param archivoConfiguracionCasaApuestas the archivoConfiguracionCasaApuestas
	 *                                         to set
	 */
	public void setArchivoConfiguracionCasaApuestas(ArchivoConfiguracionCasaApuestas archivoConfiguracionCasaApuestas) {
		this.archivoConfiguracionCasaApuestas = archivoConfiguracionCasaApuestas;
	}

	/**
	 * @return the apuestas
	 */
	public Apuesta getApuestas() {
		return apuestas;
	}

	/**
	 * @param apuestas the apuestas to set
	 */
	public void setApuestas(Apuesta apuestas) {
		this.apuestas = apuestas;
	}

	/**
	 * @return the sede
	 */
	public Sede getSede() {
		return sede;
	}

	/**
	 * @param sede the sede to set
	 */
	public void setSede(Sede sede) {
		this.sede = sede;
	}

	/**
	 * @return the juego
	 */
	public Juego getJuego() {
		return juego;
	}

	/**
	 * @param juego the juego to set
	 */
	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	/**
	 * @return the archivoPDF
	 */
	public ArchivoPDF getArchivoPDF() {
		return archivoPDF;
	}

	/**
	 * @param archivoPDF the archivoPDF to set
	 */
	public void setArchivoPDF(ArchivoPDF archivoPDF) {
		this.archivoPDF = archivoPDF;
	}

	/**
	 * @return the archivoExcel
	 */
	public ArchivoExcel getArchivoExcel() {
		return archivoExcel;
	}

	/**
	 * @param archivoExcel the archivoExcel to set
	 */
	public void setArchivoExcel(ArchivoExcel archivoExcel) {
		this.archivoExcel = archivoExcel;
	}

	/**
	 * @return the planesPremiacion
	 */
	public LecturaTxt getPlanesPremiacion() {
		return planesPremiacion;
	}

	/**
	 * @param planesPremiacion the planesPremiacion to set
	 */
	public void setPlanesPremiacion(LecturaTxt planesPremiacion) {
		this.planesPremiacion = planesPremiacion;
	}
}