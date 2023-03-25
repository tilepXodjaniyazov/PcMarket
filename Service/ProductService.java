package com.example.pcmarket.Service;

import com.example.pcmarket.Dto.ProductDto;
import com.example.pcmarket.Model.Product;
import com.example.pcmarket.Repository.ProductRepository;
import com.example.pcmarket.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getProduct() {
        List<Product> all = productRepository.findAll();
        return all;
    }

    public Result postProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setCategory(productDto.getCategory());
        product.setPrice(productDto.getPrice());
        productRepository.save(product);
        return new Result("saqlandi", true);
    }

    public Result putProduct(Integer id, ProductDto productDto) {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isPresent()) {
            Product product = byId.get();
            product.setName(productDto.getName());
            product.setCategory(productDto.getCategory());
            product.setPrice(productDto.getPrice());
            productRepository.save(product);
            return new Result("ozgardi",true);
        }
        return new Result("topilmadi",true);
    }

    public Result deleteProduct(Integer id) {
        try {
            if (productRepository.existsById(id)) {
                productRepository.deleteById(id);
                return new Result("ochirildi",true);
            }
        }catch (Exception e) {
            return new Result("ERROR",false);
        }
        return new Result("topilmadi",false);
    }
}
