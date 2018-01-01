package com.example.kamil.project.repository;

import com.example.kamil.project.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Kamil on 30.12.2017.
 */

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findByName(String name);
    Account findByNumber(int number);
}
