package com.ecommerce.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ecommerce.domain.dto.UserDTO;
import com.ecommerce.domain.model.User;
import com.ecommerce.domain.repository.UserRepository;
import com.ecommerce.service.UserService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register (User user){
        return userRepository.save(user);
    }

    //@Override
    //public UserDTO login (UserDTO userDTO){
        //return ;
    //}

    @Override
    public List<User> listarTodos() {
        return userRepository.findAll();
    }

    @Override
    public User listarPorId(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com id: " + id));
    }

}
