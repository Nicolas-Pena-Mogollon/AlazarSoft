package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Clase PanelDatosJuegos
 */

public class PanelDatosJuegos extends JPanel {

	private static final long serialVersionUID = 1L;
	private final String COMMAND_REGISTRAR_DATOS_JUEGO = "REGISTRAR_DATOS_JUEGO";
	private JLabel etiquetaNombreJuego;
	private JLabel etiquetaTipoJuego;
	private JLabel etiquetaPresupuesto;
	private JComboBox<String> comboNombreJuego;
	private JTextField campoTextoPresupuesto;
	private JComboBox<String> comboTiposDeJuego;
	private JButton botonGuardarDatosJuego;
	private JPanel panelCampos;

	/**
	 * Constructor con inicialización de atributos
	 */

	public PanelDatosJuegos() {
		setBorder(new TitledBorder("Configurar los datos de juego"));
		setLayout(new BorderLayout());
		panelCampos = new JPanel();
		panelCampos.setLayout(new GridLayout(3, 2));

		etiquetaNombreJuego = new JLabel("Nombre del juego");
		etiquetaTipoJuego = new JLabel("Tipo de juego");
		etiquetaPresupuesto = new JLabel("Presupuesto juego");

		comboTiposDeJuego = new JComboBox<String>();
		comboTiposDeJuego.addItem("Seleccione");
		comboTiposDeJuego.addItem("Deportivo");
		comboTiposDeJuego.addItem("Lotería");
		comboTiposDeJuego.addItem("Chance");

		comboNombreJuego = new JComboBox<String>();
		comboNombreJuego.addItem("Seleccione");
		comboNombreJuego.addItem("Baloto");
		comboNombreJuego.addItem("Super Astro");
		comboNombreJuego.addItem("Fútbol");
		campoTextoPresupuesto = new JTextField();

		panelCampos.add(etiquetaNombreJuego);
		panelCampos.add(comboNombreJuego);
		panelCampos.add(etiquetaTipoJuego);
		panelCampos.add(comboTiposDeJuego);
		panelCampos.add(etiquetaPresupuesto);
		panelCampos.add(campoTextoPresupuesto);

		botonGuardarDatosJuego = new JButton("Registrar datos de juego");
		botonGuardarDatosJuego.setActionCommand(COMMAND_REGISTRAR_DATOS_JUEGO);

		this.add(panelCampos, BorderLayout.CENTER);
		this.add(botonGuardarDatosJuego, BorderLayout.PAGE_END);

	}

	/**
	 * Verifica que los campos no esten vacios
	 * 
	 * @return true
	 */

	public boolean verificarEntradas() {
		boolean verificar = false;
		if (!"Seleccione".equals(comboNombreJuego.getSelectedItem()) && !"".equals(campoTextoPresupuesto.getText())
				&& !"Seleccione".equals(comboTiposDeJuego.getSelectedItem())) {
			verificar = true;
		} else {
			verificar = false;
		}
		return verificar;
	}

	/**
	 * Limpia los campos de texto y borra los valores que tengan en la interfaz
	 */
	public void limpiarCampos() {
		this.comboNombreJuego.setSelectedIndex(0);
		this.campoTextoPresupuesto.setText("");
		this.comboTiposDeJuego.setSelectedIndex(0);
	}

	/**
	 * @return the comboNombreJuego
	 */
	public JComboBox<String> getComboNombreJuego() {
		return comboNombreJuego;
	}

	/**
	 * @param comboNombreJuego the comboNombreJuego to set
	 */
	public void setComboNombreJuego(JComboBox<String> comboNombreJuego) {
		this.comboNombreJuego = comboNombreJuego;
	}

	/**
	 * @return the campoTextoPresupuesto
	 */
	public JTextField getCampoTextoPresupuesto() {
		return campoTextoPresupuesto;
	}

	/**
	 * @param campoTextoPresupuesto the campoTextoPresupuesto to set
	 */
	public void setCampoTextoPresupuesto(JTextField campoTextoPresupuesto) {
		this.campoTextoPresupuesto = campoTextoPresupuesto;
	}

	/**
	 * @return the comboTiposDeJuego
	 */
	public JComboBox<String> getComboTiposDeJuego() {
		return comboTiposDeJuego;
	}

	/**
	 * @param comboTiposDeJuego the comboTiposDeJuego to set
	 */
	public void setComboTiposDeJuego(JComboBox<String> comboTiposDeJuego) {
		this.comboTiposDeJuego = comboTiposDeJuego;
	}

	/**
	 * @return the botonGuardarDatosJuego
	 */
	public JButton getBotonGuardarDatosJuego() {
		return botonGuardarDatosJuego;
	}

	/**
	 * @param botonGuardarDatosJuego the botonGuardarDatosJuego to set
	 */
	public void setBotonGuardarDatosJuego(JButton botonGuardarDatosJuego) {
		this.botonGuardarDatosJuego = botonGuardarDatosJuego;
	}

	/**
	 * @return the cOMMAND_REGISTRAR_DATOS_JUEGO
	 */
	public String getCOMMAND_REGISTRAR_DATOS_JUEGO() {
		return COMMAND_REGISTRAR_DATOS_JUEGO;
	}

}
