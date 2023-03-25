package com.example.pcmarket.Repository;

import com.example.pcmarket.Model.Basket;
import com.example.pcmarket.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders,Integer> {
    boolean existsAllByBasket(Basket basket);
}
