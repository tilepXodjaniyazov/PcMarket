package com.example.pcmarket.Repository;

import com.example.pcmarket.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
