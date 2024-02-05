package com.io.javabrains;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

class MathUtilsTest {
	@BeforeAll
	static void beforeAllMethod() {
		System.out.println("BeforeAllMethod");
	}
	
	MathUtils math ;
	@BeforeEach
	void initSS() {
		math = new MathUtils();
	}
	
	@Test
	void testAdd() {
		int res = math.add(1, 0);
		assertEquals(2, math.add(1, 1));
	}

	
	@Test
	void testComputeCircleRadius() {
		boolean isServerUp = false;
		assumeTrue(isServerUp);
		assertEquals(314.1592653589793, math.computeCircleArea(10));
	}
	
	
	@Test
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> math.divide(10, 0),"Divide by 0 should be thrown");
	}
	
	@Test
	@Disabled
	void TDDTest() {
		fail("Test should be failed");
	}
	
	@Test
	void testMultiply() {
		assertAll( 
					()-> assertEquals(4, math.multiply(2, 2)),
					()->assertEquals(0 , math.multiply(4, 0)),
					()->assertEquals(-4 , math.multiply(4, -1))
				);
	}
}
