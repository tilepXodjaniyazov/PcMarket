package com.example.pcmarket.Controller;

import com.example.pcmarket.Dto.OrdersDto;
import com.example.pcmarket.Model.Orders;
import com.example.pcmarket.Result;
import com.example.pcmarket.Service.OrdersServic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    OrdersServic ordersServic;

    @GetMapping
    public ResponseEntity<List<Orders>> getOrders() {
        List<Orders> ordersList = ordersServic.getOrders();
        return ResponseEntity.ok(ordersList);
    }

    @PostMapping
    public ResponseEntity<?> postOrders(@RequestBody OrdersDto ordersDto) {
        Result result = ordersServic.postOrders(ordersDto);
        return ResponseEntity.status(result.getSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> putOrders(@PathVariable Integer id,@RequestBody OrdersDto ordersDto) {
        Result result = ordersServic.putOrders(id,ordersDto);
        return ResponseEntity.status(result.getSuccess()?HttpStatus.CREATED:HttpStatus.CONFLICT).body(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrders(@PathVariable Integer id) {
        Result result = ordersServic.deleteOrders(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(result);
    }
}
