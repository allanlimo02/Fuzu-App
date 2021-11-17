
package com.example.petyfinderip_version2.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
@Generated("jsonschema2pojo")
public class Breeds {

    @SerializedName("primary")
    @Expose
    private String primary;
    @SerializedName("mixed")
    @Expose
    private Boolean mixed;
    @SerializedName("unknown")
    @Expose
    private Boolean unknown;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Breeds() {
    }

    /**
     * 
     * @param mixed
     * @param primary
     * @param unknown
     */
    public Breeds(String primary, Boolean mixed, Boolean unknown) {
        super();
        this.primary = primary;
        this.mixed = mixed;
        this.unknown = unknown;
    }

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

    public Boolean getMixed() {
        return mixed;
    }

    public void setMixed(Boolean mixed) {
        this.mixed = mixed;
    }

    public Boolean getUnknown() {
        return unknown;
    }

    public void setUnknown(Boolean unknown) {
        this.unknown = unknown;
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(Breeds.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
//        sb.append("primary");
//        sb.append('=');
//        sb.append(((this.primary == null)?"<null>":this.primary));
//        sb.append(',');
//        sb.append("mixed");
//        sb.append('=');
//        sb.append(((this.mixed == null)?"<null>":this.mixed));
//        sb.append(',');
//        sb.append("unknown");
//        sb.append('=');
//        sb.append(((this.unknown == null)?"<null>":this.unknown));
//        sb.append(',');
//        if (sb.charAt((sb.length()- 1)) == ',') {
//            sb.setCharAt((sb.length()- 1), ']');
//        } else {
//            sb.append(']');
//        }
//        return sb.toString();
//    }

}
