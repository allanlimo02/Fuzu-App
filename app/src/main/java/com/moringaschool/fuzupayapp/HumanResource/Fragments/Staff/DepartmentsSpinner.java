package com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DepartmentsSpinner {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DepartmentsSpinner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    final GsonBuilder gsonBuilder = new GsonBuilder();
    final Gson gson = gsonBuilder.create();
}
