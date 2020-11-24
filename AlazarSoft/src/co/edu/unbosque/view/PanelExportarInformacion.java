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
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.util.ScaledImageIcon;

public class PanelExportarInformacion extends JPanel {

	private static final long serialVersionUID = 1L;
	private final String COMMAND_EXPORTARPDF = "EXPORTARPDF";
	private final String COMMAND_EXPORTAREXCEL = "EXPORTAREXCEL";
	

	private PanelInformeClientePorSede panelInformeClientePorSede;
	private PanelInformeApuestasPorCliente panelInformeApuestasPorCliente;
	private PanelInformeApuestasPorClienteSede panelInformeApuestasPorClienteSede;
	private PanelInformeApuestasPorSede panelInformeApuestasPorSede;
	
	private JTabbedPane panelTipoReporte;
	private JPanel panelBotones;
	private JButton botonExportarPDF;
	private JButton botonExportarExcel;
	
	private JTable tablaInformacionApostadores;
	private DefaultTableModel modeloTablaApostadores;
	private JScrollPane scrollTablaInformacionApostadores;


	public PanelExportarInformacion() {
		setLayout(new BorderLayout());

		panelTipoReporte = new JTabbedPane();
		
		
		
		panelInformeClientePorSede = new PanelInformeClientePorSede();
		panelInformeApuestasPorCliente = new PanelInformeApuestasPorCliente();
		panelInformeApuestasPorClienteSede = new PanelInformeApuestasPorClienteSede();
		panelInformeApuestasPorSede = new PanelInformeApuestasPorSede();
		

		modeloTablaApostadores = new DefaultTableModel();
		modeloTablaApostadores.fireTableStructureChanged();
		tablaInformacionApostadores = new JTable(modeloTablaApostadores);
		tablaInformacionApostadores.setEnabled(false);

		modeloTablaApostadores.addColumn("Sin informe");
		scrollTablaInformacionApostadores = new JScrollPane(tablaInformacionApostadores);


		panelBotones = new JPanel(new GridLayout(1, 2));
		botonExportarPDF = new JButton("Exportar a pdf");
		botonExportarPDF.setActionCommand(COMMAND_EXPORTARPDF);
		botonExportarExcel = new JButton("Exportar a excel");
		botonExportarExcel.setActionCommand(COMMAND_EXPORTAREXCEL);

		panelBotones.add(botonExportarPDF);
		panelBotones.add(botonExportarExcel);
		
		panelTipoReporte.add(panelInformeClientePorSede, "Cliente por sede");
		panelTipoReporte.add(panelInformeApuestasPorCliente, "Apuestas por cliente");
		panelTipoReporte.add(panelInformeApuestasPorClienteSede, "Apuestas por cliente y sede");
		panelTipoReporte.add(panelInformeApuestasPorSede, "Apuestas por sede");

		add(panelTipoReporte, BorderLayout.NORTH);
		add(scrollTablaInformacionApostadores, BorderLayout.CENTER);
		add(panelBotones, BorderLayout.SOUTH);

	}



	
	public PanelInformeClientePorSede getPanelInformeClientePorSede() {
		return panelInformeClientePorSede;
	}




	public void setPanelInformeClientePorSede(PanelInformeClientePorSede panelInformeClientePorSede) {
		this.panelInformeClientePorSede = panelInformeClientePorSede;
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




	public DefaultTableModel getModeloTablaApostadores() {
		return modeloTablaApostadores;
	}




	public void setModeloTablaApostadores(DefaultTableModel modeloTablaApostadores) {
		this.modeloTablaApostadores = modeloTablaApostadores;
	}




	public JTable getTablaInformacionApostadores() {
		return tablaInformacionApostadores;
	}




	public void setTablaInformacionApostadores(JTable tablaInformacionApostadores) {
		this.tablaInformacionApostadores = tablaInformacionApostadores;
	}




	public JScrollPane getScrollTablaInformacionApostadores() {
		return scrollTablaInformacionApostadores;
	}




	public void setScrollTablaInformacionApostadores(JScrollPane scrollTablaInformacionApostadores) {
		this.scrollTablaInformacionApostadores = scrollTablaInformacionApostadores;
	}




	public PanelInformeApuestasPorCliente getPanelInformeApuestasPorCliente() {
		return panelInformeApuestasPorCliente;
	}




	public void setPanelInformeApuestasPorCliente(PanelInformeApuestasPorCliente panelInformeApuestasPorCliente) {
		this.panelInformeApuestasPorCliente = panelInformeApuestasPorCliente;
	}

	
	

}
