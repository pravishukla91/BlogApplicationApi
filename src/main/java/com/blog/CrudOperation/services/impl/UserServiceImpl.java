package com.blog.CrudOperation.services.impl;

import com.blog.CrudOperation.entities.User;
import com.blog.CrudOperation.payloads.UserDto;
import com.blog.CrudOperation.services.UserService;

import java.util.List;

public interface UserServiceImpl extends UserService {

    @Override
    public UserDto createUser(UserDto user);

    @Override
    public UserDto updateUser(UserDto user, Integer userId);

    @Override
    public UserDto getUserbyId(Integer userId);

    @Override
    public List<UserDto> getAllUsers();

    @Override
    void deleteUser(Integer userId);


}
