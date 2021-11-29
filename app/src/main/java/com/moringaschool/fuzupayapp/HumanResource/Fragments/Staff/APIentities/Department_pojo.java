package com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIentities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;

public class Department_pojo implements Serializable {
    private int did;
    private String dname;

    public Department_pojo() {
    }

    public Department_pojo(int did, String dname) {
        this.did=did;
        this.dname=dname;
    }

    public int getId() {
        return did;
    }

    public void setId(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Department_pojo{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                '}';
    }
    final GsonBuilder gsonBuilder = new GsonBuilder();
    final Gson gson = gsonBuilder.create();
}
