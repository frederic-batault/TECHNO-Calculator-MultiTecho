package tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import service.CalculService;

@RunWith(Parameterized.class)
public class OperationParamTest {

	private String addResult;
	private String sousResult;
	private String multiResult;
	private String divResult;
	private double nb1;
	private double nb2;



	public OperationParamTest(String addResult, String sousResult, String multiResult, String divResult, double nb1,
			double nb2) {
		super();
		this.addResult = addResult;
		this.sousResult = sousResult;
		this.multiResult = multiResult;
		this.divResult = divResult;
		this.nb1 = nb1;
		this.nb2 = nb2;
	}

	// tableau des paramètres
	@Parameters
	static public List<Object[]> getParameters() {
		Object[][] parameters = { { "10.0", "6.0","16.0","4.0", 8.0, 2.0  }, { "2.0", "2.0","0.0","erreur : division par zéro", 2.0, 0.0  },};
		return Arrays.asList(parameters);

	}

	@Test
	public void testAddition() {
		CalculService refCalculService = new CalculService();
		assertEquals(addResult, refCalculService.addition(nb1,nb2));
	}

	@Test
	public void testSoustraction() {
		CalculService refCalculService = new CalculService();
		assertEquals(sousResult, refCalculService.soustraction(nb1,nb2));
	}

	@Test
	public void testMultiplication() {
		CalculService refCalculService = new CalculService();
		assertEquals(multiResult, refCalculService.multiplication(nb1,nb2));
	}

	@Test
	public void testDivision() {
		CalculService refCalculService = new CalculService();
		assertEquals(divResult, refCalculService.division(nb1,nb2));
	}

}
