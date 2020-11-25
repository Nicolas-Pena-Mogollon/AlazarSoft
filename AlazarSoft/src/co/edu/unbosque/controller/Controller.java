package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import co.edu.unbosque.model.CasaDeApuestas;
import co.edu.unbosque.model.CedulaException;
import co.edu.unbosque.model.CelularException;
import co.edu.unbosque.model.persistence.SedesDTO;
import co.edu.unbosque.view.View;

public class Controller implements ActionListener {

	private CasaDeApuestas casaApuestas;
	private View vista;

	public Controller() {
		casaApuestas = new CasaDeApuestas();
		vista = new View(this);
		vista.getPanelApostadores().getPanelCrearApostador()
				.cargarComboBox(this.casaApuestas.getSede().getSedesDao().leerSede());
		vista.getPanelApostadores().getPanelActualizarBorrarApostador()
				.cargarComboBox(this.casaApuestas.getSede().getSedesDao().leerSede());
		vista.getPanelApuestas().getPanelCrearApuesta()
				.cargarComboBox(this.casaApuestas.getSede().getSedesDao().leerSede());
		vista.getPanelSede().getPanelSedeModificar().cargarCombo(this.casaApuestas.getSede().getSedesDao().leerSede());
		vista.getPanelApuestas().getPanelModificarApuesta()
				.cargarComboBox(this.casaApuestas.getSede().getSedesDao().leerSede());
		vista.getPanelApuestas().getPanelMostrarBorrarApuesta().llenarComboSedes(casaApuestas.getSede().obtenerSedes());
		vista.getPanelApuestas().getPanelCrearApuesta().getCampoTextoFecha()
				.setText(vista.getPanelApuestas().getPanelCrearApuesta().hora());
		vista.getPanelApuestas().getPanelCrearApuesta().getPanelApuestaFutbol()
				.cargarCombo(this.casaApuestas.getSede().cargarPartido());
		vista.getPanelPremiacion().llenarInformacion(casaApuestas.getPlanesPremiacion().leerArchivo());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ((casaApuestas.getNombreCasaApuestas() != null && casaApuestas.getNumeroSedes() != 0
				&& casaApuestas.getPresupuestoTotal() != 0)
				|| e.getActionCommand()
						.equals(vista.getPanelCasaApuestas().getPanelIngresoCasaApuestas().getCOMMAND_INGRESAR())) {
			if (e.getActionCommand()
					.equals(vista.getPanelMenuCasaApuestas().getCOMMAND_CONFIGURACION_CASA_APUESTAS())) {
				vista.getSplitPane().setRightComponent(vista.getPanelCasaApuestas());
			} else if (e.getActionCommand().equals(vista.getPanelMenuCasaApuestas().getCOMMAND_GESTION_SEDES())) {
				vista.getSplitPane().setRightComponent(vista.getPanelSede());
			} else if (e.getActionCommand().equals(vista.getPanelMenuCasaApuestas().getCOMMAND_GESTION_APOSTADORES())) {
				vista.getSplitPane().setRightComponent(vista.getPanelApostadores());
			} else if (e.getActionCommand().equals(vista.getPanelMenuCasaApuestas().getCOMMAND_GESTION_APUESTAS())) {
				vista.getSplitPane().setRightComponent(vista.getPanelApuestas());
			} else if (e.getActionCommand().equals(vista.getPanelMenuCasaApuestas().getCOMMAND_PLANES_PREMIACION())) {
				vista.getSplitPane().setRightComponent(vista.getPanelPremiacion());
			} else if (e.getActionCommand().equals(vista.getPanelMenuCasaApuestas().getCOMMAND_CONSULTA_REPORTES())) {
				vista.getSplitPane().setRightComponent(vista.getPanelConsultasReportes());
			} else if (e.getActionCommand()
					.equals(vista.getPanelApuestas().getPanelCrearApuesta().getCOMMAND_CAMBIAR_TIPO_APUESTA())) {
				vista.getPanelApuestas().getPanelCrearApuesta().cambiarPanel();
			} else if (e.getActionCommand()
					.equals(vista.getPanelCasaApuestas().getPanelIngresoCasaApuestas().getCOMMAND_INGRESAR())) {
				this.gestionarConfiguracionCasaApuestas();
			} else if (e.getActionCommand().equals(vista.getPanelSede().getPanelSedeCrear().getCOMMAND_GUARDAR())) {
				this.gestionarSedes();
			} else if (e.getActionCommand()
					.equals(vista.getPanelApostadores().getPanelCrearApostador().getCOMMAND_CREAR_APOSTADOR())) {
				this.gestionarApostadoresRegistro();
			} else if (e.getActionCommand()
					.equals(vista.getPanelApostadores().getPanelActualizarBorrarApostador().getCOMMAND_BORRAR())) {
				this.gestionarApostadoresEliminar();
			} else if (e.getActionCommand()
					.equals(vista.getPanelApostadores().getPanelActualizarBorrarApostador().getCOMMAND_ACTUALIZAR())) {
				this.gestionarApostadoresActualizar();
			} else if (e.getActionCommand().equals(vista.getPanelApostadores().getPanelInformacionApostadores()
					.getCOMMAND_LEER_INFORMACION_APOSTADORES())) {
				vista.getPanelApostadores().getPanelInformacionApostadores()
						.actualizarTablaApostadores(casaApuestas.getApostadores().generarTablaApostador());
			} else if (e.getActionCommand()
					.equals(vista.getPanelApuestas().getPanelCrearApuesta().getCOMMAND_REGISTRAR_APUESTA())) {
				String apuesta = vista.getPanelApuestas().getPanelCrearApuesta().getComboTiposApuesta()
						.getSelectedItem().toString();
				if (apuesta.equals("Baloto")) {
					this.gestionarApuestasBaloto();
				} else if (apuesta.equals("Super Astro")) {
					this.gestionarApuestasSuperastro();
				} else if (apuesta.equals("Fútbol")) {
					this.gestionarApuestasFutbol();
				} else if (apuesta.equals("Seleccione el tipo de apuesta")) {
					vista.mostrarMensajeError("Escoja el tipo de apuesta");
				}
			} else if (e.getActionCommand()
					.equals(vista.getPanelApuestas().getPanelModificarApuesta().getCOMMAND_MODIFICAR_APUESTA())) {
				String apuesta = vista.getPanelApuestas().getPanelModificarApuesta().getComboTiposApuesta()
						.getSelectedItem().toString();
				if (apuesta.equals("Baloto")) {
					this.gestionarApuestasBalotoModificar();
				} else if (apuesta.equals("Super Astro")) {
					this.gestionarApuestasSuperastroModificar();
				} else if (apuesta.equals("Fútbol")) {
					this.gestionarApuestasMarcadoresModificar();
				} else if (apuesta.equals("Seleccione el tipo de apuesta")) {
					vista.mostrarMensajeError("Escoja el tipo de apuesta");
				}
			} else if (e.getActionCommand().equals(
					vista.getPanelApuestas().getPanelMostrarBorrarApuesta().getCOMMAND_LEER_INFORMACION_APUESTAS())) {
				if (vista.getPanelApuestas().getPanelMostrarBorrarApuesta().verificarDatos()) {
					vista.getPanelApuestas().getPanelMostrarBorrarApuesta()
							.actualizarTablaApuestas(casaApuestas.getApuestas().generarTablaApuestas(
									vista.getPanelApuestas().getPanelMostrarBorrarApuesta().getComboTipoApuesta()
											.getSelectedItem().toString(),
									vista.getPanelApuestas().getPanelMostrarBorrarApuesta().getComboSede()
											.getSelectedItem().toString()));
				} else {
					vista.mostrarMensajeError("Se deben escoger todas las opciones");
				}
			} else if (e.getActionCommand().equals(
					vista.getPanelApuestas().getPanelMostrarBorrarApuesta().getCOMMAND_BORRAR_INFORMACION_APUESTAS())) {
				this.gestionarBorrarApuesta();
			} else if (e.getActionCommand()
					.equals(vista.getPanelSede().getPanelSedeModificar().getCOMMAND_ACTUALIZAR_SEDE())) {
				this.gestionarSedesActualizar();
			} else if (e.getActionCommand()
					.equals(vista.getPanelConsultasReportes().getPanelExportarInformacion().getCOMMAND_EXPORTARPDF())) {
				try {
					boolean resultado = casaApuestas.exportar(
							vista.getPanelConsultasReportes().getPanelExportarInformacion().getComboOpcionExportar()
									.getSelectedItem().toString(),
							vista.getPanelConsultasReportes().getPanelExportarInformacion().getCampoTextoFecha()
									.getText(),
							vista.getPanelConsultasReportes().getPanelExportarInformacion().getComboFiltroFecha()
									.getSelectedItem().toString(),
							"PDF");
					if (resultado) {
						vista.mostrarMensajeInformacion("Se ha generado el archivo PDF");
					} else {
						vista.mostrarMensajeInformacion("No hay información para mostrar");
					}
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					vista.mostrarMensajeError("No se pudo exportar el PDF" + "\n" + e1);
				}
			} else if (e.getActionCommand().equals(
					vista.getPanelConsultasReportes().getPanelExportarInformacion().getCOMMAND_EXPORTAREXCEL())) {

				try {
					boolean resultado = casaApuestas.exportar(
							vista.getPanelConsultasReportes().getPanelExportarInformacion().getComboOpcionExportar()
									.getSelectedItem().toString(),
							vista.getPanelConsultasReportes().getPanelExportarInformacion().getCampoTextoFecha()
									.getText(),
							vista.getPanelConsultasReportes().getPanelExportarInformacion().getComboFiltroFecha()
									.getSelectedItem().toString(),
							"EXCEL");
					if (resultado) {
						vista.mostrarMensajeInformacion("Se ha generado el archivo Excel");
					} else {
						vista.mostrarMensajeInformacion("No hay información para mostrar");
					}
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					vista.mostrarMensajeError("No se pudo exportar el PDF" + "\n" + e1);
				}

			} else if (e.getActionCommand().equals(
					vista.getPanelConsultasReportes().getPanelHistoricoVentas().getCOMMAND_HISTORICO_VENTAS())) {
				String[][] data = casaApuestas
						.quitarCamposNull(casaApuestas.getApuestas().obtenerInformacionHistoricoVentas());
				if (data.length != 0) {
					vista.getPanelConsultasReportes().getPanelHistoricoVentas().recibirInfomacion(data);
				} else {
					vista.mostrarMensajeError("No hay información para mostrar");
				}
			} else if (e.getActionCommand().equals(vista.getPanelConsultasReportes().getPanelGraficoVentasSedes()
					.getCOMMAND_GRAFICA_SEDES_MAYORES_VENTAS())) {
				String[][] data = casaApuestas.obtenerCincoSedesConMayorVenta();
				if (data.length != 0) {
					vista.getPanelConsultasReportes().getPanelGraficoVentasSedes().recibirInfomacion(data);
				} else {
					vista.mostrarMensajeError("No hay información para mostrar");
				}
			} else if (e.getActionCommand()
					.equals(vista.getPanelCasaApuestas().getPanelDatosJuegos().getCOMMAND_REGISTRAR_DATOS_JUEGO())) {
				this.gestionarJuegos();
			} else if (e.getActionCommand().equals(
					vista.getPanelConsultasReportes().getPanelExportarInformacion().getCOMMAND_MOSTRARTABLA())) {
				String opcionReporte = vista.getPanelConsultasReportes().getPanelExportarInformacion()
						.getComboOpcionExportar().getSelectedItem().toString();
				if (!opcionReporte.equals("Seleccione")
						&& !vista.getPanelConsultasReportes().getPanelExportarInformacion().getComboFiltroFecha()
								.getSelectedItem().toString().equals("Seleccione")) {
					try {
						String[][] data = casaApuestas.generarInformacionReportesPantalla(
								vista.getPanelConsultasReportes().getPanelExportarInformacion().getComboOpcionExportar()
										.getSelectedItem().toString(),
								vista.getPanelConsultasReportes().getPanelExportarInformacion().getCampoTextoFecha()
										.getText(),
								vista.getPanelConsultasReportes().getPanelExportarInformacion().getComboFiltroFecha()
										.getSelectedItem().toString());
						vista.getPanelConsultasReportes().getPanelExportarInformacion()
								.cargarReporteTabla(casaApuestas.obtenerTitulosReportes(opcionReporte), data);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						vista.mostrarMensajeError("No se pudo acceder a la información" + "\n" + e1);
					}
				} else {
					vista.mostrarMensajeError("Complete los campos");
				}
			} else if (e.getActionCommand().equals(vista.getPanelConsultasReportes().getPanelGraficaClientes()
					.getCOMMAND_GRAFICA_CLIENTES_MAYORES_APUESTAS())) {
				String[][] data = casaApuestas.generarCincoClientesMayoresApuestas();
				if (data.length != 0) {
					vista.getPanelConsultasReportes().getPanelGraficaClientes().recibirInfomacion(data);
				} else {
					vista.mostrarMensajeError("No hay información para mostrar");
				}
			} else if (e.getActionCommand().equals(
					vista.getPanelConsultasReportes().getPanelGraficoApuestas().getCOMMAND_GRAFICA_APUESTAS())) {
				String[][] data = casaApuestas.generarTresTiposApuestaMayoresGanadores();
				if (data.length != 0) {
					vista.getPanelConsultasReportes().getPanelGraficoApuestas().recibirInfomacion(data);
				} else {
					vista.mostrarMensajeError("No hay información para mostrar");
				}
			}
		} else {
			vista.mostrarMensajeError("Debe registrar los datos de la casa de apuestas");
		}
	}

	public void gestionarConfiguracionCasaApuestas() {
		String[] entradas = vista.getPanelCasaApuestas().getPanelIngresoCasaApuestas()
				.verificarEntradasIngresoDatosJuegos();
		if (entradas[0].equals("0")) {
			casaApuestas.guardarConfiguracionCasaDeApuestas(entradas[1], Integer.parseInt(entradas[2]),
					Double.parseDouble(entradas[3]));
			vista.mostrarMensajeInformacion(entradas[4]);
		} else {
			vista.mostrarMensajeError(entradas[1]);
		}
		vista.getPanelCasaApuestas().getPanelIngresoCasaApuestas().borrarCamposIngresoCasaApuestas();
	}

	public void gestionarApostadoresRegistro() {
		if (vista.getPanelApostadores().getPanelCrearApostador().verificarCamposVacios()) {
			String sede = vista.getPanelApostadores().getPanelCrearApostador().getComboSede().getSelectedItem()
					.toString();
			String cedula = vista.getPanelApostadores().getPanelCrearApostador().getCampoTextoCedula().getText();
			String nombre = vista.getPanelApostadores().getPanelCrearApostador().getCampoTextoNombre().getText();
			String direccion = vista.getPanelApostadores().getPanelCrearApostador().getCampoTextoDireccion().getText();
			String celular = vista.getPanelApostadores().getPanelCrearApostador().getCampoTextoCelular().getText();
			try {
				casaApuestas.getApostadores().verificarCedula(cedula);
				casaApuestas.getApostadores().verificarCelular(celular);
				if (casaApuestas.getApostadores().getApostadorDao().verificarNumeroTelefonico(
						casaApuestas.getApostadores().getApostadorDao().getListaApostador(), celular)) {
					vista.mostrarMensajeError("El número telefónico ya se encuentra registrado");
				} else {
					if (casaApuestas.getApostadores().getApostadorDao().agregarApostador(nombre, cedula, sede,
							direccion, celular)) {
						vista.mostrarMensajeInformacion("Registro correcto");
						vista.getPanelApostadores().getPanelCrearApostador()
								.cargarComboBox(this.casaApuestas.getSede().getSedesDao().leerSede());
						vista.getPanelApostadores().getPanelCrearApostador().limpiarCampos();
						vista.getPanelApostadores().getPanelActualizarBorrarApostador()
								.cargarComboBox(this.casaApuestas.getSede().getSedesDao().leerSede());
						vista.getPanelApuestas().getPanelCrearApuesta()
								.cargarComboBox(this.casaApuestas.getSede().getSedesDao().leerSede());
					} else {
						vista.mostrarMensajeError("El número de cedula ya se encuentra registrado");
					}
				}
			} catch (CedulaException e) {
				vista.mostrarMensajeError(e.getMessage());
			} catch (CelularException e) {
				vista.mostrarMensajeError(e.getMessage());
			}
		} else {
			vista.mostrarMensajeError("Verifique los campos");
		}

	}

	public void gestionarApostadoresEliminar() {

		String cedula = vista.getPanelApostadores().getPanelActualizarBorrarApostador().getCampoTextoCedula().getText();
		try {
			this.casaApuestas.getApostadores().verificarCedula(cedula);
			if (casaApuestas.getApostadores().getApostadorDao().eliminarApostador(cedula)) {
				vista.mostrarMensajeInformacion("Se ha eliminado correctamente");
				vista.getPanelApostadores().getPanelCrearApostador()
						.cargarComboBox(this.casaApuestas.getSede().getSedesDao().leerSede());
				vista.getPanelApostadores().getPanelActualizarBorrarApostador().borrarCampos();
				vista.getPanelApostadores().getPanelActualizarBorrarApostador()
						.cargarComboBox(this.casaApuestas.getSede().getSedesDao().leerSede());
				vista.getPanelApuestas().getPanelCrearApuesta()
						.cargarComboBox(this.casaApuestas.getSede().getSedesDao().leerSede());
			} else {
				vista.mostrarMensajeError("El apostador no se encuentra registrado");
			}
		} catch (CedulaException e) {
			vista.mostrarMensajeError(e.getMessage());
		}

	}

	public void gestionarApostadoresActualizar() {
		String[] entradas = vista.getPanelApostadores().getPanelActualizarBorrarApostador()
				.verificarEntradasActualizarInformacionApostador();
		if (entradas[0].equals("0")) {
			try {
				casaApuestas.getApostadores().verificarCelular(entradas[3]);
				if (casaApuestas.getApostadores().getApostadorDao().editarApostador(entradas[5], entradas[1],
						entradas[4], entradas[2], entradas[3])) {
					vista.mostrarMensajeInformacion("Se ha editado correctamente");
					vista.getPanelApostadores().getPanelActualizarBorrarApostador().borrarCampos();
				} else {
					vista.mostrarMensajeError("El apostador no se encuentra registrado");
				}
			} catch (CelularException e) {
				vista.mostrarMensajeError(e.getMessage());
			}
		} else {
			vista.mostrarMensajeError(entradas[1]);
		}

	}

	public void gestionarApuestasBaloto() {
		vista.getPanelApuestas().getPanelCrearApuesta().getCampoTextoFecha()
				.setText(vista.getPanelApuestas().getPanelCrearApuesta().hora());
		if (vista.getPanelApuestas().getPanelCrearApuesta().verificarCamposBaloto()) {

			SimpleDateFormat formato = new SimpleDateFormat("hh: mm: ss a dd/MM/yyyy");
			String fechaString = vista.getPanelApuestas().getPanelCrearApuesta().getCampoTextoFecha().getText();
			try {
				Date fecha = formato.parse(fechaString);
				String sede = vista.getPanelApuestas().getPanelCrearApuesta().getComboSede().getSelectedItem()
						.toString();
				String cedula = vista.getPanelApuestas().getPanelCrearApuesta().getCampoTextoCedula().getText();
				if (casaApuestas.getApostadores().getApostadorDao().buscarApostador(cedula) != null) {
					try {
						double valorApuesta = Double.parseDouble(
								vista.getPanelApuestas().getPanelCrearApuesta().getCampoTextoValorApuesta().getText());
						int primerNumero = Integer.parseInt(vista.getPanelApuestas().getPanelCrearApuesta()
								.getPanelApuestaBaloto().getCampoTextoPrimerNumero().getText());
						int segundoNumero = Integer.parseInt(vista.getPanelApuestas().getPanelCrearApuesta()
								.getPanelApuestaBaloto().getCampoTextoSegundoNumero().getText());
						int tercerNumero = Integer.parseInt(vista.getPanelApuestas().getPanelCrearApuesta()
								.getPanelApuestaBaloto().getCampoTextoTercerNumero().getText());
						int cuartoNumero = Integer.parseInt(vista.getPanelApuestas().getPanelCrearApuesta()
								.getPanelApuestaBaloto().getCampoTextoCuartoNumero().getText());
						int quintoNumero = Integer.parseInt(vista.getPanelApuestas().getPanelCrearApuesta()
								.getPanelApuestaBaloto().getCampoTextoQuintoNumero().getText());
						int sextoNumero = Integer.parseInt(vista.getPanelApuestas().getPanelCrearApuesta()
								.getPanelApuestaBaloto().getCampoTextoSextoNumero().getText());
						String numeroJuego = primerNumero + "-" + segundoNumero + "-" + tercerNumero + "-"
								+ cuartoNumero + "-" + quintoNumero + "-" + sextoNumero;
						if (this.casaApuestas.getApuestas().verificarNumerosIgualesBaloto(primerNumero, segundoNumero,
								tercerNumero, cuartoNumero, quintoNumero, sextoNumero)) {
							vista.mostrarMensajeError("Los números no se pueden repetir");
						} else {
							if (!this.casaApuestas.getApuestas().verificarRangoNumerosBaloto(primerNumero,
									segundoNumero, tercerNumero, cuartoNumero, quintoNumero, sextoNumero)) {
								if (valorApuesta < 0) {
									vista.mostrarMensajeError("No puede ingresar números menores a cero");
								} else {
									if (this.casaApuestas.getApuestas().getBalotoDAO().crearApuestas(sede, cedula,
											fecha, valorApuesta, numeroJuego)) {
										vista.mostrarMensajeInformacion("Se ha agregado correctamente");
										vista.mostrarMensajeInformacion(vista.getPanelApuestas().getPanelCrearApuesta()
												.facturaBaloto(fechaString, sede, cedula, valorApuesta, numeroJuego));
										vista.getPanelApuestas().getPanelCrearApuesta().limpiarCamposBaloto();
									}
								}
							} else {
								vista.mostrarMensajeError("El rango de los números debe estar entre 1 - 45");
							}
						}
					} catch (NumberFormatException e) {
						vista.mostrarMensajeError("Ingresó un caracter no permitido para los números");
					}
				} else {
					vista.mostrarMensajeError("El apostador no se encuentra registrado");
				}
			} catch (ParseException e1) {
				vista.mostrarMensajeError("Error en fecha");
			}

		} else {
			vista.mostrarMensajeError("Campos necesarios");
		}
	}

	public void gestionarApuestasSuperastro() {
		vista.getPanelApuestas().getPanelCrearApuesta().getCampoTextoFecha()
				.setText(vista.getPanelApuestas().getPanelCrearApuesta().hora());
		if (vista.getPanelApuestas().getPanelCrearApuesta().verificarCamposSuperAstro()) {
			SimpleDateFormat formato = new SimpleDateFormat("hh: mm: ss a dd/MM/yyyy");
			String fechaString = vista.getPanelApuestas().getPanelCrearApuesta().getCampoTextoFecha().getText();
			try {
				Date fecha = formato.parse(fechaString);
				String sede = vista.getPanelApuestas().getPanelCrearApuesta().getComboSede().getSelectedItem()
						.toString();
				String cedula = vista.getPanelApuestas().getPanelCrearApuesta().getCampoTextoCedula().getText();
				if (casaApuestas.getApostadores().getApostadorDao().buscarApostador(cedula) != null) {
					try {
						double valorApuesta = Double.parseDouble(
								vista.getPanelApuestas().getPanelCrearApuesta().getCampoTextoValorApuesta().getText());
						int primerNumero = Integer.parseInt(vista.getPanelApuestas().getPanelCrearApuesta()
								.getPanelApuestaSuperAstro().getCampoTextoPrimerNumero().getText());
						int segundoNumero = Integer.parseInt(vista.getPanelApuestas().getPanelCrearApuesta()
								.getPanelApuestaSuperAstro().getCampoTextoSegundoNumero().getText());
						int tercerNumero = Integer.parseInt(vista.getPanelApuestas().getPanelCrearApuesta()
								.getPanelApuestaSuperAstro().getCampoTextoTercerNumero().getText());
						int cuartoNumero = Integer.parseInt(vista.getPanelApuestas().getPanelCrearApuesta()
								.getPanelApuestaSuperAstro().getCampoTextoCuartoNumero().getText());
						String numeroJuego = primerNumero + "-" + segundoNumero + "-" + tercerNumero + "-"
								+ cuartoNumero;
						String signo = vista.getPanelApuestas().getPanelCrearApuesta().getPanelApuestaSuperAstro()
								.getSignoZodiacal().getSelectedItem().toString();
						if (this.casaApuestas.getApuestas().verificarRangoNumerosSuperastro(primerNumero, segundoNumero,
								tercerNumero, cuartoNumero)) {

							vista.mostrarMensajeError("El rango de los números debe estar entre 0 - 9");
						} else {
							if (valorApuesta < 0) {
								vista.mostrarMensajeError("No puede ingresar números menores a cero");
							} else {
								if (this.casaApuestas.getApuestas().getSuperastroDAO().crearApuestas(sede, cedula,
										fecha, valorApuesta, numeroJuego, signo)) {
									vista.mostrarMensajeInformacion("Se ha agregado correctamente");
									vista.mostrarMensajeInformacion(
											vista.getPanelApuestas().getPanelCrearApuesta().facturaSuperastro(
													fechaString, sede, cedula, valorApuesta, numeroJuego, signo));
									vista.getPanelApuestas().getPanelCrearApuesta().limpiarCamposSuperAstro();
								}
							}
						}
					} catch (NumberFormatException e) {
						vista.mostrarMensajeError("Ingresó un caracter no permitido para los números");
					}
				} else {
					vista.mostrarMensajeError("El apostador no se encuentra registrado");
				}
			} catch (ParseException e1) {
				vista.mostrarMensajeError("Error en fecha");
			}

		} else {
			vista.mostrarMensajeError("Campos necesarios");
		}

	}

	public void gestionarApuestasFutbol() {
		vista.getPanelApuestas().getPanelCrearApuesta().getCampoTextoFecha()
				.setText(vista.getPanelApuestas().getPanelCrearApuesta().hora());
		if (vista.getPanelApuestas().getPanelCrearApuesta().verificarCamposFutbol()) {
			SimpleDateFormat formato = new SimpleDateFormat("hh: mm: ss a dd/MM/yyyy");
			String fechaString = vista.getPanelApuestas().getPanelCrearApuesta().getCampoTextoFecha().getText();
			try {
				Date fecha = formato.parse(fechaString);
				String sede = vista.getPanelApuestas().getPanelCrearApuesta().getComboSede().getSelectedItem()
						.toString();
				String cedula = vista.getPanelApuestas().getPanelCrearApuesta().getCampoTextoCedula().getText();
				if (casaApuestas.getApostadores().getApostadorDao().buscarApostador(cedula) != null) {
					try {
						double valorApuesta = Double.parseDouble(
								vista.getPanelApuestas().getPanelCrearApuesta().getCampoTextoValorApuesta().getText());
						String partido = vista.getPanelApuestas().getPanelCrearApuesta().getPanelApuestaFutbol()
								.getComboPartidos().getSelectedItem().toString();
						String resultado = vista.getPanelApuestas().getPanelCrearApuesta().getPanelApuestaFutbol()
								.getComboOpcionResultado().getSelectedItem().toString();
						if (valorApuesta < 0) {
							vista.mostrarMensajeError("No puede ingresar números menores a cero");
						} else {
							if (this.casaApuestas.getApuestas().getMarcadoresDAO().crearApuestas(sede, cedula, fecha,
									valorApuesta, partido, resultado)) {
								vista.mostrarMensajeInformacion("Se ha agregado correctamente");
								vista.mostrarMensajeInformacion(vista.getPanelApuestas().getPanelCrearApuesta()
										.facturaFutbol(fechaString, sede, cedula, valorApuesta, partido, resultado));
								vista.getPanelApuestas().getPanelCrearApuesta().limpiarCamposFutbol();
							}
						}
					} catch (NumberFormatException e) {
						vista.mostrarMensajeError("Ingresó un caracter no permitido para los números");
					}
				} else {
					vista.mostrarMensajeError("El apostador no se encuentra registrado");
				}
			} catch (ParseException e) {
				vista.mostrarMensajeError("Error en fecha");
			}

		} else {
			vista.mostrarMensajeError("Campos necesarios");
		}
	}

	public void gestionarSedes() {
		String[] entradas = vista.getPanelSede().getPanelSedeCrear().verificarEntradasIngresoSedes();
		if (entradas[0].equals("0")) {
			if (casaApuestas.getSede().getSedesDao().getDataSedes().size() < casaApuestas.getNumeroSedes()) {
				SedesDTO sede = new SedesDTO(this.casaApuestas.getSede().generarIdSede(), entradas[1],
						Integer.parseInt(entradas[2]));
				this.casaApuestas.getSede().getSedesDao().crearSede(sede);
				vista.mostrarMensajeInformacion("Se ha agregado la sede correctamente");
				vista.getPanelSede().getPanelSedeCrear().borrarCamposTxt();
				vista.getPanelApostadores().getPanelCrearApostador()
						.cargarComboBox(this.casaApuestas.getSede().getSedesDao().leerSede());
				vista.getPanelApostadores().getPanelActualizarBorrarApostador()
						.cargarComboBox(this.casaApuestas.getSede().getSedesDao().leerSede());
				vista.getPanelApuestas().getPanelMostrarBorrarApuesta()
						.llenarComboSedes(this.casaApuestas.getSede().obtenerSedes());
				vista.getPanelSede().getPanelSedeModificar()
						.cargarCombo(this.casaApuestas.getSede().getSedesDao().leerSede());
				vista.getPanelApuestas().getPanelModificarApuesta()
						.cargarComboBox(this.casaApuestas.getSede().getSedesDao().leerSede());
				vista.getPanelApuestas().getPanelMostrarBorrarApuesta()
						.llenarComboSedes(casaApuestas.getSede().obtenerSedes());
				vista.getPanelApuestas().getPanelCrearApuesta().getCampoTextoFecha()
						.setText(vista.getPanelApuestas().getPanelCrearApuesta().hora());
				vista.getPanelApostadores().getPanelCrearApostador()
						.cargarComboBox(casaApuestas.getSede().getSedesDao().leerSede());
			} else {
				vista.mostrarMensajeError("Ha excedido el número de sedes configurado");
			}
		} else {
			vista.mostrarMensajeError(entradas[1]);
		}
	}

	public void gestionarSedesActualizar() {
		String[] entradas = vista.getPanelSede().getPanelSedeModificar().verificarEntradasActualizarSedes();
		if (entradas[0].equals("0")) {
			String[] ubicacionConNombre = entradas[2].split("-");
			this.casaApuestas.getSede().getSedesDao().actualizarSede(Integer.parseInt(ubicacionConNombre[0]),
					Integer.parseInt(entradas[1]));
			vista.mostrarMensajeInformacion("Se ha editado correctamente");
			vista.getPanelSede().getPanelSedeModificar().borrarCampos();
			vista.getPanelSede().getPanelSedeModificar()
					.cargarCombo(this.casaApuestas.getSede().getSedesDao().leerSede());
			vista.getPanelApuestas().getPanelModificarApuesta()
					.cargarComboBox(this.casaApuestas.getSede().getSedesDao().leerSede());
			vista.getPanelApuestas().getPanelMostrarBorrarApuesta()
					.llenarComboSedes(casaApuestas.getSede().obtenerSedes());
			vista.getPanelApuestas().getPanelCrearApuesta().getCampoTextoFecha()
					.setText(vista.getPanelApuestas().getPanelCrearApuesta().hora());
			vista.getPanelSede().getPanelSedeModificar()
					.cargarCombo(this.casaApuestas.getSede().getSedesDao().leerSede());
			vista.getPanelApostadores().getPanelCrearApostador()
					.cargarComboBox(this.casaApuestas.getSede().getSedesDao().leerSede());
			vista.getPanelApostadores().getPanelActualizarBorrarApostador()
					.cargarComboBox(this.casaApuestas.getSede().getSedesDao().leerSede());
		} else {
			vista.mostrarMensajeError(entradas[1]);
		}
	}

	public void gestionarApuestasBalotoModificar() {
		if (this.vista.getPanelApuestas().getPanelModificarApuesta().verificarCampos()) {
			SimpleDateFormat formato = new SimpleDateFormat("hh: mm: ss a dd/MM/yyyy");
			String fechaString = vista.getPanelApuestas().getPanelModificarApuesta().getCampoTextoFecha().getText();
			try {
				Date fecha = formato.parse(fechaString);
				String sede = vista.getPanelApuestas().getPanelModificarApuesta().getComboSede().getSelectedItem()
						.toString();
				String cedula = vista.getPanelApuestas().getPanelModificarApuesta().getCampoTextoCedula().getText();
				try {
					double valorApuesta = Double.parseDouble(
							vista.getPanelApuestas().getPanelModificarApuesta().getCampoTextoValorApuesta().getText());
					if (this.casaApuestas.getApuestas().getBalotoDAO().editarApuesta(cedula, fecha, sede,
							valorApuesta)) {
						vista.mostrarMensajeInformacion("Se ha editado correctamente");
						vista.getPanelApuestas().getPanelModificarApuesta().limpiarCampos();
					} else {
						vista.mostrarMensajeError("El apostador no se encuentra registrado");
					}
				} catch (NumberFormatException e) {
					vista.mostrarMensajeError("Ingresó un caracter no permitido para los números");
				}

			} catch (ParseException e) {
				vista.mostrarMensajeError("Error en fecha");
			}
		} else {
			vista.mostrarMensajeError("Campos necesarios");
		}

	}

	public void gestionarApuestasSuperastroModificar() {
		if (this.vista.getPanelApuestas().getPanelModificarApuesta().verificarCampos()) {
			SimpleDateFormat formato = new SimpleDateFormat("hh: mm: ss a dd/MM/yyyy");
			String fechaString = vista.getPanelApuestas().getPanelModificarApuesta().getCampoTextoFecha().getText();
			try {
				Date fecha = formato.parse(fechaString);
				String sede = vista.getPanelApuestas().getPanelModificarApuesta().getComboSede().getSelectedItem()
						.toString();
				String cedula = vista.getPanelApuestas().getPanelModificarApuesta().getCampoTextoCedula().getText();
				try {
					double valorApuesta = Double.parseDouble(
							vista.getPanelApuestas().getPanelModificarApuesta().getCampoTextoValorApuesta().getText());
					if (this.casaApuestas.getApuestas().getSuperastroDAO().editarApuesta(cedula, fecha, sede,
							valorApuesta)) {
						vista.mostrarMensajeInformacion("Se ha editado correctamente");
						vista.getPanelApuestas().getPanelModificarApuesta().limpiarCampos();
					} else {
						vista.mostrarMensajeError("El apostador no se encuentra registrado");
					}
				} catch (NumberFormatException e) {
					vista.mostrarMensajeError("Ingresó un caracter no permitido para los números");
				}
			} catch (ParseException e) {
				vista.mostrarMensajeError("Error en fecha");
			}
		} else {
			vista.mostrarMensajeError("Campos necesarios");
		}

	}

	public void gestionarApuestasMarcadoresModificar() {
		if (this.vista.getPanelApuestas().getPanelModificarApuesta().verificarCampos()) {
			SimpleDateFormat formato = new SimpleDateFormat("hh: mm: ss a dd/MM/yyyy");
			String fechaString = vista.getPanelApuestas().getPanelModificarApuesta().getCampoTextoFecha().getText();
			try {
				Date fecha = formato.parse(fechaString);
				String sede = vista.getPanelApuestas().getPanelModificarApuesta().getComboSede().getSelectedItem()
						.toString();
				String cedula = vista.getPanelApuestas().getPanelModificarApuesta().getCampoTextoCedula().getText();
				try {
					double valorApuesta = Double.parseDouble(
							vista.getPanelApuestas().getPanelModificarApuesta().getCampoTextoValorApuesta().getText());
					if (this.casaApuestas.getApuestas().getMarcadoresDAO().editarApuesta(cedula, fecha, sede,
							valorApuesta)) {
						vista.mostrarMensajeInformacion("Se ha editado correctamente");
						vista.getPanelApuestas().getPanelModificarApuesta().limpiarCampos();
					} else {
						vista.mostrarMensajeError("El apostador no se encuentra registrado");
					}

				} catch (NumberFormatException e) {
					vista.mostrarMensajeError("Ingresó un caracter no permitido para los números");
				}
			} catch (ParseException e) {
				vista.mostrarMensajeError("Error en fecha");
			}
		} else {
			vista.mostrarMensajeError("Campos necesarios");
		}
	}

	public void gestionarBorrarApuesta() {
		if (vista.getPanelApuestas().getPanelMostrarBorrarApuesta().verificarDatosTabla() == 1) {
			String[] info = vista.getPanelApuestas().getPanelMostrarBorrarApuesta().obtenerDatosTabla();
			try {
				if (info[0].equals("0") && casaApuestas.getApuestas().borrarApuesta(String.valueOf(vista
						.getPanelApuestas().getPanelMostrarBorrarApuesta().getComboTipoApuesta().getSelectedItem()),
						info[1], info[2])) {
					vista.mostrarMensajeInformacion(info[3]);
				} else {
					vista.mostrarMensajeError(info[1]);
				}
			} catch (ParseException e) {
				vista.mostrarMensajeError("No se ha encontrado la apuesta");
			}
		} else if (vista.getPanelApuestas().getPanelMostrarBorrarApuesta().verificarDatosTabla() == 0) {
			vista.mostrarMensajeError("Los datos seleccionados no corresponden al tipo de apuesta");
		} else {
			vista.mostrarMensajeError("Seleccione al menos un dato");
		}
		this.vista.getPanelApuestas().getPanelMostrarBorrarApuesta()
				.actualizarTablaApuestas(casaApuestas.getApuestas().generarTablaApuestas(
						String.valueOf(vista.getPanelApuestas().getPanelMostrarBorrarApuesta().getComboTipoApuesta()
								.getSelectedItem()),
						String.valueOf(vista.getPanelApuestas().getPanelMostrarBorrarApuesta().getComboSede()
								.getSelectedItem())));
	}

	public void gestionarJuegos() {
		if (vista.getPanelCasaApuestas().getPanelDatosJuegos().verificarEntradas()) {
			String nombreJuego = vista.getPanelCasaApuestas().getPanelDatosJuegos().getComboNombreJuego()
					.getSelectedItem().toString();
			String tipoJuego = vista.getPanelCasaApuestas().getPanelDatosJuegos().getComboTiposDeJuego()
					.getSelectedItem().toString();
			double presupuesto = Double.parseDouble(
					vista.getPanelCasaApuestas().getPanelDatosJuegos().getCampoTextoPresupuesto().getText());
			if (this.casaApuestas.getJuego()
					.verificarPresupuesto(this.casaApuestas.getJuego().getJuegosDAO().getListaJuegos(), presupuesto)) {
				vista.mostrarMensajeError("No se puede sobrepasar el presupuesto total" + "\nPresupuesto disponible: "
						+ this.casaApuestas.getJuego()
								.presupuestoDisponible(this.casaApuestas.getJuego().getJuegosDAO().getListaJuegos()));
			} else {
				if (this.casaApuestas.getJuego().getJuegosDAO().agregarJuego(nombreJuego, tipoJuego, presupuesto)) {
					vista.mostrarMensajeInformacion("Se ha agregado correctamente");
					vista.getPanelCasaApuestas().getPanelDatosJuegos().limpiarCampos();

				} else {
					vista.mostrarMensajeError("No se pueden repetir juegos");
				}
			}
		} else {
			vista.mostrarMensajeError("Campos necesarios");
		}
	}

}
