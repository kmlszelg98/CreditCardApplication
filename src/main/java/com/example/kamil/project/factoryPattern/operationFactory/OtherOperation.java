package com.example.kamil.project.factoryPattern.operationFactory;

import com.example.kamil.project.entity.BankModel;
import org.springframework.stereotype.Component;

/**
 * Created by Kamil on 30.12.2017.
 */

@Component
public class OtherOperation implements Operation {
    @Override
    public void operate(BankModel model, Float amount, boolean isAdded) {
    }
}
