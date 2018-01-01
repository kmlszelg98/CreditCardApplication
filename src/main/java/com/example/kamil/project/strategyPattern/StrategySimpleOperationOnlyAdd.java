package com.example.kamil.project.strategyPattern;

import com.example.kamil.project.commandPattern.AddMoneyOperation;
import com.example.kamil.project.entity.BankModel;
import com.example.kamil.project.factoryPattern.factoryMethods.OperationFactory;
import com.example.kamil.project.service.OperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Kamil on 30.12.2017.
 */
@Component
public class StrategySimpleOperationOnlyAdd implements OperationStrategy{

    @Autowired
    OperationsService operationsService;

    @Autowired
    OperationFactory factory;

    @Override
    public boolean executeStrategy(BankModel targetModel, BankModel loggedModel, float amount) {
        operationsService.setCommand(new AddMoneyOperation(factory.getOperation("SimpleOperation")));
        operationsService.executeMoneyOperation(loggedModel,amount);
        return true;
    }
}
