package com.example.kamil.project.commandPattern;

import com.example.kamil.project.entity.BankModel;

/**
 * Created by Kamil on 30.12.2017.
 */
public interface MoneyOperationCommand {

    public void execute(BankModel model, float amount);
}
