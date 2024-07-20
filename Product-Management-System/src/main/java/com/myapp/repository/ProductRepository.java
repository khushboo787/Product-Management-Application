package com.myapp.repository;

import com.myapp.model.Product;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	    List<Product> findByCategoryAndPriceBetweenAndInStock(String category, Double minPrice, Double maxPrice, Boolean inStock, Sort sort);

	    List<Product> findByCategoryAndPriceBetween(String category, Double minPrice, Double maxPrice, Sort sort);

	    List<Product> findByCategory(String category, Sort sort);

	    List<Product> findByCategoryAndInStock(String category, Boolean inStock, Sort sort);

	    List<Product> findByInStock(Boolean inStock, Sort sort);

	    List<Product> findByPriceBetween(Double minPrice, Double maxPrice, Sort sort);
    
}