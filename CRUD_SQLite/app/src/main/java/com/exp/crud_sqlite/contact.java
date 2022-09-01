package com.exp.crud_sqlite;

public class contact {

    String name, phone;
    int id;

    public contact(String name, String phone, int id) {
        this.name = name;
        this.phone = phone;
        this.id = id;
    }

    public contact() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
