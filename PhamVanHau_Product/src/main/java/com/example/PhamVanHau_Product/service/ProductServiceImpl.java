package com.example.PhamVanHau_Product.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PhamVanHau_Product.entity.Product;
import com.example.PhamVanHau_Product.reponsitory.ProductRepository;

import jakarta.transaction.Transactional;
@Transactional
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository repository;
	@Override
	public List<Product> getAllProduct() {
		return repository.findAll();
	}

	@Override
	public Product add(Product product) {
		return repository.save(product);
	}

	@Override
	public String delete(int id) {
		repository.deleteById(id);
		return "Successly";
	}

	@Override
	public Product update(int id, Product productNew) {
		Product productOld = repository.findById(id).get();
		if(Objects.nonNull(productNew.getName()) && !"".equalsIgnoreCase(productNew.getName())) {
			return productNew;
		}
		return repository.save(productOld);
	}

	@Override
	public Product getProductById(int id) {
		return repository.findById(id).get();
	}

}
