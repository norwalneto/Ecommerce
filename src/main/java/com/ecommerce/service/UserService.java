package com.ecommerce.service;

import java.util.List;
import java.util.UUID;

import com.ecommerce.domain.dto.UserDTO;
import com.ecommerce.domain.model.User;

public interface UserService {
    User listarPorId (UUID id);
    List<User> listarTodos (User user);
    User register (User user);
    //UserDTO login (UserDTO userDTO);
}
