package com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.RequestAPI;

public class RequestResponse {
    private int id;
    private String employment_type;
    private String employee;
    private String leave_date_from;
    private String leave_date_to;
    private String position;
    private String status;
    private String created_at;
    private int approved_by;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployment_type() {
        return employment_type;
    }

    public void setEmployment_type(String employment_type) {
        this.employment_type = employment_type;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getLeave_date_from() {
        return leave_date_from;
    }

    public void setLeave_date_from(String leave_date_from) {
        this.leave_date_from = leave_date_from;
    }

    public String getLeave_date_to() {
        return leave_date_to;
    }

    public void setLeave_date_to(String leave_date_to) {
        this.leave_date_to = leave_date_to;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public int getApproved_by() {
        return approved_by;
    }

    public void setApproved_by(int approved_by) {
        this.approved_by = approved_by;
    }

    @Override
    public String toString() {
        return "requestResponse{" +
                "id=" + id +
                ", employment_type='" + employment_type + '\'' +
                ", employee='" + employee + '\'' +
                ", leave_date_from='" + leave_date_from + '\'' +
                ", leave_date_to='" + leave_date_to + '\'' +
                ", position='" + position + '\'' +
                ", status='" + status + '\'' +
                ", created_at='" + created_at + '\'' +
                ", approved_by=" + approved_by +
                '}';
    }
}
