package com.example.test.service;

import com.example.test.entity.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    List<Item> listAll();

    Optional<Item> getItemById(Integer id);

    void save(Item item);

    void delete(Integer id);
}
