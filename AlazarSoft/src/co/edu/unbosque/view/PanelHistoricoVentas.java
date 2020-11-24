package co.edu.unbosque.view;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class PanelHistoricoVentas extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton botonMostrarHistoricoVentas;
	private final String COMMAND_HISTORICO_VENTAS = "HISTORICO_VENTAS";
	private ChartPanel chartPanel;
	private DefaultCategoryDataset dataHistorico;
	private JFreeChart grafico;

	public PanelHistoricoVentas() {
		setBorder(new TitledBorder("Historico ventas por sede de los �ltimos 5 d�as"));
		setLayout(new BorderLayout());
		botonMostrarHistoricoVentas = new JButton("Mostrar hist�rico");
		botonMostrarHistoricoVentas.setActionCommand(COMMAND_HISTORICO_VENTAS);
		dataHistorico = new DefaultCategoryDataset();

		grafico = ChartFactory.createBarChart("Historico ventas por sede de los �ltimos 5 d�as", "D�as",
				"Ventas por d�a", dataHistorico, PlotOrientation.VERTICAL, true, true, false);
		chartPanel = new ChartPanel(grafico);

		add(chartPanel, BorderLayout.CENTER);
		add(botonMostrarHistoricoVentas, BorderLayout.PAGE_END);

	}

	public void recibirInfomacion(String[][] informacion) {
		for (int i = 0; i < informacion.length; i++) {
			dataHistorico.addValue(Double.parseDouble(informacion[i][0]), informacion[i][1], informacion[i][2]);
		}
	}

	/**
	 * @return the botonMostrarHistoricoVentas
	 */
	public JButton getBotonMostrarHistoricoVentas() {
		return botonMostrarHistoricoVentas;
	}

	/**
	 * @param botonMostrarHistoricoVentas the botonMostrarHistoricoVentas to set
	 */
	public void setBotonMostrarHistoricoVentas(JButton botonMostrarHistoricoVentas) {
		this.botonMostrarHistoricoVentas = botonMostrarHistoricoVentas;
	}

	/**
	 * @return the cOMMAND_HISTORICO_VENTAS
	 */
	public String getCOMMAND_HISTORICO_VENTAS() {
		return COMMAND_HISTORICO_VENTAS;
	}

}
