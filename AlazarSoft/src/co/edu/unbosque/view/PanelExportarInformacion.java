package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.formdev.flatlaf.util.ScaledImageIcon;

public class PanelExportarInformacion extends JPanel {

	private static final long serialVersionUID = 1L;
	private final String COMMAND_EXPORTARPDF = "EXPORTARPDF";
	private final String COMMAND_EXPORTAREXCEL = "EXPORTAREXCEL";
	private final String PDF = "./Imagenes/PDF.jpg";
	private final String EXCEL = "./Imagenes/EXCEL.jpg";
	private JLabel etiquetaOpcionExportar;
	private JLabel etiquetaFiltroFecha;
	private JLabel etiquetaFecha;
	private JComboBox<String> comboOpcionExportar;
	private JComboBox<String> comboFiltroFecha;
	private JTextField campoTextoFecha;
	private JPanel panelOpcionesExportar;
	private JPanel panelBotones;
	private JButton botonExportarPDF;
	private JButton botonExportarExcel;

	public PanelExportarInformacion() {
		setLayout(new BorderLayout());

		panelOpcionesExportar = new JPanel(new GridLayout(3, 2));
		etiquetaFiltroFecha = new JLabel("Escoja el filtrado por fecha");
		etiquetaOpcionExportar = new JLabel("Información a exportar");
		etiquetaFecha = new JLabel("Escriba la fecha en formato dd/mm/yyyy");

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

		panelOpcionesExportar.add(etiquetaOpcionExportar);
		panelOpcionesExportar.add(comboOpcionExportar);
		panelOpcionesExportar.add(etiquetaFiltroFecha);
		panelOpcionesExportar.add(comboFiltroFecha);
		panelOpcionesExportar.add(etiquetaFecha);
		panelOpcionesExportar.add(campoTextoFecha);

		panelBotones = new JPanel(new GridLayout(1, 2));
		botonExportarPDF = new JButton();
		botonExportarPDF.setActionCommand(COMMAND_EXPORTARPDF);
		botonExportarPDF.setIcon(new ScaledImageIcon(new ImageIcon(PDF), 330, 270));
		botonExportarExcel = new JButton();
		botonExportarExcel.setIcon(new ScaledImageIcon(new ImageIcon(EXCEL), 350, 250));
		botonExportarExcel.setActionCommand(COMMAND_EXPORTAREXCEL);

		panelBotones.add(botonExportarPDF);
		panelBotones.add(botonExportarExcel);

		add(panelOpcionesExportar, BorderLayout.PAGE_START);
		add(panelBotones, BorderLayout.CENTER);

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

}
