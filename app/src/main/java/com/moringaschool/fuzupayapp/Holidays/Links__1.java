
package com.example.petyfinderip_version2.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
@Generated("jsonschema2pojo")
public class Links__1 {

    @SerializedName("previous")
    @Expose
    private Previous previous;
    @SerializedName("next")
    @Expose
    private Next next;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Links__1() {
    }

    /**
     * 
     * @param next
     * @param previous
     */
    public Links__1(Previous previous, Next next) {
        super();
        this.previous = previous;
        this.next = next;
    }

    public Previous getPrevious() {
        return previous;
    }

    public void setPrevious(Previous previous) {
        this.previous = previous;
    }

    public Next getNext() {
        return next;
    }

    public void setNext(Next next) {
        this.next = next;
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(Links__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
//        sb.append("previous");
//        sb.append('=');
//        sb.append(((this.previous == null)?"<null>":this.previous));
//        sb.append(',');
//        sb.append("next");
//        sb.append('=');
//        sb.append(((this.next == null)?"<null>":this.next));
//        sb.append(',');
//        if (sb.charAt((sb.length()- 1)) == ',') {
//            sb.setCharAt((sb.length()- 1), ']');
//        } else {
//            sb.append(']');
//        }
//        return sb.toString();
//    }

}
