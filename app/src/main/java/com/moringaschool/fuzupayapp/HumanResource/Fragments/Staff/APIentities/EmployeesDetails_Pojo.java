package com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIentities;

import java.io.Serializable;

public class EmployeesDetails_Pojo implements Serializable {
    private String employee_id;
    private String department;
    private String other_names;
    private String position;

    public EmployeesDetails_Pojo() {
    }

    public EmployeesDetails_Pojo(String employee_id, String department, String other_names, String position) {
        this.employee_id = employee_id;
        this.department = department;
        this.other_names = other_names;
        this.position = position;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getOther_names() {
        return other_names;
    }

    public void setOther_names(String other_names) {
        this.other_names = other_names;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
