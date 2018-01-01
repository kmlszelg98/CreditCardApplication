package com.example.kamil.project.service;

import com.example.kamil.project.entity.BankModel;
import com.example.kamil.project.strategyPattern.StrategyForSimpleOperation;
import com.example.kamil.project.strategyPattern.StrategySimpleOperationOnlyAdd;
import com.example.kamil.project.strategyPattern.StrategySimpleOperationOnlyDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Kamil on 30.12.2017.
 */

@Service
public class StrategyService {

    @Autowired
    StrategyForSimpleOperation operationOne;

    @Autowired
    StrategySimpleOperationOnlyAdd operationTwo;

    @Autowired
    StrategySimpleOperationOnlyDelete operationThree;

    private String strategy;

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(BankModel targetModel, BankModel loggedModel, float amount){
        if(strategy.equals("StrategyForSimpleOperation")) return operationOne.executeStrategy(targetModel,loggedModel,amount);
        else if(strategy.equals("StrategySimpleOperationOnlyAdd")) return operationTwo.executeStrategy(targetModel,loggedModel,amount);
        else return operationThree.executeStrategy(targetModel,loggedModel,amount);
    }
}
