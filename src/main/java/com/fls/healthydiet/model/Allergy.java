package com.fls.healthydiet.model;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Table(name = "allergies")
@EqualsAndHashCode(exclude = "products")
public class Allergy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(columnDefinition = "text")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "allergy_product",
            joinColumns = @JoinColumn(name = "allergy_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private Set<Product> products;

    public Allergy(String name) {
        this.name = name;
    }

    public Allergy(String name, Product... products) {
        this.name = name;
        this.products = Stream.of(products).collect(Collectors.toSet());
        this.products.forEach(x-> x.getAllergies().add(this));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
