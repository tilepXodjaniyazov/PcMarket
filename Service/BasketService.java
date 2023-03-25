package com.example.pcmarket.Service;

import com.example.pcmarket.Model.Basket;
import com.example.pcmarket.Repository.BasketRepository;
import com.example.pcmarket.Result;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketService {
    @Autowired
    BasketRepository basketRepository;

    public Result createBasket(Basket basket) {
        if (basketRepository.existsByUserAndActive(basket.getUser(), basket.isActive())) {
            return new Result("Bunday user bor", false);
        }
        Basket basket1 = new Basket();
        basket1.setUser(basket.getUser());
        basket1.setActive(basket.isActive());
        basketRepository.save(basket1);
        return new Result("saqlandi", true);
    }

    public Basket getBasketById(Integer id) {
        val byId = basketRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        }
        return null;
    }

    public Basket updateBasket(Integer id, Basket basket) {
        val byId = basketRepository.findById(id);
        if (byId.isPresent()) {
            Basket basket1 = byId.get();
            basket1.setUser(basket.getUser());
            basket1.setActive(basket.isActive());
            basketRepository.save(basket1);
        }
        return null;
    }

    public Result deleteBasket(Integer id) {
        try {
            basketRepository.deleteById(id);
            return new Result("ochirildi",true);
        } catch (Exception e) {
            return new Result("Error",false);
        }
    }
}
