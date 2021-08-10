package my_junit_prac.com;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class My_testcase_1 {
	
private JUnit_Prac_1 junit_Prac_1;
	
	
	@BeforeEach
	void init() {
		junit_Prac_1 = new JUnit_Prac_1();
	}


	@Nested
	class AddTest {
		@Test
		void testAddingTwoPositives() {
			assertEquals(2, junit_Prac_1.add(1, 1), 
					"Add method should return the sum of two numbers");
		}
		
		@Test
		void testAddingTwoNegatives() {
			assertEquals(-2, junit_Prac_1.add(-1, -1), 
					"Add method should return the sum of two numbers");
		}
		
		@Test
		void testAddingAPositiveAndANegative() {
			assertEquals(0, junit_Prac_1.add(-1, 1), 
					"Add method should return the sum of two numbers");
		}
	}

	@Test 
	void testMultiply() {
		assertAll(
				() -> assertEquals(0, junit_Prac_1.multiply(1, 0)),
				() -> assertEquals(1, junit_Prac_1.multiply(1, 1)),
				() -> assertEquals(6, junit_Prac_1.multiply(2, 3))
				);
	}

	@Test 
	void CircleArea() {
		assertEquals(314.1592653589793, junit_Prac_1.CircleArea(10), 
				"Should return right circle area");
	}
	
	@Test
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> junit_Prac_1.divide(1, 0), 
				"Divide should throw ArithmeticException when denominator is zero");
	}
	

}
