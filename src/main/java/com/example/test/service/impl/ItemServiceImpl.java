package com.example.test.service.impl;

import com.example.test.entity.Item;
import com.example.test.repository.ItemRepository;
import com.example.test.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;


    @Override
    public List<Item> listAll() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> getItemById(Integer id) {
        return itemRepository.findById(id);
    }

    @Override
    public void save(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void delete(Integer id) {
        itemRepository.deleteById(id);
    }
}
