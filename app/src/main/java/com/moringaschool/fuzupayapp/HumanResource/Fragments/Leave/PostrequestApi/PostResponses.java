package com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.PostrequestApi;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class PostResponses {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("department")
    @Expose
    private String department;
    @SerializedName("employment_type")
    @Expose
    private String employmentType;
    @SerializedName("leave_type")
    @Expose
    private String leaveType;
    @SerializedName("employee")
    @Expose
    private String employee;
    @SerializedName("positon")
    @Expose
    private String positon;
    @SerializedName("leave_date_from")
    @Expose
    private String leaveDateFrom;
    @SerializedName("leave_date_to")
    @Expose
    private String leaveDateTo;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("approved_by")
    @Expose
    private Integer approvedBy;

    /**
     * No args constructor for use in serialization
     *
     */
    public PostResponses() {
    }

    /**
     *
     * @param leaveDateFrom
     * @param createdAt
     * @param leaveType
     * @param employmentType
     * @param positon
     * @param approvedBy
     * @param leaveDateTo
     * @param id
     * @param department
     * @param employee
     * @param status
     */
    public PostResponses(Integer id, String department, String employmentType, String leaveType, String employee, String positon, String leaveDateFrom, String leaveDateTo, String status, String createdAt, Integer approvedBy) {
        super();
        this.id = id;
        this.department = department;
        this.employmentType = employmentType;
        this.leaveType = leaveType;
        this.employee = employee;
        this.positon = positon;
        this.leaveDateFrom = leaveDateFrom;
        this.leaveDateTo = leaveDateTo;
        this.status = status;
        this.createdAt = createdAt;
        this.approvedBy = approvedBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
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

    public String getLeaveDateFrom() {
        return leaveDateFrom;
    }

    public void setLeaveDateFrom(String leaveDateFrom) {
        this.leaveDateFrom = leaveDateFrom;
    }

    public String getLeaveDateTo() {
        return leaveDateTo;
    }

    public void setLeaveDateTo(String leaveDateTo) {
        this.leaveDateTo = leaveDateTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Integer approvedBy) {
        this.approvedBy = approvedBy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PostResponses.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("department");
        sb.append('=');
        sb.append(((this.department == null)?"<null>":this.department));
        sb.append(',');
        sb.append("employmentType");
        sb.append('=');
        sb.append(((this.employmentType == null)?"<null>":this.employmentType));
        sb.append(',');
        sb.append("leaveType");
        sb.append('=');
        sb.append(((this.leaveType == null)?"<null>":this.leaveType));
        sb.append(',');
        sb.append("employee");
        sb.append('=');
        sb.append(((this.employee == null)?"<null>":this.employee));
        sb.append(',');
        sb.append("positon");
        sb.append('=');
        sb.append(((this.positon == null)?"<null>":this.positon));
        sb.append(',');
        sb.append("leaveDateFrom");
        sb.append('=');
        sb.append(((this.leaveDateFrom == null)?"<null>":this.leaveDateFrom));
        sb.append(',');
        sb.append("leaveDateTo");
        sb.append('=');
        sb.append(((this.leaveDateTo == null)?"<null>":this.leaveDateTo));
        sb.append(',');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("createdAt");
        sb.append('=');
        sb.append(((this.createdAt == null)?"<null>":this.createdAt));
        sb.append(',');
        sb.append("approvedBy");
        sb.append('=');
        sb.append(((this.approvedBy == null)?"<null>":this.approvedBy));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
