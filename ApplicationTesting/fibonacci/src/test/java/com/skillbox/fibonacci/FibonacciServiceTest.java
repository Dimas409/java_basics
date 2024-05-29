package com.skillbox.fibonacci;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FibonacciServiceTest {

    @Mock
    private FibonacciRepository repository;
    @Mock
    private FibonacciCalculator calculator;
    @InjectMocks
    private FibonacciService service;

    @BeforeEach
    public void setUp() {
        service = new FibonacciService(repository, calculator);
    }

    @Test
    @DisplayName("Test fibonacci number from database")
    public void testFibonacciNumberFromDatabase() {
        int index = 5;
        FibonacciNumber storedNumber = new FibonacciNumber(index, 5);
        when(repository.findByIndex(index)).thenReturn(Optional.of(storedNumber));
        FibonacciNumber result = service.fibonacciNumber(index);
        assertEquals(storedNumber, result);
        verify(repository).findByIndex(index);
        verify(calculator, never()).getFibonacciNumber(index);
    }
    @Test
    @DisplayName("Test fibonacci number computed and saved")
    public void testFibonacciNumberComputedAndSaved() {
        int index = 6;
        int computedValue = 8;
        FibonacciNumber computedNumber = new FibonacciNumber(index, computedValue);
        when(repository.findByIndex(index)).thenReturn(Optional.empty());
        when(calculator.getFibonacciNumber(index)).thenReturn(computedValue);
        FibonacciNumber result = service.fibonacciNumber(index);
        assertEquals(computedNumber, result);
        verify(repository).findByIndex(index);
        verify(calculator).getFibonacciNumber(index);
        verify(repository).save(computedNumber);
    }

    @Test
    @DisplayName("Test Invalid index throws exception")
    public void testInvalidIndexTrowsException() {
        int invalidIndex = -1;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> service.fibonacciNumber(invalidIndex) );
        assertEquals("Index should be greater or equal to 1", exception.getMessage());
        verify(repository, never()).findByIndex(invalidIndex);
        verify(calculator, never()).getFibonacciNumber(invalidIndex);
    }
}
