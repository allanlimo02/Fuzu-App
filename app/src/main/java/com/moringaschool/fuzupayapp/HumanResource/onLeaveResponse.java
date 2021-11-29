package com.moringaschool.fuzupayapp.HumanResource;

public class onLeaveResponse {

    private int id;
       private String department;
       private String employment_type;
       private String leave_type;
       private String employee;
       private String positon;
       private String c;
       private String leave_date_to;
       private String status;
       private String created_at;
       private String approved_by;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getLeave_type() {
        return leave_type;
    }

    public void setLeave_type(String leave_type) {
        this.leave_type = leave_type;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getPositon() {
        return positon;
    }

    public void setPositon(String positon) {
        this.positon = positon;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getLeave_date_to() {
        return leave_date_to;
    }

    public void setLeave_date_to(String leave_date_to) {
        this.leave_date_to = leave_date_to;
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

    public String getApproved_by() {
        return approved_by;
    }

    public void setApproved_by(String approved_by) {
        this.approved_by = approved_by;
    }

    @Override
    public String toString() {
        return "onLeaveResponse{" +
                "id=" + id +
                ", department='" + department + '\'' +
                ", employment_type='" + employment_type + '\'' +
                ", leave_type='" + leave_type + '\'' +
                ", employee='" + employee + '\'' +
                ", positon='" + positon + '\'' +
                ", c='" + c + '\'' +
                ", leave_date_to='" + leave_date_to + '\'' +
                ", status='" + status + '\'' +
                ", created_at='" + created_at + '\'' +
                ", approved_by='" + approved_by + '\'' +
                '}';
    }
}
