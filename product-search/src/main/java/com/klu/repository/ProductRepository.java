package com.klu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.klu.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Derived query
    List<Product> findByCategory(String category);

    List<Product> findByPriceBetween(double min, double max);

    // JPQL queries
    @Query("SELECT p FROM Product p ORDER BY p.price")
    List<Product> sortByPrice();

    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> findExpensive(double price);

    @Query("SELECT p FROM Product p WHERE p.category = :category")
    List<Product> fetchByCategory(String category);
}