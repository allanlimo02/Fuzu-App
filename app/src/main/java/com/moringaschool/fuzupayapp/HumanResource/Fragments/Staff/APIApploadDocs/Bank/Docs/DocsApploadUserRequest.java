package com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIApploadDocs.Bank.Docs;

public class DocsApploadUserRequest {
    private String employee_id;
    private int department;
    private int employment_type;
    private String surname;
    private String other_names;
    private String phone_number;
    private String position;
    private String Email;
    private String id_no;
    private String nationality;
    private String birth_date;
    private String employment_date;
    private String gross_salary;
    private String marital_status;
    private String emergency_phone;
    private String emergency_contact;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getId_no() {
        return id_no;
    }

    public void setId_no(String id_no) {
        this.id_no = id_no;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getEmployment_date() {
        return employment_date;
    }

    public void setEmployment_date(String employment_date) {
        this.employment_date = employment_date;
    }

    public String getGross_salary() {
        return gross_salary;
    }

    public void setGross_salary(String gross_salary) {
        this.gross_salary = gross_salary;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public String getEmergency_phone() {
        return emergency_phone;
    }

    public void setEmergency_phone(String emergency_phone) {
        this.emergency_phone = emergency_phone;
    }

    public String getEmergency_contact() {
        return emergency_contact;
    }

    public void setEmergency_contact(String emergency_contact) {
        this.emergency_contact = emergency_contact;
    }

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
