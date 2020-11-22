package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class PanelPremiacion extends JTabbedPane {

	private static final long serialVersionUID = 1L;
	private JPanel panelPremiacionBaloto;
	private JTextArea campoTextoPremiacionBaloto;
	private JScrollPane scrollCampoTextoPremiacionBaloto;
	private JPanel panelPremiacionSuperastro;
	private JTextArea campoTextoPremiacionSuperastro;
	private JScrollPane scrollCampoTextoPremiacionSuperastro;
	private JPanel panelPremiacionFutbol;
	private JTextArea campoTextoPremiacionFutbol;
	private JScrollPane scrollCampoTextoPremiacionFutbol;

	public PanelPremiacion() {
		panelPremiacionBaloto = new JPanel(new GridLayout(1,1));
		campoTextoPremiacionBaloto = new JTextArea();
		campoTextoPremiacionBaloto.setEditable(false);
		campoTextoPremiacionBaloto.setLineWrap(true);
		campoTextoPremiacionBaloto.setWrapStyleWord(true);
		campoTextoPremiacionBaloto.setOpaque(false);
		scrollCampoTextoPremiacionBaloto = new JScrollPane(campoTextoPremiacionBaloto);
		panelPremiacionBaloto.add(scrollCampoTextoPremiacionBaloto);
		
		panelPremiacionSuperastro = new JPanel(new GridLayout(1,1));
		campoTextoPremiacionSuperastro= new JTextArea();
		campoTextoPremiacionSuperastro.setEditable(false);
		campoTextoPremiacionSuperastro.setLineWrap(true);
		campoTextoPremiacionSuperastro.setWrapStyleWord(true);
		campoTextoPremiacionSuperastro.setOpaque(false);
		scrollCampoTextoPremiacionSuperastro = new JScrollPane(campoTextoPremiacionSuperastro);
		panelPremiacionSuperastro.add(scrollCampoTextoPremiacionSuperastro);
		
		panelPremiacionFutbol = new JPanel(new GridLayout(1,1));
		campoTextoPremiacionFutbol = new JTextArea();
		campoTextoPremiacionFutbol.setEditable(false);
		campoTextoPremiacionFutbol.setLineWrap(true);
		campoTextoPremiacionFutbol.setWrapStyleWord(true);
		campoTextoPremiacionFutbol.setOpaque(false);
		scrollCampoTextoPremiacionFutbol = new JScrollPane(campoTextoPremiacionFutbol);
		panelPremiacionFutbol.add(scrollCampoTextoPremiacionFutbol);
		
		this.add(panelPremiacionBaloto, "Plan de Premios Baloto");
		this.add(panelPremiacionSuperastro, "Plan de Premios SuperAstro");
		this.add(panelPremiacionFutbol, "Plan de Premios Marcadores");
	}
	
	public void llenarInformacion(String[] entrada) {
		this.campoTextoPremiacionSuperastro.setText(entrada[0]);
		this.campoTextoPremiacionBaloto.setText(entrada[1]);
		this.campoTextoPremiacionFutbol.setText(entrada[2]);

	}

	public JPanel getPanelPremiacionBaloto() {
		return panelPremiacionBaloto;
	}

	public void setPanelPremiacionBaloto(JPanel panelPremiacionBaloto) {
		this.panelPremiacionBaloto = panelPremiacionBaloto;
	}

	public JPanel getPanelPremiacionSuperastro() {
		return panelPremiacionSuperastro;
	}

	public void setPanelPremiacionSuperastro(JPanel panelPremiacionSuperastro) {
		this.panelPremiacionSuperastro = panelPremiacionSuperastro;
	}

	public JPanel getPanelPremiacionFutbol() {
		return panelPremiacionFutbol;
	}

	public void setPanelPremiacionFutbol(JPanel panelPremiacionFutbol) {
		this.panelPremiacionFutbol = panelPremiacionFutbol;
	}

}
