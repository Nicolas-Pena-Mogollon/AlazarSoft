package co.edu.unbosque.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import co.edu.unbosque.model.persistence.ArchivoConfiguracionCasaApuestas;
import co.edu.unbosque.model.persistence.ArchivoPDF;

public class CasaDeApuestas {

	private Apostador apostadores;
	private Sede sede;
	private Apuesta apuestas;
	private String nombreCasaApuestas;
	private int numeroSedes;
	private Long presupuestoTotal;
	private ArchivoConfiguracionCasaApuestas archivoConfiguracionCasaApuestas;
	private ArchivoPDF archivoPDF;

	public CasaDeApuestas() {
		this.archivoConfiguracionCasaApuestas = new ArchivoConfiguracionCasaApuestas();
		this.apostadores = new Apostador();
		this.apuestas = new Apuesta();
		this.sede = new Sede();
		this.archivoPDF = new ArchivoPDF();
	}

//Falta Condicional para campos vacios
	public void guardarConfiguracionCasaDeApuestas(String nombre, int numeroSedes, Long presupuestoTotal) {
		this.nombreCasaApuestas = nombre;
		this.numeroSedes = numeroSedes;
		this.presupuestoTotal = presupuestoTotal;

		String[] datos = { nombre, String.valueOf(numeroSedes), String.valueOf(presupuestoTotal) };
		archivoConfiguracionCasaApuestas.escribirConfiguracionCasaApuestas(datos);
	}

	public String[][] generarDatosPDFClientes(String fecha, String tipoFiltro) throws ParseException {
		String[][] salida = new String[apuestas.getBalotoDAO().getListaBaloto().size()
				+ apuestas.getSuperastroDAO().getListaSuperastro().size()
				+ apuestas.getMarcadoresDAO().getListaMarcadores().size()][6];
		SimpleDateFormat dateUno = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat dateDos = new SimpleDateFormat("MM/yyyy");
		SimpleDateFormat dateTres = new SimpleDateFormat("yyyy");

		String[] aux = new String[3];
		for (int i = 0; i < apuestas.getBalotoDAO().getListaBaloto().size(); i++) {
			aux = buscarDatosApostador(apuestas.getBalotoDAO().getListaBaloto().get(i).getCedula());
			if (tipoFiltro.equals("día, mes y año")) {
				if (dateUno.parse(fecha)
						.getDay() == (apuestas.getBalotoDAO().getListaBaloto().get(i).getFecha().getDay())
						&& dateUno.parse(fecha)
								.getMonth() == (apuestas.getBalotoDAO().getListaBaloto().get(i).getFecha().getMonth())
						&& dateUno.parse(fecha)
								.getYear() == (apuestas.getBalotoDAO().getListaBaloto().get(i).getFecha().getYear())) {
					salida[i][0] = dateUno.format(apuestas.getBalotoDAO().getListaBaloto().get(i).getFecha());
					salida[i][1] = apuestas.getBalotoDAO().getListaBaloto().get(i).getNombreSede();
					salida[i][2] = apuestas.getBalotoDAO().getListaBaloto().get(i).getCedula();
					salida[i][3] = aux[0];
					salida[i][4] = aux[1];
					salida[i][5] = aux[2];
				}
			} else if (tipoFiltro.equals("mes y año")) {
				if (dateDos.parse(fecha)
						.getMonth() == (apuestas.getBalotoDAO().getListaBaloto().get(i).getFecha().getMonth())
						&& dateDos.parse(fecha)
								.getYear() == (apuestas.getBalotoDAO().getListaBaloto().get(i).getFecha().getYear())) {
					salida[i][0] = dateDos.format(apuestas.getBalotoDAO().getListaBaloto().get(i).getFecha());
					salida[i][1] = apuestas.getBalotoDAO().getListaBaloto().get(i).getNombreSede();
					salida[i][2] = apuestas.getBalotoDAO().getListaBaloto().get(i).getCedula();
					salida[i][3] = aux[0];
					salida[i][4] = aux[1];
					salida[i][5] = aux[2];
				}
			} else if (tipoFiltro.equals("año")) {
				if (dateTres.parse(fecha)
						.getYear() == (apuestas.getBalotoDAO().getListaBaloto().get(i).getFecha().getYear())) {
					salida[i][0] = dateTres.format(apuestas.getBalotoDAO().getListaBaloto().get(i).getFecha());
					salida[i][1] = apuestas.getBalotoDAO().getListaBaloto().get(i).getNombreSede();
					salida[i][2] = apuestas.getBalotoDAO().getListaBaloto().get(i).getCedula();
					salida[i][3] = aux[0];
					salida[i][4] = aux[1];
					salida[i][5] = aux[2];
				}
			}

		}

		int cont = 0;
		for (int i = apuestas.getBalotoDAO().getListaBaloto().size(); i < salida.length
				- apuestas.getMarcadoresDAO().getListaMarcadores().size(); i++) {
			aux = buscarDatosApostador(apuestas.getSuperastroDAO().getListaSuperastro().get(i).getCedula());
			if (tipoFiltro.equals("día, mes y año")) {
				if (dateUno.parse(fecha)
						.getDay() == (apuestas.getSuperastroDAO().getListaSuperastro().get(i).getFecha().getDay())
						&& dateUno.parse(fecha)
								.getMonth() == (apuestas.getSuperastroDAO().getListaSuperastro().get(i).getFecha().getMonth())
						&& dateUno.parse(fecha)
								.getYear() == (apuestas.getSuperastroDAO().getListaSuperastro().get(i).getFecha().getYear())) {
					salida[i][0] = dateUno.format(apuestas.getSuperastroDAO().getListaSuperastro().get(i).getFecha());
					salida[i][1] = apuestas.getSuperastroDAO().getListaSuperastro().get(i).getNombreSede();
					salida[i][2] = apuestas.getSuperastroDAO().getListaSuperastro().get(i).getCedula();
					salida[i][3] = aux[0];
					salida[i][4] = aux[1];
					salida[i][5] = aux[2];
				}
			} else if (tipoFiltro.equals("mes y año")) {
				if (dateDos.parse(fecha)
						.getMonth() == (apuestas.getSuperastroDAO().getListaSuperastro().get(i).getFecha().getMonth())
						&& dateDos.parse(fecha)
								.getYear() == (apuestas.getSuperastroDAO().getListaSuperastro().get(i).getFecha().getYear())) {
					salida[i][0] = dateDos.format(apuestas.getSuperastroDAO().getListaSuperastro().get(i).getFecha());
					salida[i][1] = apuestas.getSuperastroDAO().getListaSuperastro().get(i).getNombreSede();
					salida[i][2] = apuestas.getSuperastroDAO().getListaSuperastro().get(i).getCedula();
					salida[i][3] = aux[0];
					salida[i][4] = aux[1];
					salida[i][5] = aux[2];
				}
			} else if (tipoFiltro.equals("año")) {
				if (dateTres.parse(fecha)
						.getYear() == (apuestas.getSuperastroDAO().getListaSuperastro().get(i).getFecha().getYear())) {
					salida[i][0] = dateTres.format(apuestas.getSuperastroDAO().getListaSuperastro().get(i).getFecha());
					salida[i][1] = apuestas.getSuperastroDAO().getListaSuperastro().get(i).getNombreSede();
					salida[i][2] = apuestas.getSuperastroDAO().getListaSuperastro().get(i).getCedula();
					salida[i][3] = aux[0];
					salida[i][4] = aux[1];
					salida[i][5] = aux[2];
				}
			}

		}
		cont = 0;
		for (int i = salida.length - apuestas.getMarcadoresDAO().getListaMarcadores().size(); i < salida.length; i++) {
			aux = buscarDatosApostador(apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getCedula());
			if (tipoFiltro.equals("día, mes y año")) {
				if (dateUno.parse(fecha)
						.getDay() == (apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getFecha().getDay())
						&& dateUno.parse(fecha)
								.getMonth() == (apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getFecha().getMonth())
						&& dateUno.parse(fecha)
								.getYear() == (apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getFecha().getYear())) {
					salida[i][0] = dateUno.format(apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getFecha());
					salida[i][1] = apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getNombreSede();
					salida[i][2] = apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getCedula();
					salida[i][3] = aux[0];
					salida[i][4] = aux[1];
					salida[i][5] = aux[2];
				}
			} else if (tipoFiltro.equals("mes y año")) {
				if (dateDos.parse(fecha)
						.getMonth() == (apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getFecha().getMonth())
						&& dateDos.parse(fecha)
								.getYear() == (apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getFecha().getYear())) {
					salida[i][0] = dateDos.format(apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getFecha());
					salida[i][1] = apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getNombreSede();
					salida[i][2] = apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getCedula();
					salida[i][3] = aux[0];
					salida[i][4] = aux[1];
					salida[i][5] = aux[2];
				}
			} else if (tipoFiltro.equals("año")) {
				if (dateTres.parse(fecha)
						.getYear() == (apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getFecha().getYear())) {
					salida[i][0] = dateTres.format(apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getFecha());
					salida[i][1] = apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getNombreSede();
					salida[i][2] = apuestas.getMarcadoresDAO().getListaMarcadores().get(i).getCedula();
					salida[i][3] = aux[0];
					salida[i][4] = aux[1];
					salida[i][5] = aux[2];
				}
			}

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

//	public void generarInformacionPdf(String tipoReporte) throws ParseException {
//		archivoPDF.exportar(this.apuestas.quicksortRecursivo(this.generarDatosPDFClientes()), tipoReporte);
//	}

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

}
