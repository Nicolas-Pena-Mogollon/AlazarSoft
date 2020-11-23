package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ArchivoPDF extends ArchivoExportar {

	private static final Font chapterFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 26, Font.BOLDITALIC);
	public final String RUTA_REPORTEPDF_CLIENTES = "./Export/reporteClientesSede.pdf";
	public final String RUTA_REPORTEPDF_TOTAL_APUESTAS_CLIENTES = "./Export/reporteApuestasClientes.pdf";
	public final String RUTA_REPORTE_DETALLES_APUESTAS_POR_CLIENTE = "./Export/reporteApuestasClienteSede.pdf";
	public final String RUTA_REPORTE_TOTAL_APUESTAS_POR_SEDE = "./Export/reporteTotalApuestasSedeJuego.pdf";
	private PdfPTable tablaPDF;
	private File file;
	private FileOutputStream fos;

	public ArchivoPDF() {
		tablaPDF = new PdfPTable(1);
	}

	/**
	 * M�todo encargado de recibir una lista de clientes para escribir la
	 * informaci�n en el archivo PDF correspondiente
	 * 
	 * @param data
	 * @param tipoReporte
	 */
	@Override
	public void exportar(String[][] data, String tipoReporte) {
		// TODO Auto-generated method stub
		String[] titulosSeleccionados = this.verificarTipoReporte(tipoReporte);
		Document document = new Document();
		document.setPageSize(PageSize.LEGAL.rotate());
		try {
			fos = new FileOutputStream(file);
			PdfWriter.getInstance(document, fos).setInitialLeading(20);
			// Se abre el documento
			document.open();
			// T�tulo
			Chunk titulo = new Chunk(tipoReporte + "\n\n", chapterFont);
			Paragraph parrafo = new Paragraph(titulo);
			parrafo.setAlignment(Element.ALIGN_CENTER);
			// Cap�tulo
			Chapter capitulo = new Chapter(parrafo, 1);
			capitulo.setNumberDepth(0);

//			// Se crea la tabla
			tablaPDF = new PdfPTable(data[0].length);
			tablaPDF.setWidthPercentage(100);
			this.llenarTitulos(titulosSeleccionados);

			for (int i = 0; i < data.length; i++) {
//				PdfPCell celdaFecha = new PdfPCell(new Phrase(fechaComoCadena));
//				celdaFecha.setHorizontalAlignment(Element.ALIGN_RIGHT);
				for (int j = 0; j < data[i].length; j++) {
					tablaPDF.addCell(data[i][j]);
				}
				// Para alinear las cifras y fechas toca as�
//				PdfPCell celdaCilindraje = new PdfPCell(new Phrase(listaCompra.get(i).getMoto().getCilindraje() + ""));
//				celdaCilindraje.setHorizontalAlignment(Element.ALIGN_RIGHT);
//				tablaPDF.addCell(celdaCilindraje);
			}
			capitulo.add(tablaPDF);
			document.add(capitulo);
			document.close();
			fos.close();
		} catch (DocumentException | IOException e) {
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
			file = new File(RUTA_REPORTEPDF_TOTAL_APUESTAS_CLIENTES);
			return titulosValorTotalApuestasCliente;
		} else if (tipoReporte.equals("Detalle de apuestas realizadas por cliente y sede")) {
			file = new File(RUTA_REPORTE_DETALLES_APUESTAS_POR_CLIENTE);
			return titulosDetalleApuestasRealizadasClienteSede;
		} else if (tipoReporte.equals("Total de apuestas por sede y tipo de juego")) {
			file = new File(RUTA_REPORTE_TOTAL_APUESTAS_POR_SEDE);
			return titulosTotalApuestasSedeTipoJuego;
		} else {
			return null;
		}
	}

	@Override
	public void llenarTitulos(String[] titulos) {
		// TODO Auto-generated method stub
		for (int i = 0; i < titulos.length; i++) {
			PdfPCell celdaTitulo = new PdfPCell(new Phrase(titulos[i]));
			celdaTitulo.setBackgroundColor(new BaseColor(194, 210, 214));
			tablaPDF.addCell(celdaTitulo);
		}
	}
}
