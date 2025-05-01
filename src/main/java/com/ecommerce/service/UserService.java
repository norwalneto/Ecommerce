package com.ecommerce.service;

import com.ecommerce.domain.dto.UserDTO;

public interface UserService {
    UserDTO register (UserDTO userDTO);
    UserDTO login (UserDTO userDTO);
}
