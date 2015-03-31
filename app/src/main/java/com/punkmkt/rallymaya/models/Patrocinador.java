package com.punkmkt.rallymaya.models;

/**
 * Created by germanpunk on 05/03/15.
 */
public class Patrocinador {
    private Integer id;
    private String name;
    private String image;
    private String link;
    private String order;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String year) {
        this.order = order;
    }
}