
package com.moringaschool.fuzupayapp.Holidays;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Observed {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("numeric")
    @Expose
    private String numeric;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Observed() {
    }

    /**
     * 
     * @param name
     * @param numeric
     */
    public Observed(String name, String numeric) {
        super();
        this.name = name;
        this.numeric = numeric;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumeric() {
        return numeric;
    }

    public void setNumeric(String numeric) {
        this.numeric = numeric;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Observed.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("numeric");
        sb.append('=');
        sb.append(((this.numeric == null)?"<null>":this.numeric));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
