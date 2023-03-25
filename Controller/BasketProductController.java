package com.example.pcmarket.Controller;

import com.example.pcmarket.Model.BasketProduct;
import com.example.pcmarket.Result;
import com.example.pcmarket.Service.BasketProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("basketProduct")
public class BasketProductController {
    @Autowired
    BasketProductService basketProductService;

    @PostMapping("/")
    public ResponseEntity<?> createBasket(@RequestBody BasketProduct basketProduct) {
        Result result =  basketProductService.createBasketProduct(basketProduct);
        return ResponseEntity.status(result.getSuccess()? HttpStatus.CREATED:HttpStatus.CONFLICT).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BasketProduct> getBasketById(@PathVariable Integer id) {
        BasketProduct basket = basketProductService.getBasketProductById(id);
        return ResponseEntity.status(basket!=null?HttpStatus.OK:HttpStatus.CONFLICT).body(basket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Result> updateBasket(@PathVariable Integer id, @RequestBody BasketProduct basket) {
        Result result = basketProductService.updateBasketProduct(id, basket);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBasket(@PathVariable Integer id) {
        Result result = basketProductService.deleteBasketProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
