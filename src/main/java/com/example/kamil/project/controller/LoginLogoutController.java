package com.example.kamil.project.controller;

import com.example.kamil.project.service.DataSourceService;
import com.example.kamil.project.entity.Account;
import com.example.kamil.project.entity.BankModel;
import com.example.kamil.project.entity.Card;
import com.example.kamil.project.entity.request.LoginRequest;
import com.example.kamil.project.entity.response.Response;
import com.example.kamil.project.repository.AccountRepository;
import com.example.kamil.project.service.LoginLogoutService;
import com.example.kamil.project.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Kamil on 28.12.2017.
 */

@RestController
@Scope
public class LoginLogoutController {

    @Autowired
    LoginLogoutService service;

    @Autowired
    DataSourceService dataSourceService;

    private CardRepository repository;
    private AccountRepository accountRepository;

    @Autowired
    public LoginLogoutController(CardRepository repository,AccountRepository accountRepository) {
        this.repository = repository;
        this.accountRepository = accountRepository;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Response login(@RequestBody LoginRequest request){
        if(request.isCard()){
            Card card = repository.findByName(request.getName());
            if(card==null) card = dataSourceService.findCardByName(request.getName());
            return checkFoundBankModel(card, request.getPassword());
        } else {
            Account account = accountRepository.findByName(request.getName());
            if(account==null) account = dataSourceService.findAccountByName(request.getName());
            return checkFoundBankModel(account, request.getPassword());
        }
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public Response logout(){
        service.clear();
        return new Response(200,"Logout success");
    }

    private Response checkFoundBankModel(BankModel model, String password){
        if(model!=null){
            if(model.getPassword().equals(password)){
                if(service.addBankModel(model)) return new Response(200, "Login Success");
                return new Response(200, "You are already logged in");
            }
        }
        return new Response(401, "Login failed, try another name or password");
    }
}
