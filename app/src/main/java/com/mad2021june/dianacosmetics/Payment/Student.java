package com.mad2021june.dianacosmetics.Payment;

public class Student {

    private String fName, lName, mail, phone, address;

    public Student(String fName, String lName, String mail, String phone, String address) {
        this.fName = fName;
        this.lName = lName;
        this.mail = mail;
        this.phone = phone;
        this.address = address;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}



