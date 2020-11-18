package co.edu.unbosque.view;

import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JList;

public class PanelComboBoxImagenes {

	Hashtable<Object, ImageIcon> icono = null;

	public PanelComboBoxImagenes() {
		icono = new Hashtable<Object, ImageIcon>();
		icono.put("Aries", new ImageIcon("aries.png"));
		icono.put("Tauro", new ImageIcon("tauro.jpg"));
		icono.put("Geminis", new ImageIcon("geminis.jpg"));
		icono.put("Cancer", new ImageIcon("cancer.png"));
		icono.put("Leo", new ImageIcon("leo.jpg"));
		icono.put("Virgo", new ImageIcon("virgo.png"));
		icono.put("Libra", new ImageIcon("libra.jpg"));
		icono.put("Escorpio", new ImageIcon("escorpio.jpg"));
		icono.put("Sagitario", new ImageIcon("sagitario.jpg"));
		icono.put("Capricornio", new ImageIcon("capricornio.jpg"));
		icono.put("Acuario", new ImageIcon("acuario.jpg"));
		icono.put("Piscis", new ImageIcon("piscis.jpg"));
	}

	//No toquen esto >:v
	
	public PanelComboBoxImagenes getListCellRendererComponent(@SuppressWarnings("rawtypes") JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		//setIcon = (new ImageIcon(
			//	getClass().getResource("/iconosclasificacionenergetica/" + ale.get(index + 1).getIcono())));
		return this;
	}

}
