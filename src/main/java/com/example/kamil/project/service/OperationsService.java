package com.example.kamil.project.service;

import com.example.kamil.project.commandPattern.MoneyOperationCommand;
import com.example.kamil.project.entity.Account;
import com.example.kamil.project.entity.BankModel;
import com.example.kamil.project.entity.Card;
import com.example.kamil.project.repository.AccountRepository;
import com.example.kamil.project.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Kamil on 30.12.2017.
 */

@Service
public class OperationsService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    DataSourceService dataSourceService;

    private MoneyOperationCommand command;

    public synchronized void setCommand(MoneyOperationCommand command) {
        this.command = command;
    }

    public BankModel findModel(int number){
        Card card = cardRepository.findByNumber(number);
        if(card==null){
            Account account = accountRepository.findByNumber(number);
            return account;
        }
        return card;
    }

    public BankModel findModelInSecondDB(int number){
        Card card = dataSourceService.findCardByNumber(number);
        if(card==null){
            Account account = dataSourceService.findAccountByNumber(number);
            return account;
        }
        return card;
    }

    public synchronized void executeMoneyOperation(BankModel model, float amount){
        command.execute(model,amount);
    }

}
