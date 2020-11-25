/**
 * Paquete vista
 */
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
 * Clase PanelSedeModificar
 */

public class PanelSedeModificar extends JPanel {

	private static final long serialVersionUID = 1L;
	private final String COMMAND_ACTUALIZAR_SEDE = "ACTUALIZAR_INFO_SEDES";
	private JLabel etiquetaId;
	private JLabel etiquetaEmpleado;
	private JTextField campoTextoEmpleado;
	private JComboBox<String> comboIdUbicacion;
	private JScrollPane scrollId;
	private JButton botonActualizar;
	private JPanel panelSedeModificar;

	/**
	 * Constructor con inicialización de atributos
	 */

	public PanelSedeModificar() {
		setBorder(new TitledBorder("Actualizar información de la sede"));
		setLayout(new BorderLayout());
		panelSedeModificar = new JPanel();
		panelSedeModificar.setLayout(new GridLayout(2, 2));

		etiquetaId = new JLabel("Seleccione el id de la ubicación: ");
		etiquetaEmpleado = new JLabel("Número de empleados: ");

		comboIdUbicacion = new JComboBox<String>();
		scrollId = new JScrollPane(comboIdUbicacion);
		campoTextoEmpleado = new JTextField();

		panelSedeModificar.add(etiquetaId);
		panelSedeModificar.add(scrollId);

		panelSedeModificar.add(etiquetaEmpleado);
		panelSedeModificar.add(campoTextoEmpleado);

		botonActualizar = new JButton("Actualizar sede");
		botonActualizar.setActionCommand(COMMAND_ACTUALIZAR_SEDE);

		this.add(panelSedeModificar, BorderLayout.CENTER);
		this.add(botonActualizar, BorderLayout.PAGE_END);

	}

	/**
	 * Asigna valores vacios a los JTextField
	 */

	public void borrarCampos() {
		campoTextoEmpleado.setText("");
		comboIdUbicacion.setSelectedIndex(0);
	}

	/**
	 * Toma la información de un array unidimensional con las id y llenar el
	 * combobox
	 * 
	 * @param data
	 */

	public void cargarId(String[] data) {
		comboIdUbicacion.removeAllItems();
		comboIdUbicacion.addItem("Seleccione");
		for (int i = 0; i < data.length; i++)
			comboIdUbicacion.addItem(data[i]);
	}

	/**
	 * Verifica que los campos de texto y el combobox tengan valores y almacena los
	 * datos en un array unidimensional para luego retornarlos
	 * 
	 * @return
	 */

	public String[] verificarEntradasActualizarSedes() {
		String[] salida = new String[3];
		salida[0] = "0";
		if ((!campoTextoEmpleado.getText().equals("") && !comboIdUbicacion.getSelectedItem().equals("Seleccione"))) {
			try {
				if (Integer.parseInt(campoTextoEmpleado.getText()) <= 0) {
					salida[0] = "1";
					salida[1] = "El número de empleados debe ser mayor de cero";
				} else {
					salida[1] = campoTextoEmpleado.getText();
					salida[2] = String.valueOf(comboIdUbicacion.getSelectedItem());
				}

			} catch (NumberFormatException e) {
				salida[0] = "1";
				salida[1] = "Valor ingresado incorrecto";
			}
		} else {
			salida[0] = "1";
			salida[1] = "Los campos deben ser completados";
		}
		return salida;
	}

	/**
	 * Toma la información del Arraylist de las Sedes y asigna los valores de la id
	 * y la ubicación al combobox
	 * 
	 * @param lista
	 */
	public void cargarCombo(ArrayList<SedesDTO> lista) {
		comboIdUbicacion.removeAllItems();
		comboIdUbicacion.addItem("Seleccione");
		for (int i = 0; i < lista.size(); i++) {
			comboIdUbicacion.addItem(lista.get(i).getIdUbicacion() + "-" + lista.get(i).getUbicacion());
		}
	}

	/**
	 * @return the campoTextoEmpleado
	 */
	public JTextField getCampoTextoEmpleado() {
		return campoTextoEmpleado;
	}

	/**
	 * @param campoTextoEmpleado the campoTextoEmpleado to set
	 */
	public void setCampoTextoEmpleado(JTextField campoTextoEmpleado) {
		this.campoTextoEmpleado = campoTextoEmpleado;
	}

	/**
	 * @return the comboIdUbicacion
	 */
	public JComboBox<String> getComboIdUbicacion() {
		return comboIdUbicacion;
	}

	/**
	 * @param comboIdUbicacion the comboIdUbicacion to set
	 */
	public void setComboIdUbicacion(JComboBox<String> comboIdUbicacion) {
		this.comboIdUbicacion = comboIdUbicacion;
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
	 * @return the cOMMAND_ACTUALIZAR_SEDE
	 */
	public String getCOMMAND_ACTUALIZAR_SEDE() {
		return COMMAND_ACTUALIZAR_SEDE;
	}

}
