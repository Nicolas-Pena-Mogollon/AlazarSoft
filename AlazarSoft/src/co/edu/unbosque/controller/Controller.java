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
		vista.getPanelApuesta().cargarComboBox(this.sedes.leerSede());
		vista.getPanelApuesta().cargarId(listaApostador);

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
			try {
				datos = prop.cargarInfo(new File("Data\\partidos.properties"));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			this.partidos = prop.inicializarDatosPartido(datos);
			vista.getPanelApuesta().getPanelApuestaFutbol().cargarCombo(partidos);
			vista.getSplitPane().setRightComponent(vista.getPanelApuesta());
			vista.getPanelApuesta().getCampoTextoFecha().setText(vista.getPanelApuesta().hora());
			;
		} else if (e.getActionCommand().equals(vista.getPanelMenuCasaApuestas().getCOMMAND_PLANES_PREMIACION())) {
			// vista.getSplitPane().setRightComponent(vista.getPanelSede());
		} else if (e.getActionCommand().equals(vista.getPanelMenuCasaApuestas().getCOMMAND_CONSULTA_REPORTES())) {
			// vista.getSplitPane().setRightComponent(vista.getPanelSede());
		} else if (e.getActionCommand().equals(vista.getPanelApuesta().getCOMMAND_CAMBIAR_TIPO_APUESTA())) {
			//
			//
			// Se puede implementar en la vista y queda mejor
			//
			//
			if (vista.getPanelApuesta().getComboTiposApuesta().getSelectedItem().equals("Baloto")) {
				vista.getPanelApuesta().getPanelContenedorDividido()
						.setBottomComponent(vista.getPanelApuesta().getPanelApuestaBaloto());
			} else if (vista.getPanelApuesta().getComboTiposApuesta().getSelectedItem().equals("Super Astro")) {
				vista.getPanelApuesta().getPanelContenedorDividido()
						.setBottomComponent(vista.getPanelApuesta().getPanelApuestaSuperAstro());
			} else if (vista.getPanelApuesta().getComboTiposApuesta().getSelectedItem().equals("Fútbol")) {
				vista.getPanelApuesta().getPanelContenedorDividido()
						.setBottomComponent(vista.getPanelApuesta().getPanelApuestaFutbol());
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
		} else if (e.getActionCommand().equals(vista.getPanelApuesta().getCOMMAND_REGISTRAR_APUESTA_BALOTO())) {
			this.gestionApuestasBaloto();
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
						vista.getPanelApuesta().cargarComboBox(this.sedes.leerSede());
						vista.getPanelApuesta().cargarId(listaApostador);

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
			vista.getPanelApuesta().cargarComboBox(this.sedes.leerSede());
			vista.getPanelApuesta().cargarId(listaApostador);
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
		Date fecha = null;
		String sede = vista.getPanelApuesta().getComboSede().getSelectedItem().toString();
		String cedula = vista.getPanelApuesta().getComboCedula().getSelectedItem().toString();
		double valorApuesta = Double.parseDouble(vista.getPanelApuesta().getCampoTextoValorApuesta().getText());
		int primerNumero = Integer
				.parseInt(vista.getPanelApuesta().getPanelApuestaBaloto().getCampoTextoPrimerNumero().getText());
		int segundoNumero = Integer
				.parseInt(vista.getPanelApuesta().getPanelApuestaBaloto().getCampoTextoSegundoNumero().getText());
		int tercerNumero = Integer
				.parseInt(vista.getPanelApuesta().getPanelApuestaBaloto().getCampoTextoTercerNumero().getText());
		int cuartoNumero = Integer
				.parseInt(vista.getPanelApuesta().getPanelApuestaBaloto().getCampoTextoCuartoNumero().getText());
		int quintoNumero = Integer
				.parseInt(vista.getPanelApuesta().getPanelApuestaBaloto().getCampoTextoQuintoNumero().getText());
		int sextoNumero = Integer
				.parseInt(vista.getPanelApuesta().getPanelApuestaBaloto().getCampoTextoSextoNumero().getText());
		String numeroJuego = primerNumero + " - " + segundoNumero + " - " + tercerNumero + " - " + cuartoNumero + " - "
				+ quintoNumero + " - " + sextoNumero;
		if (this.baloto.crearApuestas(sede, cedula, fecha, valorApuesta, numeroJuego, listaBaloto, fileBaloto)) {
			vista.mostrarMensajeInformacion("Se ha agregado correctamente");
		}
	}

	public void gestionApuestasSuperastro() {
		Date fecha = null;
		String sede = vista.getPanelApuesta().getComboSede().getSelectedItem().toString();
		String cedula = vista.getPanelApuesta().getComboCedula().getSelectedItem().toString();
		double valorApuesta = Double.parseDouble(vista.getPanelApuesta().getCampoTextoValorApuesta().getText());
		int primerNumero = Integer
				.parseInt(vista.getPanelApuesta().getPanelApuestaSuperAstro().getCampoTextoPrimerNumero().getText());
		int segundoNumero = Integer
				.parseInt(vista.getPanelApuesta().getPanelApuestaSuperAstro().getCampoTextoSegundoNumero().getText());
		int tercerNumero = Integer
				.parseInt(vista.getPanelApuesta().getPanelApuestaSuperAstro().getCampoTextoTercerNumero().getText());
		int cuartoNumero = Integer
				.parseInt(vista.getPanelApuesta().getPanelApuestaSuperAstro().getCampoTextoCuartoNumero().getText());
		String numeroJuego = primerNumero + " - " + segundoNumero + " - " + tercerNumero + " - " + cuartoNumero;
		String signo = vista.getPanelApuesta().getPanelApuestaSuperAstro().getSignoZodiacal().getSelectedItem()
				.toString();
		if (this.superastro.crearApuestas(sede, cedula, fecha, valorApuesta, numeroJuego, signo, listaSuperastro,
				fileSuperastro)) {
			vista.mostrarMensajeInformacion("Se ha agregado correctamente");
		}

	}

	public void gestionApuestasFutbol() {
		Date fecha = null;
		String sede = vista.getPanelApuesta().getComboSede().getSelectedItem().toString();
		String cedula = vista.getPanelApuesta().getComboCedula().getSelectedItem().toString();
		double valorApuesta = Double.parseDouble(vista.getPanelApuesta().getCampoTextoValorApuesta().getText());
		String partido = vista.getPanelApuesta().getPanelApuestaFutbol().getComboPartidos().getSelectedItem()
				.toString();
		String resultado = vista.getPanelApuesta().getPanelApuestaFutbol().getComboOpcionResultado().getSelectedItem()
				.toString();
		if (this.marcador.crearApuestas(sede, cedula, fecha, valorApuesta, partido, resultado, listaMarcadores,
				fileMarcadores)) {
			vista.mostrarMensajeInformacion("Se ha agregado correctamente");
		}
	}

	public void gestionSedes() {
		String ubicacionSede = vista.getPanelSede().getPanelSedeCrear().getCampoTextoNombreSede().getText();
		String empleados = vista.getPanelSede().getPanelSedeCrear().getCampoTextoNumeroEmpleado().getText();
		int numeroEmpleado = Integer.parseInt(empleados);
		SedesDTO sede = new SedesDTO(0, ubicacionSede, numeroEmpleado);
//		this.sede.generarIdSede();
		sedes.crearSede(sede);
		vista.mostrarMensajeInformacion("Se ha agregado la sede correctammente");
		vista.getPanelApostadores().getPanelCrearApostador().cargarComboBox(this.sedes.leerSede());
		vista.getPanelApostadores().getPanelActualizarBorrarApostador().cargarComboBox(this.sedes.leerSede());
		vista.getPanelApostadores().getPanelActualizarBorrarApostador().cargarId(listaApostador);
		vista.getPanelApuesta().cargarComboBox(this.sedes.leerSede());
		vista.getPanelApuesta().cargarId(listaApostador);
	}
}
