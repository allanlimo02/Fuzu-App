
package com.example.petyfinderip_version2.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
@Generated("jsonschema2pojo")
public class Links {

    @SerializedName("self")
    @Expose
    private Self self;
    @SerializedName("type")
    @Expose
    private Type type;
    @SerializedName("organization")
    @Expose
    private Organization organization;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Links() {
    }

    /**
     * 
     * @param organization
     * @param self
     * @param type
     */
    public Links(Self self, Type type, Organization organization) {
        super();
        this.self = self;
        this.type = type;
        this.organization = organization;
    }

    public Self getSelf() {
        return self;
    }

    public void setSelf(Self self) {
        this.self = self;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(Links.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
//        sb.append("self");
//        sb.append('=');
//        sb.append(((this.self == null)?"<null>":this.self));
//        sb.append(',');
//        sb.append("type");
//        sb.append('=');
//        sb.append(((this.type == null)?"<null>":this.type));
//        sb.append(',');
//        sb.append("organization");
//        sb.append('=');
//        sb.append(((this.organization == null)?"<null>":this.organization));
//        sb.append(',');
//        if (sb.charAt((sb.length()- 1)) == ',') {
//            sb.setCharAt((sb.length()- 1), ']');
//        } else {
//            sb.append(']');
//        }
//        return sb.toString();
//    }

}
