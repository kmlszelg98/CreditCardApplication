package com.example.kamil.project.service;

import com.example.kamil.project.reservedDatabase.DataSourceImpl;
import com.example.kamil.project.entity.Account;
import com.example.kamil.project.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Kamil on 01.01.2018.
 */

@Service
public class DataSourceService {

    @Autowired
    DataSourceImpl dataSource;

    @Transactional
    public Account findAccountByName(String name){
        return dataSource.findAccountByName(name);
    }

    @Transactional
    public Account findAccountByNumber(int number){
        return dataSource.findAccountByNumber(number);
    }

    @Transactional
    public Card findCardByName(String name){
        return dataSource.findCardByName(name);
    }

    @Transactional
    public Card findCardByNumber(int number){
        return dataSource.findCardByNumber(number);
    }

    @Transactional
    public void save(Account account){
        dataSource.save(account);
    }

    @Transactional
    public void save(Card card){
        dataSource.save(card);
    }


}
