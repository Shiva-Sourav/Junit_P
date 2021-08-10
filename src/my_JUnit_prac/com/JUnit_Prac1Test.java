package my_JUnit_prac.com;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;



class JUnit_Prac1Test {

	private JUnit_Prac1 junit_Prac1;

	@BeforeAll
	//the reason I used static here bcz @BeforeAll will be executed before object gets created..... 
	static void beforeAllInit() {
		System.out.println("This Before all runs before everything!!");
	}
	
	@BeforeEach
	void init() {
		junit_Prac1 = new JUnit_Prac1();
	}
	
	@AfterEach
	void afterEach() {
		System.out.println("after each method !!");
	}


	@Nested
	@DisplayName("nested-addition")
	@Tag("basicMathOperations")
	class AddTest {
		@Test
		@DisplayName("Adding +ve no.")
		void testAddingTwoPositives() {
			assertEquals(2, junit_Prac1.add(1, 1), 
					"Add method should return the sum of two numbers");
			System.out.println("testAddingTwoPositives");
		}
		
		
		
		@Test
		@DisplayName("Adding -ve no.")
		void testAddingTwoNegatives() {
			int expected=-2;
			int actual=junit_Prac1.add(-1, -1);
			assertEquals(junit_Prac1.add(-1, -1), actual,()->
					"should return the sum of two numbers"+expected+"but returned"+actual);
			System.out.println("testAddingTwoNegatives");
		}
		
	}
	
	
	@Test 
	@DisplayName("Multiplying")
	@Tag("basicMathOperations")
	void testMultiply() {
		assertAll(
				() -> assertEquals(0, junit_Prac1.multiply(9, 0)),
				() -> assertEquals(1, junit_Prac1.multiply(1, 1)),
				() -> assertEquals(6, junit_Prac1.multiply(2, 3))
				);
		System.out.println("testMultiply");
	}
	
	

	@Test 
	@DisplayName("Area of Circle")
	@Tag("Area")
	void CircleArea() {
		assertEquals(314.1592653589793, junit_Prac1.CircleArea(10), 
				"Should return right circle area");
		System.out.println("CircleArea");
	}
	
	
	
	@Test
	@DisplayName("Division")
	@Tag("basicMathOperations")
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> junit_Prac1.divide(1, 0), 
				"Division throws ArithmeticException when denominator is zero");
		System.out.println("testDivide");
	}
	
   @RepeatedTest(3)
   void repeatMethod() {
	   int count=0;
	   count++;
	   System.out.println("repeating the test"+count);
   }
   
  @Test
  @Disabled
   void diableTest() {
	   fail("This test might fail");
   }

}
