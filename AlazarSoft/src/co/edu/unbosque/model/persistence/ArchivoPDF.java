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
	private String[] titulos;
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
	 * @author Nicolas Peña Mogollón Método encargado de recibir una lista de
	 *         clientes para escribir la información en el archivo PDF
	 *         correspondiente
	 * @param datos
	 */
// Se tiene que hacer así por métodos
	public void exportarPDF(String[][] datos, String tipoReporte) {

		if (this.verificarTipoReporte(tipoReporte) == 1) {

		}
		file = new File(REPORTEPDF_CLIENTES);
		try {
			fos = new FileOutputStream(file);
			PdfWriter.getInstance(document, fos).setInitialLeading(20);
			// Se abre el documento
			document.open();
			// Título
			Chunk titulo = new Chunk("REGISTRO DE COMPRAS\n\n", chapterFont);
			parrafo.add(titulo);
			parrafo.setAlignment(Element.ALIGN_CENTER);
			Chapter capitulo = new Chapter(parrafo, 1);
			// Capítulo

			capitulo.setNumberDepth(0);
//			// Se crea la tabla
			tablaPDF.resetColumnCount(datos[0].length);
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
				tablaPDF.addCell(datos[i][6]);
				tablaPDF.addCell(datos[i][7]);
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

	private int verificarTipoReporte(String reporte) {
		if (reporte.equals("Listado de clientes")) {
			titulos = titulosReportePDFClientes;
			file = new File(REPORTEPDF_CLIENTES);
			return 1;
		} else if (reporte.equals("Valor total de apuestas por cliente")) {
			file = new File(REPORTE_DETALLES_APUESTAS_POR_CLIENTE);
			return 2;
		} else if (reporte.equals("Detalle de apuestas por cliente y por sede")) {
			file = new File(REPORTE_TOTAL_APUESTAS_POR_SEDE);
			return 2;
		} else if (reporte.equals("Total de apuestas por sede y tipo de juego")) {
			file = new File(REPORTEPDF_CLIENTES);
			return 2;
		} else {
			return 0;
		}
	}

	private void crearTitulosCeldas(String reporte) {

	}

	public static void main(String[] args) {
		ArchivoPDF arch = new ArchivoPDF();
		String[][] tabla = new String[3][8];
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla.length; j++) {
				tabla[i][j] = i + "";
			}
		}
		arch.exportarPDF(tabla, "");
	}

}
