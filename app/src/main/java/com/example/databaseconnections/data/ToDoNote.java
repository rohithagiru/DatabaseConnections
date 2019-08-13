package com.example.databaseconnections.data;

import java.sql.Struct;

public class ToDoNote {
    String title;
    String subTitle;
    String name;
    String address;

    public ToDoNote(String title, String subTitle, String name,String address) {
        this.title = title;
        this.subTitle = subTitle;
        this.name = name;
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
