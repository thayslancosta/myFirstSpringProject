package com.thayslan.myfirstspringproject.resources;

import com.thayslan.myfirstspringproject.entities.Order;
import com.thayslan.myfirstspringproject.entities.Profile;
import com.thayslan.myfirstspringproject.repositories.OrderRepository;
import com.thayslan.myfirstspringproject.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/orders")
public class OrderResource {


    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
		List<Order> order = orderRepository.findAll();
        return ResponseEntity.ok().body(order);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order>findById(@PathVariable Long id) {
		Order order = orderRepository.findById(id).get();
        return ResponseEntity.ok().body(order);
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order order) {
        Order savedOrder= orderRepository.save(order);
        return ResponseEntity.ok(savedOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> update(@PathVariable Long id, @RequestBody Order order) {
        order.setId(id);
        Order updatedOrder = orderRepository.save(order);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}