package com.thayslan.myfirstspringproject.resources;

import com.thayslan.myfirstspringproject.entities.Order;
import com.thayslan.myfirstspringproject.entities.Profile;
import com.thayslan.myfirstspringproject.repositories.OrderRepository;
import com.thayslan.myfirstspringproject.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}