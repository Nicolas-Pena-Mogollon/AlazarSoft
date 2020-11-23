package co.edu.unbosque.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.Apuesta;
import co.edu.unbosque.model.persistence.BalotoDTO;
import co.edu.unbosque.model.persistence.DiscordFile;
import co.edu.unbosque.model.persistence.GamerDAO;

public class BalotoDaoTest {

	Apuesta apuesta;
	File file = new File("./DataTest/GamerDaoTest.dat");
	ArrayList<BalotoDTO> balotoLista;
	BalotoDTO baloto1;
	Date fecha;
	SimpleDateFormat f;

	@Before
	public void setUp() throws Exception {
		gamerDao = new GamerDAO();
		dFile = new DiscordFile();
		gamers = dFile.leerRegistroJugador();

		file.delete();
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		apuesta = new Apuesta();
		fecha = new Date();
		// String fechaNew = f.format(fecha);
		balotoLista = apuesta.getBalotoDAO().getListaBaloto();
		baloto1 = new BalotoDTO("Usaquén", "1000149678", fecha, 10000.00, "1-2-3-4-5-6");
		balotoLista.add(baloto1);

		System.out.println("SetUp hecho");

	}

	@Test
	public void testBuscarApuesta() {
		assertNotNull("La apuesta debio ser buscada",
				apuesta.getBalotoDAO().buscarApuesta(baloto1.getCedula(), baloto1.getFecha()));

	}

	@Test
	public void testCrearApuestas() {
		assertNotNull("Se debio crear la apuesta", baloto1);

	}

	@Test
	public void testEliminarApuesta() {
		assertTrue("Se debio eliminar la apuesta", apuesta.getBalotoDAO().eliminarApuesta(baloto1.getCedula(), baloto1.getFecha()));
	}

	@Test
	public void testEditarApuesta() {
		assertNotSame("Debio realizarse la edición", baloto1, apuesta.getBalotoDAO().editarApuesta(baloto1.getCedula(), fecha, nombreSede, valorApuesta));
	}

	@After
	public void tearDown() throws Exception {

		System.out.println("TearDown Hecho");

	}

}
