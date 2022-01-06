package com.moringaschool.fuzupayapp.APIRequests.FinancePayrolePaymentApi;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



    @Generated("jsonschema2pojo")
    public class PayrolePaymentResponse {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("pay_id")
        @Expose
        private String payId;
        @SerializedName("month")
        @Expose
        private String month;
        @SerializedName("debit_amount")
        @Expose
        private String debitAmount;
        @SerializedName("gross_pay")
        @Expose
        private String grossPay;
        @SerializedName("net_pay")
        @Expose
        private String netPay;
        @SerializedName("deduction")
        @Expose
        private String deduction;
        @SerializedName("staff_paid")
        @Expose
        private Integer staffPaid;
        @SerializedName("payroll_status")
        @Expose
        private String payrollStatus;

        /**
         * No args constructor for use in serialization
         *
         */
        public PayrolePaymentResponse() {
        }

        /**
         *
         * @param netPay
         * @param month
         * @param deduction
         * @param grossPay
         * @param staffPaid
         * @param payrollStatus
         * @param id
         * @param payId
         * @param debitAmount
         */
        public PayrolePaymentResponse(Integer id, String payId, String month, String debitAmount, String grossPay, String netPay, String deduction, Integer staffPaid, String payrollStatus) {
            super();
            this.id = id;
            this.payId = payId;
            this.month = month;
            this.debitAmount = debitAmount;
            this.grossPay = grossPay;
            this.netPay = netPay;
            this.deduction = deduction;
            this.staffPaid = staffPaid;
            this.payrollStatus = payrollStatus;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getPayId() {
            return payId;
        }

        public void setPayId(String payId) {
            this.payId = payId;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public String getDebitAmount() {
            return debitAmount;
        }

        public void setDebitAmount(String debitAmount) {
            this.debitAmount = debitAmount;
        }

        public String getGrossPay() {
            return grossPay;
        }

        public void setGrossPay(String grossPay) {
            this.grossPay = grossPay;
        }

        public String getNetPay() {
            return netPay;
        }

        public void setNetPay(String netPay) {
            this.netPay = netPay;
        }

        public String getDeduction() {
            return deduction;
        }

        public void setDeduction(String deduction) {
            this.deduction = deduction;
        }

        public Integer getStaffPaid() {
            return staffPaid;
        }

        public void setStaffPaid(Integer staffPaid) {
            this.staffPaid = staffPaid;
        }

        public String getPayrollStatus() {
            return payrollStatus;
        }

        public void setPayrollStatus(String payrollStatus) {
            this.payrollStatus = payrollStatus;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(PayrolePaymentResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("id");
            sb.append('=');
            sb.append(((this.id == null)?"<null>":this.id));
            sb.append(',');
            sb.append("payId");
            sb.append('=');
            sb.append(((this.payId == null)?"<null>":this.payId));
            sb.append(',');
            sb.append("month");
            sb.append('=');
            sb.append(((this.month == null)?"<null>":this.month));
            sb.append(',');
            sb.append("debitAmount");
            sb.append('=');
            sb.append(((this.debitAmount == null)?"<null>":this.debitAmount));
            sb.append(',');
            sb.append("grossPay");
            sb.append('=');
            sb.append(((this.grossPay == null)?"<null>":this.grossPay));
            sb.append(',');
            sb.append("netPay");
            sb.append('=');
            sb.append(((this.netPay == null)?"<null>":this.netPay));
            sb.append(',');
            sb.append("deduction");
            sb.append('=');
            sb.append(((this.deduction == null)?"<null>":this.deduction));
            sb.append(',');
            sb.append("staffPaid");
            sb.append('=');
            sb.append(((this.staffPaid == null)?"<null>":this.staffPaid));
            sb.append(',');
            sb.append("payrollStatus");
            sb.append('=');
            sb.append(((this.payrollStatus == null)?"<null>":this.payrollStatus));
            sb.append(',');
            if (sb.charAt((sb.length()- 1)) == ',') {
                sb.setCharAt((sb.length()- 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

    }


