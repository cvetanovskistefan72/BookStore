package com.emt.lab1.entity;

public class Category {

    private long id;

    private String categoryName;

    private String categoryDetails;

    public Category() {

    }

    public Category(long id, String categoryName, String categoryDetails) {
        this.id=id;
        this.categoryName = categoryName;
        this.categoryDetails = categoryDetails;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDetails() {
        return categoryDetails;
    }

    public void setCategoryDetails(String categoryDetails) {
        this.categoryDetails = categoryDetails;
    }
}
