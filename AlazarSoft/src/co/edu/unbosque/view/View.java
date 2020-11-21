package co.edu.unbosque.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;

import co.edu.unbosque.controller.Controller;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelIngresoCasaApuestas panelIngresoCasaApuestas;
	private PanelMenuCasaApuestas panelMenuCasaApuestas;
	private PanelApostadores panelApostadores;
	private PanelApuestas panelApuestas;
	private PanelSede panelSede;
	private JSplitPane splitPane;

	public View(Controller control) {

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(870, 300);
		this.setTitle("Casa de apuestas");
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		panelIngresoCasaApuestas = new PanelIngresoCasaApuestas();
		panelApostadores = new PanelApostadores();
		panelSede = new PanelSede();
		panelApuestas = new PanelApuestas();
		panelMenuCasaApuestas = new PanelMenuCasaApuestas();

		splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setLeftComponent(panelMenuCasaApuestas);
		splitPane.setRightComponent(panelApostadores);
		getContentPane().add(splitPane);
		asignarOyentes(control);
		repaint();
		revalidate();

	}

	public void asignarOyentes(Controller control) {
		panelMenuCasaApuestas.getBotonConfiguracionCasaApuestas().addActionListener(control);
		panelMenuCasaApuestas.getBotonGestionSedes().addActionListener(control);
		panelMenuCasaApuestas.getBotonGestionApostadores().addActionListener(control);
		panelMenuCasaApuestas.getBotonGestionApuestas().addActionListener(control);
		panelMenuCasaApuestas.getBotonPlanesPremiacion().addActionListener(control);
		panelMenuCasaApuestas.getBotonConsultasReportes().addActionListener(control);
		panelIngresoCasaApuestas.getBotonGuardar().addActionListener(control);
		panelSede.getPanelSedeCrear().getBotonSede().addActionListener(control);
		panelSede.getPanelSedeModificar().getBotonActualizar().addActionListener(control);
		panelApostadores.getPanelCrearApostador().getBotonCrearApostador().addActionListener(control);
		panelApostadores.getPanelActualizarBorrarApostador().getBotonActualizar().addActionListener(control);
		panelApostadores.getPanelActualizarBorrarApostador().getBotonBorrar().addActionListener(control);
		panelApostadores.getPanelInformacionApostadores().getBotonLeerInformacionApostadores()
				.addActionListener(control);
		panelApuestas.getPanelCrearApuesta().getComboTiposApuesta().addActionListener(control);
		panelApuestas.getPanelCrearApuesta().getBotonGuardarApuestaBaloto().addActionListener(control);
		panelApuestas.getPanelModificarApuesta().getBotonModificarApuesta().addActionListener(control);
	}

	public void mostrarMensajeError(String message) {
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public boolean mostrarMensajeAdvertencia() {
		int entrada = JOptionPane.showConfirmDialog(null, "", "Advertencia", JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE);
		if (entrada == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void mostrarMensajeInformacion(String message) {
		JOptionPane.showMessageDialog(null, message, "Información", JOptionPane.INFORMATION_MESSAGE);
	}

	public PanelMenuCasaApuestas getPanelMenuCasaApuestas() {
		return panelMenuCasaApuestas;
	}

	public void setPanelMenuCasaApuestas(PanelMenuCasaApuestas panelMenuCasaApuestas) {
		this.panelMenuCasaApuestas = panelMenuCasaApuestas;
	}

	public PanelIngresoCasaApuestas getPanelIngresoCasaApuestas() {
		return panelIngresoCasaApuestas;
	}

	public void setPanelIngresoCasaApuestas(PanelIngresoCasaApuestas panelIngresoCasaApuestas) {
		this.panelIngresoCasaApuestas = panelIngresoCasaApuestas;
	}

	public PanelApostadores getPanelApostadores() {
		return panelApostadores;
	}

	public void setPanelApostadores(PanelApostadores panelApostadores) {
		this.panelApostadores = panelApostadores;
	}

	public PanelSede getPanelSede() {
		return panelSede;
	}

	public void setPanelSede(PanelSede panelSede) {
		this.panelSede = panelSede;
	}

	public PanelApuestas getPanelApuestas() {
		return panelApuestas;
	}

	public void setPanelApuestas(PanelApuestas panelApuestas) {
		this.panelApuestas = panelApuestas;
	}

	public JSplitPane getSplitPane() {
		return splitPane;
	}

	public void setSplitPane(JSplitPane splitPane) {
		this.splitPane = splitPane;
	}

}
