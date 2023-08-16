package com.example.test.service.impl;

import com.example.test.dto.UserItemsDTO;
import com.example.test.entity.Item;
import com.example.test.entity.User;
import com.example.test.repository.ItemRepository;
import com.example.test.repository.UserRepository;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ItemRepository itemRepository;


    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public void userItems(UserItemsDTO userItemsDTO) {
        Optional.ofNullable(userItemsDTO.getUserId())
                .flatMap(userRepository::findById)
                .ifPresent(user -> {
                    List<Item> items = itemRepository.findByIdIn(userItemsDTO.getItemIds());
                    user.getItemList().addAll(items);
                    userRepository.save(user);
                });
    }

    @Override
    public void userChooseItems(UserItemsDTO userItemsDTO) {
        if (!ObjectUtils.isEmpty(userItemsDTO.getUserId())) {
            User user = userRepository.findById(userItemsDTO.getUserId()).orElse(null);
            if (!ObjectUtils.isEmpty(user)) {
                List<Item> items = itemRepository.findByIdIn(userItemsDTO.getItemIds());
                user.getItemList().addAll(items);
                userRepository.save(user);
            }
        }
    }
}
