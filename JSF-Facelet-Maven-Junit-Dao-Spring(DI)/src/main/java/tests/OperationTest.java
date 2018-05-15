package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import service.CalculService;

public class OperationTest {
	

	
	@Test
	public void testAdditionVrai() {
		CalculService refCalculService = new CalculService();
		assertEquals("5.0", refCalculService.addition(2.0,3.0));
	}

	@Test
	public void testAdditionFaux() {
		CalculService refCalculService = new CalculService();
		assertNotEquals("6.0", refCalculService.addition(2.0,3.0));
	}
	
	@Test
	public void testSoustractionVrai() {
		CalculService refCalculService = new CalculService();
		assertEquals("1.0", refCalculService.soustraction(3.0,2.0));
	}
	
	@Test
	public void testSoustractionFaux() {
		CalculService refCalculService = new CalculService();
		assertNotEquals("5.0", refCalculService.soustraction(2.0,3.0));
	}

	@Test
	public void testMultiplicationVrai() {
		CalculService refCalculService = new CalculService();
		assertEquals("6.0", refCalculService.multiplication(2.0,3.0));
	}
	
	@Test
	public void testMultiplicationFaux() {
		CalculService refCalculService = new CalculService();
		assertNotEquals("5.0", refCalculService.multiplication(2.0,3.0));
	}

	@Test
	public void testDivisionVrai() {
		CalculService refCalculService = new CalculService();
		assertEquals("1.5", refCalculService.division(3.0,2.0));
	}
	@Test
	public void testDivisionFaux() {
		CalculService refCalculService = new CalculService();
		assertNotEquals("5.0", refCalculService.division(3.0,2.0));
	}
	@Test
	public void testDivisionErreur() {
		CalculService refCalculService = new CalculService();
		assertEquals("erreur : division par zéro", refCalculService.division(3.0,0.0));
	}
}
