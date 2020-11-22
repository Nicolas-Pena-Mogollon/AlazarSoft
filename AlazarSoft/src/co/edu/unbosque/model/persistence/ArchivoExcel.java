package co.edu.unbosque.model.persistence;

import java.io.FileOutputStream;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.hssf.util.HSSFColor;
import com.itextpdf.text.FontFactory;


public class ArchivoExcel extends ArchivoExportar {
	
	public static void crearExcel() {
		
		HSSFWorkbook workBook = new HSSFWorkbook();
		HSSFSheet hoja1= workBook.createSheet("Reporte");
		
		HSSFRow filaTitulo = hoja1.createRow(0);
		CellStyle estiloTitulo = workBook.createCellStyle();
		
		Font font = workBook.createFont();
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		estiloTitulo.setFont(font);
		
		// Se le dan características a las celdas
				estiloTitulo.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
				estiloTitulo.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
				estiloTitulo.setBorderBottom(HSSFCellStyle.BORDER_THIN);
				estiloTitulo.setBorderLeft(HSSFCellStyle.BORDER_THIN);
				estiloTitulo.setBorderRight(HSSFCellStyle.BORDER_THIN);
				estiloTitulo.setBorderTop(HSSFCellStyle.BORDER_THIN);

				
		try {
			
			FileOutputStream fileout = new FileOutputStream("Reporte.xls");
			workBook.write(fileout);
			fileout.close();
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al Exportar", "Warning", JOptionPane.WARNING_MESSAGE);
		}
				
				
	}

	
	@Override
	public void exportar(String[][] data, String tipoReporte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void llenarTitulos(String[] titulos) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public String[] verificarTipoReporte(String reporte) {
		// TODO Auto-generated method stub
		return null;
	}
}
