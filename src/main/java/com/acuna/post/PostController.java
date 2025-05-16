package com.acuna.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
@CrossOrigin(origins = {"http://localhost:5173", "https://final-ui-liart.vercel.app/"}) // Add Vercel frontend URL here
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @PostMapping("/bulk")
    public List<Post> createPostsBulk(@RequestBody List<Post> posts) {
        return postRepository.saveAll(posts);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.setAuthor(updatedPost.getAuthor());
            post.setContent(updatedPost.getContent());
            post.setMediaUrl(updatedPost.getMediaUrl());
            // Optionally update createdAt or leave as is
            return postRepository.save(post);
        } else {
            throw new RuntimeException("Post not found with id " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
    }
}
