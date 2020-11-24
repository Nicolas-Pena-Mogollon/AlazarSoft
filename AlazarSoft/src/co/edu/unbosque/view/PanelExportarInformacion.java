package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PanelExportarInformacion extends JPanel {

	private static final long serialVersionUID = 1L;
	private final String COMMAND_EXPORTARPDF = "EXPORTARPDF";
	private final String COMMAND_EXPORTAREXCEL = "EXPORTAREXCEL";
	private final String COMMAND_MOSTRARTABLA = "MOSTRARTABLA";
	private JLabel etiquetaOpcionExportar;
	private JLabel etiquetaFiltroFecha;
	private JLabel etiquetaFecha;
	private JLabel etiquetaTabla;
	private JComboBox<String> comboOpcionExportar;
	private JComboBox<String> comboFiltroFecha;
	private JTextField campoTextoFecha;
	private JPanel panelOpcionesExportar;
	private JPanel panelBotones;
	private JButton botonExportarPDF;
	private JButton botonExportarExcel;
	private JButton botonMostrarInfo;
	private JTable tablaInformacion;
	private DefaultTableModel tablaModelo;
	private JScrollPane scroll;

	public PanelExportarInformacion() {
		setLayout(new BorderLayout());

		panelOpcionesExportar = new JPanel(new GridLayout(4, 2));
		etiquetaFiltroFecha = new JLabel("Escoja el filtrado por fecha");
		etiquetaOpcionExportar = new JLabel("Información a exportar");
		etiquetaFecha = new JLabel("Escriba la fecha en formato dd/mm/yyyy");
		etiquetaTabla = new JLabel("Mostrar la información en pantalla");

		comboFiltroFecha = new JComboBox<String>();
		comboFiltroFecha.addItem("Seleccione");
		comboFiltroFecha.addItem("día, mes y año");
		comboFiltroFecha.addItem("mes y año");
		comboFiltroFecha.addItem("año");

		comboOpcionExportar = new JComboBox<String>();
		comboOpcionExportar.addItem("Seleccione");
		comboOpcionExportar.addItem("Listado de clientes por sede");
		comboOpcionExportar.addItem("Valor total de apuestas por cliente");
		comboOpcionExportar.addItem("Detalle de apuestas realizadas por cliente y sede");
		comboOpcionExportar.addItem("Total de apuestas por sede y tipo de juego");
		SimpleDateFormat dateF = new SimpleDateFormat("hh: mm: ss a dd/MM/yyyy");
		campoTextoFecha = new JTextField(dateF.format(new Date()));

		tablaModelo = new DefaultTableModel();
		tablaInformacion = new JTable(tablaModelo);
		tablaModelo.fireTableStructureChanged();
		tablaModelo.addColumn("");
		tablaModelo.addColumn("");
		tablaModelo.addColumn("");
		tablaModelo.addColumn("");
		tablaModelo.addColumn("");

		scroll = new JScrollPane(tablaInformacion);

		panelOpcionesExportar.add(etiquetaOpcionExportar);
		panelOpcionesExportar.add(comboOpcionExportar);
		panelOpcionesExportar.add(etiquetaFiltroFecha);
		panelOpcionesExportar.add(comboFiltroFecha);
		panelOpcionesExportar.add(etiquetaFecha);
		panelOpcionesExportar.add(campoTextoFecha);
		panelOpcionesExportar.add(etiquetaTabla);

		botonMostrarInfo = new JButton("Mostrar Información exportada");
		botonMostrarInfo.setActionCommand(COMMAND_MOSTRARTABLA);
		panelOpcionesExportar.add(botonMostrarInfo);

		panelBotones = new JPanel(new GridLayout(1, 2));
		botonExportarPDF = new JButton("Exportar PDF");
		botonExportarPDF.setActionCommand(COMMAND_EXPORTARPDF);
		botonExportarExcel = new JButton("Exportar Excel");
		botonExportarExcel.setActionCommand(COMMAND_EXPORTAREXCEL);

		panelBotones.add(botonExportarPDF);
		panelBotones.add(botonExportarExcel);

		add(panelOpcionesExportar, BorderLayout.PAGE_START);
		this.add(scroll, BorderLayout.CENTER);
		add(panelBotones, BorderLayout.PAGE_END);

	}

	/**
	 * @return the comboOpcionExportar
	 */
	public JComboBox<String> getComboOpcionExportar() {
		return comboOpcionExportar;
	}

	/**
	 * @param comboOpcionExportar the comboOpcionExportar to set
	 */
	public void setComboOpcionExportar(JComboBox<String> comboOpcionExportar) {
		this.comboOpcionExportar = comboOpcionExportar;
	}

	/**
	 * @return the comboFiltroFecha
	 */
	public JComboBox<String> getComboFiltroFecha() {
		return comboFiltroFecha;
	}

	/**
	 * @param comboFiltroFecha the comboFiltroFecha to set
	 */
	public void setComboFiltroFecha(JComboBox<String> comboFiltroFecha) {
		this.comboFiltroFecha = comboFiltroFecha;
	}

	/**
	 * @return the botonExportarPDF
	 */
	public JButton getBotonExportarPDF() {
		return botonExportarPDF;
	}

	/**
	 * @param botonExportarPDF the botonExportarPDF to set
	 */
	public void setBotonExportarPDF(JButton botonExportarPDF) {
		this.botonExportarPDF = botonExportarPDF;
	}

	/**
	 * @return the botonExportarExcel
	 */
	public JButton getBotonExportarExcel() {
		return botonExportarExcel;
	}

	/**
	 * @param botonExportarExcel the botonExportarExcel to set
	 */
	public void setBotonExportarExcel(JButton botonExportarExcel) {
		this.botonExportarExcel = botonExportarExcel;
	}

	/**
	 * @return the cOMMAND_EXPORTARPDF
	 */
	public String getCOMMAND_EXPORTARPDF() {
		return COMMAND_EXPORTARPDF;
	}

	/**
	 * @return the cOMMAND_EXPORTAREXCEL
	 */
	public String getCOMMAND_EXPORTAREXCEL() {
		return COMMAND_EXPORTAREXCEL;
	}

	/**
	 * @return the campoTextoFecha
	 */
	public JTextField getCampoTextoFecha() {
		return campoTextoFecha;
	}

	/**
	 * @param campoTextoFecha the campoTextoFecha to set
	 */
	public void setCampoTextoFecha(JTextField campoTextoFecha) {
		this.campoTextoFecha = campoTextoFecha;
	}

	public JPanel getPanelOpcionesExportar() {
		return panelOpcionesExportar;
	}

	public void setPanelOpcionesExportar(JPanel panelOpcionesExportar) {
		this.panelOpcionesExportar = panelOpcionesExportar;
	}

	public JPanel getPanelBotones() {
		return panelBotones;
	}

	public void setPanelBotones(JPanel panelBotones) {
		this.panelBotones = panelBotones;
	}

	public JButton getBotonMostrarInfo() {
		return botonMostrarInfo;
	}

	public void setBotonMostrarInfo(JButton botonMostrarInfo) {
		this.botonMostrarInfo = botonMostrarInfo;
	}

	public String getCOMMAND_MOSTRARTABLA() {
		return COMMAND_MOSTRARTABLA;
	}

}
