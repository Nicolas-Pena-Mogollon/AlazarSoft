package co.edu.unbosque.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.persistence.SuperastroDAO;
import co.edu.unbosque.model.persistence.SuperastroDTO;

public class SuperastroTest {
	
	SuperastroDAO superastroDao;
	ArrayList<SuperastroDTO> listaSuperastro;
	SuperastroDTO superAstro1;
	Date fecha;
	SimpleDateFormat formato;


	@Before
	public void setUp() throws Exception {
		fecha = new Date();
		superastroDao = new SuperastroDAO();
		listaSuperastro = superastroDao.getListaSuperastro();
		superAstro1 = new SuperastroDTO("Usaquén", "1000149678", fecha, 50000.00, "1 2 3 4", "Escorpio");
		System.out.println("SetUp hecho");
	}

	@Test
	public void testEditarApuesta() {
		assertNotNull("La apuesta no debe estar vacia",
				superastroDao.editarApuesta("1193499871", fecha, "Usaquén", 350000));
		superastroDao.eliminarApuesta(superAstro1.getCedula(), superAstro1.getFecha());

	}

	@Test
	public void testAgregarEliminarBaloto() {
		assertNotNull("El apostador debio ser agregado", superastroDao.crearApuestas(superAstro1.getNombreSede(), superAstro1.getCedula(), superAstro1.getFecha(),
				superAstro1.getValorApuesta(), superAstro1.getNumeroJuego(), superAstro1.getSigno()));
		assertTrue("El apostador debio ser eliminado",
				superastroDao.eliminarApuesta(superAstro1.getCedula(), superAstro1.getFecha()));
	}

	@Test
	public void testBuscarApuesta() {
		superastroDao.crearApuestas(superAstro1.getNombreSede(), superAstro1.getCedula(), superAstro1.getFecha(),
				superAstro1.getValorApuesta(), superAstro1.getNumeroJuego(), superAstro1.getSigno());
		assertNotNull("El apostador debio ser buscado",
				superastroDao.buscarApuesta(superAstro1.getCedula(), superAstro1.getFecha()));
		superastroDao.eliminarApuesta(superAstro1.getCedula(), superAstro1.getFecha());
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("TearDown Hecho");

	}

}
