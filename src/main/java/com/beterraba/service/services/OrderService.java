package com.beterraba.service.services;

import com.beterraba.service.entities.Order;
import com.beterraba.service.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> optionalOrder = repository.findById(id);
        return optionalOrder.get();
    }
}
