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
	private Long presupuestoTotal;
	private ArchivoConfiguracionCasaApuestas archivoConfiguracionCasaApuestas;
	private ArchivoPDF archivoPDF;
	private ArchivoExcel archivoExcel;
	private Juego juego;
	private LecturaTxt planesPremiacion;
	private Informe informe;

	public CasaDeApuestas() {
		this.archivoConfiguracionCasaApuestas = new ArchivoConfiguracionCasaApuestas();
		this.apostadores = new Apostador();
		this.apuestas = new Apuesta();
		this.sede = new Sede();
		this.juego = new Juego();
		this.planesPremiacion = new LecturaTxt();
		this.informe = new Informe("", "", null);
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

	public boolean exportarInformePDF(){
		this.archivoPDF = new ArchivoPDF();
		try {
			archivoPDF.exportar(informe);
			return true;
		} catch (Exception e) {
			return false;
		}
}
	
	public boolean exportarInformeEXCEL(){
		this.archivoExcel = new ArchivoExcel();
		try {
			archivoExcel.exportar(informe);
			return true;
		} catch (Exception e) {
			return false;
		}
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

	public Informe getInforme() {
		return informe;
	}

	public void setInforme(Informe informe) {
		this.informe = informe;
	}

	public void borrarInforme() {
		this.informe.setTitulo("");
		this.informe.setDesccripción("");
		this.informe.setTablaDatos(null);
	}
	
}
