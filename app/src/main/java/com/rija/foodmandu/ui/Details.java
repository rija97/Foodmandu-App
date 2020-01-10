package com.rija.foodmandu.ui;

public class Details {
    public String name;
    public  String location;
    public String image;
    public String itemtype;

    public Details(String name, String location, String image, String itemtype) {
        this.name = name;
        this.location = location;
        this.image = image;
        this.itemtype = itemtype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }


    public void setImage(String image) {
        this.image = image;
    }

    public String getItemtype() {
        return itemtype;
    }

    public void setItemtype(String itemtype) {
        this.itemtype = itemtype;
    }
}
