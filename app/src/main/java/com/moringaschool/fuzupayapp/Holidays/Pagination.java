
package com.example.petyfinderip_version2.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
@Generated("jsonschema2pojo")
public class Pagination {

    @SerializedName("count_per_page")
    @Expose
    private Integer countPerPage;
    @SerializedName("total_count")
    @Expose
    private Integer totalCount;
    @SerializedName("current_page")
    @Expose
    private Integer currentPage;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("_links")
    @Expose
    private Links__1 links;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Pagination() {
    }

    /**
     * 
     * @param countPerPage
     * @param totalPages
     * @param links
     * @param totalCount
     * @param currentPage
     */
    public Pagination(Integer countPerPage, Integer totalCount, Integer currentPage, Integer totalPages, Links__1 links) {
        super();
        this.countPerPage = countPerPage;
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.links = links;
    }

    public Integer getCountPerPage() {
        return countPerPage;
    }

    public void setCountPerPage(Integer countPerPage) {
        this.countPerPage = countPerPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Links__1 getLinks() {
        return links;
    }

    public void setLinks(Links__1 links) {
        this.links = links;
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(Pagination.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
//        sb.append("countPerPage");
//        sb.append('=');
//        sb.append(((this.countPerPage == null)?"<null>":this.countPerPage));
//        sb.append(',');
//        sb.append("totalCount");
//        sb.append('=');
//        sb.append(((this.totalCount == null)?"<null>":this.totalCount));
//        sb.append(',');
//        sb.append("currentPage");
//        sb.append('=');
//        sb.append(((this.currentPage == null)?"<null>":this.currentPage));
//        sb.append(',');
//        sb.append("totalPages");
//        sb.append('=');
//        sb.append(((this.totalPages == null)?"<null>":this.totalPages));
//        sb.append(',');
//        sb.append("links");
//        sb.append('=');
//        sb.append(((this.links == null)?"<null>":this.links));
//        sb.append(',');
//        if (sb.charAt((sb.length()- 1)) == ',') {
//            sb.setCharAt((sb.length()- 1), ']');
//        } else {
//            sb.append(']');
//        }
//        return sb.toString();
//    }

}
