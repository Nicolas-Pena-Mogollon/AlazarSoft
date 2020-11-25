package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import co.edu.unbosque.model.persistence.SedesDTO;

/**
 * Clase PanelActualizarBorrarApostador
 */

public class PanelActualizarBorrarApostador extends JPanel {

	private static final long serialVersionUID = 1L;
	private final String COMMAND_ACTUALIZAR = "ACTUALIZAR_INFO_APOSTADOR";
	private final String COMMAND_BORRAR = "BORRAR_APOSTADOR";
	private JLabel etiquetaNombre;
	private JLabel etiquetaCedula;
	private JLabel etiquetaSede;
	private JLabel etiquetaDireccion;
	private JLabel etiquetaCelular;
	private JTextField campoTextoNombre;
	private JTextField campoTextoDireccion;
	private JTextField campoTextoCelular;
	private JTextField campoTextoCedula;
	private JComboBox<String> comboSede;
	private JScrollPane scrollSede;
	private JButton botonActualizar;
	private JButton botonBorrar;
	private JPanel panelIngreso;
	private JPanel panelBotones;

	/**
	 * Constructor con inicialización de atributos
	 */

	public PanelActualizarBorrarApostador() {

		setBorder(new TitledBorder("Actualizar/Borrar apostadores"));
		setLayout(new BorderLayout());
		panelIngreso = new JPanel();
		panelIngreso.setLayout(new GridLayout(5, 2));

		etiquetaCedula = new JLabel("Cédula");
		etiquetaNombre = new JLabel("Nombre completo");
		etiquetaSede = new JLabel("Sede");
		etiquetaDireccion = new JLabel("Dirección");
		etiquetaCelular = new JLabel("Celular");

		campoTextoCedula = new JTextField();
		comboSede = new JComboBox<String>();
		scrollSede = new JScrollPane(comboSede);

		campoTextoNombre = new JTextField();
		campoTextoDireccion = new JTextField();
		campoTextoCelular = new JTextField();

		panelIngreso.add(etiquetaSede);
		panelIngreso.add(scrollSede);

		panelIngreso.add(etiquetaCedula);
		panelIngreso.add(campoTextoCedula);

		panelIngreso.add(etiquetaNombre);
		panelIngreso.add(campoTextoNombre);

		panelIngreso.add(etiquetaDireccion);
		panelIngreso.add(campoTextoDireccion);

		panelIngreso.add(etiquetaCelular);
		panelIngreso.add(campoTextoCelular);

		panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(1, 2));

		botonActualizar = new JButton("Actualizar");
		botonActualizar.setActionCommand(COMMAND_ACTUALIZAR);
		botonBorrar = new JButton("Borrar");
		botonBorrar.setActionCommand(COMMAND_BORRAR);

		panelBotones.add(botonActualizar);
		panelBotones.add(botonBorrar);

		this.add(panelIngreso, BorderLayout.CENTER);
		this.add(panelBotones, BorderLayout.PAGE_END);

	}

	/**
	 * Verifica que el ingreso de datos para la actualización sea correcto
	 * 
	 * @return salida Un array con al información tomada y correcta.
	 */

	public String[] verificarEntradasActualizarInformacionApostador() {
		String[] salida = new String[6];
		salida[0] = "0";
		if ((!campoTextoNombre.getText().equals("") || !campoTextoDireccion.getText().equals("")
				|| !campoTextoCelular.getText().equals("") || !comboSede.getSelectedItem().equals("Seleccione"))
				&& !campoTextoCedula.getText().equals("")) {
			salida[1] = campoTextoNombre.getText();
			salida[2] = campoTextoDireccion.getText();
			salida[3] = campoTextoCelular.getText();
			salida[4] = String.valueOf(comboSede.getSelectedItem());
			salida[5] = campoTextoCedula.getText();
		} else {
			salida[0] = "1";
			salida[1] = "Los campos deben ser completados";
		}
		return salida;
	}

	/**
	 * Verifica que el ingreso de datos para el borrado sea correcto
	 * 
	 * @return salida Un array con al información tomada y correcta.
	 */

	public String[] verificarEntradasBorrarInformacionApostador() {
		String[] salida = new String[3];
		salida[0] = "0";
		if (!campoTextoCedula.getText().equals("Seleccione")) {
			salida[1] = (String) campoTextoCedula.getText();
			salida[2] = "Se ha borrado el apostador";
		} else {
			salida[0] = "1";
			salida[1] = "Los campos deben ser completados";
		}
		return salida;

	}

	/**
	 * Asigna valores vacios en los JTextfield
	 * 
	 */

	public void borrarCampos() {
		this.campoTextoNombre.setText("");
		this.campoTextoCedula.setText("");
		this.campoTextoDireccion.setText("");
		this.campoTextoCelular.setText("");
		this.comboSede.setSelectedIndex(0);
	}

	/**
	 * Llena el combobox con los valores de las sedes
	 */

	public void cargarComboBox(ArrayList<SedesDTO> sede) {
		this.comboSede.removeAllItems();
		this.comboSede.addItem("Seleccione");
		for (int i = 0; i < sede.size(); i++) {
			this.comboSede.addItem(sede.get(i).getUbicacion() + sede.get(i).getIdUbicacion());
		}
	}

	/**
	 * @return the campoTextoNombre
	 */
	public JTextField getCampoTextoNombre() {
		return campoTextoNombre;
	}

	/**
	 * @param campoTextoNombre the campoTextoNombre to set
	 */
	public void setCampoTextoNombre(JTextField campoTextoNombre) {
		this.campoTextoNombre = campoTextoNombre;
	}

	/**
	 * @return the campoTextoDireccion
	 */
	public JTextField getCampoTextoDireccion() {
		return campoTextoDireccion;
	}

	/**
	 * @param campoTextoDireccion the campoTextoDireccion to set
	 */
	public void setCampoTextoDireccion(JTextField campoTextoDireccion) {
		this.campoTextoDireccion = campoTextoDireccion;
	}

	/**
	 * @return the campoTextoCelular
	 */
	public JTextField getCampoTextoCelular() {
		return campoTextoCelular;
	}

	/**
	 * @param campoTextoCelular the campoTextoCelular to set
	 */
	public void setCampoTextoCelular(JTextField campoTextoCelular) {
		this.campoTextoCelular = campoTextoCelular;
	}

	/**
	 * @return the campoTextoCedula
	 */
	public JTextField getCampoTextoCedula() {
		return campoTextoCedula;
	}

	/**
	 * @param campoTextoCedula the campoTextoCedula to set
	 */
	public void setCampoTextoCedula(JTextField campoTextoCedula) {
		this.campoTextoCedula = campoTextoCedula;
	}

	/**
	 * @return the botonActualizar
	 */
	public JButton getBotonActualizar() {
		return botonActualizar;
	}

	/**
	 * @param botonActualizar the botonActualizar to set
	 */
	public void setBotonActualizar(JButton botonActualizar) {
		this.botonActualizar = botonActualizar;
	}

	/**
	 * @return the botonBorrar
	 */
	public JButton getBotonBorrar() {
		return botonBorrar;
	}

	/**
	 * @param botonBorrar the botonBorrar to set
	 */
	public void setBotonBorrar(JButton botonBorrar) {
		this.botonBorrar = botonBorrar;
	}

	/**
	 * @return the cOMMAND_ACTUALIZAR
	 */
	public String getCOMMAND_ACTUALIZAR() {
		return COMMAND_ACTUALIZAR;
	}

	/**
	 * @return the cOMMAND_BORRAR
	 */
	public String getCOMMAND_BORRAR() {
		return COMMAND_BORRAR;
	}

}
