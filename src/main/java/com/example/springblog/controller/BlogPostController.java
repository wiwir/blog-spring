package com.example.springblog.controller;

import com.example.springblog.domain.BlogPost;
import com.example.springblog.repository.BlogPostRepository;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post/v1")
@CrossOrigin(origins = "*")

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


    @PostMapping(value = "created_post")
    public ResponseEntity<BlogPost> createBlogPost(@RequestBody BlogPost blogPost) {
        BlogPost rsp = blogPostRepository.save(blogPost);
        return new ResponseEntity<>(rsp, HttpStatus.CREATED);
    }

    @PutMapping(value = "updated_post")
    public ResponseEntity<Boolean> updatedBlogPost(@RequestBody BlogPost blogPost) {
        if (blogPostRepository.existsById(blogPost.getId())) {
            BlogPost post;
            post = blogPostRepository.findById(blogPost.getId()).get();

            post.setText(blogPost.getText());
            post.setUpdated(blogPost.getUpdated());
            post.setTitle(blogPost.getTitle());
            blogPostRepository.save(post);

            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
        }

        return new ResponseEntity<>(Boolean.FALSE, HttpStatus.OK);
    }

    @DeleteMapping(value = "deteled_post/{id}")
    public ResponseEntity<Boolean> deletedBlogPost(@PathVariable long id) {
        if (blogPostRepository.existsById(id)) {
            BlogPost post;
            post = blogPostRepository.findById(id).get();
            blogPostRepository.delete(post);
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
        }

        return new ResponseEntity<>(Boolean.FALSE, HttpStatus.OK);
    }

}