package com.blog.CrudOperation.repositories;

import com.blog.CrudOperation.entities.Category;
import com.blog.CrudOperation.entities.Post;
import com.blog.CrudOperation.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    //getting all post by a single user
    List<Post> findByUser(User user);

    //finding all post by category
    List<Post> findByCategory(Category category);
}
