import static org.junit.Assert.*;

import org.junit.Test;


public class CalculatorTest {

	
	@Test
	public void testCalculator1() {
		Calculator c = new Calculator();
		double testValue=2.0, value;
		
		 c.setExpression("1+1");
		 value = c.evaluate();		
		assertEquals("Test 1+1",testValue , value, 0);

	}
	
	
	@Test
	public void testCalculator2() {
		Calculator c = new Calculator();
		double testValue=-14.0, value;
		
		 c.setExpression("1+1-4*4");
		 value = c.evaluate();		
		assertEquals("Test 1+1-4*4",testValue , value, 0);

	}
	
	

	@Test
	public void testCalculator3() {
		Calculator c = new Calculator();
		double testValue=2.0, value;
		
		 c.setExpression("2");
		 value = c.evaluate();		
		assertEquals("Test 2",testValue , value, 0);

	}
	


}
