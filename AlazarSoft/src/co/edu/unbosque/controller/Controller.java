package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


import co.edu.unbosque.model.CasaDeApuestas;
import co.edu.unbosque.model.CedulaException;
import co.edu.unbosque.model.CelularException;
import co.edu.unbosque.model.persistence.ApostadorDTO;
import co.edu.unbosque.model.persistence.ApuestaDTO;
import co.edu.unbosque.model.persistence.SedesDTO;
import co.edu.unbosque.view.PanelInformeApuestasPorCliente;
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
		vista.getPanelApuestas().getPanelMostrarBorrarApuesta().llenarComboSedes(casaApuestas.getSede().ObtenerSedes());
		vista.getPanelApuestas().getPanelCrearApuesta().getCampoTextoFecha()
				.setText(vista.getPanelApuestas().getPanelCrearApuesta().hora());
		vista.getPanelApuestas().getPanelCrearApuesta().getPanelApuestaFutbol()
				.cargarCombo(this.casaApuestas.getSede().cargarPartido());
		vista.getPanelPremiacion().llenarInformacion(casaApuestas.getPlanesPremiacion().leerArchivo());
		vista.getPanelConsultasReportes().getPanelExportarInformacion().getPanelInformeClientePorSede().cargarComboBox(this.casaApuestas.getSede().getSedesDao().leerSede());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals(vista.getPanelMenuCasaApuestas().getCOMMAND_CONFIGURACION_CASA_APUESTAS())) {
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
			this.coordinarConfiguracionCasaApuestas();
		} else if (e.getActionCommand().equals(vista.getPanelSede().getPanelSedeCrear().getCOMMAND_GUARDAR())) {
			this.gestionSedes();
		} else if (e.getActionCommand()
				.equals(vista.getPanelApostadores().getPanelCrearApostador().getCOMMAND_CREAR_APOSTADOR())) {
			this.gestionApostadoresRegistro();
		} else if (e.getActionCommand()
				.equals(vista.getPanelApostadores().getPanelActualizarBorrarApostador().getCOMMAND_BORRAR())) {
			this.gestionApostadoresEliminar();
		} else if (e.getActionCommand()
				.equals(vista.getPanelApostadores().getPanelActualizarBorrarApostador().getCOMMAND_ACTUALIZAR())) {
			this.gestionApostadoresActualizar();
		} else if (e.getActionCommand().equals(vista.getPanelApostadores().getPanelInformacionApostadores()
				.getCOMMAND_LEER_INFORMACION_APOSTADORES())) {
			vista.getPanelApostadores().getPanelInformacionApostadores()
					.actualizarTablaApostadores(casaApuestas.getApostadores().generarTablaApostador());
		} else if (e.getActionCommand()
				.equals(vista.getPanelApuestas().getPanelCrearApuesta().getCOMMAND_REGISTRAR_APUESTA())) {
			String apuesta = vista.getPanelApuestas().getPanelCrearApuesta().getComboTiposApuesta().getSelectedItem()
					.toString();
			if (apuesta.equals("Baloto")) {
				this.gestionApuestasBaloto();
			} else if (apuesta.equals("Super Astro")) {
				this.gestionApuestasSuperastro();
			} else if (apuesta.equals("Fútbol")) {
				this.gestionApuestasFutbol();
			} else if (apuesta.equals("Seleccione el tipo de apuesta")) {
				vista.mostrarMensajeError("Escoja el tipo de apuesta");
			}
		} else if (e.getActionCommand()
				.equals(vista.getPanelApuestas().getPanelModificarApuesta().getCOMMAND_MODIFICAR_APUESTA())) {
			String apuesta = vista.getPanelApuestas().getPanelModificarApuesta().getComboTiposApuesta()
					.getSelectedItem().toString();
			if (apuesta.equals("Baloto")) {
				this.gestionApuestasBalotoModificar();
			} else if (apuesta.equals("Super Astro")) {
				this.gestionApuestasSuperastroModificar();
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
								vista.getPanelApuestas().getPanelMostrarBorrarApuesta().getComboSede().getSelectedItem()
										.toString()));
			} else {
				vista.mostrarMensajeError("Se deben escoger todas las opciones");
			}
		} else if (e.getActionCommand().equals(
				vista.getPanelApuestas().getPanelMostrarBorrarApuesta().getCOMMAND_BORRAR_INFORMACION_APUESTAS())) {
			this.gestionarBorrarApuesta();
		} else if (e.getActionCommand()
				.equals(vista.getPanelSede().getPanelSedeModificar().getCOMMAND_ACTUALIZAR_SEDE())) {
			this.gestionarSedesActualizar();
		}else if (e.getActionCommand()
				.equals(vista.getPanelConsultasReportes().getPanelExportarInformacion().getCOMMAND_EXPORTAREXCEL())) {
				this.exportarExcel();
		}else if (e.getActionCommand()
				.equals(vista.getPanelConsultasReportes().getPanelExportarInformacion().getCOMMAND_EXPORTARPDF())) {
				this.exportarPDF();				
		} else if (e.getActionCommand()
				.equals(vista.getPanelConsultasReportes().getPanelHistoricoVentas().getCOMMAND_HISTORICO_VENTAS())) {
			vista.getPanelConsultasReportes().getPanelHistoricoVentas()
					.recibirInfomacion(casaApuestas.getApuestas().obtenerInformacionHistoricoVentas());
		} else if (e.getActionCommand().equals(vista.getPanelConsultasReportes().getPanelGraficoVentasSedes()
				.getCOMMAND_GRAFICA_SEDES_MAYORES_VENTAS())) {
			vista.getPanelConsultasReportes().getPanelGraficoVentasSedes()
					.recibirInfomacion(casaApuestas.obtenerCincoSedesConMayorVenta());
		} else if (e.getActionCommand()
				.equals(vista.getPanelCasaApuestas().getPanelDatosJuegos().getCOMMAND_REGISTRAR_DATOS_JUEGO())) {
			this.gestionarJuegos();
		}else if (e.getActionCommand()
				.equals(vista.getPanelConsultasReportes().getPanelExportarInformacion().getPanelInformeClientePorSede().getCOMMAND_LIMPIAR_INFORME())) {
				this.limpiarConsultaREportes();
		}else if (e.getActionCommand()
				.equals(vista.getPanelConsultasReportes().getPanelExportarInformacion().getPanelInformeClientePorSede().getCOMMAND_INFORME_CLIENTE_POR_SEDE())) {
				this.generarInformeClientesPorSede();
		}else if (e.getActionCommand()
				.equals(vista.getPanelConsultasReportes().getPanelExportarInformacion().getPanelInformeApuestasPorCliente().getCOMMAND_INFORME_APUESTAS_POR_CLIENTE())) {
				try {
					this.generarInformeApuestasPorCliente();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		
	}

	private void generarInformeApuestasPorCliente() throws ParseException {
		
		SimpleDateFormat dateF = new SimpleDateFormat("dd/MM/yyyy");
		PanelInformeApuestasPorCliente panelInformes = vista.getPanelConsultasReportes().getPanelExportarInformacion().getPanelInformeApuestasPorCliente();
		
		if (panelInformes.getCampoTextoCliente().getText().equals("")) {
			vista.mostrarMensajeError("Debes ingresar un numero de identificaciòn para cliente");
		} else {
			String idCliente = panelInformes.getCampoTextoCliente().getText();
			String FechaInicio = panelInformes.getCampoTextoFechaInicio().getText();
			Date date = dateF.parse("26/10/1985");

			if (dateF.parse(FechaInicio) != null) {
				String FechaFin = panelInformes.getCampoTextoFechaFin().getText();
				
				if (dateF.parse(FechaFin) != null) {
					
					Date fechaInicio =  dateF.parse(FechaInicio);
					Date fechaFin =  dateF.parse(FechaFin);
					
					if (fechaInicio.before(fechaFin) ) {
						
						String[][] apuestas = casaApuestas.getApuestas().generarTablaApuestasPorCliente(idCliente, fechaInicio, fechaFin);
						
					} else {
						vista.mostrarMensajeError("La fecha desde es mayor que la fecha hasta");
					}
					
					
				} else {
					vista.mostrarMensajeError("Error en formato de fecha fin");
				}

			}else{
				vista.mostrarMensajeError("Error en formato de fecha de inicio");
			}
		}
		
	}

	private void generarInformeClientesPorSede() {
		if (vista.getPanelConsultasReportes().getPanelExportarInformacion().getPanelInformeClientePorSede().getComboSede().getSelectedIndex() == 0) {
			vista.mostrarMensajeError("Debes escoger una sede para la consulta");
			this.limpiarConsultaREportes();
		} else {

			this.limpiarConsultaREportes();
			ArrayList<ApostadorDTO> apostadores = casaApuestas.getApostadores().getApostadorDao().apostadoresPorSede(vista.getPanelConsultasReportes().getPanelExportarInformacion().getPanelInformeClientePorSede().getComboSede().getSelectedItem().toString());
			
			if (apostadores.size() > 0) {
				TableColumnModel modeloColumnas= vista.getPanelConsultasReportes().getPanelExportarInformacion().getTablaInformacionApostadores().getColumnModel();
				DefaultTableModel modelo = vista.getPanelConsultasReportes().getPanelExportarInformacion().getModeloTablaApostadores();
				vista.getPanelConsultasReportes().getPanelExportarInformacion().getModeloTablaApostadores().setColumnCount(5);
				modeloColumnas.getColumn(0).setHeaderValue("Cedula");
				modeloColumnas.getColumn(1).setHeaderValue("Nombres");
				modeloColumnas.getColumn(2).setHeaderValue("Celular");
				modeloColumnas.getColumn(3).setHeaderValue("Direcciòn");
				modeloColumnas.getColumn(4).setHeaderValue("Sede");
				
				casaApuestas.getInforme().setTitulo("Listado de clientes por sede");
				casaApuestas.getInforme().setDesccripción("Informa de clientes para la sede " + vista.getPanelConsultasReportes().getPanelExportarInformacion().getPanelInformeClientePorSede().getComboSede().getSelectedItem().toString());
				String[][] data =  new String[apostadores.size()+1][5];
				
				data[0][0] = "Cedula";
				data[0][1] = "Nombres";
				data[0][2] = "Celular";
				data[0][3] = "Direcciòn";
				data[0][4] = "Sede";
				
				for (int i = 0; i < apostadores.size(); i++) {
				
					data[i+1][0] = apostadores.get(i).getCedula();
					data[i+1][1] = apostadores.get(i).getNombre();
					data[i+1][2] = apostadores.get(i).getCelular();
					data[i+1][3] = apostadores.get(i).getDireccion();
					data[i+1][4] = apostadores.get(i).getSede();
					modelo.addRow(data[i+1]);
					
				}
				
				casaApuestas.getInforme().setTablaDatos(data);
				
				
			} else {
				vista.mostrarMensajeError("No hay datos para esta consulta");
			}
			
		
		}
	}
	
	private void exportarExcel() {
		if (casaApuestas.getInforme().getTablaDatos() == null) {
			vista.mostrarMensajeError("No hay datos por exportar");
		} else {
			try {
				casaApuestas.exportarInformeEXCEL();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				vista.mostrarMensajeError("Imposible generar archivo error: " + e1);
			}
		}
		
	}

	private void exportarPDF() {
		
		if (casaApuestas.getInforme().getTablaDatos() == null) {
			vista.mostrarMensajeError("No hay datos por exportar");
		} else {
			try {
				casaApuestas.exportarInformePDF();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				vista.mostrarMensajeError("Imposible generar archivo error: " + e1);
			}
		}
		
	}

	private void limpiarConsultaREportes() {
		TableColumnModel modeloColumnas= vista.getPanelConsultasReportes().getPanelExportarInformacion().getTablaInformacionApostadores().getColumnModel();
		DefaultTableModel modelo = vista.getPanelConsultasReportes().getPanelExportarInformacion().getModeloTablaApostadores();
		vista.getPanelConsultasReportes().getPanelExportarInformacion().getModeloTablaApostadores().setColumnCount(1);
		modeloColumnas.getColumn(0).setHeaderValue("Vacio");
		modelo.setRowCount(0);
	}

	public void coordinarConfiguracionCasaApuestas() {
		String[] entradas = vista.getPanelCasaApuestas().getPanelIngresoCasaApuestas()
				.verificarEntradasIngresoDatosJuegos();
		if (entradas[0].equals("0")) {
			casaApuestas.guardarConfiguracionCasaDeApuestas(entradas[1], Integer.parseInt(entradas[2]),
					Long.parseLong(entradas[3]));
			vista.mostrarMensajeInformacion(entradas[4]);
		} else {
			vista.mostrarMensajeError(entradas[1]);
		}
		vista.getPanelCasaApuestas().getPanelIngresoCasaApuestas().borrarCamposIngresoCasaApuestas();
	}

	public void gestionApostadoresRegistro() {
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

	public void gestionApostadoresEliminar() {

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

	public void gestionApostadoresActualizar() {
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

	public void gestionApuestasBaloto() {
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
						String numeroJuego = primerNumero + " - " + segundoNumero + " - " + tercerNumero + " - "
								+ cuartoNumero + " - " + quintoNumero + " - " + sextoNumero;
						if (this.casaApuestas.getApuestas().verificarNumerosIgualesBaloto(primerNumero, segundoNumero,
								tercerNumero, cuartoNumero, quintoNumero, sextoNumero)) {
							vista.mostrarMensajeError("Los números no se pueden repetir");
						} else {
							if (!this.casaApuestas.getApuestas().verificarRangoNumerosBaloto(primerNumero,
									segundoNumero, tercerNumero, cuartoNumero, quintoNumero, sextoNumero)) {
								if (this.casaApuestas.getApuestas().getBalotoDAO().crearApuestas(sede, cedula, fecha,
										valorApuesta, numeroJuego)) {
									vista.mostrarMensajeInformacion("Se ha agregado correctamente");
									vista.mostrarMensajeInformacion(vista.getPanelApuestas().getPanelCrearApuesta()
											.facturaBaloto(fechaString, sede, cedula, valorApuesta, numeroJuego));
									vista.getPanelApuestas().getPanelCrearApuesta().limpiarCamposBaloto();
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

	public void gestionApuestasSuperastro() {
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
						String numeroJuego = primerNumero + " - " + segundoNumero + " - " + tercerNumero + " - "
								+ cuartoNumero;
						String signo = vista.getPanelApuestas().getPanelCrearApuesta().getPanelApuestaSuperAstro()
								.getSignoZodiacal().getSelectedItem().toString();
						if (this.casaApuestas.getApuestas().verificarRangoNumerosSuperastro(primerNumero, segundoNumero,
								tercerNumero, cuartoNumero)) {
							vista.mostrarMensajeError("El rango de los números debe estar entre 0 - 9");
						} else {
							if (this.casaApuestas.getApuestas().getSuperastroDAO().crearApuestas(sede, cedula, fecha,
									valorApuesta, numeroJuego, signo)) {
								vista.mostrarMensajeInformacion("Se ha agregado correctamente");
								vista.mostrarMensajeInformacion(
										vista.getPanelApuestas().getPanelCrearApuesta().facturaSuperastro(fechaString,
												sede, cedula, valorApuesta, numeroJuego, signo));
								vista.getPanelApuestas().getPanelCrearApuesta().limpiarCamposSuperAstro();
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

	public void gestionApuestasFutbol() {
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
						if (this.casaApuestas.getApuestas().getMarcadoresDAO().crearApuestas(sede, cedula, fecha,
								valorApuesta, partido, resultado)) {
							vista.mostrarMensajeInformacion("Se ha agregado correctamente");
							vista.mostrarMensajeInformacion(vista.getPanelApuestas().getPanelCrearApuesta()
									.facturaFutbol(fechaString, sede, cedula, valorApuesta, partido, resultado));
							vista.getPanelApuestas().getPanelCrearApuesta().limpiarCamposFutbol();
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

	public void gestionSedes() {
		String[] entradas = vista.getPanelSede().getPanelSedeCrear().verificarEntradasIngresoSedes();
		if (entradas[0].equals("0")) {
			SedesDTO sede = new SedesDTO(this.casaApuestas.getSede().generarIdSede(), entradas[1],
					Integer.parseInt(entradas[2]));
			this.casaApuestas.getSede().getSedesDao().crearSede(sede);
			vista.mostrarMensajeInformacion("Se ha agregado la sede correctammente");
			vista.getPanelSede().getPanelSedeCrear().borrarCamposTxt();
			vista.getPanelApostadores().getPanelCrearApostador()
					.cargarComboBox(this.casaApuestas.getSede().getSedesDao().leerSede());
			vista.getPanelSede().getPanelSedeModificar()
					.cargarCombo(this.casaApuestas.getSede().getSedesDao().leerSede());
		} else {
			vista.mostrarMensajeError(entradas[1]);
		}

	}

	public void gestionarSedesActualizar() {
		String[] entradas = vista.getPanelSede().getPanelSedeModificar().verificarEntradasActualizarSedes();
		if (entradas[0].equals("0")) {
			this.casaApuestas.getSede().getSedesDao().actualizarSede(Integer.parseInt(entradas[3]), entradas[1],
					Integer.parseInt(entradas[2]));
			vista.mostrarMensajeInformacion("Se ha editado correctamente");
			vista.getPanelSede().getPanelSedeModificar().borrarCampos();
			vista.getPanelSede().getPanelSedeModificar()
					.cargarCombo(this.casaApuestas.getSede().getSedesDao().leerSede());
			vista.getPanelApuestas().getPanelModificarApuesta()
					.cargarComboBox(this.casaApuestas.getSede().getSedesDao().leerSede());
			vista.getPanelApuestas().getPanelMostrarBorrarApuesta()
					.llenarComboSedes(casaApuestas.getSede().ObtenerSedes());
			vista.getPanelApuestas().getPanelCrearApuesta().getCampoTextoFecha()
					.setText(vista.getPanelApuestas().getPanelCrearApuesta().hora());
			vista.getPanelSede().getPanelSedeModificar()
					.cargarCombo(this.casaApuestas.getSede().getSedesDao().leerSede());
		} else {
			vista.mostrarMensajeError(entradas[1]);
		}
	}

	public void gestionApuestasBalotoModificar() {
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

	public void gestionApuestasSuperastroModificar() {
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
			long presupuesto = Long
					.parseLong(vista.getPanelCasaApuestas().getPanelDatosJuegos().getCampoTextoPresupuesto().getText());
			if (this.casaApuestas.getJuego()
					.verificarPresupuesto(this.casaApuestas.getJuego().getJuegosDAO().getListaJuegos(), presupuesto)) {
				vista.mostrarMensajeError(
						"No se puede sobrepasar el presupuesto total" + "\nPresupuesto disponible: " + this.casaApuestas.getJuego()
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
