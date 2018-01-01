package com.example.kamil.project.entity.request;

/**
 * Created by Kamil on 30.12.2017.
 */
public class PayRequest {

    private int idToPay;
    private float amount;

    public PayRequest() {
    }

    public int getIdToPay() {
        return idToPay;
    }

    public void setIdToPay(int idToPay) {
        this.idToPay = idToPay;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
