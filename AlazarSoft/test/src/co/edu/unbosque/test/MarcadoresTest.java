package co.edu.unbosque.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.persistence.MarcadoresDAO;
import co.edu.unbosque.model.persistence.MarcadoresDTO;

public class MarcadoresTest {
	MarcadoresDAO marcadoresDao;
	ArrayList<MarcadoresDTO> listaMarcadores;
	MarcadoresDTO marcador1;
	Date fecha;
	SimpleDateFormat formato;

	@Before
	public void setUp() throws Exception {
		fecha = new Date();
		marcadoresDao = new MarcadoresDAO();
		listaMarcadores = marcadoresDao.getListaMarcadores();
		marcador1 = new MarcadoresDTO("Usaquén", "1000149678", fecha, 50000.00, "Barcelona vs. Real Madrid", "Empate");
		System.out.println("SetUp hecho");
	}

	@Test
	public void testEditarApuesta() {
		assertNotNull("La apuesta no debe estar vacia",
				marcadoresDao.editarApuesta("1193499871", fecha, "Usaquén", 350000));
		marcadoresDao.eliminarApuesta(marcador1.getCedula(), marcador1.getFecha());

	}

	@Test
	public void testAgregarEliminarBaloto() {
		assertNotNull("El apostador debio ser agregado",
				marcadoresDao.crearApuestas(marcador1.getNombreSede(), marcador1.getCedula(), marcador1.getFecha(),
						marcador1.getValorApuesta(), marcador1.getPartido(), marcador1.getResultado()));
		assertTrue("El apostador debio ser eliminado",
				marcadoresDao.eliminarApuesta(marcador1.getCedula(), marcador1.getFecha()));
	}

	@Test
	public void testBuscarApuesta() {
		marcadoresDao.crearApuestas(marcador1.getNombreSede(), marcador1.getCedula(), marcador1.getFecha(),
				marcador1.getValorApuesta(), marcador1.getPartido(), marcador1.getResultado());
		assertNotNull("El apostador debio ser buscado",
				marcadoresDao.buscarApuesta(marcador1.getCedula(), marcador1.getFecha()));
		marcadoresDao.eliminarApuesta(marcador1.getCedula(), marcador1.getFecha());
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("TearDown Hecho");
	}

}
