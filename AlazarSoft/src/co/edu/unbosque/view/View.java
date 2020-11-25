package co.edu.unbosque.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;

import co.edu.unbosque.controller.Controller;

/**
 * Clase View
 */

public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelCasaApuestas panelCasaApuestas;
	private PanelMenuCasaApuestas panelMenuCasaApuestas;
	private PanelApostadores panelApostadores;
	private PanelApuestas panelApuestas;
	private PanelSede panelSede;
	private PanelPremiacion panelPremiacion;
	private PanelConsultasReportes panelConsultasReportes;
	private JSplitPane splitPane;

	/**
	 * Constructor con inicialización de atributos
	 * 
	 * @param control
	 */

	public View(Controller control) {

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(870, 300);
		this.setTitle("Casa de apuestas");
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		panelCasaApuestas = new PanelCasaApuestas();
		panelApostadores = new PanelApostadores();
		panelSede = new PanelSede();
		panelApuestas = new PanelApuestas();
		panelMenuCasaApuestas = new PanelMenuCasaApuestas();
		panelConsultasReportes = new PanelConsultasReportes();
		panelPremiacion = new PanelPremiacion();

		splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setLeftComponent(panelMenuCasaApuestas);
		splitPane.setRightComponent(panelCasaApuestas);

		getContentPane().add(splitPane);
		asignarOyentes(control);
		repaint();
		revalidate();
	}

	/**
	 * 
	 * @param control
	 */

	public void asignarOyentes(Controller control) {
		panelMenuCasaApuestas.getBotonConfiguracionCasaApuestas().addActionListener(control);
		panelMenuCasaApuestas.getBotonGestionSedes().addActionListener(control);
		panelMenuCasaApuestas.getBotonGestionApostadores().addActionListener(control);
		panelMenuCasaApuestas.getBotonGestionApuestas().addActionListener(control);
		panelMenuCasaApuestas.getBotonPlanesPremiacion().addActionListener(control);
		panelMenuCasaApuestas.getBotonConsultasReportes().addActionListener(control);
		panelCasaApuestas.getPanelIngresoCasaApuestas().getBotonGuardar().addActionListener(control);
		panelCasaApuestas.getPanelDatosJuegos().getBotonGuardarDatosJuego().addActionListener(control);
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
		panelApuestas.getPanelMostrarBorrarApuesta().getBotonBorrarInformacionApuestas().addActionListener(control);
		panelApuestas.getPanelMostrarBorrarApuesta().getBotonLeerInformacionApuestas().addActionListener(control);
		panelConsultasReportes.getPanelExportarInformacion().getBotonExportarPDF().addActionListener(control);
		panelConsultasReportes.getPanelExportarInformacion().getBotonExportarExcel().addActionListener(control);
		panelConsultasReportes.getPanelGraficaClientes().getBotonMostrarClientesMayoresApuestas()
				.addActionListener(control);
		panelConsultasReportes.getPanelGraficoApuestas().getBotonMostrarGraficoApuestas().addActionListener(control);
		panelConsultasReportes.getPanelGraficoVentasSedes().getBotonMostrarSedesMayoresVentas()
				.addActionListener(control);
		panelConsultasReportes.getPanelHistoricoVentas().getBotonMostrarHistoricoVentas().addActionListener(control);
		panelConsultasReportes.getPanelExportarInformacion().getBotonMostrarInfo().addActionListener(control);
	}

	/**
	 * Envia un mensaje de error por medio de un JOptionPane
	 * 
	 * @param message
	 */

	public void mostrarMensajeError(String message) {
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Envia un mensaje de advertencia por medio de un JOptionPane
	 * 
	 * @return
	 */

	public boolean mostrarMensajeAdvertencia() {
		int entrada = JOptionPane.showConfirmDialog(null, "", "Advertencia", JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE);
		if (entrada == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Envia un mensaje de información por medio de un JOptionPane
	 * 
	 * @param message
	 */

	public void mostrarMensajeInformacion(String message) {
		JOptionPane.showMessageDialog(null, message, "Información", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * @return the panelCasaApuestas
	 */
	public PanelCasaApuestas getPanelCasaApuestas() {
		return panelCasaApuestas;
	}

	/**
	 * @param panelCasaApuestas the panelCasaApuestas to set
	 */
	public void setPanelCasaApuestas(PanelCasaApuestas panelCasaApuestas) {
		this.panelCasaApuestas = panelCasaApuestas;
	}

	/**
	 * @return the panelMenuCasaApuestas
	 */
	public PanelMenuCasaApuestas getPanelMenuCasaApuestas() {
		return panelMenuCasaApuestas;
	}

	/**
	 * @param panelMenuCasaApuestas the panelMenuCasaApuestas to set
	 */
	public void setPanelMenuCasaApuestas(PanelMenuCasaApuestas panelMenuCasaApuestas) {
		this.panelMenuCasaApuestas = panelMenuCasaApuestas;
	}

	/**
	 * @return the panelApostadores
	 */
	public PanelApostadores getPanelApostadores() {
		return panelApostadores;
	}

	/**
	 * @param panelApostadores the panelApostadores to set
	 */
	public void setPanelApostadores(PanelApostadores panelApostadores) {
		this.panelApostadores = panelApostadores;
	}

	/**
	 * @return the panelApuestas
	 */
	public PanelApuestas getPanelApuestas() {
		return panelApuestas;
	}

	/**
	 * @param panelApuestas the panelApuestas to set
	 */
	public void setPanelApuestas(PanelApuestas panelApuestas) {
		this.panelApuestas = panelApuestas;
	}

	/**
	 * @return the panelSede
	 */
	public PanelSede getPanelSede() {
		return panelSede;
	}

	/**
	 * @param panelSede the panelSede to set
	 */
	public void setPanelSede(PanelSede panelSede) {
		this.panelSede = panelSede;
	}

	/**
	 * @return the panelConsultasReportes
	 */
	public PanelConsultasReportes getPanelConsultasReportes() {
		return panelConsultasReportes;
	}

	/**
	 * @param panelConsultasReportes the panelConsultasReportes to set
	 */
	public void setPanelConsultasReportes(PanelConsultasReportes panelConsultasReportes) {
		this.panelConsultasReportes = panelConsultasReportes;
	}

	/**
	 * @return the splitPane
	 */
	public JSplitPane getSplitPane() {
		return splitPane;
	}

	/**
	 * @param splitPane the splitPane to set
	 */
	public void setSplitPane(JSplitPane splitPane) {
		this.splitPane = splitPane;
	}

	/**
	 * @return the panelPremiacion
	 */
	public PanelPremiacion getPanelPremiacion() {
		return panelPremiacion;
	}

	/**
	 * @param panelPremiacion the panelPremiacion to set
	 */
	public void setPanelPremiacion(PanelPremiacion panelPremiacion) {
		this.panelPremiacion = panelPremiacion;
	}

}
