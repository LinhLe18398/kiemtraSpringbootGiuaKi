package com.example.kiemtragiuaki.service;

import com.example.kiemtragiuaki.model.Category;
import com.example.kiemtragiuaki.model.Product;
import com.example.kiemtragiuaki.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private IProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    public List<Product> searchByPriceRange(double minPrice, double maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public List<Product> sortByAmount() {
        return productRepository.findAllByOrderByAmountAsc();
    }

    public List<Product> getTop3ExpensiveProducts() {
        return productRepository.findTop3ByOrderByPriceDesc();
    }

    public List<Product> getProductsByCategory(Category category) {
        return productRepository.findByCategory(category);
    }
}
