package com.moringaschool.fuzupayapp.Finance.ExpensesApi;

public class EcompletedResponse {

    private int id;
    private String name;
    private String merchant;
    private String date_processed;
    private String amount;
    private String status;
    private String total_amount;

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

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getDate_processed() {
        return date_processed;
    }

    public void setDate_processed(String date_processed) {
        this.date_processed = date_processed;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    @Override
    public String toString() {
        return "EcompletedResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", merchant='" + merchant + '\'' +
                ", date_processed='" + date_processed + '\'' +
                ", amount='" + amount + '\'' +
                ", status='" + status + '\'' +
                ", total_amount='" + total_amount + '\'' +
                '}';
    }
}
