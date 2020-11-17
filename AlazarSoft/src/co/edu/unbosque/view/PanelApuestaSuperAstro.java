package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PanelApuestaSuperAstro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel etiquetaNumero;
	private JLabel etiquetaSigno;
	private JTextField campoTextoPrimerNumero;
	private JTextField campoTextoSegundoNumero;
	private JTextField campoTextoTercerNumero;
	private JTextField campoTextoCuartoNumero;
	private JComboBox<String> SignoZodiacal;
	private JPanel panelCamposDeTextoNumero;

	public PanelApuestaSuperAstro() {
		setBorder(new TitledBorder("Apuesta baloto"));
		setLayout(new GridLayout(1, 2));

		SignoZodiacal = new JComboBox<String>();
		etiquetaSigno = new JLabel("Signo del Zodiaco");
		etiquetaNumero = new JLabel("Número");

		panelCamposDeTextoNumero = new JPanel();
		panelCamposDeTextoNumero.setLayout(new GridLayout(2, 5));

		campoTextoPrimerNumero = new JTextField();
		campoTextoSegundoNumero = new JTextField();
		campoTextoTercerNumero = new JTextField();
		campoTextoCuartoNumero = new JTextField();

		campoTextoPrimerNumero.setBorder(new LineBorder(Color.GRAY));
		campoTextoSegundoNumero.setBorder(new LineBorder(Color.GRAY));
		campoTextoTercerNumero.setBorder(new LineBorder(Color.GRAY));
		campoTextoCuartoNumero.setBorder(new LineBorder(Color.GRAY));

		panelCamposDeTextoNumero.add(campoTextoPrimerNumero);
		panelCamposDeTextoNumero.add(campoTextoSegundoNumero);
		panelCamposDeTextoNumero.add(campoTextoTercerNumero);
		panelCamposDeTextoNumero.add(campoTextoCuartoNumero);

		this.add(etiquetaNumero);
		this.add(panelCamposDeTextoNumero);
		this.add(etiquetaSigno);
		this.add(SignoZodiacal);
		llenarComboZodiaco();
		SignoZodiacal.setRenderer((ListCellRenderer<? super String>) new PanelComboBoxImagenes());
		SignoZodiacal.setSelectedIndex(0);
	}

	public void llenarComboZodiaco() {
		SignoZodiacal.addItem("Seleccione un signo");
		SignoZodiacal.addItem("Aries");
		SignoZodiacal.addItem("Tauro");
		SignoZodiacal.addItem("Geminis");
		SignoZodiacal.addItem("Cancer");
		SignoZodiacal.addItem("Leo");
		SignoZodiacal.addItem("Virgo");
		SignoZodiacal.addItem("Libra");
		SignoZodiacal.addItem("Escorpio");
		SignoZodiacal.addItem("Sagitario");
		SignoZodiacal.addItem("Capricornio");
		SignoZodiacal.addItem("Acuario");
		SignoZodiacal.addItem("Piscis");

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

	public JLabel getEtiquetaNumero() {
		return etiquetaNumero;
	}

	public void setEtiquetaNumero(JLabel etiquetaNumero) {
		this.etiquetaNumero = etiquetaNumero;
	}

	public JComboBox<String> getSignoZodiacal() {
		return SignoZodiacal;
	}

	public void setSignoZodiacal(JComboBox<String> signoZodiacal) {
		SignoZodiacal = signoZodiacal;
	}

	public JPanel getPanelCamposDeTextoNumero() {
		return panelCamposDeTextoNumero;
	}

	public void setPanelCamposDeTextoNumero(JPanel panelCamposDeTextoNumero) {
		this.panelCamposDeTextoNumero = panelCamposDeTextoNumero;
	}

}
