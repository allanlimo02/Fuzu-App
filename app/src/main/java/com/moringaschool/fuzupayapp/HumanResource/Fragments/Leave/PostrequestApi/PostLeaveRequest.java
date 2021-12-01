package com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.PostrequestApi;

public class PostLeaveRequest {

    public String employee ;
    public String leave_type ;
    public  String department ;
    public String employment_type;

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getLeave_type() {
        return leave_type;
    }

    public void setLeave_type(String leave_type) {
        this.leave_type = leave_type;
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
}
