package com.example.kamil.project.factoryPattern.factoryMethods;

import com.example.kamil.project.factoryPattern.operationFactory.Operation;
import com.example.kamil.project.factoryPattern.operationFactory.OtherOperation;
import com.example.kamil.project.factoryPattern.operationFactory.SimpleOperation;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by Kamil on 30.12.2017.
 */

@Service
public class OperationFactory {

    public Operation getOperation(String name){
        if(name.equals("SimpleOperation")) return new SimpleOperation();
        else return new OtherOperation();
    }
}
