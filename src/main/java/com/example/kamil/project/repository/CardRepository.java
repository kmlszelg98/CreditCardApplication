package com.example.kamil.project.repository;

import com.example.kamil.project.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by Kamil on 28.12.2017.
 */

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

    Card findByName(String name);
    Card findByNumber(int number);
}
