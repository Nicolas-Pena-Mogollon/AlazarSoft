package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Apostador;
import co.edu.unbosque.model.CasaDeApuestas;
import co.edu.unbosque.model.CedulaException;
import co.edu.unbosque.model.CelularException;
import co.edu.unbosque.model.Sede;
import co.edu.unbosque.model.persistence.ApostadorDAO;
import co.edu.unbosque.model.persistence.ApostadorDTO;
import co.edu.unbosque.model.persistence.Archivo;
import co.edu.unbosque.model.persistence.ArchivoApuesta;
import co.edu.unbosque.model.persistence.BalotoDAO;
import co.edu.unbosque.model.persistence.BalotoDTO;
import co.edu.unbosque.model.persistence.MarcadoresDAO;
import co.edu.unbosque.model.persistence.MarcadoresDTO;
import co.edu.unbosque.model.persistence.Propiedades;
import co.edu.unbosque.model.persistence.SedesDAO;
import co.edu.unbosque.model.persistence.SedesDTO;
import co.edu.unbosque.model.persistence.SuperastroDAO;
import co.edu.unbosque.model.persistence.SuperastroDTO;
import co.edu.unbosque.view.View;

public class Controller implements ActionListener {

	private CasaDeApuestas casaApuestas;
	private View vista;
	private Propiedades prop;
	private Properties datos;
	private SedesDAO sedes;
	private Sede sede;
	private ApostadorDAO apostador;
	private BalotoDAO baloto;
	private MarcadoresDAO marcador;
	private SuperastroDAO superastro;
	private Apostador apostadorV;
	private File fileApostador = new File("Data\\apostadores.dat");
	private File fileBaloto = new File("Data\\apuestas-baloto.dat");
	private File fileSuperastro = new File("Data\\apuestas-superastro.dat");
	private File fileMarcadores = new File("Data\\apuestas-marcadores.dat");
	private ArrayList<ApostadorDTO> listaApostador;
	private ArrayList<BalotoDTO> listaBaloto;
	private ArrayList<SuperastroDTO> listaSuperastro;
	private ArrayList<MarcadoresDTO> listaMarcadores;
	private String[] partidos;
	private Archivo archivoApostador;
	private ArchivoApuesta archivoApuesta;

	public Controller() {
		vista = new View(this);
		prop = new Propiedades();
		datos = new Properties();
		casaApuestas = new CasaDeApuestas();
		sedes = new SedesDAO();
		baloto = new BalotoDAO();
		superastro = new SuperastroDAO();
		marcador = new MarcadoresDAO();
		sede = new Sede();
		apostador = new ApostadorDAO();
		apostadorV = new Apostador();
		archivoApostador = new Archivo();
		archivoApuesta = new ArchivoApuesta();
		listaApostador = archivoApostador.leerArchivo(fileApostador);
		listaBaloto = archivoApuesta.leerArchivoBaloto(fileBaloto);
		listaSuperastro = archivoApuesta.leerArchivoSuperastro(fileSuperastro);
		listaMarcadores = archivoApuesta.leerArchivoMarcadores(fileMarcadores);
		partidos = new String[14];
		vista.getPanelApostadores().getPanelCrearApostador().cargarComboBox(this.sedes.leerSede());
		vista.getPanelApostadores().getPanelActualizarBorrarApostador().cargarComboBox(this.sedes.leerSede());
		vista.getPanelApostadores().getPanelActualizarBorrarApostador().cargarId(listaApostador);
		vista.getPanelApuestas().getPanelCrearApuesta().cargarComboBox(this.sedes.leerSede());
		vista.getPanelApuestas().getPanelCrearApuesta().cargarId(listaApostador);
		this.cargarPartido();

	}

	public void cargarPartido() {
		try {
			datos = prop.cargarInfo(new File("Data\\partidos.properties"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		this.partidos = prop.inicializarDatosPartido(datos);
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
			vista.getPanelApuestas().getPanelCrearApuesta().getPanelApuestaFutbol().cargarCombo(partidos);
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
					.equals("Fútbol")) {
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
			if (apuesta.equals("Fútbol")) {
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
				apostadorV.verificarCedula(cedula);
				apostadorV.verificarCelular(celular);
				if (apostador.verificarNumeroTelefonico(listaApostador, celular)) {
					JOptionPane.showMessageDialog(null, "El número telefónico ya se encuentra registrado");
				} else {
					if (apostador.agregarApostador(nombre, cedula, sede, direccion, celular, listaApostador,
							fileApostador)) {
						JOptionPane.showMessageDialog(null, "Registro correcto");
						vista.getPanelApostadores().getPanelCrearApostador().cargarComboBox(this.sedes.leerSede());
						vista.getPanelApostadores().getPanelActualizarBorrarApostador().cargarId(listaApostador);
						vista.getPanelApostadores().getPanelCrearApostador().limpiarCampos();
						vista.getPanelApostadores().getPanelActualizarBorrarApostador()
								.cargarComboBox(this.sedes.leerSede());
						vista.getPanelApuestas().getPanelCrearApuesta().cargarComboBox(this.sedes.leerSede());
						vista.getPanelApuestas().getPanelCrearApuesta().cargarId(listaApostador);

					} else {
						JOptionPane.showMessageDialog(null, "El número de cedula ya se encuentra registrado");

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
		String cedula = vista.getPanelApostadores().getPanelActualizarBorrarApostador().getComboCedula()
				.getSelectedItem().toString();
		if (apostador.eliminarApostador(cedula, listaApostador, fileApostador)) {
			JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
			vista.getPanelApostadores().getPanelCrearApostador().cargarComboBox(this.sedes.leerSede());
			vista.getPanelApostadores().getPanelActualizarBorrarApostador().cargarId(listaApostador);
			vista.getPanelApostadores().getPanelActualizarBorrarApostador().borrarCampos();
			vista.getPanelApostadores().getPanelActualizarBorrarApostador().cargarComboBox(this.sedes.leerSede());
			vista.getPanelApuestas().getPanelCrearApuesta().cargarComboBox(this.sedes.leerSede());
			vista.getPanelApuestas().getPanelCrearApuesta().cargarId(listaApostador);
		}

	}

	public void gestionApostadoresActualizar() {
		System.out.println(this.sedes.leerSede().size());
		String[] entradas = vista.getPanelApostadores().getPanelActualizarBorrarApostador()
				.verificarEntradasActualizarInformacionApostador();
		if (entradas[0].equals("0")) {
			try {
				apostadorV.verificarCelular(entradas[3]);
				if (apostador.editarApostador(entradas[5], entradas[1], entradas[4], entradas[2], entradas[3],
						listaApostador, fileApostador)) {
					JOptionPane.showMessageDialog(null, "Se ha editado correctamente");
				}
			} catch (IOException e) {
				e.printStackTrace();
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
			String cedula = vista.getPanelApuestas().getPanelCrearApuesta().getComboCedula().getSelectedItem()
					.toString();
			double valorApuesta = Double
					.parseDouble(vista.getPanelApuestas().getPanelCrearApuesta().getCampoTextoValorApuesta().getText());
			int primerNumero = Integer.parseInt(vista.getPanelApuestas().getPanelCrearApuesta().getPanelApuestaBaloto()
					.getCampoTextoPrimerNumero().getText());
			int segundoNumero = Integer.parseInt(vista.getPanelApuestas().getPanelCrearApuesta().getPanelApuestaBaloto()
					.getCampoTextoSegundoNumero().getText());
			int tercerNumero = Integer.parseInt(vista.getPanelApuestas().getPanelCrearApuesta().getPanelApuestaBaloto()
					.getCampoTextoTercerNumero().getText());
			int cuartoNumero = Integer.parseInt(vista.getPanelApuestas().getPanelCrearApuesta().getPanelApuestaBaloto()
					.getCampoTextoCuartoNumero().getText());
			int quintoNumero = Integer.parseInt(vista.getPanelApuestas().getPanelCrearApuesta().getPanelApuestaBaloto()
					.getCampoTextoQuintoNumero().getText());
			int sextoNumero = Integer.parseInt(vista.getPanelApuestas().getPanelCrearApuesta().getPanelApuestaBaloto()
					.getCampoTextoSextoNumero().getText());
			String numeroJuego = primerNumero + " - " + segundoNumero + " - " + tercerNumero + " - " + cuartoNumero
					+ " - " + quintoNumero + " - " + sextoNumero;
			if (this.baloto.crearApuestas(sede, cedula, fecha, valorApuesta, numeroJuego, listaBaloto, fileBaloto)) {
				vista.mostrarMensajeInformacion("Se ha agregado correctamente");
				vista.mostrarMensajeInformacion(vista.getPanelApuestas().getPanelCrearApuesta().facturaBaloto("Fecha",
						sede, cedula, valorApuesta, numeroJuego));
				vista.getPanelApuestas().getPanelCrearApuesta().limpiarCamposBaloto();
			}
		} else {
			vista.mostrarMensajeError("Campos necesarios");
		}
	}

	public void gestionApuestasSuperastro() {
		if (vista.getPanelApuestas().getPanelCrearApuesta().verificarCamposSuperAstro()) {
			Date fecha = null;
			String sede = vista.getPanelApuestas().getPanelCrearApuesta().getComboSede().getSelectedItem().toString();
			String cedula = vista.getPanelApuestas().getPanelCrearApuesta().getComboCedula().getSelectedItem()
					.toString();
			double valorApuesta = Double
					.parseDouble(vista.getPanelApuestas().getPanelCrearApuesta().getCampoTextoValorApuesta().getText());
			int primerNumero = Integer.parseInt(vista.getPanelApuestas().getPanelCrearApuesta()
					.getPanelApuestaSuperAstro().getCampoTextoPrimerNumero().getText());
			int segundoNumero = Integer.parseInt(vista.getPanelApuestas().getPanelCrearApuesta()
					.getPanelApuestaSuperAstro().getCampoTextoSegundoNumero().getText());
			int tercerNumero = Integer.parseInt(vista.getPanelApuestas().getPanelCrearApuesta()
					.getPanelApuestaSuperAstro().getCampoTextoTercerNumero().getText());
			int cuartoNumero = Integer.parseInt(vista.getPanelApuestas().getPanelCrearApuesta()
					.getPanelApuestaSuperAstro().getCampoTextoCuartoNumero().getText());
			String numeroJuego = primerNumero + " - " + segundoNumero + " - " + tercerNumero + " - " + cuartoNumero;
			String signo = vista.getPanelApuestas().getPanelCrearApuesta().getPanelApuestaSuperAstro()
					.getSignoZodiacal().getSelectedItem().toString();
			if (this.superastro.crearApuestas(sede, cedula, fecha, valorApuesta, numeroJuego, signo, listaSuperastro,
					fileSuperastro)) {
				vista.mostrarMensajeInformacion("Se ha agregado correctamente");
				vista.mostrarMensajeInformacion(vista.getPanelApuestas().getPanelCrearApuesta()
						.facturaSuperastro("Fecha", sede, cedula, valorApuesta, numeroJuego, signo));
				vista.getPanelApuestas().getPanelCrearApuesta().limpiarCamposSuperAstro();
			}
		} else {
			vista.mostrarMensajeError("Campos necesarios");
		}

	}

	public void gestionApuestasFutbol() {
		if (vista.getPanelApuestas().getPanelCrearApuesta().verificarCamposFutbol()) {
			Date fecha = null;
			String sede = vista.getPanelApuestas().getPanelCrearApuesta().getComboSede().getSelectedItem().toString();
			String cedula = vista.getPanelApuestas().getPanelCrearApuesta().getComboCedula().getSelectedItem()
					.toString();
			double valorApuesta = Double
					.parseDouble(vista.getPanelApuestas().getPanelCrearApuesta().getCampoTextoValorApuesta().getText());
			String partido = vista.getPanelApuestas().getPanelCrearApuesta().getPanelApuestaFutbol().getComboPartidos()
					.getSelectedItem().toString();
			String resultado = vista.getPanelApuestas().getPanelCrearApuesta().getPanelApuestaFutbol()
					.getComboOpcionResultado().getSelectedItem().toString();
			if (this.marcador.crearApuestas(sede, cedula, fecha, valorApuesta, partido, resultado, listaMarcadores,
					fileMarcadores)) {
				vista.mostrarMensajeInformacion("Se ha agregado correctamente");
				vista.mostrarMensajeInformacion(vista.getPanelApuestas().getPanelCrearApuesta().facturaFutbol("Fecha",
						sede, cedula, valorApuesta, partido, resultado));
				vista.getPanelApuestas().getPanelCrearApuesta().limpiarCamposFutbol();
			}
		} else {
			vista.mostrarMensajeError("Campos necesarios");
		}
	}

	public void gestionSedes() {
		String[] entradas = vista.getPanelSede().getPanelSedeCrear().verificarEntradasIngresoSedes();
		if (entradas[0].equals("0")) {
			SedesDTO sede = new SedesDTO(this.sede.generarIdSede(), entradas[1], Integer.parseInt(entradas[2]));
			sedes.crearSede(sede);
			vista.mostrarMensajeInformacion("Se ha agregado la sede correctammente");
			vista.getPanelSede().getPanelSedeCrear().borrarCamposTxt();
			vista.getPanelApostadores().getPanelCrearApostador().cargarComboBox(this.sedes.leerSede());
			vista.getPanelApostadores().getPanelActualizarBorrarApostador().cargarComboBox(this.sedes.leerSede());
			vista.getPanelApostadores().getPanelActualizarBorrarApostador().cargarId(listaApostador);
			vista.getPanelApuestas().getPanelCrearApuesta().cargarComboBox(this.sedes.leerSede());
			vista.getPanelApuestas().getPanelCrearApuesta().cargarId(listaApostador);
		} else {
			vista.mostrarMensajeError(entradas[1]);
		}

	}
}
