package com.example.pcmarket.Controller;

import com.example.pcmarket.Model.Basket;
import com.example.pcmarket.Result;
import com.example.pcmarket.Service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/basket")
public class BasketController {

    @Autowired
    BasketService basketService;

    @PostMapping("/")
    public ResponseEntity<?> createBasket(@RequestBody Basket basket) {
        Result result =  basketService.createBasket(basket);
        return ResponseEntity.status(result.getSuccess()?HttpStatus.CREATED:HttpStatus.CONFLICT).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Basket> getBasketById(@PathVariable Integer id) {
        Basket basket = basketService.getBasketById(id);
        return ResponseEntity.status(basket!=null?HttpStatus.OK:HttpStatus.CONFLICT).body(basket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Basket> updateBasket(@PathVariable Integer id, @RequestBody Basket basket) {
        Basket updatedBasket = basketService.updateBasket(id, basket);
        return new ResponseEntity<>(updatedBasket, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBasket(@PathVariable Integer id) {
        Result result = basketService.deleteBasket(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
