package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

/**
 * Clase PanelApuestaFutbol
 */
public class PanelApuestaFutbol extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel etiquetaPartidos;
	private JLabel etiquetaResultado;
	private JComboBox<String> comboPartidos;
	private JScrollPane scrollComboPartidos;
	private JComboBox<String> comboOpcionResultado;

	/**
	 * Constructor con inicialización de atributos
	 */

	public PanelApuestaFutbol() {
		setLayout(new GridLayout());
		setBorder(new TitledBorder("Apuesta Marcadores"));

		etiquetaPartidos = new JLabel("Local Vs Visitante");
		etiquetaResultado = new JLabel("Resultado ganador");

		comboPartidos = new JComboBox<String>();
		scrollComboPartidos = new JScrollPane(comboPartidos);
		comboOpcionResultado = new JComboBox<String>();
		comboOpcionResultado.addItem("Seleccione");
		comboOpcionResultado.addItem("Local");
		comboOpcionResultado.addItem("Visitante");
		comboOpcionResultado.addItem("Empate");

		add(etiquetaPartidos);
		add(etiquetaResultado);
		add(scrollComboPartidos);
		add(comboOpcionResultado);

	}

	/**
	 * Carga el combobox con los partidos para seleccionar
	 * 
	 * @param partidos
	 */

	public void cargarCombo(String[] partidos) {
		comboPartidos.removeAllItems();
		comboPartidos.addItem("Seleccione");
		for (int i = 0; i < partidos.length; i++) {
			comboPartidos.addItem(partidos[i]);
		}

	}

	/**
	 * @return the etiquetaPartidos
	 */
	public JLabel getEtiquetaPartidos() {
		return etiquetaPartidos;
	}

	/**
	 * @param etiquetaPartidos the etiquetaPartidos to set
	 */
	public void setEtiquetaPartidos(JLabel etiquetaPartidos) {
		this.etiquetaPartidos = etiquetaPartidos;
	}

	/**
	 * @return the etiquetaResultado
	 */
	public JLabel getEtiquetaResultado() {
		return etiquetaResultado;
	}

	/**
	 * @param etiquetaResultado the etiquetaResultado to set
	 */
	public void setEtiquetaResultado(JLabel etiquetaResultado) {
		this.etiquetaResultado = etiquetaResultado;
	}

	/**
	 * @return the comboPartidos
	 */
	public JComboBox<String> getComboPartidos() {
		return comboPartidos;
	}

	/**
	 * @param comboPartidos the comboPartidos to set
	 */
	public void setComboPartidos(JComboBox<String> comboPartidos) {
		this.comboPartidos = comboPartidos;
	}

	/**
	 * @return the scrollComboPartidos
	 */
	public JScrollPane getScrollComboPartidos() {
		return scrollComboPartidos;
	}

	/**
	 * @param scrollComboPartidos the scrollComboPartidos to set
	 */
	public void setScrollComboPartidos(JScrollPane scrollComboPartidos) {
		this.scrollComboPartidos = scrollComboPartidos;
	}

	/**
	 * @return the comboOpcionResultado
	 */
	public JComboBox<String> getComboOpcionResultado() {
		return comboOpcionResultado;
	}

	/**
	 * @param comboOpcionResultado the comboOpcionResultado to set
	 */
	public void setComboOpcionResultado(JComboBox<String> comboOpcionResultado) {
		this.comboOpcionResultado = comboOpcionResultado;
	}

}
