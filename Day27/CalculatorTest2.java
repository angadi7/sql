package com.Day27;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorTest2 {

    private Calculator calculator;

    @BeforeAll
    public void setupAll() {
        System.out.println("Executing @BeforeAll - Runs once before all test methods in this class");
    }

    @BeforeEach
    public void setup() {
        System.out.println("Executing @BeforeEach - Runs before each test method in this class");
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {
        System.out.println("Executing testAdd");
        assertEquals(5, calculator.add(2, 3));
        assertEquals(-1, calculator.add(-2, 1));
        assertEquals(0, calculator.add(-3, 3));
    }

    @Test
    public void testSubtract() {
        System.out.println("Executing testSubtract");
        assertEquals(1, calculator.subtract(3, 2));
        assertEquals(-3, calculator.subtract(-2, 1));
        assertEquals(-6, calculator.subtract(-3, 3));
    }

    @Test
    public void testMultiply() {
        System.out.println("Executing testMultiply");
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(-2, calculator.multiply(-2, 1));
        assertEquals(-9, calculator.multiply(-3, 3));
    }

    @Test
    public void testDivide() {
        System.out.println("Executing testDivide");
        assertEquals(2.0, calculator.divide(6, 3));
        assertEquals(-2.0, calculator.divide(-6, 3));
        assertEquals(1.5, calculator.divide(3, 2));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(1, 0);
        });
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }

    @AfterEach
    public void teardown() {
        System.out.println("Executing @AfterEach - Runs after each test method in this class");
        calculator = null;
    }

    @AfterAll
    public void teardownAll() {
        System.out.println("Executing @AfterAll - Runs once after all test methods in this class");
    }
}
