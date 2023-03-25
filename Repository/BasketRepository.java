package com.example.pcmarket.Repository;

import com.example.pcmarket.Model.Basket;
import com.example.pcmarket.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket,Integer> {
    boolean existsByUserAndActive(User user, boolean active);

}
