
package com.moringaschool.fuzupayapp.Holidays;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Weekday {

    @SerializedName("date")
    @Expose
    private Date date;
    @SerializedName("observed")
    @Expose
    private Observed observed;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Weekday() {
    }

    /**
     * 
     * @param date
     * @param observed
     */
    public Weekday(Date date, Observed observed) {
        super();
        this.date = date;
        this.observed = observed;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Observed getObserved() {
        return observed;
    }

    public void setObserved(Observed observed) {
        this.observed = observed;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Weekday.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("date");
        sb.append('=');
        sb.append(((this.date == null)?"<null>":this.date));
        sb.append(',');
        sb.append("observed");
        sb.append('=');
        sb.append(((this.observed == null)?"<null>":this.observed));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
