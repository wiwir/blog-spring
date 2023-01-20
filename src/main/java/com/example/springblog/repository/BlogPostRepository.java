package com.example.springblog.repository;

import com.example.springblog.domain.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

}
