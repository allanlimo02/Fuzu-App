
package com.moringaschool.fuzupayapp.Holidays;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class HolidayResponses {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("observed")
    @Expose
    private String observed;
    @SerializedName("public")
    @Expose
    private Boolean _public;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("uuid")
    @Expose
    private String uuid;
    @SerializedName("weekday")
    @Expose
    private Weekday weekday;

    /**
     * No args constructor for use in serialization
     * 
     */
    public HolidayResponses() {
    }

    /**
     * 
     * @param date
     * @param country
     * @param _public
     * @param name
     * @param weekday
     * @param uuid
     * @param observed
     */
    public HolidayResponses(String name, String date, String observed, Boolean _public, String country, String uuid, Weekday weekday) {
        super();
        this.name = name;
        this.date = date;
        this.observed = observed;
        this._public = _public;
        this.country = country;
        this.uuid = uuid;
        this.weekday = weekday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getObserved() {
        return observed;
    }

    public void setObserved(String observed) {
        this.observed = observed;
    }

    public Boolean getPublic() {
        return _public;
    }

    public void setPublic(Boolean _public) {
        this._public = _public;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Weekday getWeekday() {
        return weekday;
    }

    public void setWeekday(Weekday weekday) {
        this.weekday = weekday;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(HolidayResponses.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("date");
        sb.append('=');
        sb.append(((this.date == null)?"<null>":this.date));
        sb.append(',');
        sb.append("observed");
        sb.append('=');
        sb.append(((this.observed == null)?"<null>":this.observed));
        sb.append(',');
        sb.append("_public");
        sb.append('=');
        sb.append(((this._public == null)?"<null>":this._public));
        sb.append(',');
        sb.append("country");
        sb.append('=');
        sb.append(((this.country == null)?"<null>":this.country));
        sb.append(',');
        sb.append("uuid");
        sb.append('=');
        sb.append(((this.uuid == null)?"<null>":this.uuid));
        sb.append(',');
        sb.append("weekday");
        sb.append('=');
        sb.append(((this.weekday == null)?"<null>":this.weekday));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
