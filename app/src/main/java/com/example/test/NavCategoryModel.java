package com.example.test;

public class NavCategoryModel {
    String image;
    String title;
    String price;

    public NavCategoryModel() {
    }

    public NavCategoryModel(String image, String title, String price) {
        this.image = image;
        this.title = title;
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
