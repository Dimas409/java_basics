package com.skillbox.fibonacci;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLInsert;


@Entity
@Data
@Table(name = "fibonacci_number", uniqueConstraints = { @UniqueConstraint(columnNames={"index"}) })
@SQLInsert(sql = "INSERT INTO fibonacci_number(index, value) VALUES (?, ?) ON CONFLICT(index) DO UPDATE SET value = EXCLUDED.value RETURNING id" )
public class FibonacciNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    @JsonIgnore
    private Integer id;

    private int index;

    private int value;

    public FibonacciNumber() {

    }

    public FibonacciNumber(int index, int value) {
        this.index = index;
        this.value = value;
    }
    public FibonacciNumber(int id, int index, int value) {
        this.id = id;
        this.index = index;
        this.value = value;
    }
}
