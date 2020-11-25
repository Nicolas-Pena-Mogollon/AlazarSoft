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

/**
 * Clase PanelGraficoVentasSedes
 */

public class PanelGraficoVentasSedes extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton botonMostrarSedesMayoresVentas;
	private final String COMMAND_GRAFICA_SEDES_MAYORES_VENTAS = "GRAFICA_SEDES_MAYORES_VENTAS";
	private ChartPanel chartPanel;
	private DefaultCategoryDataset dataGraficaMayoresVentas;
	private JFreeChart graficoSedesMayoresApuestas;

	/**
	 * Constructor con inicialización de atributos
	 */

	public PanelGraficoVentasSedes() {
		setBorder(new TitledBorder("Top 5 de las sedes con mayores ventas realizadas"));
		setLayout(new BorderLayout());
		botonMostrarSedesMayoresVentas = new JButton("Mostrar gráfico");
		botonMostrarSedesMayoresVentas.setActionCommand(COMMAND_GRAFICA_SEDES_MAYORES_VENTAS);
		dataGraficaMayoresVentas = new DefaultCategoryDataset();
		graficoSedesMayoresApuestas = ChartFactory.createBarChart("Top 5 de las sedes con mayores ventas realizadas",
				"Días", "Ventas por día", dataGraficaMayoresVentas, PlotOrientation.VERTICAL, true, true, false);
		chartPanel = new ChartPanel(graficoSedesMayoresApuestas);
		add(chartPanel, BorderLayout.CENTER);
		add(botonMostrarSedesMayoresVentas, BorderLayout.PAGE_END);

	}

	/**
	 * Recibe la información para añadirla a las gráficas
	 * 
	 * @param informacion
	 */

	public void recibirInfomacion(String[][] informacion) {
		for (int i = 0; i < informacion.length; i++)
			dataGraficaMayoresVentas.addValue(Double.parseDouble(informacion[i][0]), informacion[i][1],
					informacion[i][2]);
	}

	/**
	 * @return the botonMostrarSedesMayoresVentas
	 */
	public JButton getBotonMostrarSedesMayoresVentas() {
		return botonMostrarSedesMayoresVentas;
	}

	/**
	 * @param botonMostrarSedesMayoresVentas the botonMostrarSedesMayoresVentas to
	 *                                       set
	 */
	public void setBotonMostrarSedesMayoresVentas(JButton botonMostrarSedesMayoresVentas) {
		this.botonMostrarSedesMayoresVentas = botonMostrarSedesMayoresVentas;
	}

	/**
	 * @return the cOMMAND_GRAFICA_SEDES_MAYORES_VENTAS
	 */
	public String getCOMMAND_GRAFICA_SEDES_MAYORES_VENTAS() {
		return COMMAND_GRAFICA_SEDES_MAYORES_VENTAS;
	}

}
