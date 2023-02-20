package org.ssglobal.training.codes.test;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ssglobal.training.codes.MathOps;

public class TestMathOps {
	private MathOps mo;
	
	@BeforeEach
	public void setup() {
		mo = new MathOps();
	}
	
	@AfterEach
	public void teardown() {
		mo = null;
	}
	
	@Test
	public void testDivOp() {
		assertDoesNotThrow(() -> {
			int result = mo.div(10, 2);
			assertEquals(5, result);
		});
	}
	
	@Test
	public void testDivOpRainy() {
		assertThrows(ArithmeticException.class, () -> {
			int result = mo.div(10, 0);
			assertEquals(0, result);
		});
	}
	
	@Test
	public void testDisplayArray() {
		int[] testData = {10, 20, 30, 40};
		int[] result = mo.displayArray(testData);
		assertSame(testData, result);
	}
	
	@Test
	public void testDisplayArrayRainy() {
		int[] testData = null;
		int[] result = mo.displayArray(testData);
		assertSame(testData, result);
	}
	
	@Test
	public void testAdd() {
		int result = mo.add(10, 15);
		assertEquals(25, result);
	}
}
