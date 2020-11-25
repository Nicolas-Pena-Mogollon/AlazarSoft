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
 * Clase PanelGraficaClientes
 */
public class PanelGraficaClientes extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton botonMostrarClientesMayoresApuestas;
	private final String COMMAND_GRAFICA_CLIENTES_MAYORES_APUESTAS = "GRAFICA_CLIENTES_MAYORES_APUESTAS";
	private ChartPanel chartPanelClientesMayoresApuestas;
	private DefaultCategoryDataset dataGraficaClientes;
	private JFreeChart graficoClientes;

	/**
	 * Constructor con inicialización de atributos
	 */

	public PanelGraficaClientes() {
		setBorder(new TitledBorder("Top 5 de los clientes con mayores apuestas ganadas"));
		setLayout(new BorderLayout());
		botonMostrarClientesMayoresApuestas = new JButton("Mostrar gráfico");
		botonMostrarClientesMayoresApuestas.setActionCommand(COMMAND_GRAFICA_CLIENTES_MAYORES_APUESTAS);
		dataGraficaClientes = new DefaultCategoryDataset();
		graficoClientes = ChartFactory.createBarChart("Top 5 de los clientes con mayores apuestas ganadas", "",
				"Ventas por día", dataGraficaClientes, PlotOrientation.VERTICAL, true, true, false);
		chartPanelClientesMayoresApuestas = new ChartPanel(graficoClientes);
		add(chartPanelClientesMayoresApuestas, BorderLayout.CENTER);
		add(botonMostrarClientesMayoresApuestas, BorderLayout.PAGE_END);
	}

	/**
	 * Recibe la información para añadirla a las gráficas
	 * 
	 * @param informacion
	 */

	public void recibirInfomacion(String[][] informacion) {
		for (int i = 0; i < informacion.length; i++)
			dataGraficaClientes.addValue(Double.parseDouble(informacion[i][2]), informacion[i][1], informacion[i][0]);
	}

	/**
	 * @return the botonMostrarClientesMayoresApuestas
	 */
	public JButton getBotonMostrarClientesMayoresApuestas() {
		return botonMostrarClientesMayoresApuestas;
	}

	/**
	 * @param botonMostrarClientesMayoresApuestas the
	 *                                            botonMostrarClientesMayoresApuestas
	 *                                            to set
	 */
	public void setBotonMostrarClientesMayoresApuestas(JButton botonMostrarClientesMayoresApuestas) {
		this.botonMostrarClientesMayoresApuestas = botonMostrarClientesMayoresApuestas;
	}

	/**
	 * @return the cOMMAND_GRAFICA_CLIENTES_MAYORES_APUESTAS
	 */
	public String getCOMMAND_GRAFICA_CLIENTES_MAYORES_APUESTAS() {
		return COMMAND_GRAFICA_CLIENTES_MAYORES_APUESTAS;
	}

}
