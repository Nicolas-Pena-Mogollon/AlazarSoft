package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Clase PanelMenuCasaApuestas
 */

public class PanelMenuCasaApuestas extends JPanel {

	private static final long serialVersionUID = 1L;
	private final String COMMAND_CONFIGURACION_CASA_APUESTAS = "CONFIGURACION_CASA_APUESTAS";
	private final String COMMAND_GESTION_SEDES = "GESTION_SEDES";
	private final String COMMAND_GESTION_APOSTADORES = "GESTION_APOSTADORES";
	private final String COMMAND_GESTION_APUESTAS = "GESTION_APUESTAS";
	private final String COMMAND_PLANES_PREMIACION = "PLANES_PREMIACION";
	private final String COMMAND_CONSULTA_REPORTES = "CONSULTA_REPORTES";

	private JButton botonConfiguracionCasaApuestas;
	private JButton botonGestionSedes;
	private JButton botonGestionApostadores;
	private JButton botonGestionApuestas;
	private JButton botonPlanesPremiacion;
	private JButton botonConsultasReportes;

	/**
	 * Constructor con inicialización de atributos
	 */

	public PanelMenuCasaApuestas() {

		setLayout(new GridLayout(6, 1));

		botonConfiguracionCasaApuestas = new JButton("Configuración casa de apuestas");
		botonGestionSedes = new JButton("Gestión de sedes");
		botonGestionApostadores = new JButton("Gestion de apostadores");
		botonGestionApuestas = new JButton("Gestion de las apuestas");
		botonPlanesPremiacion = new JButton("Planes y premiación");
		botonConsultasReportes = new JButton("Consulta de reportes");

		add(botonConfiguracionCasaApuestas);
		add(botonGestionSedes);
		add(botonGestionApostadores);
		add(botonGestionApuestas);
		add(botonPlanesPremiacion);
		add(botonConsultasReportes);

		botonConfiguracionCasaApuestas.setActionCommand(COMMAND_CONFIGURACION_CASA_APUESTAS);
		botonGestionSedes.setActionCommand(COMMAND_GESTION_SEDES);
		botonGestionApostadores.setActionCommand(COMMAND_GESTION_APOSTADORES);
		botonGestionApuestas.setActionCommand(COMMAND_GESTION_APUESTAS);
		botonPlanesPremiacion.setActionCommand(COMMAND_PLANES_PREMIACION);
		botonConsultasReportes.setActionCommand(COMMAND_CONSULTA_REPORTES);

	}

	/**
	 * @return the botonConfiguracionCasaApuestas
	 */
	public JButton getBotonConfiguracionCasaApuestas() {
		return botonConfiguracionCasaApuestas;
	}

	/**
	 * @param botonConfiguracionCasaApuestas the botonConfiguracionCasaApuestas to
	 *                                       set
	 */
	public void setBotonConfiguracionCasaApuestas(JButton botonConfiguracionCasaApuestas) {
		this.botonConfiguracionCasaApuestas = botonConfiguracionCasaApuestas;
	}

	/**
	 * @return the botonGestionSedes
	 */
	public JButton getBotonGestionSedes() {
		return botonGestionSedes;
	}

	/**
	 * @param botonGestionSedes the botonGestionSedes to set
	 */
	public void setBotonGestionSedes(JButton botonGestionSedes) {
		this.botonGestionSedes = botonGestionSedes;
	}

	/**
	 * @return the botonGestionApostadores
	 */
	public JButton getBotonGestionApostadores() {
		return botonGestionApostadores;
	}

	/**
	 * @param botonGestionApostadores the botonGestionApostadores to set
	 */
	public void setBotonGestionApostadores(JButton botonGestionApostadores) {
		this.botonGestionApostadores = botonGestionApostadores;
	}

	/**
	 * @return the botonGestionApuestas
	 */
	public JButton getBotonGestionApuestas() {
		return botonGestionApuestas;
	}

	/**
	 * @param botonGestionApuestas the botonGestionApuestas to set
	 */
	public void setBotonGestionApuestas(JButton botonGestionApuestas) {
		this.botonGestionApuestas = botonGestionApuestas;
	}

	/**
	 * @return the botonPlanesPremiacion
	 */
	public JButton getBotonPlanesPremiacion() {
		return botonPlanesPremiacion;
	}

	/**
	 * @param botonPlanesPremiacion the botonPlanesPremiacion to set
	 */
	public void setBotonPlanesPremiacion(JButton botonPlanesPremiacion) {
		this.botonPlanesPremiacion = botonPlanesPremiacion;
	}

	/**
	 * @return the botonConsultasReportes
	 */
	public JButton getBotonConsultasReportes() {
		return botonConsultasReportes;
	}

	/**
	 * @param botonConsultasReportes the botonConsultasReportes to set
	 */
	public void setBotonConsultasReportes(JButton botonConsultasReportes) {
		this.botonConsultasReportes = botonConsultasReportes;
	}

	/**
	 * @return the cOMMAND_CONFIGURACION_CASA_APUESTAS
	 */
	public String getCOMMAND_CONFIGURACION_CASA_APUESTAS() {
		return COMMAND_CONFIGURACION_CASA_APUESTAS;
	}

	/**
	 * @return the cOMMAND_GESTION_SEDES
	 */
	public String getCOMMAND_GESTION_SEDES() {
		return COMMAND_GESTION_SEDES;
	}

	/**
	 * @return the cOMMAND_GESTION_APOSTADORES
	 */
	public String getCOMMAND_GESTION_APOSTADORES() {
		return COMMAND_GESTION_APOSTADORES;
	}

	/**
	 * @return the cOMMAND_GESTION_APUESTAS
	 */
	public String getCOMMAND_GESTION_APUESTAS() {
		return COMMAND_GESTION_APUESTAS;
	}

	/**
	 * @return the cOMMAND_PLANES_PREMIACION
	 */
	public String getCOMMAND_PLANES_PREMIACION() {
		return COMMAND_PLANES_PREMIACION;
	}

	/**
	 * @return the cOMMAND_CONSULTA_REPORTES
	 */
	public String getCOMMAND_CONSULTA_REPORTES() {
		return COMMAND_CONSULTA_REPORTES;
	}

}
