package com.moringaschool.fuzupayapp.APIRequests;

public class DepartmentResponse {
        private String employee_id;
        private String department;
        private String employment_type;
        private String position;
        private String surname;
        private String other_names;
        private String phone_number;
        private String work_email;
        private String personal_email;
        private String id_number;
        private String gross_salary;
        private String marital_status;
        private String emergency_contact;
        private String emergency_contact_number;
        private String insurance_number;
        private String tax_pin_number;
        private String country;
        private String date_of_birth;
        private String employment_date;
        private String status;
        private String created_at;
        private String bank_payment_details;

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

    public String getEmployment_type() {
        return employment_type;
    }

    public void setEmployment_type(String employment_type) {
        this.employment_type = employment_type;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public String getWork_email() {
        return work_email;
    }

    public void setWork_email(String work_email) {
        this.work_email = work_email;
    }

    public String getPersonal_email() {
        return personal_email;
    }

    public void setPersonal_email(String personal_email) {
        this.personal_email = personal_email;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
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

    public String getEmergency_contact() {
        return emergency_contact;
    }

    public void setEmergency_contact(String emergency_contact) {
        this.emergency_contact = emergency_contact;
    }

    public String getEmergency_contact_number() {
        return emergency_contact_number;
    }

    public void setEmergency_contact_number(String emergency_contact_number) {
        this.emergency_contact_number = emergency_contact_number;
    }

    public String getInsurance_number() {
        return insurance_number;
    }

    public void setInsurance_number(String insurance_number) {
        this.insurance_number = insurance_number;
    }

    public String getTax_pin_number() {
        return tax_pin_number;
    }

    public void setTax_pin_number(String tax_pin_number) {
        this.tax_pin_number = tax_pin_number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getEmployment_date() {
        return employment_date;
    }

    public void setEmployment_date(String employment_date) {
        this.employment_date = employment_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getBank_payment_details() {
        return bank_payment_details;
    }

    public void setBank_payment_details(String bank_payment_details) {
        this.bank_payment_details = bank_payment_details;
    }

    @Override
    public String toString() {
        return "DepartmentResponse{" +
                "employee_id='" + employee_id + '\'' +
                ", department='" + department + '\'' +
                ", employment_type='" + employment_type + '\'' +
                ", position='" + position + '\'' +
                ", surname='" + surname + '\'' +
                ", other_names='" + other_names + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", work_email='" + work_email + '\'' +
                ", personal_email='" + personal_email + '\'' +
                ", id_number='" + id_number + '\'' +
                ", gross_salary='" + gross_salary + '\'' +
                ", marital_status='" + marital_status + '\'' +
                ", emergency_contact='" + emergency_contact + '\'' +
                ", emergency_contact_number='" + emergency_contact_number + '\'' +
                ", insurance_number='" + insurance_number + '\'' +
                ", tax_pin_number='" + tax_pin_number + '\'' +
                ", country='" + country + '\'' +
                ", date_of_birth='" + date_of_birth + '\'' +
                ", employment_date='" + employment_date + '\'' +
                ", status='" + status + '\'' +
                ", created_at='" + created_at + '\'' +
                ", bank_payment_details='" + bank_payment_details + '\'' +
                '}';
    }
}
