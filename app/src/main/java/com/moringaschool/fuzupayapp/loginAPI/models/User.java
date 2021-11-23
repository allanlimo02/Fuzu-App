
package com.moringaschool.fuzupayapp.loginAPI.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.moringaschool.fuzupayapp.loginAPI.models.Role;

import java.io.Serializable;

@Generated("jsonschema2pojo")
public class User implements Serializable {

    @SerializedName("pk")
    @Expose
    private Integer pk;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("nationality")
    @Expose
    private String nationality;
    @SerializedName("national_id")
    @Expose
    private Object nationalId;
    @SerializedName("date_joined")
    @Expose
    private String dateJoined;
    @SerializedName("last_login")
    @Expose
    private String lastLogin;
    @SerializedName("role")
    @Expose
    private Role role;

    public Integer getPk() {
        return pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Object getNationalId() {
        return nationalId;
    }

    public void setNationalId(Object nationalId) {
        this.nationalId = nationalId;
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
