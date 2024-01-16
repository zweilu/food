package com.example.wei.springbootfood.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.example.wei.springbootfood.model.dto.ProductRequest;
import com.example.wei.springbootfood.model.entity.Product;
import com.example.wei.springbootfood.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> productList = productService.getProducts();

		return ResponseEntity.status(HttpStatus.OK).body(productList);
	}

	@GetMapping("/products/{productsId}")
	public ResponseEntity<Product> getProduct(@PathVariable Integer productsId) {
		Product product = productService.getProductById(productsId);

		if (product != null) {
			return ResponseEntity.status(HttpStatus.OK).body(product);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping("/products")
	public ResponseEntity<?> createProduct(@ModelAttribute ProductRequest productRequest,
			@RequestParam("productImage") MultipartFile productImage) {

		try {
			String filename = productImage.getOriginalFilename();
			
			String dir = "C:/food/";
			File dirFile = new File(dir);
			if(!dirFile.exists())
				dirFile.mkdirs();
			
			String path = "C:/food/"+ filename;
			File newFile = new File(path);
			productImage.transferTo(newFile);

			Product product = new Product();
			product.setProductName(productRequest.getProductName());
			product.setPrice(productRequest.getProductPrice());
			product.setPic(filename);

			productService.createProduct(product);

			// 返回 JSON 格式
			Map<String, Object> response = new HashMap<>();
			response.put("message", "Product successfully added");
			return ResponseEntity.ok(response);
		} catch (IOException e) {
			e.printStackTrace();
			Map<String, Object> response = new HashMap<>();
			response.put("error", "Error saving the file");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

	@PutMapping("/products/{productId}")
	public ResponseEntity<?> updateProduct(@PathVariable Integer productId,
			@ModelAttribute ProductRequest productRequest, @RequestParam("productImage") MultipartFile productImage) {

		try {
			String filename = productImage.getOriginalFilename();
			String path = "C:/Users/User/Desktop/MyProject/food/springboot-food/src/main/resources/static/images/"
					+ filename;
			File newFile = new File(path);
			productImage.transferTo(newFile);

			Product product = productService.getProductById(productId);
			if (product == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
			}

			product.setProductName(productRequest.getProductName());
			product.setPrice(productRequest.getProductPrice());
			product.setPic(filename);

			productService.updateProduct(productId, product);

			// 返回更新后的商品訊息

			return ResponseEntity.ok(product);
		} catch (IOException e) {
			// 错误处理
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving the file");
		}

	}

	@DeleteMapping("products/{productId}")
	public ResponseEntity<Product> deleteProduct(@PathVariable Integer productId) {
		productService.deleteProductById(productId);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}