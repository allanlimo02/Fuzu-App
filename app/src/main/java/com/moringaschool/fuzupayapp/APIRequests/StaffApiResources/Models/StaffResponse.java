
package com.moringaschool.fuzupayapp.APIRequests.StaffApiResources.Models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class StaffResponse {

    @SerializedName("employee_id")
    @Expose
    private String employeeId;
    @SerializedName("department")
    @Expose
    private String department;
    @SerializedName("employment_type")
    @Expose
    private String employmentType;
    @SerializedName("position")
    @Expose
    private String position;
    @SerializedName("surname")
    @Expose
    private String surname;
    @SerializedName("other_names")
    @Expose
    private String otherNames;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("work_email")
    @Expose
    private String workEmail;
    @SerializedName("personal_email")
    @Expose
    private Object personalEmail;
    @SerializedName("id_number")
    @Expose
    private String idNumber;
    @SerializedName("gross_salary")
    @Expose
    private String grossSalary;
    @SerializedName("marital_status")
    @Expose
    private String maritalStatus;
    @SerializedName("emergency_contact")
    @Expose
    private String emergencyContact;
    @SerializedName("emergency_contact_number")
    @Expose
    private String emergencyContactNumber;
    @SerializedName("insurance_number")
    @Expose
    private Object insuranceNumber;
    @SerializedName("tax_pin_number")
    @Expose
    private Object taxPinNumber;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("date_of_birth")
    @Expose
    private String dateOfBirth;
    @SerializedName("employment_date")
    @Expose
    private String employmentDate;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("bank_payment_details")
    @Expose
    private Object bankPaymentDetails;

    /**
     * No args constructor for use in serialization
     * 
     */
    public StaffResponse() {
    }

    /**
     * 
     * @param country
     * @param employmentType
     * @param workEmail
     * @param emergencyContact
     * @param employmentDate
     * @param emergencyContactNumber
     * @param bankPaymentDetails
     * @param employeeId
     * @param dateOfBirth
     * @param idNumber
     * @param grossSalary
     * @param taxPinNumber
     * @param personalEmail
     * @param insuranceNumber
     * @param createdAt
     * @param otherNames
     * @param phoneNumber
     * @param surname
     * @param position
     * @param department
     * @param maritalStatus
     * @param status
     */
    public StaffResponse(String employeeId, String department, String employmentType, String position, String surname, String otherNames, String phoneNumber, String workEmail, Object personalEmail, String idNumber, String grossSalary, String maritalStatus, String emergencyContact, String emergencyContactNumber, Object insuranceNumber, Object taxPinNumber, String country, String dateOfBirth, String employmentDate, String status, String createdAt, Object bankPaymentDetails) {
        super();
        this.employeeId = employeeId;
        this.department = department;
        this.employmentType = employmentType;
        this.position = position;
        this.surname = surname;
        this.otherNames = otherNames;
        this.phoneNumber = phoneNumber;
        this.workEmail = workEmail;
        this.personalEmail = personalEmail;
        this.idNumber = idNumber;
        this.grossSalary = grossSalary;
        this.maritalStatus = maritalStatus;
        this.emergencyContact = emergencyContact;
        this.emergencyContactNumber = emergencyContactNumber;
        this.insuranceNumber = insuranceNumber;
        this.taxPinNumber = taxPinNumber;
        this.country = country;
        this.dateOfBirth = dateOfBirth;
        this.employmentDate = employmentDate;
        this.status = status;
        this.createdAt = createdAt;
        this.bankPaymentDetails = bankPaymentDetails;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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

    public String getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public Object getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(Object personalEmail) {
        this.personalEmail = personalEmail;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(String grossSalary) {
        this.grossSalary = grossSalary;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public Object getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(Object insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public Object getTaxPinNumber() {
        return taxPinNumber;
    }

    public void setTaxPinNumber(Object taxPinNumber) {
        this.taxPinNumber = taxPinNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(String employmentDate) {
        this.employmentDate = employmentDate;
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

    public Object getBankPaymentDetails() {
        return bankPaymentDetails;
    }

    public void setBankPaymentDetails(Object bankPaymentDetails) {
        this.bankPaymentDetails = bankPaymentDetails;
    }

    @Override
    public String toString() {
        return "StaffResponse{" +
                "employeeId='" + employeeId + '\'' +
                ", department='" + department + '\'' +
                ", employmentType='" + employmentType + '\'' +
                ", position='" + position + '\'' +
                ", surname='" + surname + '\'' +
                ", otherNames='" + otherNames + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", workEmail='" + workEmail + '\'' +
                ", personalEmail=" + personalEmail +
                ", idNumber='" + idNumber + '\'' +
                ", grossSalary='" + grossSalary + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", emergencyContact='" + emergencyContact + '\'' +
                ", emergencyContactNumber='" + emergencyContactNumber + '\'' +
                ", insuranceNumber=" + insuranceNumber +
                ", taxPinNumber=" + taxPinNumber +
                ", country='" + country + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", employmentDate='" + employmentDate + '\'' +
                ", status='" + status + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", bankPaymentDetails=" + bankPaymentDetails +
                '}';
    }
}
