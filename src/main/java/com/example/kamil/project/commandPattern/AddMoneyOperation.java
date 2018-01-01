package com.example.kamil.project.commandPattern;

import com.example.kamil.project.entity.BankModel;
import com.example.kamil.project.factoryPattern.operationFactory.Operation;

/**
 * Created by Kamil on 30.12.2017.
 */
public class AddMoneyOperation implements MoneyOperationCommand {

    private Operation operation;

    public AddMoneyOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public void execute(BankModel model, float amount) {
        operation.operate(model,amount,true);
    }
}
