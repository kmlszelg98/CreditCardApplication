package com.example.kamil.project.factoryPattern.operationFactory;

import com.example.kamil.project.entity.BankModel;

/**
 * Created by Kamil on 30.12.2017.
 */
public interface Operation {

    public void operate(BankModel model, Float amount, boolean isAdded);
}
