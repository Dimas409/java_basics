package com.skillbox.fibonacci;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class FibonacciControllerTest extends PostgresTestContainerInitializer {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private FibonacciRepository repository;
    @Autowired
    private EntityManager entityManager;
    @Mock
    private FibonacciService fibonacciService;
    private FibonacciController fibonacciController;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        fibonacciController = new FibonacciController(fibonacciService);
    }
    @Test
    void testGetNumberValidIndex() {
        int index = 5;
        FibonacciNumber expectedNumber = new FibonacciNumber(5, 5, 8);
        when(fibonacciService.fibonacciNumber(index)).thenReturn(expectedNumber);

        ResponseEntity response = fibonacciController.getNumber(index);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedNumber, response.getBody());
        verify(fibonacciService).fibonacciNumber(index);
    }
    @Test
    void testGetNumberInvalidIndex() {
        int index = 0;
        String errorMessage = "Index should be greater or equal to 1";
        when(fibonacciService.fibonacciNumber(index)).thenThrow(new IllegalArgumentException(errorMessage));

        ResponseEntity response = fibonacciController.getNumber(index);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(errorMessage, response.getBody());
        verify(fibonacciService).fibonacciNumber(index);
    }

    @Test
    @DisplayName("Test get fibonacci number valid index")
    public void testGetFibonacciNumberValidIndex() throws Exception {
        FibonacciNumber number = new FibonacciNumber(2, 2, 3);
        repository.save(number);
        entityManager.flush();
        entityManager.detach(number);

        mockMvc.perform(get("/fibonacci/2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.index").value(2))
                .andExpect(jsonPath("$.value").value(3));
    }
    @Test
    @DisplayName("Test get fibonacci number invalid index")
    public void testGetFibonacciNumberInvalidIndex() throws Exception {
        mockMvc.perform(get("/fibonacci/0"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("Index should be greater or equal to 1"));
    }

}
