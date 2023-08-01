package com.ars.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ars.exceptions.ProductNotFoundException;
import com.ars.model.Product;

@RestController
public class ProductController {

	private static Map<Integer, Product> productMap = new HashMap<>();

	static {
		Product soap = new Product();
		soap.setId(1);
		soap.setName("Lux");
		productMap.put(soap.getId(), soap);

		Product mobilePhone = new Product();
		mobilePhone.setId(2);
		mobilePhone.setName("Samsung");
		productMap.put(mobilePhone.getId(), mobilePhone);
	}
	
	@RequestMapping("/all")
	public Map<Integer, Product> getAllProducts(){
	return productMap;
}
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
		if (!productMap.containsKey(id))
			throw new ProductNotFoundException();
		else {
			productMap.remove(id);
			product.setId(id);
			productMap.put(id, product);
			return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
		}
	}

}