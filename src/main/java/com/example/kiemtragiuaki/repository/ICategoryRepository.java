package com.example.kiemtragiuaki.repository;

import com.example.kiemtragiuaki.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
