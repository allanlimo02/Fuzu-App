package com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIApploadDocs.Bank.Docs;

public class DocsApploadUserRequest {
    private String employee_id;
    private int department;
    private int employment_type;
    private String surname;
    private String other_names;
    private String phone_number;
    private String position;

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getEmployment_type() {
        return employment_type;
    }

    public void setEmployment_type(int employment_type) {
        this.employment_type = employment_type;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOther_names() {
        return other_names;
    }

    public void setOther_names(String other_names) {
        this.other_names = other_names;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
