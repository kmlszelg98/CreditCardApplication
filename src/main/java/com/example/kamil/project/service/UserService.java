package com.example.kamil.project.service;

import com.example.kamil.project.entity.BankModel;
import com.example.kamil.project.entity.Card;
import com.example.kamil.project.model.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Kamil on 30.12.2017.
 */

@Service
public class UserService {

    @Autowired
    LoggedUser user;

    public LoggedUser getUser(){
        return user;
    }

    public boolean isUserLogged(){
        return user.isLogged();
    }

    public void setBankModel(BankModel model){
        user.setModel(model);
    }

    public void clear(){
        user.setModel(null);
    }

    public String getType(){
        if(user.getModel() instanceof Card) return "Card";
        return "Account";
    }
}
