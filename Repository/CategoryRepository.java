package com.example.pcmarket.Repository;

import com.example.pcmarket.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
