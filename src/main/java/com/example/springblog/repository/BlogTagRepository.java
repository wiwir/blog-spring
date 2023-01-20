package com.example.springblog.repository;

import com.example.springblog.domain.BlogTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogTagRepository extends JpaRepository<BlogTag, Long> {
}
