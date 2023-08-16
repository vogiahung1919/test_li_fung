package com.example.test.service;

import com.example.test.dto.UserItemsDTO;
import com.example.test.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UserService {

    List<User> listAll();

    Optional<User> getUserById(Integer id);

    void save(User user);

    void delete(Integer id);

    void userItems(UserItemsDTO userItemsDTO);

    void userChooseItems(UserItemsDTO userItemsDTO);
}
