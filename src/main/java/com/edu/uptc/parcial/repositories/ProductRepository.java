package com.edu.uptc.parcial.repositories;

import com.edu.uptc.parcial.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
