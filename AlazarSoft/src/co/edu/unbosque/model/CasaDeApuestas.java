package co.edu.unbosque.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import co.edu.unbosque.model.persistence.ArchivoConfiguracionCasaApuestas;
import co.edu.unbosque.model.persistence.ArchivoExcel;
import co.edu.unbosque.model.persistence.ArchivoPDF;
import co.edu.unbosque.model.persistence.LecturaTxt;

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

	public void guardarConfiguracionCasaDeApuestas(String nombre, int numeroSedes, double presupuestoTotal) {
		System.out.println(nombre + numeroSedes + presupuestoTotal);
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
					matrizMadre[i][0] = dateUno
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
				if (dateUno.parse(fecha).equals(apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getFecha())) {
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

	public int numeroGanadorBaloto(String numeroBaloto, String numeroSuperastro) {
		int cont = 0;
		for (int i = 0; i < this.apuestas.getBalotoDAO().getListaBaloto().size(); i++) {
			if (numeroBaloto.equals(this.apuestas.getBalotoDAO().getListaBaloto().get(i).getNumeroJuego())) {
				this.apuestas.getBalotoDAO().getListaBaloto().get(i).getCedula();
				cont++;
			}

		}
		for (int i = 0; i < this.apuestas.getSuperastroDAO().getListaSuperastro().size(); i++) {
			if (numeroSuperastro
					.equals(this.apuestas.getSuperastroDAO().getListaSuperastro().get(i).getNumeroJuego())) {
				this.apuestas.getSuperastroDAO().getListaSuperastro().get(i).getCedula();
				cont++;
			}
		}
		return cont;
	}

	public String[][] obtenerCincoApostadoresGanadores() {
		String[][] salida = new String[5][3];
		int[] ganador = new int[3];
		String[] arregloBaloto = new String[this.apuestas.getBalotoDAO().getListaBaloto().size()];

		for (int i = 0; i < arregloBaloto.length; i++) {

		}
		return salida;
	}

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
			System.out.println(valorTotalSedes[i]);
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

	private String buscarNombreApostador(String cedula) {
		String salida = "";
		for (int i = 0; i < this.apostadores.getApostadorDao().getListaApostador().size(); i++) {
			if (cedula.equals(this.apostadores.getApostadorDao().getListaApostador().get(i).getCedula())) {
				salida = this.apostadores.getApostadorDao().getListaApostador().get(i).getNombre();
			}
		}
		return salida;
	}

	public String[][] generarInformacionReportesPantalla(String tipoReporte, String fecha, String tipoFiltro)
			throws ParseException {
		return this.apuestas.quicksortRecursivo(this.generarDatosReportes(tipoReporte, fecha, tipoFiltro));
	}

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