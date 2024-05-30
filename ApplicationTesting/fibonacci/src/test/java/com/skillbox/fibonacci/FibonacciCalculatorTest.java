package com.skillbox.fibonacci;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FibonacciCalculatorTest {
    private FibonacciCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new FibonacciCalculator();
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 1",
            "3, 2",
            "4, 3",
            "5, 5",
            "6, 8",
            "7, 13",
            "8, 21",
            "9, 34",
            "10, 55"
    })
    @DisplayName("Test fibonacci number")
    public void testFibonacciNumber(int index, int expected) {
        assertEquals(expected, calculator.getFibonacciNumber(index));
    }
    @Test
    @DisplayName("Test fibonacci number invalid index")
    public void testFibonacciNumberInvalidIndex() {
        Executable executable = () -> calculator.getFibonacciNumber(0);
        assertThrows(IllegalArgumentException.class, executable, "Index should be greater or equal to 1");
    }
    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 1"
    })
    @DisplayName("Test fibonacci for index 1 and 2")
    public void testFibonacciNumberForIndex1And2(int index, int expected) {
        assertEquals(expected, calculator.getFibonacciNumber(index));
    }

}
