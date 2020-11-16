package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelSedeModificar extends JPanel {

	private static final long serialVersionUID = 1L;
	private final String COMMAND_ACTUALIZAR_SEDE = "ACTUALIZAR_INFO_SEDES";
	private JLabel etiquetaUbicacion;
	private JLabel etiquetaId;
	private JLabel etiquetaEmpleado;
	private JTextField campoTextoUbicacion;
	private JTextField campoTextoEmpleado;
	private JComboBox<String> comboIdUbicacion;
	private JScrollPane scrollId;
	private JButton botonActualizar;
	private JPanel panelSedeModificar;

	public PanelSedeModificar() {
		setBorder(new TitledBorder("Actualizar información de la sede"));
		setLayout(new BorderLayout());
		panelSedeModificar = new JPanel();
		panelSedeModificar.setLayout(new GridLayout(3, 2));

		etiquetaId = new JLabel("Seleccione el id de la ubicación: ");
		etiquetaUbicacion = new JLabel("Ubicación de la sede: ");
		etiquetaEmpleado = new JLabel("Número de empleados: ");

		comboIdUbicacion = new JComboBox<String>();
		scrollId = new JScrollPane(comboIdUbicacion);

		campoTextoUbicacion = new JTextField();
		campoTextoEmpleado = new JTextField();

		panelSedeModificar.add(etiquetaId);
		panelSedeModificar.add(scrollId);

		panelSedeModificar.add(etiquetaUbicacion);
		panelSedeModificar.add(campoTextoUbicacion);

		panelSedeModificar.add(etiquetaEmpleado);
		panelSedeModificar.add(campoTextoEmpleado);

		botonActualizar = new JButton("Actualizar sede");
		botonActualizar.setActionCommand(COMMAND_ACTUALIZAR_SEDE);

		this.add(panelSedeModificar, BorderLayout.CENTER);
		this.add(botonActualizar, BorderLayout.PAGE_END);

	}

	public void borrarCamposTxt() {
		campoTextoUbicacion.setText("");
		campoTextoEmpleado.setText("");
	}

	public void cargarId(String[] data) {
		comboIdUbicacion.removeAllItems();
		comboIdUbicacion.addItem("Seleccione");
		for (int i = 0; i < data.length; i++)
			comboIdUbicacion.addItem(data[i]);
	}

	public String[] verificarEntradasActualizarSedes() {
		String[] salida = new String[4];
		salida[0] = "0";
		if ((!campoTextoUbicacion.getText().equals("") || !campoTextoEmpleado.getText().equals("")
				&& !comboIdUbicacion.getSelectedItem().equals("Seleccione"))) {
			salida[1] = campoTextoUbicacion.getText();
			salida[2] = campoTextoEmpleado.getText();
			salida[3] = String.valueOf(comboIdUbicacion.getSelectedItem());
		} else {
			salida[0] = "1";
			salida[1] = "Los campos deben ser completados";
		}
		return salida;
	}

	public JLabel getEtiquetaUbicacion() {
		return etiquetaUbicacion;
	}

	public void setEtiquetaUbicacion(JLabel etiquetaUbicacion) {
		this.etiquetaUbicacion = etiquetaUbicacion;
	}

	public JLabel getEtiquetaId() {
		return etiquetaId;
	}

	public void setEtiquetaId(JLabel etiquetaId) {
		this.etiquetaId = etiquetaId;
	}

	public JLabel getEtiquetaEmpleado() {
		return etiquetaEmpleado;
	}

	public void setEtiquetaEmpleado(JLabel etiquetaEmpleado) {
		this.etiquetaEmpleado = etiquetaEmpleado;
	}

	public JTextField getCampoTextoUbicacion() {
		return campoTextoUbicacion;
	}

	public void setCampoTextoUbicacion(JTextField campoTextoUbicacion) {
		this.campoTextoUbicacion = campoTextoUbicacion;
	}

	public JTextField getCampoTextoEmpleado() {
		return campoTextoEmpleado;
	}

	public void setCampoTextoEmpleado(JTextField campoTextoEmpleado) {
		this.campoTextoEmpleado = campoTextoEmpleado;
	}

	public JComboBox<String> getComboIdUbicacion() {
		return comboIdUbicacion;
	}

	public void setComboIdUbicacion(JComboBox<String> comboIdUbicacion) {
		this.comboIdUbicacion = comboIdUbicacion;
	}

	public JScrollPane getScrollId() {
		return scrollId;
	}

	public void setScrollId(JScrollPane scrollId) {
		this.scrollId = scrollId;
	}

	public JButton getBotonActualizar() {
		return botonActualizar;
	}

	public void setBotonActualizar(JButton botonActualizar) {
		this.botonActualizar = botonActualizar;
	}

	public JPanel getPanelSedeModificar() {
		return panelSedeModificar;
	}

	public void setPanelSedeModificar(JPanel panelSedeModificar) {
		this.panelSedeModificar = panelSedeModificar;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCOMMAND_ACTUALIZAR_SEDE() {
		return COMMAND_ACTUALIZAR_SEDE;
	}

}
