package com.example.pcmarket.Service;

import com.example.pcmarket.Dto.OrdersDto;
import com.example.pcmarket.Model.Basket;
import com.example.pcmarket.Model.Orders;
import com.example.pcmarket.Repository.BasketRepository;
import com.example.pcmarket.Repository.OrdersRepository;
import com.example.pcmarket.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersServic {
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    BasketRepository basketRepository;

    public List<Orders> getOrders() {
        List<Orders> all = ordersRepository.findAll();
        return all;
    }

    public Result postOrders(OrdersDto ordersDto) {
        Basket byId = basketRepository.findById(ordersDto.getBasketId()).get();
        if (ordersRepository.existsAllByBasket(byId)) {
            return new Result("Bunady basket bor", false);
        }
        Orders orders = new Orders();
        orders.setBasket(byId);
        orders.setCanceled(ordersDto.isCanceled());
        orders.setClaimed(orders.isClaimed());
        ordersRepository.save(orders);
        return new Result("saqlandi", true);
    }

    public Result putOrders(Integer id, OrdersDto ordersDto) {
        Optional<Orders> byId = ordersRepository.findById(id);
        if (byId.isPresent()) {
            Basket basket = basketRepository.findById(ordersDto.getBasketId()).get();
            Orders orders1 = byId.get();
            orders1.setBasket(basket);
            orders1.setCanceled(ordersDto.isCanceled());
            orders1.setClaimed(ordersDto.isClaimed());
            ordersRepository.save(orders1);
            return new Result("saqlandi", true);
        }
        return new Result("topilmadi", false);
    }

    public Result deleteOrders(Integer id) {
        try {
            if (!ordersRepository.existsById(id)) return new Result("topilmadi", false);
            ordersRepository.deleteById(id);
            return new Result("ochirildi", false);
        } catch (Exception e) {
            return new Result("ERROR", false);
        }
    }
}
