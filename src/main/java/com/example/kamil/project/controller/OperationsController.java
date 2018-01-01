package com.example.kamil.project.controller;

import com.example.kamil.project.entity.BankModel;
import com.example.kamil.project.entity.request.PayRequest;
import com.example.kamil.project.entity.response.Response;
import com.example.kamil.project.service.OperationsService;
import com.example.kamil.project.service.StrategyService;
import com.example.kamil.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Kamil on 30.12.2017.
 */

@RestController
@Scope
public class OperationsController {

    @Autowired
    UserService service;

    @Autowired
    OperationsService operationsService;

    @Autowired
    StrategyService strategyService;


    @RequestMapping(value="/pay", method= RequestMethod.POST)
    public Response pay(@RequestBody PayRequest request) throws Exception {
        if(service.isUserLogged()){
            BankModel targetModel = operationsService.findModel(request.getIdToPay());
            if(targetModel==null) {
                targetModel = operationsService.findModelInSecondDB(request.getIdToPay());
                if(targetModel==null) return new Response(401,"Account or Card with this number does not exists");
            }
            BankModel loggedModel = service.getUser().getModel();
            strategyService.setStrategy("StrategyForSimpleOperation");
            boolean result = strategyService.executeStrategy(targetModel,loggedModel,request.getAmount());
            if(result) return new Response(200,"Operation finished with success");
        }
        return new Response(403,"Please log in");
    }



}
