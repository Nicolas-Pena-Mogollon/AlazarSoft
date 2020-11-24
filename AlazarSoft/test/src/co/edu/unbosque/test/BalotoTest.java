package co.edu.unbosque.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.persistence.BalotoDAO;
import co.edu.unbosque.model.persistence.BalotoDTO;

public class BalotoTest {

	BalotoDAO balotoDao;
	ArrayList<BalotoDTO> ListaBaloto;
	BalotoDTO baloto1;
	Date fecha;
	SimpleDateFormat formato;

	@Before
	public void setUp() throws Exception {
		fecha = new Date();
		balotoDao = new BalotoDAO();
		ListaBaloto = balotoDao.getListaBaloto();
		baloto1 = new BalotoDTO("Usaquén", "1000149678", fecha, 50000.00, "1 2 3 4 5 6");
		System.out.println("SetUp hecho");
	}

	@Test
	public void testEditarApuesta() {
		assertNotNull("La apuesta no debe estar vacia",
				balotoDao.editarApuesta("1193499871", fecha, "Usaquén", 350000));
		balotoDao.eliminarApuesta(baloto1.getCedula(), baloto1.getFecha());

	}

	@Test
	public void testAgregarEliminarBaloto() {
		assertNotNull("El apostador debio ser agregado", balotoDao.crearApuestas(baloto1.getNombreSede(),
				baloto1.getCedula(), baloto1.getFecha(), baloto1.getValorApuesta(), baloto1.getNumeroJuego()));
		assertTrue("El apostador debio ser eliminado",
				balotoDao.eliminarApuesta(baloto1.getCedula(), baloto1.getFecha()));
	}

	@Test
	public void testBuscarApuesta() {
		balotoDao.crearApuestas(baloto1.getNombreSede(), baloto1.getCedula(), baloto1.getFecha(),
				baloto1.getValorApuesta(), baloto1.getNumeroJuego());
		assertNotNull("El apostador debio ser buscado",
				balotoDao.buscarApuesta(baloto1.getCedula(), baloto1.getFecha()));
		balotoDao.eliminarApuesta(baloto1.getCedula(), baloto1.getFecha());
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("TearDown Hecho");

	}

}
