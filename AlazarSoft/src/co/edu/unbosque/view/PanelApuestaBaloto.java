/**
 * Paquete vista
 */
package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * Clase PanelApuestaBaloto
 */
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

	/**
	 * Constructor con inicialización de atributos
	 */
	public PanelApuestaBaloto() {
		setBorder(new TitledBorder("Registro apuestas baloto"));
		setLayout(new GridLayout(1, 2));

		etiquetaNumero = new JLabel("Número");

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

	/**
	 * @return the etiquetaNumero
	 */
	public JLabel getEtiquetaNumero() {
		return etiquetaNumero;
	}

	/**
	 * @param etiquetaNumero the etiquetaNumero to set
	 */
	public void setEtiquetaNumero(JLabel etiquetaNumero) {
		this.etiquetaNumero = etiquetaNumero;
	}

	/**
	 * @return the campoTextoPrimerNumero
	 */
	public JTextField getCampoTextoPrimerNumero() {
		return campoTextoPrimerNumero;
	}

	/**
	 * @param campoTextoPrimerNumero the campoTextoPrimerNumero to set
	 */
	public void setCampoTextoPrimerNumero(JTextField campoTextoPrimerNumero) {
		this.campoTextoPrimerNumero = campoTextoPrimerNumero;
	}

	/**
	 * @return the campoTextoSegundoNumero
	 */
	public JTextField getCampoTextoSegundoNumero() {
		return campoTextoSegundoNumero;
	}

	/**
	 * @param campoTextoSegundoNumero the campoTextoSegundoNumero to set
	 */
	public void setCampoTextoSegundoNumero(JTextField campoTextoSegundoNumero) {
		this.campoTextoSegundoNumero = campoTextoSegundoNumero;
	}

	/**
	 * @return the campoTextoTercerNumero
	 */
	public JTextField getCampoTextoTercerNumero() {
		return campoTextoTercerNumero;
	}

	/**
	 * @param campoTextoTercerNumero the campoTextoTercerNumero to set
	 */
	public void setCampoTextoTercerNumero(JTextField campoTextoTercerNumero) {
		this.campoTextoTercerNumero = campoTextoTercerNumero;
	}

	/**
	 * @return the campoTextoCuartoNumero
	 */
	public JTextField getCampoTextoCuartoNumero() {
		return campoTextoCuartoNumero;
	}

	/**
	 * @param campoTextoCuartoNumero the campoTextoCuartoNumero to set
	 */
	public void setCampoTextoCuartoNumero(JTextField campoTextoCuartoNumero) {
		this.campoTextoCuartoNumero = campoTextoCuartoNumero;
	}

	/**
	 * @return the campoTextoQuintoNumero
	 */
	public JTextField getCampoTextoQuintoNumero() {
		return campoTextoQuintoNumero;
	}

	/**
	 * @param campoTextoQuintoNumero the campoTextoQuintoNumero to set
	 */
	public void setCampoTextoQuintoNumero(JTextField campoTextoQuintoNumero) {
		this.campoTextoQuintoNumero = campoTextoQuintoNumero;
	}

	/**
	 * @return the campoTextoSextoNumero
	 */
	public JTextField getCampoTextoSextoNumero() {
		return campoTextoSextoNumero;
	}

	/**
	 * @param campoTextoSextoNumero the campoTextoSextoNumero to set
	 */
	public void setCampoTextoSextoNumero(JTextField campoTextoSextoNumero) {
		this.campoTextoSextoNumero = campoTextoSextoNumero;
	}

	/**
	 * @return the panelCamposDeTextoNumero
	 */
	public JPanel getPanelCamposDeTextoNumero() {
		return panelCamposDeTextoNumero;
	}

	/**
	 * @param panelCamposDeTextoNumero the panelCamposDeTextoNumero to set
	 */
	public void setPanelCamposDeTextoNumero(JPanel panelCamposDeTextoNumero) {
		this.panelCamposDeTextoNumero = panelCamposDeTextoNumero;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
