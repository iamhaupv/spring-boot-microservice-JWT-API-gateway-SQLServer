package com.example.PhamVanHau_Product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.PhamVanHau_Product.entity.Product;

@Service
public interface ProductService {
	public List<Product> getAllProduct();
	public Product add(Product product);
	public String delete(int id);
	public Product update(int id, Product product);
	public Product getProductById(int id);
}
