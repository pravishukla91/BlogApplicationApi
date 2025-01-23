package com.blog.CrudOperation.services.impl;

import com.blog.CrudOperation.entities.User;
import com.blog.CrudOperation.exceptions.ResourceNotFoundExceptions;
import com.blog.CrudOperation.payloads.UserDto;
import com.blog.CrudOperation.repositories.UserRepo;
import com.blog.CrudOperation.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtotoUser(userDto);
        User savedUser = this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        // Find the user by ID or throw an exception if not found
        User user = this.userRepo.findById(userId)
                .orElseThrow(() ->new ResourceNotFoundExceptions("User", "id", userId));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());


        User updatedUser = this.userRepo.save(user);
        return this.userToDto(updatedUser);
    }

    @Override
    public UserDto getUserbyId(Integer userId) {
        // Find the user by ID or throw an exception if not found
        User user = this.userRepo.findById(userId)
                .orElseThrow(() ->new ResourceNotFoundExceptions("User", "id", userId));

        // Convert the user entity to DTO and return it
        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        // Retrieve all users from the repository
        List<User> users = this.userRepo.findAll();

        // Convert the list of users to a list of DTOs and return it
        return users.stream()
                .map(this::userToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Integer userId) {
        // Find the user by ID or throw an exception if not found
        User user = this.userRepo.findById(userId)
                .orElseThrow(() ->new ResourceNotFoundExceptions("User", "id", userId));

        // Delete the user
        this.userRepo.delete(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found with email: "+ username);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),new ArrayList<>());
    }

    public User dtotoUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
        return user;
    }

    public UserDto userToDto(User user) {
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }
}
