package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.CasaDeApuestas;
import co.edu.unbosque.model.CedulaException;
import co.edu.unbosque.model.CelularException;
import co.edu.unbosque.model.Sede;
import co.edu.unbosque.model.persistence.Propiedades;
import co.edu.unbosque.model.persistence.SedesDAO;
import co.edu.unbosque.model.persistence.SedesDTO;
import co.edu.unbosque.view.View;

public class Controller implements ActionListener {

	private CasaDeApuestas casaApuestas;
	private View vista;

	public Controller() {
		vista = new View(this);
		casaApuestas = new CasaDeApuestas();
		vista.getPanelApostadores().getPanelCrearApostador()
				.cargarComboBox(this.casaApuestas.getSede().getSedesDao().leerSede());
		vista.getPanelApostadores().getPanelActualizarBorrarApostador()
				.cargarComboBox(this.casaApuestas.getSede().getSedesDao().leerSede());
		vista.getPanelApuestas().getPanelCrearApuesta()
				.cargarComboBox(this.casaApuestas.getSede().getSedesDao().leerSede());
		vista.getPanelSede().getPanelSedeModificar().cargarCombo(this.casaApuestas.getSede().getSedesDao().leerSede());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals(vista.getPanelMenuCasaApuestas().getCOMMAND_CONFIGURACION_CASA_APUESTAS())) {
			vista.getSplitPane().setRightComponent(vista.getPanelIngresoCasaApuestas());
		} else if (e.getActionCommand().equals(vista.getPanelMenuCasaApuestas().getCOMMAND_GESTION_SEDES())) {
			vista.getSplitPane().setRightComponent(vista.getPanelSede());
		} else if (e.getActionCommand().equals(vista.getPanelMenuCasaApuestas().getCOMMAND_GESTION_APOSTADORES())) {
			vista.getSplitPane().setRightComponent(vista.getPanelApostadores());
		} else if (e.getActionCommand().equals(vista.getPanelMenuCasaApuestas().getCOMMAND_GESTION_APUESTAS())) {
			vista.getPanelApuestas().getPanelCrearApuesta().getPanelApuestaFutbol()
					.cargarCombo(this.casaApuestas.getSede().cargarPartido());
			vista.getSplitPane().setRightComponent(vista.getPanelApuestas());
			vista.getPanelApuestas().getPanelCrearApuesta().getCampoTextoFecha()
					.setText(vista.getPanelApuestas().getPanelCrearApuesta().hora());
		} else if (e.getActionCommand().equals(vista.getPanelMenuCasaApuestas().getCOMMAND_PLANES_PREMIACION())) {
			// vista.getSplitPane().setRightComponent(vista.getPanelSede());
		} else if (e.getActionCommand().equals(vista.getPanelMenuCasaApuestas().getCOMMAND_CONSULTA_REPORTES())) {
			// vista.getSplitPane().setRightComponent(vista.getPanelSede());
		} else if (e.getActionCommand()
				.equals(vista.getPanelApuestas().getPanelCrearApuesta().getCOMMAND_CAMBIAR_TIPO_APUESTA())) {
			//
			//
			// Se puede implementar en la vista y queda mejor
			//
			//
			if (vista.getPanelApuestas().getPanelCrearApuesta().getComboTiposApuesta().getSelectedItem()
					.equals("Baloto")) {
				vista.getPanelApuestas().getPanelCrearApuesta().getPanelContenedorDividido()
						.setBottomComponent(vista.getPanelApuestas().getPanelCrearApuesta().getPanelApuestaBaloto());
			} else if (vista.getPanelApuestas().getPanelCrearApuesta().getComboTiposApuesta().getSelectedItem()
					.equals("Super Astro")) {
				vista.getPanelApuestas().getPanelCrearApuesta().getPanelContenedorDividido().setBottomComponent(
						vista.getPanelApuestas().getPanelCrearApuesta().getPanelApuestaSuperAstro());
			} else if (vista.getPanelApuestas().getPanelCrearApuesta().getComboTiposApuesta().getSelectedItem()
					.equals("F�tbol")) {
				vista.getPanelApuestas().getPanelCrearApuesta().getPanelContenedorDividido()
						.setBottomComponent(vista.getPanelApuestas().getPanelCrearApuesta().getPanelApuestaFutbol());
			}
		} else if (e.getActionCommand().equals(vista.getPanelIngresoCasaApuestas().getCOMMAND_INGRESAR())) {
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
		} else if (e.getActionCommand()
				.equals(vista.getPanelApuestas().getPanelCrearApuesta().getCOMMAND_REGISTRAR_APUESTA_BALOTO())) {
			String apuesta = vista.getPanelApuestas().getPanelCrearApuesta().getComboTiposApuesta().getSelectedItem()
					.toString();
			if (apuesta.equals("Baloto")) {
				this.gestionApuestasBaloto();
			}
			if (apuesta.equals("Super Astro")) {
				this.gestionApuestasSuperastro();
			}
			if (apuesta.equals("F�tbol")) {
				this.gestionApuestasFutbol();
			}
			if (apuesta.equals("Seleccione el tipo de apuesta")) {
				vista.mostrarMensajeError("Escoja el tipo de apuesta");
			}
		}
	}

	public void coordinarConfiguracionCasaApuestas() {
		String[] entradas = vista.getPanelIngresoCasaApuestas().verificarEntradasIngresoDatosJuegos();
		if (entradas[0].equals("0")) {
			casaApuestas.guardarConfiguracionCasaDeApuestas(entradas[1], Integer.parseInt(entradas[2]),
					Long.parseLong(entradas[3]));
			vista.mostrarMensajeInformacion(entradas[4]);
		} else {
			vista.mostrarMensajeError(entradas[1]);
		}
		vista.getPanelIngresoCasaApuestas().borrarCamposIngresoCasaApuestas();
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
					JOptionPane.showMessageDialog(null, "El n�mero telef�nico ya se encuentra registrado");
				} else {
					if (casaApuestas.getApostadores().getApostadorDao().agregarApostador(nombre, cedula, sede,
							direccion, celular)) {
						JOptionPane.showMessageDialog(null, "Registro correcto");
						vista.getPanelApostadores().getPanelCrearApostador()
								.cargarComboBox(this.casaApuestas.getSede().getSedesDao().leerSede());
						vista.getPanelApostadores().getPanelCrearApostador().limpiarCampos();
						vista.getPanelApostadores().getPanelActualizarBorrarApostador()
								.cargarComboBox(this.casaApuestas.getSede().getSedesDao().leerSede());
						vista.getPanelApuestas().getPanelCrearApuesta()
								.cargarComboBox(this.casaApuestas.getSede().getSedesDao().leerSede());
					} else {
						JOptionPane.showMessageDialog(null, "El n�mero de cedula ya se encuentra registrado");

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
				JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
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
					JOptionPane.showMessageDialog(null, "Se ha editado correctamente");
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
		if (vista.getPanelApuestas().getPanelCrearApuesta().verificarCamposBaloto()) {

			Date fecha = null;
			String sede = vista.getPanelApuestas().getPanelCrearApuesta().getComboSede().getSelectedItem().toString();
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
						vista.mostrarMensajeError("Los n�meros no se pueden repetir");
					} else {
						if (!this.casaApuestas.getApuestas().verificarRangoNumerosBaloto(primerNumero, segundoNumero,
								tercerNumero, cuartoNumero, quintoNumero, sextoNumero)) {
							if (this.casaApuestas.getApuestas().getBalotoDAO().crearApuestas(sede, cedula, fecha,
									valorApuesta, numeroJuego)) {
								vista.mostrarMensajeInformacion("Se ha agregado correctamente");
								vista.mostrarMensajeInformacion(vista.getPanelApuestas().getPanelCrearApuesta()
										.facturaBaloto("Fecha", sede, cedula, valorApuesta, numeroJuego));
								vista.getPanelApuestas().getPanelCrearApuesta().limpiarCamposBaloto();
							}
						} else {
							vista.mostrarMensajeError("El rango de los n�meros debe estar entre 1 - 45");
						}
					}
				} catch (NumberFormatException e) {
					vista.mostrarMensajeError("Ingres� un caracter no permitido para los n�meros");
				}
			} else {
				vista.mostrarMensajeError("El apostador no se encuentra registrado");
			}
		} else

		{
			vista.mostrarMensajeError("Campos necesarios");
		}
	}

	public void gestionApuestasSuperastro() {
		if (vista.getPanelApuestas().getPanelCrearApuesta().verificarCamposSuperAstro()) {
			Date fecha = null;
			String sede = vista.getPanelApuestas().getPanelCrearApuesta().getComboSede().getSelectedItem().toString();
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
						vista.mostrarMensajeError("El rango de los n�meros debe estar entre 0 - 9");
					} else {
						if (this.casaApuestas.getApuestas().getSuperastroDAO().crearApuestas(sede, cedula, fecha,
								valorApuesta, numeroJuego, signo)) {
							vista.mostrarMensajeInformacion("Se ha agregado correctamente");
							vista.mostrarMensajeInformacion(vista.getPanelApuestas().getPanelCrearApuesta()
									.facturaSuperastro("Fecha", sede, cedula, valorApuesta, numeroJuego, signo));
							vista.getPanelApuestas().getPanelCrearApuesta().limpiarCamposSuperAstro();
						}
					}
				} catch (NumberFormatException e) {
					vista.mostrarMensajeError("Ingres� un caracter no permitido para los n�meros");
				}
			} else {
				vista.mostrarMensajeError("El apostador no se encuentra registrado");
			}

		} else {
			vista.mostrarMensajeError("Campos necesarios");
		}

	}

	public void gestionApuestasFutbol() {
		if (vista.getPanelApuestas().getPanelCrearApuesta().verificarCamposFutbol()) {
			Date fecha = null;
			String sede = vista.getPanelApuestas().getPanelCrearApuesta().getComboSede().getSelectedItem().toString();
			String cedula = vista.getPanelApuestas().getPanelCrearApuesta().getCampoTextoCedula().getText();
			if (casaApuestas.getApostadores().getApostadorDao().buscarApostador(cedula) != null) {
				double valorApuesta = Double.parseDouble(
						vista.getPanelApuestas().getPanelCrearApuesta().getCampoTextoValorApuesta().getText());
				String partido = vista.getPanelApuestas().getPanelCrearApuesta().getPanelApuestaFutbol()
						.getComboPartidos().getSelectedItem().toString();
				String resultado = vista.getPanelApuestas().getPanelCrearApuesta().getPanelApuestaFutbol()
						.getComboOpcionResultado().getSelectedItem().toString();
				if (this.casaApuestas.getApuestas().getMarcadoresDAO().crearApuestas(sede, cedula, fecha, valorApuesta,
						partido, resultado)) {
					vista.mostrarMensajeInformacion("Se ha agregado correctamente");
					vista.mostrarMensajeInformacion(vista.getPanelApuestas().getPanelCrearApuesta()
							.facturaFutbol("Fecha", sede, cedula, valorApuesta, partido, resultado));
					vista.getPanelApuestas().getPanelCrearApuesta().limpiarCamposFutbol();
				}
			} else {
				vista.mostrarMensajeError("El apostador no se encuentra registrado");
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
			vista.getPanelApostadores().getPanelActualizarBorrarApostador()
					.cargarComboBox(this.casaApuestas.getSede().getSedesDao().leerSede());
			vista.getPanelApuestas().getPanelCrearApuesta()
					.cargarComboBox(this.casaApuestas.getSede().getSedesDao().leerSede());
			vista.getPanelSede().getPanelSedeModificar()
					.cargarCombo(this.casaApuestas.getSede().getSedesDao().leerSede());
		} else {
			vista.mostrarMensajeError(entradas[1]);
		}

	}
}
