package com.punkmkt.rallymaya.models;

/**
 * Created by germanpunk on 24/02/15.
 */
public class Participante {
    private Integer id;
    private String name;
    private String image;
    private String year;
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
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String year) {
        this.order = order;
    }
}
