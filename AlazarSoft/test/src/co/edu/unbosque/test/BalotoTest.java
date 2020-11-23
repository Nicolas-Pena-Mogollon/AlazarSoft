package co.edu.unbosque.test;

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
	public void test() {
	}

	@Test

	@After
	public void tearDown() throws Exception {
		System.out.println("TearDown Hecho");

	}

}
