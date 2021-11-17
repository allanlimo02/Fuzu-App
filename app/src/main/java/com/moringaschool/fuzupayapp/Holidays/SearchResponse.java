
package com.example.petyfinderip_version2.models;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
@Generated("jsonschema2pojo")
public class SearchResponse {

    @SerializedName("animals")
    @Expose
    private List<Animal> animals = null;
    @SerializedName("pagination")
    @Expose
    private Pagination pagination;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SearchResponse() {
    }

    /**
     * 
     * @param pagination
     * @param animals
     */
    public SearchResponse(List<Animal> animals, Pagination pagination) {
        super();
        this.animals = animals;
        this.pagination = pagination;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(SearchResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
//        sb.append("animals");
//        sb.append('=');
//        sb.append(((this.animals == null)?"<null>":this.animals));
//        sb.append(',');
//        sb.append("pagination");
//        sb.append('=');
//        sb.append(((this.pagination == null)?"<null>":this.pagination));
//        sb.append(',');
//        if (sb.charAt((sb.length()- 1)) == ',') {
//            sb.setCharAt((sb.length()- 1), ']');
//        } else {
//            sb.append(']');
//        }
//        return sb.toString();
//    }

}
