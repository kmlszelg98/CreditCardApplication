package com.example.kamil.project.service;

import com.example.kamil.project.entity.BankModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Kamil on 30.12.2017.
 */

@Service
public class LoginLogoutService {

    @Autowired
    UserService userService;

    public boolean addBankModel(BankModel model){
        if(!userService.isUserLogged()){
            userService.setBankModel(model);
            return true;
        }
        return false;
    }

    public void clear(){
        userService.clear();
    }

}
