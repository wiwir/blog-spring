package com.example.springblog.repository;


import com.example.springblog.domain.BlogCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogCategoryRepository  extends JpaRepository<BlogCategory,Long> {
}
