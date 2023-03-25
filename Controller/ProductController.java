package com.example.pcmarket.Controller;

import com.example.pcmarket.Dto.ProductDto;
import com.example.pcmarket.Model.Product;
import com.example.pcmarket.Result;
import com.example.pcmarket.Service.BasketProductService;
import com.example.pcmarket.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<?> getProduct() {
        List<Product> productList = productService.getProduct();
        return ResponseEntity.ok(productList);
    }

    @PostMapping
    public ResponseEntity<Result> postProduct(@RequestBody ProductDto productDto) {
        Result result = productService.postProduct(productDto);
        return ResponseEntity.status(result.getSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putProduct(@PathVariable Integer id, @RequestBody ProductDto productDto) {
        Result result = productService.putProduct(id, productDto);
        return ResponseEntity.status(result.getSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
        Result result = productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(result);
    }
}
