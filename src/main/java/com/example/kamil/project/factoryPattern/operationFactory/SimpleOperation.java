package com.example.kamil.project.factoryPattern.operationFactory;

import com.example.kamil.project.entity.BankModel;
import org.springframework.stereotype.Component;

/**
 * Created by Kamil on 30.12.2017.
 */

@Component
public class SimpleOperation implements Operation {

    @Override
    public void operate(BankModel model, Float amount, boolean isAdded) {
        if(isAdded){
            model.setAmount(model.getAmount()+amount);
        } else {
            model.setAmount(model.getAmount()-amount);
        }
    }

}
