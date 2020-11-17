package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
		} else if (e.getActionCommand().equals(vista.getPanelIngresoCasaApuestas().getCOMMAND_INGRESAR())) {
			this.coordinarConfiguracionCasaApuestas();
		} else if (e.getActionCommand().equals(vista.getPanelSede().getPanelSedeCrear().getCOMMAND_GUARDAR())) {
			this.gestionSedes();
		} else if (e.getActionCommand()
				.equals(vista.getPanelApostadores().getPanelCrearApostador().getCOMMAND_CREAR_APOSTADOR())) {
			gestionApostadores();
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

	public void gestionApostadores() {
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
				if (apostador.agregarApostador(nombre, cedula, sede, direccion, celular, listaApostador,
						fileApostador)) {
					JOptionPane.showMessageDialog(null, "Registro correcto");
					vista.getPanelApostadores().getPanelCrearApostador().limpiarCampos();
				} else {
					JOptionPane.showMessageDialog(null, "El número de cedula ya se encuentra registrado");

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

	public void gestionSedes() {
		String ubicacionSede = vista.getPanelSede().getPanelSedeCrear().getCampoTextoNombreSede().getText();
		String empleados = vista.getPanelSede().getPanelSedeCrear().getCampoTextoNumeroEmpleado().getText();
		int numeroEmpleado = Integer.parseInt(empleados);
		SedesDTO sede = new SedesDTO(this.sede.generarIdSede(), ubicacionSede, numeroEmpleado);
		sedes.crearSede(sede);
	}
}
