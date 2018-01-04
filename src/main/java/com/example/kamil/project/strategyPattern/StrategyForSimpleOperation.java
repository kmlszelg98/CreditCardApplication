package com.example.kamil.project.strategyPattern;

import com.example.kamil.project.service.DataSourceService;
import com.example.kamil.project.commandPattern.AddMoneyOperation;
import com.example.kamil.project.commandPattern.DeleteMoneyOperation;
import com.example.kamil.project.entity.Account;
import com.example.kamil.project.entity.BankModel;
import com.example.kamil.project.entity.Card;
import com.example.kamil.project.factoryPattern.factoryMethods.OperationFactory;
import com.example.kamil.project.repository.AccountRepository;
import com.example.kamil.project.repository.CardRepository;
import com.example.kamil.project.service.OperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Kamil on 30.12.2017.
 */

@Service
public class StrategyForSimpleOperation implements OperationStrategy {

    @Autowired
    OperationsService operationsService;

    @Autowired
    OperationFactory factory;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    DataSourceService dataSourceService;

    @Override
    public boolean executeStrategy(BankModel targetModel, BankModel loggedModel, float amount) {
        if(loggedModel.getAmount()<amount) return false;
        if(loggedModel instanceof Card){
           int limit = ((Card) loggedModel).getMoney_limit();
           if(limit>amount) return false;
        }
        operationsService.setCommand(new AddMoneyOperation(factory.getOperation("SimpleOperation")));
        operationsService.executeMoneyOperation(targetModel,amount);
        operationsService.setCommand(new DeleteMoneyOperation(factory.getOperation("SimpleOperation")));
        operationsService.executeMoneyOperation(loggedModel,amount);
        saveBankModelToDatabase(targetModel);
        saveBankModelToDatabase(loggedModel);
        return true;
    }

    private void saveBankModelToDatabase(BankModel model){
        if(model instanceof Card) {
            dataSourceService.save((Card)model);
            cardRepository.save((Card)model);
        }
        else {
            dataSourceService.save((Account)model);
            accountRepository.save((Account)model);
        }
    }
}
