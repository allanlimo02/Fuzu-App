
package com.example.petyfinderip_version2.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
@Generated("jsonschema2pojo")
public class Photo {

    @SerializedName("small")
    @Expose
    private String small;
    @SerializedName("medium")
    @Expose
    private String medium;
    @SerializedName("large")
    @Expose
    private String large;
    @SerializedName("full")
    @Expose
    private String full;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Photo() {
    }

    /**
     * 
     * @param small
     * @param large
     * @param medium
     * @param full
     */
    public Photo(String small, String medium, String large, String full) {
        super();
        this.small = small;
        this.medium = medium;
        this.large = large;
        this.full = full;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(Photo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
//        sb.append("small");
//        sb.append('=');
//        sb.append(((this.small == null)?"<null>":this.small));
//        sb.append(',');
//        sb.append("medium");
//        sb.append('=');
//        sb.append(((this.medium == null)?"<null>":this.medium));
//        sb.append(',');
//        sb.append("large");
//        sb.append('=');
//        sb.append(((this.large == null)?"<null>":this.large));
//        sb.append(',');
//        sb.append("full");
//        sb.append('=');
//        sb.append(((this.full == null)?"<null>":this.full));
//        sb.append(',');
//        if (sb.charAt((sb.length()- 1)) == ',') {
//            sb.setCharAt((sb.length()- 1), ']');
//        } else {
//            sb.append(']');
//        }
//        return sb.toString();
//    }

}
