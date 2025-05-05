package com.example.myclothingshop.models;

import java.io.Serializable;

public class PopularModel implements Serializable {
    String name;
    String description;
    String ratting;
    String discount;
    String type;
    String image_url;

    public PopularModel() {} // Needed for Firestore

    public PopularModel(String name, String description, String ratting, String discount, String type, String image_url) {
        this.name = name;
        this.description = description;
        this.ratting = ratting;
        this.discount = discount;
        this.type = type;
        this.image_url = image_url;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getRatting() { return ratting; }
    public String getDiscount() { return discount; }
    public String getType() { return type; }
    public String getImage_url() { return image_url; }

    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setRatting(String ratting) { this.ratting = ratting; }
    public void setDiscount(String discount) { this.discount = discount; }
    public void setType(String type) { this.type = type; }
    public void setImage_url(String image_url) { this.image_url = image_url; }
}
