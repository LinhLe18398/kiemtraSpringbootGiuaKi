package com.example.kiemtragiuaki.repository;

import com.example.kiemtragiuaki.model.Category;
import com.example.kiemtragiuaki.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {
    @Modifying
    @Query(value = "select * from product where name like %?% ", nativeQuery = true)
    List<Product> findAllByName(String keyword);

    @Modifying
    @Query(value = "select * from product order by price desc limit 3 ", nativeQuery = true)
    List<Product> findTop3();

    @Modifying
    @Query(value = "select * from customers order by price desc ", nativeQuery = true)
    List<Product> findAllByADESC();

    List<Product> findByPriceBetween(double minPrice, double maxPrice);
    List<Product> findAllByOrderByAmountAsc();
    List<Product> findTop3ByOrderByPriceDesc();
    List<Product> findByCategory(Category category);
}
