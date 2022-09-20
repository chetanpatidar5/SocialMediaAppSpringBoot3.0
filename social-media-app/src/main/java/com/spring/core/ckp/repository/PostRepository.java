package com.spring.core.ckp.repository;

import com.spring.core.ckp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
