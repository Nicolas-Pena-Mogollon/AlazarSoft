package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class PanelApuestaFutbol extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel etiquetaPartidos;
	private JLabel etiquetaResultado;
	private JComboBox<String> comboPartidos;
	private JScrollPane scrollComboPartidos;
	private JComboBox<String> comboOpcionResultado;

	public PanelApuestaFutbol() {
		setLayout(new GridLayout());
		setBorder(new TitledBorder("Apuesta baloto"));

		etiquetaPartidos = new JLabel("Local Vs Visitante");
		etiquetaResultado = new JLabel("Resultado ganador");

		comboPartidos = new JComboBox<String>();
		scrollComboPartidos = new JScrollPane(comboPartidos);
		comboOpcionResultado = new JComboBox<String>();
		comboOpcionResultado.addItem("Local");
		comboOpcionResultado.addItem("Visitante");
		comboOpcionResultado.addItem("Empate");

		add(etiquetaPartidos);
		add(etiquetaResultado);
		add(scrollComboPartidos);
		add(comboOpcionResultado);

	}

	public JComboBox<String> getComboPartidos() {
		return comboPartidos;
	}

	public void setComboPartidos(JComboBox<String> comboPartidos) {
		this.comboPartidos = comboPartidos;
	}

	public JComboBox<String> getComboOpcionResultado() {
		return comboOpcionResultado;
	}

	public void setComboOpcionResultado(JComboBox<String> comboOpcionResultado) {
		this.comboOpcionResultado = comboOpcionResultado;
	}

}
