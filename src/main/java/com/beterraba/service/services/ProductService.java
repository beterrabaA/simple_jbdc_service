package com.beterraba.service.services;

import com.beterraba.service.entities.Product;
import com.beterraba.service.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> optionalProduct = repository.findById(id);
        return optionalProduct.get();
    }
}
