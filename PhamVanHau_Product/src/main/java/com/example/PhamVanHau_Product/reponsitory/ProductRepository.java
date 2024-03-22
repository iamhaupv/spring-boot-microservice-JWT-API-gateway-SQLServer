package com.example.PhamVanHau_Product.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PhamVanHau_Product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
