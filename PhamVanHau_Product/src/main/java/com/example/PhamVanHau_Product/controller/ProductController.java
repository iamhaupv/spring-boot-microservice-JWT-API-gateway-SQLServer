package com.example.PhamVanHau_Product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.PhamVanHau_Product.entity.Product;
import com.example.PhamVanHau_Product.entity.User;
import com.example.PhamVanHau_Product.reponsitory.OrderReponsitory;
import com.example.PhamVanHau_Product.reponsitory.ProductRepository;
import com.example.PhamVanHau_Product.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
	@Autowired
	private ProductService service;
	@Autowired
	private ProductRepository repository;
	@Autowired
	private RestTemplate restTemplate;
	@GetMapping("/products")
	public List<Product> getAllProduct(){
		return service.getAllProduct();
	}
	@PostMapping("/product")
	public Product add(@Valid @RequestBody Product product) {
		return service.add(product);
	}
	@DeleteMapping("/product/{id}")
	public String delete(@PathVariable("id")int id) {
		service.delete(id);
		return "Successly";
	}
	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable("id") int id) {
		return service.getProductById(id);
	}
	@PutMapping("/product/{id}")
	public Product update(@Valid @PathVariable("id")int id, @RequestBody Product product) {
		return service.update(id, product);
	}
	@GetMapping("/orderproduct/{id}/{productId}")
	public ResponseEntity<OrderReponsitory> orderProductByUser(@PathVariable Integer id,
			@PathVariable Integer productId) {
		OrderReponsitory orderReponsitory = new OrderReponsitory();
		String url = "http://localhost:8802/api/v2/user/" + id;
		ResponseEntity<User> reponse = restTemplate.getForEntity(url, User.class);
		Optional<Product> optional = repository.findById(productId);
		Product product = null;
		if (optional.isPresent()) {
			product = optional.get();
		} else {
			new RuntimeException("Khong co user theo id này");
		}
		User user = reponse.getBody();
		orderReponsitory.setUser(user);
		orderReponsitory.setProduct(product);
		return new ResponseEntity<OrderReponsitory>(orderReponsitory, HttpStatus.OK);
	}
}
