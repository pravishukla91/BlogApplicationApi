package com.blog.CrudOperation.services;

import com.blog.CrudOperation.payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user, Integer userId);

    UserDto getUserbyId(Integer userId);

    List<UserDto> getAllUsers();

    void deleteUser(Integer userId);



}
