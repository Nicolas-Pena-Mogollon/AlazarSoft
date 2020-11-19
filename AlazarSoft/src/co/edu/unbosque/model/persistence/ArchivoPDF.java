package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;
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

	private File file;
	private FileOutputStream fos;
	private Document document;

	public ArchivoPDF() {
		document = new Document();
		document.setPageSize(PageSize.LEGAL.rotate());
		

	}
//Código de otro ejemplo (es la base)
//Aquí entra la info
//	public void createPDF(ArrayList<Compra> listaCompra) {
//		try {
//			// Se crea el OutputStream para el fichero donde queremos dejar el pdf.
//			FileOutputStream ficheroPdf = new FileOutputStream("Compras.pdf");
//			PdfWriter.getInstance(document, ficheroPdf).setInitialLeading(20);
//			// Se abre el documento
//			document.open();
//
//			// Título
//			Chunk titulo = new Chunk("REGISTRO DE COMPRAS\n\n", chapterFont);
//
//			// Capítulo
//			Paragraph tittle = new Paragraph(titulo);
//			tittle.setAlignment(Element.ALIGN_JUSTIFIED);
//			Chapter chapter = new Chapter(tittle, 1);
//			chapter.setNumberDepth(0);
//
//			// Se crea la tabla
//			PdfPTable tabla = new PdfPTable(8);
//			tabla.setWidthPercentage(100);
//
//			for (int i = 0; i < titulosReportePDFClientes.length; i++) {
//				PdfPCell titles = new PdfPCell(new Phrase(titulosReportePDFClientes[i]));
//				titles.setBackgroundColor(new BaseColor(194, 210, 214));
//				tabla.addCell(titles);
//			}
//
//			// Se formatea la fecha
//			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//			String fechaComoCadena = "";
//
//			for (int i = 0; i < listaCompra.size(); i++) {
//
//				Date pFecha = listaCompra.get(i).getFechaCompra();
//				fechaComoCadena = sdf.format(pFecha);
//				PdfPCell celdaFecha = new PdfPCell(new Phrase(fechaComoCadena));
//				celdaFecha.setHorizontalAlignment(Element.ALIGN_RIGHT);
//				tabla.addCell(celdaFecha);
//
//				tabla.addCell(listaCompra.get(i).getNombreProveedor());
//				tabla.addCell(listaCompra.get(i).getMoto().getModelo());
//				tabla.addCell(listaCompra.get(i).getMoto().getReferencia());
//
//				PdfPCell celdaCilindraje = new PdfPCell(new Phrase(listaCompra.get(i).getMoto().getCilindraje() + ""));
//				celdaCilindraje.setHorizontalAlignment(Element.ALIGN_RIGHT);
//				tabla.addCell(celdaCilindraje);
//
//				PdfPCell celdaExistencias = new PdfPCell(
//						new Phrase(listaCompra.get(i).getMoto().getExistencias() + ""));
//				celdaExistencias.setHorizontalAlignment(Element.ALIGN_RIGHT);
//				tabla.addCell(celdaExistencias);
//
//				PdfPCell celdaValorCompra = new PdfPCell(
//						new Phrase(listaCompra.get(i).getMoto().getValorCompra() + ""));
//				celdaValorCompra.setHorizontalAlignment(Element.ALIGN_RIGHT);
//				tabla.addCell(celdaValorCompra);
//
//				PdfPCell celdaCantidad = new PdfPCell(new Phrase(listaCompra.get(i).getCantidad() + ""));
//				celdaCantidad.setHorizontalAlignment(Element.ALIGN_RIGHT);
//				tabla.addCell(celdaCantidad);
//
//			}
//
//			// Se añade la tabla al capítulo
//			chapter.add(tabla);
//			// Se añade el capítulo al documento
//			document.add(chapter);
//
//			// Se cierra el documento
//			document.close();
//
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "Error al Exportar", "Warning", JOptionPane.WARNING_MESSAGE);
//		}
//	}

// Se tiene que hacer así por métodos
	public void exportarPDFClientes(String[][] datos) {
		file = new File(REPORTEPDF_CLIENTES);
		try {
			fos = new FileOutputStream(file);
			PdfWriter.getInstance(document, fos).setInitialLeading(20);
			// Se abre el documento
			document.open();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
