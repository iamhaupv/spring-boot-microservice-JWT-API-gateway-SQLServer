package com.example.PhamVanHau_User.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PhamVanHau_User.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
