package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import co.edu.unbosque.model.Informe;

public class ArchivoPDF {

	private static final Font chapterFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 26, Font.BOLDITALIC);
	private static final Font paragraphFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 20, Font.NORMAL);
	
	public final String RUTA_EXPORT = "./Export/PDF/";
	
	private Paragraph parrafo;
	private PdfPTable tablaPDF;
	private PdfPCell celdaTitulo;
	private File file;
	private FileOutputStream fos;
	private Document document;
	
	

	
	public ArchivoPDF() {
		super();
	}




	public void exportar(Informe informe) {
	
		// We create the document and set the file name.        
		// Creamos el documento e indicamos el nombre del fichero.
		
		String[][] data = informe.getTablaDatos();
		try {
		    Document document = new Document();
		    try {
		    	file = new File(this.RUTA_EXPORT + informe.getTitulo() + ".pdf");
		    	
		        PdfWriter.getInstance(document, new FileOutputStream(file));
		    } catch (FileNotFoundException fileNotFoundException) {
		        System.out.println("(No se encontró el fichero para generar el pdf)" + fileNotFoundException);
		    }
		    document.open();
		 
		    
		    document.addTitle(informe.getTitulo());
		    
			 // First page
			 // Primera página 
			 Chunk chunk = new Chunk(informe.getTitulo(), chapterFont);
			 chunk.setBackground(BaseColor.GRAY);
			 // Let's create de first Chapter (Creemos el primer capítulo)
			 Chapter chapter = new Chapter(new Paragraph(chunk), 1);
			 chapter.setNumberDepth(0);
			 chapter.add(new Paragraph(informe.getDesccripción(), paragraphFont));
			 
			 document.add(chapter);

		
			Integer numColumns = data[0].length;
			Integer numRows = data.length;

			PdfPTable table = new PdfPTable(numColumns); 

			PdfPCell columnHeader;
			                
			for (int column = 0; column < numColumns; column++) {
			    columnHeader = new PdfPCell(new Phrase(data[0][column]));
			    columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
			    table.addCell(columnHeader);
			}
			table.setHeaderRows(1);

			for (int row = 1; row < numRows; row++) {
			    for (int column = 0; column < numColumns; column++) {
			        table.addCell(data[row][column]);
			    }
			}

			document.add(table);
			document.close();
		 
		} catch (DocumentException documentException) {
		    System.out.println("The file not exists (Se ha producido un error al generar un documento): " + documentException);
		}
	}



}
