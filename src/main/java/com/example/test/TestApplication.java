package com.example.test;

import com.example.test.entity.Item;
import com.example.test.entity.User;
import com.example.test.repository.ItemRepository;
import com.example.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication{

	public static void main(String[] args) {SpringApplication.run(TestApplication.class, args);}

}
