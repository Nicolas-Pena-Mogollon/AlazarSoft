package co.edu.unbosque.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import com.itextpdf.text.log.SysoLogger;

import co.edu.unbosque.model.persistence.ArchivoConfiguracionCasaApuestas;
import co.edu.unbosque.model.persistence.ArchivoPDF;
import co.edu.unbosque.model.persistence.LecturaTxt;

public class CasaDeApuestas {

	private Apostador apostadores;
	private Sede sede;
	private Apuesta apuestas;
	private String nombreCasaApuestas;
	private int numeroSedes;
	private Long presupuestoTotal;
	private ArchivoConfiguracionCasaApuestas archivoConfiguracionCasaApuestas;
	private ArchivoPDF archivoPDF;
	private Juego juego;
	private LecturaTxt planesPremiacion;

	public CasaDeApuestas() {
		this.archivoConfiguracionCasaApuestas = new ArchivoConfiguracionCasaApuestas();
		this.apostadores = new Apostador();
		this.apuestas = new Apuesta();
		this.sede = new Sede();
		this.archivoPDF = new ArchivoPDF();
		this.juego = new Juego();
		this.planesPremiacion = new LecturaTxt();
	}

	public void guardarConfiguracionCasaDeApuestas(String nombre, int numeroSedes, Long presupuestoTotal) {
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

		
	public String[][] generarDatosPDFClientes(String fecha, String tipoFiltro) throws ParseException {
		String[][] salidaDatosClientes = new String[apuestas.getBalotoDAO().getListaBaloto().size()
				+ apuestas.getSuperastroDAO().getListaSuperastro().size()
				+ apuestas.getMarcadoresDAO().getListaMarcadores().size()][7];
		SimpleDateFormat dateUno = new SimpleDateFormat("hh: mm: ss a dd/MM/yyyy");
		String[] aux = new String[3];
		int cont = 0;
		for (int i = 0; i < apuestas.getBalotoDAO().getListaBaloto().size(); i++) {
			aux = buscarDatosApostador(apuestas.getBalotoDAO().getListaBaloto().get(i).getCedula());
			if (tipoFiltro.equals("día, mes y año")) {
				if (dateUno.parse(fecha)
						.getDay() == (apuestas.getBalotoDAO().getListaBaloto().get(i).getFecha().getDay())
						&& dateUno.parse(fecha)
								.getMonth() == (apuestas.getBalotoDAO().getListaBaloto().get(i).getFecha().getMonth())
						&& dateUno.parse(fecha)
								.getYear() == (apuestas.getBalotoDAO().getListaBaloto().get(i).getFecha().getYear())) {
					salidaDatosClientes[cont][0] = dateUno.format(apuestas.getBalotoDAO().getListaBaloto().get(i).getFecha());
					salidaDatosClientes[cont][1] = apuestas.getBalotoDAO().getListaBaloto().get(i).getNombreSede();
					salidaDatosClientes[cont][2] = apuestas.getBalotoDAO().getListaBaloto().get(i).getCedula();
					salidaDatosClientes[cont][3] = aux[0];
					salidaDatosClientes[cont][4] = aux[1];
					salidaDatosClientes[cont][5] = aux[2];
					salidaDatosClientes[cont][6]= String.valueOf(apuestas.getBalotoDAO().getListaBaloto().get(i).getValorApuesta());
					cont++;
				}
			} else if (tipoFiltro.equals("mes y año")) {
				if (dateUno.parse(fecha)
						.getMonth() == (apuestas.getBalotoDAO().getListaBaloto().get(i).getFecha().getMonth())
						&& dateUno.parse(fecha)
								.getYear() == (apuestas.getBalotoDAO().getListaBaloto().get(i).getFecha().getYear())) {
					salidaDatosClientes[cont][0] = dateUno.format(apuestas.getBalotoDAO().getListaBaloto().get(i).getFecha());
					salidaDatosClientes[cont][1] = apuestas.getBalotoDAO().getListaBaloto().get(i).getNombreSede();
					salidaDatosClientes[cont][2] = apuestas.getBalotoDAO().getListaBaloto().get(i).getCedula();
					salidaDatosClientes[cont][3] = aux[0];
					salidaDatosClientes[cont][4] = aux[1];
					salidaDatosClientes[cont][5] = aux[2];
					cont++;
				}
			} else if (tipoFiltro.equals("año")) {
				if (dateUno.parse(fecha)
						.getYear() == (apuestas.getBalotoDAO().getListaBaloto().get(i).getFecha().getYear())) {
					salidaDatosClientes[cont][0] = dateUno.format(apuestas.getBalotoDAO().getListaBaloto().get(i).getFecha());
					salidaDatosClientes[cont][1] = apuestas.getBalotoDAO().getListaBaloto().get(i).getNombreSede();
					salidaDatosClientes[cont][2] = apuestas.getBalotoDAO().getListaBaloto().get(i).getCedula();
					salidaDatosClientes[cont][3] = aux[0];
					salidaDatosClientes[cont][4] = aux[1];
					salidaDatosClientes[cont][5] = aux[2];
					cont++;
				}
			}

		}
		int posicionArrayList = 0;
		for (int i = apuestas.getBalotoDAO().getListaBaloto().size(); i < salidaDatosClientes.length
				- apuestas.getMarcadoresDAO().getListaMarcadores().size(); i++) {
			aux = buscarDatosApostador(
					apuestas.getSuperastroDAO().getListaSuperastro().get(posicionArrayList).getCedula());
			if (tipoFiltro.equals("día, mes y año")) {
				if (dateUno.parse(fecha)
						.getDay() == (apuestas.getSuperastroDAO().getListaSuperastro().get(posicionArrayList).getFecha()
								.getDay())
						&& dateUno.parse(fecha)
								.getMonth() == (apuestas.getSuperastroDAO().getListaSuperastro().get(posicionArrayList)
										.getFecha().getMonth())
						&& dateUno.parse(fecha).getYear() == (apuestas.getSuperastroDAO().getListaSuperastro()
								.get(posicionArrayList).getFecha().getYear())) {
					salidaDatosClientes[cont][0] = dateUno
							.format(apuestas.getSuperastroDAO().getListaSuperastro().get(posicionArrayList).getFecha());
					salidaDatosClientes[cont][1] = apuestas.getSuperastroDAO().getListaSuperastro().get(posicionArrayList)
							.getNombreSede();
					salidaDatosClientes[cont][2] = apuestas.getSuperastroDAO().getListaSuperastro().get(posicionArrayList)
							.getCedula();
					salidaDatosClientes[cont][3] = aux[0];
					salidaDatosClientes[cont][4] = aux[1];
					salidaDatosClientes[cont][5] = aux[2];
					cont++;
				}
				posicionArrayList++;

			} else if (tipoFiltro.equals("mes y año")) {
				if (dateUno.parse(fecha)
						.getMonth() == (apuestas.getSuperastroDAO().getListaSuperastro().get(posicionArrayList)
								.getFecha().getMonth())
						&& dateUno.parse(fecha).getYear() == (apuestas.getSuperastroDAO().getListaSuperastro()
								.get(posicionArrayList).getFecha().getYear())) {
					salidaDatosClientes[cont][0] = dateUno
							.format(apuestas.getSuperastroDAO().getListaSuperastro().get(posicionArrayList).getFecha());
					salidaDatosClientes[cont][1] = apuestas.getSuperastroDAO().getListaSuperastro().get(posicionArrayList)
							.getNombreSede();
					salidaDatosClientes[cont][2] = apuestas.getSuperastroDAO().getListaSuperastro().get(posicionArrayList)
							.getCedula();
					salidaDatosClientes[cont][3] = aux[0];
					salidaDatosClientes[cont][4] = aux[1];
					salidaDatosClientes[cont][5] = aux[2];
					cont++;
				}
				posicionArrayList++;

			} else if (tipoFiltro.equals("año")) {
				if (dateUno.parse(fecha).getYear() == (apuestas.getSuperastroDAO().getListaSuperastro()
						.get(posicionArrayList).getFecha().getYear())) {
					salidaDatosClientes[cont][0] = dateUno
							.format(apuestas.getSuperastroDAO().getListaSuperastro().get(posicionArrayList).getFecha());
					salidaDatosClientes[cont][1] = apuestas.getSuperastroDAO().getListaSuperastro().get(posicionArrayList)
							.getNombreSede();
					salidaDatosClientes[cont][2] = apuestas.getSuperastroDAO().getListaSuperastro().get(posicionArrayList)
							.getCedula();
					salidaDatosClientes[cont][3] = aux[0];
					salidaDatosClientes[cont][4] = aux[1];
					salidaDatosClientes[cont][5] = aux[2];
					cont++;
				}
				posicionArrayList++;
			}

		}
		posicionArrayList = 0;
		for (int i = salidaDatosClientes.length - apuestas.getMarcadoresDAO().getListaMarcadores().size(); i < salidaDatosClientes.length; i++) {
			aux = buscarDatosApostador(
					apuestas.getMarcadoresDAO().getListaMarcadores().get(posicionArrayList).getCedula());
			if (tipoFiltro.equals("día, mes y año")) {
				if (dateUno.parse(fecha)
						.getDay() == (apuestas.getMarcadoresDAO().getListaMarcadores().get(posicionArrayList).getFecha()
								.getDay())
						&& dateUno.parse(fecha)
								.getMonth() == (apuestas.getMarcadoresDAO().getListaMarcadores().get(posicionArrayList)
										.getFecha().getMonth())
						&& dateUno.parse(fecha).getYear() == (apuestas.getMarcadoresDAO().getListaMarcadores()
								.get(posicionArrayList).getFecha().getYear())) {
					salidaDatosClientes[cont][0] = dateUno
							.format(apuestas.getMarcadoresDAO().getListaMarcadores().get(posicionArrayList).getFecha());
					salidaDatosClientes[cont][1] = apuestas.getMarcadoresDAO().getListaMarcadores().get(posicionArrayList)
							.getNombreSede();
					salidaDatosClientes[cont][2] = apuestas.getMarcadoresDAO().getListaMarcadores().get(posicionArrayList)
							.getCedula();
					salidaDatosClientes[cont][3] = aux[0];
					salidaDatosClientes[cont][4] = aux[1];
					salidaDatosClientes[cont][5] = aux[2];
					cont++;
				}
				posicionArrayList++;
			} else if (tipoFiltro.equals("mes y año")) {
				if (dateUno.parse(fecha)
						.getMonth() == (apuestas.getMarcadoresDAO().getListaMarcadores().get(posicionArrayList)
								.getFecha().getMonth())
						&& dateUno.parse(fecha).getYear() == (apuestas.getMarcadoresDAO().getListaMarcadores()
								.get(posicionArrayList).getFecha().getYear())) {
					salidaDatosClientes[i][0] = dateUno
							.format(apuestas.getMarcadoresDAO().getListaMarcadores().get(posicionArrayList).getFecha());
					salidaDatosClientes[cont][1] = apuestas.getMarcadoresDAO().getListaMarcadores().get(posicionArrayList)
							.getNombreSede();
					salidaDatosClientes[cont][2] = apuestas.getMarcadoresDAO().getListaMarcadores().get(posicionArrayList)
							.getCedula();
					salidaDatosClientes[cont][3] = aux[0];
					salidaDatosClientes[cont][4] = aux[1];
					salidaDatosClientes[cont][5] = aux[2];
					cont++;
				}
				posicionArrayList++;

			} else if (tipoFiltro.equals("año")) {
				if (dateUno.parse(fecha)
						.equals(apuestas.getMarcadoresDAO().getListaMarcadores().get(posicionArrayList).getFecha())) {
					salidaDatosClientes[cont][0] = dateUno
							.format(apuestas.getMarcadoresDAO().getListaMarcadores().get(posicionArrayList).getFecha());
					salidaDatosClientes[cont][1] = apuestas.getMarcadoresDAO().getListaMarcadores().get(posicionArrayList)
							.getNombreSede();
					salidaDatosClientes[cont][2] = apuestas.getMarcadoresDAO().getListaMarcadores().get(posicionArrayList)
							.getCedula();
					salidaDatosClientes[cont][3] = aux[0];
					salidaDatosClientes[cont][4] = aux[1];
					salidaDatosClientes[cont][5] = aux[2];
					cont++;
				}
				posicionArrayList++;
			}
		}
		String[][] salidaSinNull = new String[cont][6];
		for (int j = 0; j < cont; j++) {
			if (salidaDatosClientes[j][0] != null) {
				salidaSinNull[j] = salidaDatosClientes[j];
			}
		}
		return salidaSinNull;
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
		for (int i = 0; i < arregloSedes.length; i++) {
			salida[i][0] = String.valueOf(valorTotalSedes[i]);
			salida[i][1] = "" + (i + 1);
			salida[i][2] = arregloSedes[i];
		}
		return salida;
	}

	private String[] buscarDatosApostador(String cedula) {
		String[] salida = new String[3];
		for (int i = 0; i < this.apostadores.getApostadorDao().getListaApostador().size(); i++) {
			if (cedula.equals(this.apostadores.getApostadorDao().getListaApostador().get(i).getCedula())) {
				salida[0] = this.apostadores.getApostadorDao().getListaApostador().get(i).getNombre();
				salida[1] = this.apostadores.getApostadorDao().getListaApostador().get(i).getCelular();
				salida[2] = this.apostadores.getApostadorDao().getListaApostador().get(i).getDireccion();
			}

		}
		return salida;

	}

	public boolean generarInformacionPdf(String tipoReporte, String fecha, String tipoFiltro) throws ParseException {
		String[][] datos = this.apuestas.quicksortRecursivo(this.generarDatosPDFClientes(fecha, tipoFiltro));
		if (datos.length > 0) {
			archivoPDF.exportar(datos, tipoReporte);
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
	public Long getPresupuestoTotal() {
		return presupuestoTotal;
	}

	/**
	 * @param presupuestoTotal the presupuestoTotal to set
	 */
	public void setPresupuestoTotal(Long presupuestoTotal) {
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
