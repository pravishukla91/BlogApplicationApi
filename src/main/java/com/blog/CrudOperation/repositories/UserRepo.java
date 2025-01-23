package com.blog.CrudOperation.repositories;

import com.blog.CrudOperation.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {

    User findByEmail(String email);

}
