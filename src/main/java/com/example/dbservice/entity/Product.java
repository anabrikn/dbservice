package com.example.dbservice.entity;

import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Getter
@EqualsAndHashCode(of = "name")
@ToString(of = {"name", "expenses"})
@NoArgsConstructor
@Entity
//@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 32, nullable = false)
    private String name;

    @Column(nullable = false)
    private Long expenses;

    public Product(String name, long expenses) {
        this.name = name;
        this.expenses = expenses;
    }
}
