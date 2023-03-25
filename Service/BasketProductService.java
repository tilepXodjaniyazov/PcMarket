package com.example.pcmarket.Service;

import com.example.pcmarket.Model.BasketProduct;
import com.example.pcmarket.Repository.BasketProductRepository;
import com.example.pcmarket.Result;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketProductService {
   @Autowired
   BasketProductRepository basketProductRepository;
    public Result createBasketProduct(BasketProduct basketProduct) {
        BasketProduct basketProduct1 = new BasketProduct();
        basketProduct1.setBasketId(basketProduct.getBasketId());
        basketProductRepository.save(basketProduct1);
        return new Result("saqlandi",true);
    }

    public BasketProduct getBasketProductById(Integer id) {
        val byId = basketProductRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        }
        return null;
    }

    public Result updateBasketProduct(Integer id, BasketProduct basket) {
        val byId = basketProductRepository.findById(id);
        if (byId.isPresent()) {
            BasketProduct basketProduct = byId.get();
            basketProduct.setBasketId(basket.getBasketId());
            return new Result("ozgardi",true);
        }
        return new Result("topilmadi",false);
    }

    public Result deleteBasketProduct(Integer id) {
        try {
            val b = basketProductRepository.existsById(id);
            if (b) {
                basketProductRepository.deleteById(id);
                return new Result("ochirildi",true);
            }
            return new Result("bunday basket product yoq",false);
        } catch (Exception e) {
            return new Result("Error",false);
        }
    }
}
