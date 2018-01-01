package com.example.kamil.project.strategyPattern;

import com.example.kamil.project.entity.BankModel;

/**
 * Created by Kamil on 30.12.2017.
 */
public interface OperationStrategy {

    public boolean executeStrategy(BankModel targetModel, BankModel loggedModel, float amount);
}
