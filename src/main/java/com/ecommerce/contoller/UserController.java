package com.ecommerce.contoller;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.domain.model.User;
import com.ecommerce.service.UserService;

@RestController
@RequestMapping("/v1/users")
public class UserController {
  
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> listarTodos(){
        List<User> lista = userService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> listarPorId(@PathVariable UUID id){
        User user = userService.listarPorId(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> register(@RequestBody User user){
        User users = userService.register(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(users);
    }
}
