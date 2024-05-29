package com.skillbox.fibonacci;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FibonacciRepositoryTest extends PostgresTestContainerInitializer {

    @Autowired
    FibonacciRepository repository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Test save fibonacci Number")
    public void testSaveFibonacciNumber() {
        FibonacciNumber number = new FibonacciNumber(1, 1);
        repository.save(number);
        entityManager.flush();
        entityManager.detach(number);
        List<FibonacciNumber> actual = jdbcTemplate.query(
                "SELECT * FROM fibonacci_number WHERE index = 1",
                (rs, rowNum) -> new FibonacciNumber(rs.getInt("id"),
                        rs.getInt("index"), rs.getInt("value"))
        );
        assertEquals(1, actual.size());
        assertEquals(number, actual.get(0));
    }
    @Test
    @DisplayName("Test find by index")
    public void testFindByIndex() {
        FibonacciNumber number = new FibonacciNumber(2, 1);
        repository.save(number);
        entityManager.flush();
        entityManager.detach(number);

        Optional<FibonacciNumber> foundNumber = repository.findByIndex(2);
        assertTrue(foundNumber.isPresent());
        assertEquals(number, foundNumber.get());
    }
    @Test
    @DisplayName("Test duplicate insertion")
    public void testDuplicateInsertion() {
        FibonacciNumber number1 = new FibonacciNumber(3, 2);
        FibonacciNumber number2 = new FibonacciNumber(3, 2);
        repository.save(number1);
        entityManager.flush();
        entityManager.detach(number1);
        repository.save(number2);
        entityManager.flush();
        entityManager.detach(number2);

        List<FibonacciNumber> actual = jdbcTemplate.query(
                "SELECT * FROM fibonacci_number WHERE index = 3",
                (rs, rowNum) -> new FibonacciNumber(rs.getInt("id"),
                        rs.getInt("index"), rs.getInt("value"))
        );
        assertEquals(1, actual.size());
        assertEquals(number1, actual.get(0));
    }

}
