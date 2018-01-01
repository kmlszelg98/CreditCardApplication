package com.example.kamil.project.model;

import com.example.kamil.project.entity.BankModel;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by Kamil on 30.12.2017.
 */

@Component
@Scope(value="session", proxyMode= ScopedProxyMode.TARGET_CLASS)
public class LoggedUser implements Serializable{

    private BankModel model;

    public void setModel(BankModel model) {
        this.model = model;
    }

    public boolean isLogged(){
        return model!=null;
    }

    public BankModel getModel(){
        return model;
    }
}
