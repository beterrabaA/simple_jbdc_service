package com.beterraba.service.services;

import com.beterraba.service.entities.User;
import com.beterraba.service.exceptions.ResourceNotFoundException;
import com.beterraba.service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> optionalUser = repository.findById(id);
        return optionalUser.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public User update(Long id,User data) {
        User entity = repository.getReferenceById(id);
        updateData(entity,data);
        return  repository.save(entity);
    }

    private void updateData(User entity, User data) {
        entity.setName(data.getName());
        entity.setEmail(data.getEmail());
        entity.setPhone(data.getPhone());
    }
}
