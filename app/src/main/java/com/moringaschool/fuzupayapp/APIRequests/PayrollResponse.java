package com.moringaschool.fuzupayapp.APIRequests;

public class PayrollResponse {

        private int id;
        private String pay_id;
        private String month;
        private String debit_amount;
        private String gross_pay;
        private String net_pay;
        private String deduction;
        private String staff_paid;
        private String payroll_status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPay_id() {
        return pay_id;
    }

    public void setPay_id(String pay_id) {
        this.pay_id = pay_id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDebit_amount() {
        return debit_amount;
    }

    public void setDebit_amount(String debit_amount) {
        this.debit_amount = debit_amount;
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

    public String getDeduction() {
        return deduction;
    }

    public void setDeduction(String deduction) {
        this.deduction = deduction;
    }

    public String getStaff_paid() {
        return staff_paid;
    }

    public void setStaff_paid(String staff_paid) {
        this.staff_paid = staff_paid;
    }

    public String getPayroll_status() {
        return payroll_status;
    }

    public void setPayroll_status(String payroll_status) {
        this.payroll_status = payroll_status;
    }

    @Override
    public String toString() {
        return "PayrollResponse{" +
                "id=" + id +
                ", pay_id='" + pay_id + '\'' +
                ", month='" + month + '\'' +
                ", debit_amount='" + debit_amount + '\'' +
                ", gross_pay='" + gross_pay + '\'' +
                ", net_pay='" + net_pay + '\'' +
                ", deduction='" + deduction + '\'' +
                ", staff_paid='" + staff_paid + '\'' +
                ", payroll_status='" + payroll_status + '\'' +
                '}';
    }
}
