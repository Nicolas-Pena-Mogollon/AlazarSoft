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

public class PanelGraficoApuestas extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton botonMostrarGraficoApuestas;
	private final String COMMAND_GRAFICA_APUESTAS = "GRAFICA_APUESTAS";
	private ChartPanel chartPanelGraficoApuestas;
	private DefaultCategoryDataset dataGraficoApuestas;
	private JFreeChart graficoApuestas;

	public PanelGraficoApuestas() {
		setBorder(new TitledBorder("Top 3 de los tipos de apuesta con mayores ganadores"));
		setLayout(new BorderLayout());
		botonMostrarGraficoApuestas = new JButton("Mostrar gr�fico");
		botonMostrarGraficoApuestas.setActionCommand(COMMAND_GRAFICA_APUESTAS);
		dataGraficoApuestas = new DefaultCategoryDataset();
		graficoApuestas = ChartFactory.createBarChart("Top 3 de los tipos de apuesta con mayores ganadores", "D�as",
				"Ventas por d�a", dataGraficoApuestas, PlotOrientation.VERTICAL, true, true, false);
		chartPanelGraficoApuestas = new ChartPanel(graficoApuestas);
		add(chartPanelGraficoApuestas, BorderLayout.CENTER);
		add(botonMostrarGraficoApuestas, BorderLayout.PAGE_END);

	}

	public void recibirInfomacion(String[][] informacion) {
		for (int i = 0; i < informacion.length; i++)
			dataGraficoApuestas.addValue(Double.parseDouble(informacion[i][0]), informacion[i][1], informacion[i][2]);
	}

	/**
	 * @return the botonMostrarGraficoApuestas
	 */
	public JButton getBotonMostrarGraficoApuestas() {
		return botonMostrarGraficoApuestas;
	}

	/**
	 * @param botonMostrarGraficoApuestas the botonMostrarGraficoApuestas to set
	 */
	public void setBotonMostrarGraficoApuestas(JButton botonMostrarGraficoApuestas) {
		this.botonMostrarGraficoApuestas = botonMostrarGraficoApuestas;
	}

	/**
	 * @return the cOMMAND_GRAFICA_APUESTAS
	 */
	public String getCOMMAND_GRAFICA_APUESTAS() {
		return COMMAND_GRAFICA_APUESTAS;
	}

}
