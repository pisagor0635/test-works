package com.ab.calculator;

import org.junit.jupiter.api.*;

public class TestCalculator {

    private Calculator calculator;
    private final int firstNumber = 5;
    private final int secondNumber = 3;

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    public void testAddition() {

        int sum = calculator.addition(firstNumber, secondNumber);
        Assertions.assertEquals(8, sum);
    }

    @Test
    public void testSubtraction() {

        int result = calculator.subtract(firstNumber, secondNumber);
        Assertions.assertEquals(2, result);

    }

    @Test
    public void testMultiplication() {

        int result = calculator.multiplicate(firstNumber, secondNumber);
        Assertions.assertEquals(15, result);

    }

    @Test
    public void division() {

        double result = calculator.division(firstNumber, secondNumber);
        Assertions.assertEquals(1.6666666666666667, result);
    }

    @Test
    @DisplayName("divide by zero throw arithmetic exception")
    public void testDivideByZero() {
        int thirdNumber = 0;

        ArithmeticException exception
                = Assertions.assertThrows(ArithmeticException.class,
                () -> calculator.division(firstNumber, thirdNumber));

        Assertions.assertEquals("/ by zero", exception.getMessage());
    }

}
