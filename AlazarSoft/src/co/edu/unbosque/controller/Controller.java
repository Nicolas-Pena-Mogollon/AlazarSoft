package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Apostador;
import co.edu.unbosque.model.CasaDeApuestas;
import co.edu.unbosque.model.CedulaException;
import co.edu.unbosque.model.CelularException;
import co.edu.unbosque.model.Sede;
import co.edu.unbosque.model.persistence.ApostadorDAO;
import co.edu.unbosque.model.persistence.ApostadorDTO;
import co.edu.unbosque.model.persistence.Archivo;
import co.edu.unbosque.model.persistence.SedesDAO;
import co.edu.unbosque.model.persistence.SedesDTO;
import co.edu.unbosque.view.View;

public class Controller implements ActionListener {

	private CasaDeApuestas casaApuestas;
	private View vista;
	private SedesDAO sedes;
	private Sede sede;
	private ApostadorDAO apostador;
	private Apostador apostadorV;
	private File fileApostador = new File("Data\\apostadores.dat");
	private ArrayList<ApostadorDTO> listaApostador;
	private Archivo archivoApostador;

	public Controller() {
		vista = new View(this);
		casaApuestas = new CasaDeApuestas();
		sedes = new SedesDAO();
		sede = new Sede();
		apostador = new ApostadorDAO();
		apostadorV = new Apostador();
		archivoApostador = new Archivo();
		listaApostador = archivoApostador.leerArchivo(fileApostador);
		vista.getPanelApostadores().getPanelCrearApostador().cargarComboBox(this.sedes.leerSede());
		vista.getPanelApostadores().getPanelActualizarBorrarApostador().cargarComboBox(this.sedes.leerSede());
		vista.getPanelApostadores().getPanelActualizarBorrarApostador().cargarId(listaApostador);
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
			vista.getSplitPane().setRightComponent(vista.getPanelApuesta());
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
			} else if (vista.getPanelApuesta().getComboTiposApuesta().getSelectedItem().equals("F�tbol")) {
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
					JOptionPane.showMessageDialog(null, "El n�mero telef�nico ya se encuentra registrado");
				} else {
					if (apostador.agregarApostador(nombre, cedula, sede, direccion, celular, listaApostador,
							fileApostador)) {
						JOptionPane.showMessageDialog(null, "Registro correcto");
						vista.getPanelApostadores().getPanelCrearApostador().cargarComboBox(this.sedes.leerSede());
						vista.getPanelApostadores().getPanelActualizarBorrarApostador().cargarId(listaApostador);
						vista.getPanelApostadores().getPanelCrearApostador().limpiarCampos();
						vista.getPanelApostadores().getPanelActualizarBorrarApostador().cargarComboBox(this.sedes.leerSede());

					} else {
						JOptionPane.showMessageDialog(null, "El n�mero de cedula ya se encuentra registrado");

					}
				}
			} catch (CedulaException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			} catch (CelularException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Verifique los campos");
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
			System.out.println(apostador.mostrarApostadorBusqueda(listaApostador, cedula));
		}

	}

	public void gestionApostadoresActualizar() {
		String[] entradas = vista.getPanelApostadores().getPanelActualizarBorrarApostador()
				.verificarEntradasActualizarInformacionApostador();
		if(entradas[0].equals("0")) {
			try {
				apostadorV.verificarCelular(entradas[3]);
				if (apostador.editarApostador(entradas[5], entradas[1], entradas[4], entradas[2], entradas[3], listaApostador, fileApostador)) {
					JOptionPane.showMessageDialog(null, "Se ha editado correctamente");
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (CelularException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}else {
			vista.mostrarMensajeError(entradas[1]);
		}
		
	}

	public void gestionSedes() {
		String ubicacionSede = vista.getPanelSede().getPanelSedeCrear().getCampoTextoNombreSede().getText();
		String empleados = vista.getPanelSede().getPanelSedeCrear().getCampoTextoNumeroEmpleado().getText();
		int numeroEmpleado = Integer.parseInt(empleados);
		SedesDTO sede = new SedesDTO(this.sede.generarIdSede(), ubicacionSede, numeroEmpleado);
		sedes.crearSede(sede);
	}
}
