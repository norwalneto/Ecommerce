package com.ecommerce.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
