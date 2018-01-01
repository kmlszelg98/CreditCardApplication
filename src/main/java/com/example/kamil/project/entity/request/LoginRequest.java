package com.example.kamil.project.entity.request;

/**
 * Created by Kamil on 30.12.2017.
 */
public class LoginRequest {

    private String name;
    private String password;
    private boolean isCard;

    public LoginRequest(String name, String password, boolean isCard) {
        this.name = name;
        this.password = password;
        this.isCard = isCard;
    }

    public LoginRequest() {
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

    public boolean isCard() {
        return isCard;
    }

    public void setCard(boolean card) {
        isCard = card;
    }
}
