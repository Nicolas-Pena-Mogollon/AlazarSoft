package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ArchivoPDF extends ArchivoExportar {

	private static final Font chapterFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 26, Font.BOLDITALIC);
	public final String RUTA_REPORTEPDF_CLIENTES = "reporteClientes.pdf";
	public final String RUTA_REPORTEPDF_TOTAL_APUESTAS_CLIENTES = "reporteClientes.pdf";
	public final String RUTA_REPORTE_DETALLES_APUESTAS_POR_CLIENTE = "reporteClientes.pdf";
	public final String RUTA_REPORTE_TOTAL_APUESTAS_POR_SEDE = "reporteClientes.pdf";
	private Paragraph parrafo;
	private PdfPTable tablaPDF;
	private PdfPCell celdaTitulo;
	private File file;
	private FileOutputStream fos;
	private Document document;

	public ArchivoPDF() {
		document = new Document();
		parrafo = new Paragraph();
		celdaTitulo = new PdfPCell();
		document.setPageSize(PageSize.LEGAL.rotate());
		tablaPDF = new PdfPTable(1);
	}

	/**
	 * Método encargado de recibir una lista de clientes para escribir la
	 * información en el archivo PDF correspondiente
	 * 
	 * @param data
	 * @param tipoReporte
	 */
	@Override
	public void exportar(String[][] data, String tipoReporte) {
		// TODO Auto-generated method stub
		String[] titulosSeleccionados = this.verificarTipoReporte(tipoReporte);
		try {
			fos = new FileOutputStream(file);
			PdfWriter.getInstance(document, fos).setInitialLeading(20);
			// Se abre el documento
			document.open();
			// Título
			Chunk titulo = new Chunk(tipoReporte + "\n\n", chapterFont);
			parrafo.add(titulo);
			parrafo.setAlignment(Element.ALIGN_CENTER);
			// Capítulo
			Chapter capitulo = new Chapter(parrafo, 1);

			// capitulo.setNumberDepth(0);
//			// Se crea la tabla
			tablaPDF.resetColumnCount(data[0].length);
			tablaPDF.setWidthPercentage(100);
			this.llenarTitulos(titulosSeleccionados);

			for (int i = 0; i < data.length; i++) {
//				PdfPCell celdaFecha = new PdfPCell(new Phrase(fechaComoCadena));
//				celdaFecha.setHorizontalAlignment(Element.ALIGN_RIGHT);
				for (int j = 0; j < data[i].length; j++) {
					tablaPDF.addCell(data[i][j]);
				}
				// Para alinear las cifras y fechas toca así
//				PdfPCell celdaCilindraje = new PdfPCell(new Phrase(listaCompra.get(i).getMoto().getCilindraje() + ""));
//				celdaCilindraje.setHorizontalAlignment(Element.ALIGN_RIGHT);
//				tablaPDF.addCell(celdaCilindraje);
			}
			capitulo.add(tablaPDF);
			document.add(capitulo);
			document.close();
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public String[] verificarTipoReporte(String tipoReporte) {
		if (tipoReporte.equals("Listado de clientes por sede")) {
			file = new File(RUTA_REPORTEPDF_CLIENTES);
			return titulosReportePDFClientes;
		} else if (tipoReporte.equals("Valor total de apuestas por cliente")) {
			file = new File(RUTA_REPORTE_DETALLES_APUESTAS_POR_CLIENTE);
			return titulosTotalApuestasSedeTipoJuego;
		} else if (tipoReporte.equals("Detalle de apuestas realizadas por cliente y sede")) {
			file = new File(RUTA_REPORTE_TOTAL_APUESTAS_POR_SEDE);
			return titulosDetalleApuestasRealizadasClienteSede;
		} else if (tipoReporte.equals("Total de apuestas por sede y tipo de juego")) {
			file = new File(RUTA_REPORTEPDF_TOTAL_APUESTAS_CLIENTES);
			return titulosTotalApuestasSedeTipoJuego;
		} else {
			return null;
		}
	}

	@Override
	public void llenarTitulos(String[] titulos) {
		// TODO Auto-generated method stub
		for (int i = 0; i < titulos.length; i++) {
			celdaTitulo.setPhrase(new Phrase(titulos[i]));
			celdaTitulo.setBackgroundColor(new BaseColor(194, 210, 214));
			tablaPDF.addCell(celdaTitulo);
		}
	}

}
