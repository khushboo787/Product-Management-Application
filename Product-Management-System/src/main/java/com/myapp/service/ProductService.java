package com.myapp.service;

import com.myapp.model.Product;
import com.myapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    
     
    public Product addProduct(Product product) {
        product.setCreatedAt(new Date());
        return productRepository.save(product);
    }
    
    public List<Product> getProducts(String category, Double minPrice, Double maxPrice, Boolean inStock, Sort sort) {
        if (category != null && minPrice != null && maxPrice != null && inStock != null) {
            return productRepository.findByCategoryAndPriceBetweenAndInStock(category, minPrice, maxPrice, inStock, sort);
        } else if (category != null && minPrice != null && maxPrice != null) {
            return productRepository.findByCategoryAndPriceBetween(category, minPrice, maxPrice, sort);
        } else if (category != null && inStock != null) {
            return productRepository.findByCategoryAndInStock(category, inStock, sort);
        } else if (category != null) {
            return productRepository.findByCategory(category, sort);
        } else if (inStock != null) {
            return productRepository.findByInStock(inStock, sort);
        } else if (minPrice != null && maxPrice != null) {
            return productRepository.findByPriceBetween(minPrice, maxPrice, sort);
        } else {
            return productRepository.findAll(sort);
        }
    }

	 
}