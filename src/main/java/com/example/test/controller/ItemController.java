package com.example.test.controller;

import com.example.test.entity.Item;
import com.example.test.entity.User;
import com.example.test.service.impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemServiceImpl itemService;

    @GetMapping("/items")
    public ResponseEntity<List<Item>> listAll(){
        try {
            return new ResponseEntity<>(itemService.listAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/item")
    public ResponseEntity<Item> create(@RequestBody Item item) {
        try {
            itemService.save(item);
            return new ResponseEntity<>(item, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<Item> findItemById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(itemService.getItemById(id).orElse(null), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<Integer> delete(@PathVariable Integer id){
        try {
            itemService.delete(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
