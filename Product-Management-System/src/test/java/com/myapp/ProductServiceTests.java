package com.myapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import com.myapp.model.Product;
import com.myapp.repository.ProductRepository;
import com.myapp.service.ProductService;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductServiceTests {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() {
        productRepository.deleteAll();
    }

    @AfterEach
    public void tearDown() {
        productRepository.deleteAll();
    }

    @Test
    public void testGetProducts() {
        // Add test data
        Product product1 = new Product();
        product1.setName("Smartphone");
        product1.setCategory("electronics");
        product1.setPrice(299.99);
        product1.setInStock(true);
        product1.setRating(4.5);
        product1.setCreatedAt(new Date());
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("Laptop");
        product2.setCategory("electronics");
        product2.setPrice(899.99);
        product2.setInStock(true);
        product2.setRating(4.7);
        product2.setCreatedAt(new Date());
        productRepository.save(product2);

        List<Product> products = productService.getProducts(
                "electronics",
                100.0,
                1000.0,
                true,
                Sort.by(Sort.Order.asc("price"))
        );

        assertEquals(2, products.size());
        assertEquals("Smartphone", products.get(0).getName());
        assertEquals("Laptop", products.get(1).getName());
    }
}
