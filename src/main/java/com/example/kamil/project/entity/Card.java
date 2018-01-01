package com.example.kamil.project.entity;

/**
 * Created by Kamil on 28.12.2017.
 */
import javax.persistence.*;

@Entity
public class Card implements BankModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String password;

    private Integer number;

    private Float amount;

    private Integer money_limit;

    public Card() {}

    public Card(Integer id, String name, String password, Integer number, Float amount, Integer money_limit) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.number = number;
        this.amount = amount;
        this.money_limit = money_limit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Integer getMoney_limit() {
        return money_limit;
    }

    public void setMoney_limit(Integer money_limit) {
        this.money_limit = money_limit;
    }
}
