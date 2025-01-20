package com.blog.CrudOperation.services;

import com.blog.CrudOperation.entities.Post;
import com.blog.CrudOperation.payloads.PostDto;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface PostService {

    //Create post

    PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);

    //update post
    PostDto updatePost(PostDto postDto, Integer postId);

    //delete post
    void deletePost(Integer postId);

    //get all post

    List<PostDto> getAllPost();

    //get post by id
    PostDto getPostById(Integer postId);

    //get post by category
    List<PostDto> getPostsByCategory(Integer categoryid);

    //get posts by user
    List<PostDto> getPostsByUser(Integer userId);
}
