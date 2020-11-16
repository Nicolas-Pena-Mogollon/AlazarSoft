package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PanelApuestaBaloto extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel etiquetaNumero;
	private JTextField campoTextoPrimerNumero;
	private JTextField campoTextoSegundoNumero;
	private JTextField campoTextoTercerNumero;
	private JTextField campoTextoCuartoNumero;
	private JTextField campoTextoQuintoNumero;
	private JTextField campoTextoSextoNumero;
	private JPanel panelCamposDeTextoNumero;

	public PanelApuestaBaloto() {
		setBorder(new TitledBorder("Registro apuestas baloto"));
		setLayout(new GridLayout(1, 2));

		etiquetaNumero = new JLabel("N�mero");

		panelCamposDeTextoNumero = new JPanel();
		panelCamposDeTextoNumero.setLayout(new GridLayout(1, 6));

		campoTextoPrimerNumero = new JTextField();
		campoTextoSegundoNumero = new JTextField();
		campoTextoTercerNumero = new JTextField();
		campoTextoCuartoNumero = new JTextField();
		campoTextoQuintoNumero = new JTextField();
		campoTextoSextoNumero = new JTextField();

		campoTextoPrimerNumero.setBorder(new LineBorder(Color.GRAY));
		campoTextoSegundoNumero.setBorder(new LineBorder(Color.GRAY));
		campoTextoTercerNumero.setBorder(new LineBorder(Color.GRAY));
		campoTextoCuartoNumero.setBorder(new LineBorder(Color.GRAY));
		campoTextoQuintoNumero.setBorder(new LineBorder(Color.GRAY));
		campoTextoSextoNumero.setBorder(new LineBorder(Color.GRAY));

		panelCamposDeTextoNumero.add(campoTextoPrimerNumero);
		panelCamposDeTextoNumero.add(campoTextoSegundoNumero);
		panelCamposDeTextoNumero.add(campoTextoTercerNumero);
		panelCamposDeTextoNumero.add(campoTextoCuartoNumero);
		panelCamposDeTextoNumero.add(campoTextoQuintoNumero);
		panelCamposDeTextoNumero.add(campoTextoSextoNumero);

		this.add(etiquetaNumero);
		this.add(panelCamposDeTextoNumero);
	}

	public JTextField getCampoTextoPrimerNumero() {
		return campoTextoPrimerNumero;
	}

	public void setCampoTextoPrimerNumero(JTextField campoTextoPrimerNumero) {
		this.campoTextoPrimerNumero = campoTextoPrimerNumero;
	}

	public JTextField getCampoTextoSegundoNumero() {
		return campoTextoSegundoNumero;
	}

	public void setCampoTextoSegundoNumero(JTextField campoTextoSegundoNumero) {
		this.campoTextoSegundoNumero = campoTextoSegundoNumero;
	}

	public JTextField getCampoTextoTercerNumero() {
		return campoTextoTercerNumero;
	}

	public void setCampoTextoTercerNumero(JTextField campoTextoTercerNumero) {
		this.campoTextoTercerNumero = campoTextoTercerNumero;
	}

	public JTextField getCampoTextoCuartoNumero() {
		return campoTextoCuartoNumero;
	}

	public void setCampoTextoCuartoNumero(JTextField campoTextoCuartoNumero) {
		this.campoTextoCuartoNumero = campoTextoCuartoNumero;
	}

	public JTextField getCampoTextoQuintoNumero() {
		return campoTextoQuintoNumero;
	}

	public void setCampoTextoQuintoNumero(JTextField campoTextoQuintoNumero) {
		this.campoTextoQuintoNumero = campoTextoQuintoNumero;
	}

	public JTextField getCampoTextoSextoNumero() {
		return campoTextoSextoNumero;
	}

	public void setCampoTextoSextoNumero(JTextField campoTextoSextoNumero) {
		this.campoTextoSextoNumero = campoTextoSextoNumero;
	}

}
