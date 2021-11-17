
package com.example.petyfinderip_version2.models;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
@Generated("jsonschema2pojo")
public class Animal {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("organization_id")
    @Expose
    private String organizationId;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("species")
    @Expose
    private String species;
    @SerializedName("breeds")
    @Expose
    private Breeds breeds;
    @SerializedName("age")
    @Expose
    private String age;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("attributes")
    @Expose
    private Attributes attributes;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("photos")
    @Expose
    private List<Photo> photos = null;
    @SerializedName("videos")
    @Expose
    private List<Video> videos = null;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("published_at")
    @Expose
    private String publishedAt;
    @SerializedName("contact")
    @Expose
    private Contact contact;
    @SerializedName("_links")
    @Expose
    private Links links;

    /**
     * No args constructor for use in serialization
     * 
     */
    private String pushId;
    public Animal() {
    }

    /**
     * 
     * @param gender
     * @param publishedAt
     * @param description
     * @param videos
     * @param type
     * @param photos
     * @param url
     * @param breeds
     * @param tags
     * @param organizationId
     * @param size
     * @param species
     * @param contact
     * @param name
     * @param attributes
     * @param links
     * @param id
     * @param age
     * @param status
     */
    public Animal(Integer id, String organizationId, String url, String type, String species, Breeds breeds, String age, String gender, String size, Attributes attributes, List<String> tags, String name, String description, List<Photo> photos, List<Video> videos, String status, String publishedAt, Contact contact, Links links) {
        super();
        this.id = id;
        this.organizationId = organizationId;
        this.url = url;
        this.type = type;
        this.species = species;
        this.breeds = breeds;
        this.age = age;
        this.gender = gender;
        this.size = size;
        this.attributes = attributes;
        this.tags = tags;
        this.name = name;
        this.description = description;
        this.photos = photos;
        this.videos = videos;
        this.status = status;
        this.publishedAt = publishedAt;
        this.contact = contact;
        this.links = links;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Breeds getBreeds() {
        return breeds;
    }

    public void setBreeds(Breeds breeds) {
        this.breeds = breeds;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getPushId(){
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }
    //    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(Animal.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
//        sb.append("id");
//        sb.append('=');
//        sb.append(((this.id == null)?"<null>":this.id));
//        sb.append(',');
//        sb.append("organizationId");
//        sb.append('=');
//        sb.append(((this.organizationId == null)?"<null>":this.organizationId));
//        sb.append(',');
//        sb.append("url");
//        sb.append('=');
//        sb.append(((this.url == null)?"<null>":this.url));
//        sb.append(',');
//        sb.append("type");
//        sb.append('=');
//        sb.append(((this.type == null)?"<null>":this.type));
//        sb.append(',');
//        sb.append("species");
//        sb.append('=');
//        sb.append(((this.species == null)?"<null>":this.species));
//        sb.append(',');
//        sb.append("breeds");
//        sb.append('=');
//        sb.append(((this.breeds == null)?"<null>":this.breeds));
//        sb.append(',');
//        sb.append("age");
//        sb.append('=');
//        sb.append(((this.age == null)?"<null>":this.age));
//        sb.append(',');
//        sb.append("gender");
//        sb.append('=');
//        sb.append(((this.gender == null)?"<null>":this.gender));
//        sb.append(',');
//        sb.append("size");
//        sb.append('=');
//        sb.append(((this.size == null)?"<null>":this.size));
//        sb.append(',');
//        sb.append("attributes");
//        sb.append('=');
//        sb.append(((this.attributes == null)?"<null>":this.attributes));
//        sb.append(',');
//        sb.append("tags");
//        sb.append('=');
//        sb.append(((this.tags == null)?"<null>":this.tags));
//        sb.append(',');
//        sb.append("name");
//        sb.append('=');
//        sb.append(((this.name == null)?"<null>":this.name));
//        sb.append(',');
//        sb.append("description");
//        sb.append('=');
//        sb.append(((this.description == null)?"<null>":this.description));
//        sb.append(',');
//        sb.append("photos");
//        sb.append('=');
//        sb.append(((this.photos == null)?"<null>":this.photos));
//        sb.append(',');
//        sb.append("videos");
//        sb.append('=');
//        sb.append(((this.videos == null)?"<null>":this.videos));
//        sb.append(',');
//        sb.append("status");
//        sb.append('=');
//        sb.append(((this.status == null)?"<null>":this.status));
//        sb.append(',');
//        sb.append("publishedAt");
//        sb.append('=');
//        sb.append(((this.publishedAt == null)?"<null>":this.publishedAt));
//        sb.append(',');
//        sb.append("contact");
//        sb.append('=');
//        sb.append(((this.contact == null)?"<null>":this.contact));
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
