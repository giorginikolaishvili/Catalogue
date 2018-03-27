package com.example.apphandling.controller.repository;

import com.example.apphandling.controller.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Integer> {
    public UserModel findByusername(String username);
}
