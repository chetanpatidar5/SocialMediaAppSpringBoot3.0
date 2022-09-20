package com.spring.core.ckp.controller;

import com.spring.core.ckp.entity.Post;
import com.spring.core.ckp.entity.User;
import com.spring.core.ckp.repository.PostRepository;
import com.spring.core.ckp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserResource {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @PostMapping("/user")
    public ResponseEntity<User> postUser(@RequestBody User user) {
        User saveUser = userRepository.save(user);

        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> getAllUser = new ArrayList<User>();
        userRepository.findAll().forEach(getAllUser::add);

        return new ResponseEntity<>(getAllUser, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUsers(@PathVariable int id) {
        Optional<User> getUser = userRepository.findById(id);

        if (getUser.isPresent()) {
            return new ResponseEntity<>(getUser.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/users/{id}/posts")
    public ResponseEntity<List<Post>> getUsersPosts(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get().getListPosts(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Post> CreatePostUSer(@PathVariable int id, @RequestBody Post post) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            post.setUser(user.get());
            postRepository.save(post);
            return new ResponseEntity<>(post, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}