/**
 * Paquete vista
 */
package co.edu.unbosque.view;

import javax.swing.JTabbedPane;

/**
 * Clase PanelConsultasReportes
 */

public class PanelConsultasReportes extends JTabbedPane {

	/**
	 * Asociacion clase PanelExportarInformacion 
	 * Asociacion clase PanelHistoricoVentas
	 * Asociacion clase PanelGraficoVentasSedes
	 * Asociacion clase PanelGraficaClientes
	 * Asociacion clase PanelGraficoApuestas
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private PanelExportarInformacion panelExportarInformacion;
	private PanelHistoricoVentas panelHistoricoVentas;
	private PanelGraficoVentasSedes panelGraficoVentasSedes;
	private PanelGraficaClientes panelGraficaClientes;
	private PanelGraficoApuestas panelGraficoApuestas;

	/**
	 * Constructor con inicialización de atributos
	 */

	public PanelConsultasReportes() {

		panelExportarInformacion = new PanelExportarInformacion();
		panelHistoricoVentas = new PanelHistoricoVentas();
		panelGraficoVentasSedes = new PanelGraficoVentasSedes();
		panelGraficaClientes = new PanelGraficaClientes();
		panelGraficoApuestas = new PanelGraficoApuestas();

		add(panelExportarInformacion, "Exportar Información");
		add(panelHistoricoVentas, "Gráfica ventas");
		add(panelGraficoVentasSedes, "Gráfica Sedes");
		add(panelGraficaClientes, "Gráfica clientes");
		add(panelGraficoApuestas, "Gráfica tipos de apuesta");

	}

	/**
	 * @return the panelExportarInformacion
	 */
	public PanelExportarInformacion getPanelExportarInformacion() {
		return panelExportarInformacion;
	}

	/**
	 * @param panelExportarInformacion the panelExportarInformacion to set
	 */
	public void setPanelExportarInformacion(PanelExportarInformacion panelExportarInformacion) {
		this.panelExportarInformacion = panelExportarInformacion;
	}

	/**
	 * @return the panelHistoricoVentas
	 */
	public PanelHistoricoVentas getPanelHistoricoVentas() {
		return panelHistoricoVentas;
	}

	/**
	 * @param panelHistoricoVentas the panelHistoricoVentas to set
	 */
	public void setPanelHistoricoVentas(PanelHistoricoVentas panelHistoricoVentas) {
		this.panelHistoricoVentas = panelHistoricoVentas;
	}

	/**
	 * @return the panelGraficoVentasSedes
	 */
	public PanelGraficoVentasSedes getPanelGraficoVentasSedes() {
		return panelGraficoVentasSedes;
	}

	/**
	 * @param panelGraficoVentasSedes the panelGraficoVentasSedes to set
	 */
	public void setPanelGraficoVentasSedes(PanelGraficoVentasSedes panelGraficoVentasSedes) {
		this.panelGraficoVentasSedes = panelGraficoVentasSedes;
	}

	/**
	 * @return the panelGraficaClientes
	 */
	public PanelGraficaClientes getPanelGraficaClientes() {
		return panelGraficaClientes;
	}

	/**
	 * @param panelGraficaClientes the panelGraficaClientes to set
	 */
	public void setPanelGraficaClientes(PanelGraficaClientes panelGraficaClientes) {
		this.panelGraficaClientes = panelGraficaClientes;
	}

	/**
	 * @return the panelGraficoApuestas
	 */
	public PanelGraficoApuestas getPanelGraficoApuestas() {
		return panelGraficoApuestas;
	}

	/**
	 * @param panelGraficoApuestas the panelGraficoApuestas to set
	 */
	public void setPanelGraficoApuestas(PanelGraficoApuestas panelGraficoApuestas) {
		this.panelGraficoApuestas = panelGraficoApuestas;
	}

}
