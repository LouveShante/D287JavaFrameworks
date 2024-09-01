package com.example.demo.domain;

import com.example.demo.validators.ValidMaximum;
import com.example.demo.validators.ValidMinimum;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 *
 *
 *
 */
@Entity
@ValidMinimum
@ValidMaximum
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="part_type",discriminatorType = DiscriminatorType.INTEGER)
@Table(name="Parts")
public abstract class Part implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    @Min(value = 0, message = "Price value must be positive")
    double price;
    @Min(value = 0, message = "Inventory value must be positive")
    int inv;
    @Min(value = 0, message = "Inventory value must be positive")
    private static int invMin;
    @Min(value = 0, message = "Inventory value must be positive")
    private static int invMax;

    @ManyToMany
    @JoinTable(name="product_part", joinColumns = @JoinColumn(name="part_id"),
            inverseJoinColumns=@JoinColumn(name="product_id"))
    Set<Product> products= new HashSet<>();

    public Part() {
    }

    public Part(String name, double price, int inv) {
        this.name = name;
        this.price = price;
        this.inv = inv;

    }

    public Part(long id, String name, double price, int inv) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inv = inv;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInv() {
        return inv;
    }


    public void setInv(int inv) {
        this.inv = inv;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String toString(){
        return this.name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Part part = (Part) o;

        return id == part.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
    public Part(int invMin, int invMax) {
        this.invMin = invMin;
        this.invMax = invMax;
    }

    public int getInvMin() {
        return invMin;
    }

    public void setInvMin(int invMin) {
        this.invMin = invMin;
    }

    public int getInvMax() {
        return invMax;
    }

    public void setInvMax(int invMax) {
        this.invMax = invMax;
    }

    public static boolean invIsValid(int inv) {
        if (inv >= invMin && inv <= invMax) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean atLowerBounds(int inv) {
        if(inv <= (invMin - 1)){
            return false;
        }
        else { return true; }
    }

    public static boolean atUpperBounds(int inv) {
        if (inv > invMax) {
            return false;
        }
        else { return true; }


    }
}