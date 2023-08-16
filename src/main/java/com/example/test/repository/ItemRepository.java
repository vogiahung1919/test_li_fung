package com.example.test.repository;

import com.example.test.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Query(nativeQuery = true, value = "select * from item where id in :ids")
    List<Item> findByIdIn(@Param("ids") List<Integer> ids);
}
