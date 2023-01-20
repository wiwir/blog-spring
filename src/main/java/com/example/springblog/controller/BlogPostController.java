package com.example.springblog.controller;

import com.example.springblog.domain.BlogPost;
import com.example.springblog.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/post")
public class BlogPostController {


    @Autowired
    private BlogPostRepository blogPostRepository;

    @GetMapping()
    public ResponseEntity<List<BlogPost>> getAllBlogPosts() {

        List<BlogPost> postList = blogPostRepository.findAll();

        return new ResponseEntity<>(postList, HttpStatus.OK);
    }


    @GetMapping("{id}")
    public ResponseEntity<BlogPost> getBlogPostById(@PathVariable long id) {

        if (blogPostRepository.existsById(id)) {
            BlogPost returnPost = blogPostRepository.findById(id).get();
            return new ResponseEntity<>(returnPost, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }


    @PostMapping
    public ResponseEntity<BlogPost> createBlogPost(@RequestBody BlogPost blogPost) {
        blogPostRepository.save(blogPost);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}