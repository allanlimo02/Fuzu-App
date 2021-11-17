
package com.example.petyfinderip_version2.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
@Generated("jsonschema2pojo")
public class Attributes {

    @SerializedName("spayed_neutered")
    @Expose
    private Boolean spayedNeutered;
    @SerializedName("house_trained")
    @Expose
    private Boolean houseTrained;
    @SerializedName("special_needs")
    @Expose
    private Boolean specialNeeds;
    @SerializedName("shots_current")
    @Expose
    private Boolean shotsCurrent;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Attributes() {
    }

    /**
     * 
     * @param houseTrained
     * @param shotsCurrent
     * @param spayedNeutered
     * @param specialNeeds
     */
    public Attributes(Boolean spayedNeutered, Boolean houseTrained, Boolean specialNeeds, Boolean shotsCurrent) {
        super();
        this.spayedNeutered = spayedNeutered;
        this.houseTrained = houseTrained;
        this.specialNeeds = specialNeeds;
        this.shotsCurrent = shotsCurrent;
    }

    public Boolean getSpayedNeutered() {
        return spayedNeutered;
    }

    public void setSpayedNeutered(Boolean spayedNeutered) {
        this.spayedNeutered = spayedNeutered;
    }

    public Boolean getHouseTrained() {
        return houseTrained;
    }

    public void setHouseTrained(Boolean houseTrained) {
        this.houseTrained = houseTrained;
    }

    public Boolean getSpecialNeeds() {
        return specialNeeds;
    }

    public void setSpecialNeeds(Boolean specialNeeds) {
        this.specialNeeds = specialNeeds;
    }

    public Boolean getShotsCurrent() {
        return shotsCurrent;
    }

    public void setShotsCurrent(Boolean shotsCurrent) {
        this.shotsCurrent = shotsCurrent;
    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(Attributes.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
//        sb.append("spayedNeutered");
//        sb.append('=');
//        sb.append(((this.spayedNeutered == null)?"<null>":this.spayedNeutered));
//        sb.append(',');
//        sb.append("houseTrained");
//        sb.append('=');
//        sb.append(((this.houseTrained == null)?"<null>":this.houseTrained));
//        sb.append(',');
//        sb.append("specialNeeds");
//        sb.append('=');
//        sb.append(((this.specialNeeds == null)?"<null>":this.specialNeeds));
//        sb.append(',');
//        sb.append("shotsCurrent");
//        sb.append('=');
//        sb.append(((this.shotsCurrent == null)?"<null>":this.shotsCurrent));
//        sb.append(',');
//        if (sb.charAt((sb.length()- 1)) == ',') {
//            sb.setCharAt((sb.length()- 1), ']');
//        } else {
//            sb.append(']');
//        }
//        return sb.toString();
//    }

}
