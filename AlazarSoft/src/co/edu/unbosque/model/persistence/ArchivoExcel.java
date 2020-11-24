package co.edu.unbosque.model.persistence;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.hssf.util.HSSFColor;

import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;

import co.edu.unbosque.model.Informe;


public class ArchivoExcel {
	
	private File file;
	public final String RUTA_EXPORT = "./Export/EXCEL/";
	
	// Fonts
		private HSSFFont headerFont;
		private HSSFFont contentFont;
	 
		// Styles
		private HSSFCellStyle headerStyle;
		private HSSFCellStyle oddRowStyle;
		private HSSFCellStyle normalRowStyle;
		private HSSFCellStyle evenRowStyle;
		private HSSFWorkbook workBook;

	public ArchivoExcel() {
		super();
	}


	public void exportar(Informe informe) {
		
		workBook = new HSSFWorkbook();
		HSSFSheet hoja= workBook.createSheet("Reporte");
		String[][] data = informe.getTablaDatos(); 
		
		// Generate fonts
				headerFont  = createFont(HSSFColor.WHITE.index, (short)12, true);
				contentFont = createFont(HSSFColor.BLACK.index, (short)10, false);
		 
				// Generate styles
				headerStyle  = createStyle(headerFont,  HSSFCellStyle.ALIGN_CENTER, HSSFColor.BLUE_GREY.index,       true, HSSFColor.WHITE.index);
				oddRowStyle  = createStyle(contentFont, HSSFCellStyle.ALIGN_LEFT,   HSSFColor.GREY_25_PERCENT.index, true, HSSFColor.GREY_80_PERCENT.index);
				normalRowStyle  = createStyle(contentFont, HSSFCellStyle.ALIGN_LEFT,   HSSFColor.WHITE.index, true, HSSFColor.GREY_80_PERCENT.index);
				evenRowStyle = createStyle(contentFont, HSSFCellStyle.ALIGN_LEFT,   HSSFColor.GREY_40_PERCENT.index, true, HSSFColor.GREY_80_PERCENT.index);
		 
		
				
				// Se crea una fila dentro de la hoja
		        HSSFRow fila = hoja.createRow(0);

		        HSSFCell headerCell = null;
				for (int i = 0; i < data[0].length; i++) {
					headerCell = fila.createCell(i);
					headerCell.setCellStyle(headerStyle);
					headerCell.setCellValue( data[0][i] );
				}
				
							
				for (int i = 1; i < data.length; i++) {
					HSSFRow filaContent = hoja.createRow(i);
					HSSFCell contentCell = null;
					for (int j = 0; j < data[0].length; j++) {
						contentCell = filaContent.createCell(j);
						contentCell.setCellStyle(normalRowStyle);
						contentCell.setCellValue( data[i][j] );
					}
				}
				
				for (int i = 0; i < data[0].length; hoja.autoSizeColumn(i++));

		        		        
		        
		try {
			file = new File(RUTA_EXPORT + "nombre" + ".xls");
			FileOutputStream fileout = new FileOutputStream(file);
			workBook.write(fileout);
			fileout.close();
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al Exportar", "Warning", JOptionPane.WARNING_MESSAGE);
		}
				
				
	}
	
	
	/**
	 * Create a new font on base workbook
	 * 
	 * @param fontColor       Font color (see {@link HSSFColor})
	 * @param fontHeight      Font height in points
	 * @param fontBold        Font is boldweight (<code>true</code>) or not (<code>false</code>)
	 * 
	 * @return New cell style
	 */
	private HSSFFont createFont(short fontColor, short fontHeight, boolean fontBold) {
 
		HSSFFont font = workBook.createFont();
		font.setColor(fontColor);
		font.setFontName("Arial");
		font.setFontHeightInPoints(fontHeight);
 
		return font;
	}

	/**
	 * Create a style on base workbook
	 * 
	 * @param font            Font used by the style
	 * @param cellAlign       Cell alignment for contained text (see {@link HSSFCellStyle})
	 * @param cellColor       Cell background color (see {@link HSSFColor})
	 * @param cellBorder      Cell has border (<code>true</code>) or not (<code>false</code>)
	 * @param cellBorderColor Cell border color (see {@link HSSFColor})
	 * 
	 * @return New cell style
	 */
	private HSSFCellStyle createStyle(HSSFFont font, short cellAlign, short cellColor, boolean cellBorder, short cellBorderColor) {
 
		HSSFCellStyle style = workBook.createCellStyle();
		style.setFont(font);
		style.setAlignment(cellAlign);
		style.setFillForegroundColor(cellColor);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
 
		if (cellBorder) {
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
 
			style.setTopBorderColor(cellBorderColor);
			style.setLeftBorderColor(cellBorderColor);
			style.setRightBorderColor(cellBorderColor);
			style.setBottomBorderColor(cellBorderColor);
		}
 
		return style;
	}
	
}
