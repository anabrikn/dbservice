package com.example.dbservice.entity;

import javax.persistence.*;
import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@EqualsAndHashCode(of = {"date", "customer"})
@ToString(of = {"date", "customer"})
@NoArgsConstructor
@Entity
//@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date = LocalDate.now();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Product product;

    public Purchase(Customer customer, LocalDate date) {
        this.customer = customer;
        this.date = date;
    }

}
/*
@ElementCollection
    @Column(name = "quantity", nullable = false) // дает имя элемента "значение"
    @MapKeyJoinColumn(name = "product_id") // дает имя столбца, представляющего идентификатор элемента "ключ"
    private Map<Product, Integer> products  = new HashMap<>();

        public Map<Product, Integer> getProducts() {
        return Collections.unmodifiableMap(products);
    }

    public void addProduct(Product product) {
        products.merge(product, 1, (v1, v2) -> v1 + v2);
    }

    public void removeProduct(Product product) {
        products.computeIfPresent(product, (k, v) -> v > 1 ? v - 1 : null);
    }


 */