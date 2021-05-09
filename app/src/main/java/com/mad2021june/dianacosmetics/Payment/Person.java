package com.mad2021june.dianacosmetics.Payment;

public class Person {
    private String account, name, date, cvc;

    public Person(String account, String name, String date, String cvc) {
        this.account = account;
        this.name = name;
        this.date = date;
        this.cvc = cvc;
    }

    public String getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getCvc() {
        return cvc;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }
}
