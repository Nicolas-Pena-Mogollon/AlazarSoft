package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ArchivoPDF {

	private static final Font chapterFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 26, Font.BOLDITALIC);
	/**
	 * Rutas de cada tipo de pdf
	 */
	private final String REPORTEPDF_CLIENTES = "reporteClientes.pdf";
	private final String REPORTEPDF_TOTAL_APUESTAS_CLIENTES = "reporteTotalApuestasClientes.pdf";
	private final String REPORTE_DETALLES_APUESTAS_POR_CLIENTE = "reporteDetallesApuestasCliente.pdf";
	private final String REPORTE_TOTAL_APUESTAS_POR_SEDE = "reporteTotalApuestasSede.pdf";
	/**
	 * Títulos de cada tipo de pdf (Faltan)
	 */
	private String[] titulosReportePDFClientes = { "FECHA", "PROVEEDOR", "MODELO", "REFERENCIA", "CILINDRAJE",
			"EXISTENCIAS", "VALOR UNIDAD", "CANTIDAD" };
	private Paragraph parrafo;
	private Chapter capitulo;
	private PdfPTable tablaPDF;
	private PdfPCell celdaTitulo;
	private File file;
	private FileOutputStream fos;
	private Document document;

	public ArchivoPDF() {
		document = new Document();
		parrafo = new Paragraph();
		capitulo = new Chapter(0);
		tablaPDF = new PdfPTable(0);
		celdaTitulo = new PdfPCell();
		document.setPageSize(PageSize.LEGAL.rotate());
		tablaPDF = new PdfPTable(0);
	}

// Se tiene que hacer así por métodos
	public void exportarPDFClientes(String[][] datos) {
		file = new File(REPORTEPDF_CLIENTES);
		try {
			fos = new FileOutputStream(file);
			PdfWriter.getInstance(document, fos).setInitialLeading(20);
			// Se abre el documento
			document.open();
			// Título
			Chunk titulo = new Chunk("REGISTRO DE COMPRAS\n\n", chapterFont);

			// Capítulo
			parrafo.add(titulo);
			parrafo.setAlignment(Element.ALIGN_JUSTIFIED);

			capitulo.add(1, parrafo);
			capitulo.setNumberDepth(0);
//			// Se crea la tabla
			tablaPDF.resetColumnCount(8);
			tablaPDF.setWidthPercentage(100);

			for (int i = 0; i < titulosReportePDFClientes.length; i++) {
				celdaTitulo.setPhrase(new Phrase(titulosReportePDFClientes[i]));
				celdaTitulo.setBackgroundColor(new BaseColor(194, 210, 214));
				tablaPDF.addCell(celdaTitulo);
			}

			for (int i = 0; i < datos.length; i++) {

//				PdfPCell celdaFecha = new PdfPCell(new Phrase(fechaComoCadena));
//				celdaFecha.setHorizontalAlignment(Element.ALIGN_RIGHT);
				tablaPDF.addCell(datos[i][0]);
				tablaPDF.addCell(datos[i][1]);
				tablaPDF.addCell(datos[i][2]);
				tablaPDF.addCell(datos[i][3]);
				tablaPDF.addCell(datos[i][4]);
				tablaPDF.addCell(datos[i][5]);

				// Para alinear las cifras y fechas toca así
//				PdfPCell celdaCilindraje = new PdfPCell(new Phrase(listaCompra.get(i).getMoto().getCilindraje() + ""));
//				celdaCilindraje.setHorizontalAlignment(Element.ALIGN_RIGHT);
//				tablaPDF.addCell(celdaCilindraje);

			}
			capitulo.add(tablaPDF);
			document.add(capitulo);
			document.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
