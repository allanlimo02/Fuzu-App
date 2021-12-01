package com.moringaschool.fuzupayapp.Finance.Pazyroll.reviewApi;

public class reviewResponse {
      int id;
    String name;
    String created_at;
    String updated_at;
    String amount;
    String position;
    String full_name;
    String department;
    String company;
    String work_email;
    String personal_email;
    int employee_id;
    String location;
    String date_processed;
    String employment_date;
    int insurance_number;
    int tax_pin_number;
    String paye;
    String gross_pay;
    String net_pay;
    String tax_deducted;
    String pension;
    String sacco;
    String medical_cover;

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

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate_processed() {
        return date_processed;
    }

    public void setDate_processed(String date_processed) {
        this.date_processed = date_processed;
    }

    public String getEmployment_date() {
        return employment_date;
    }

    public void setEmployment_date(String employment_date) {
        this.employment_date = employment_date;
    }

    public int getInsurance_number() {
        return insurance_number;
    }

    public void setInsurance_number(int insurance_number) {
        this.insurance_number = insurance_number;
    }

    public int getTax_pin_number() {
        return tax_pin_number;
    }

    public void setTax_pin_number(int tax_pin_number) {
        this.tax_pin_number = tax_pin_number;
    }

    public String getPaye() {
        return paye;
    }

    public void setPaye(String paye) {
        this.paye = paye;
    }

    public String getGross_pay() {
        return gross_pay;
    }

    public void setGross_pay(String gross_pay) {
        this.gross_pay = gross_pay;
    }

    public String getNet_pay() {
        return net_pay;
    }

    public void setNet_pay(String net_pay) {
        this.net_pay = net_pay;
    }

    public String getTax_deducted() {
        return tax_deducted;
    }

    public void setTax_deducted(String tax_deducted) {
        this.tax_deducted = tax_deducted;
    }

    public String getPension() {
        return pension;
    }

    public void setPension(String pension) {
        this.pension = pension;
    }

    public String getSacco() {
        return sacco;
    }

    public void setSacco(String sacco) {
        this.sacco = sacco;
    }

    public String getMedical_cover() {
        return medical_cover;
    }

    public void setMedical_cover(String medical_cover) {
        this.medical_cover = medical_cover;
    }

    @Override
    public String toString() {
        return "reviewResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", amount='" + amount + '\'' +
                ", position='" + position + '\'' +
                ", full_name='" + full_name + '\'' +
                ", department='" + department + '\'' +
                ", company='" + company + '\'' +
                ", work_email='" + work_email + '\'' +
                ", personal_email='" + personal_email + '\'' +
                ", employee_id=" + employee_id +
                ", location='" + location + '\'' +
                ", date_processed='" + date_processed + '\'' +
                ", employment_date='" + employment_date + '\'' +
                ", insurance_number=" + insurance_number +
                ", tax_pin_number=" + tax_pin_number +
                ", paye='" + paye + '\'' +
                ", gross_pay='" + gross_pay + '\'' +
                ", net_pay='" + net_pay + '\'' +
                ", tax_deducted='" + tax_deducted + '\'' +
                ", pension='" + pension + '\'' +
                ", sacco='" + sacco + '\'' +
                ", medical_cover='" + medical_cover + '\'' +
                '}';
    }
}
