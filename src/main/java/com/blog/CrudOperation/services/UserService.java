package com.blog.CrudOperation.services;

import com.blog.CrudOperation.payloads.UserDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService extends UserDetailsService {

    UserDto createUser(UserDto userDto);

    UserDto updateUser(UserDto userDto, Integer userId);

    UserDto getUserbyId(Integer userId);

    List<UserDto> getAllUsers();

    void deleteUser(Integer userId);

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;



}
