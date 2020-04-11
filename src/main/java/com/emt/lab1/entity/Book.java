package com.emt.lab1.entity;

import org.springframework.web.multipart.MultipartFile;


import javax.annotation.processing.Generated;
import javax.validation.constraints.Min;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


public class Book {

    private long id;

    @NotNull(message = "*Book name is required")
    @Size(min = 1,message = "*Name is too short")
    private String bookName;

    @NotNull(message = "Samples number is required")
    @Min(value = 0,message = "*You entered a negative number")
    private int samples;

    @NotNull(message = "*Please select a Category")

    private int categoryInt;

   private Category category;

    private MultipartFile img;

    private String imgFileName;

    public Book() {
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Book(long id, String bookName, int samples, Category category,int categoryInt) {
        this.id=id;
        this.bookName = bookName;
        this.samples = samples;
        this.category = category;
        this.categoryInt=categoryInt;



    }

    public String getImgFileName() {
        return imgFileName;
    }
    public void setImgFileName2(String imgFileName) {
        this.imgFileName = imgFileName;
    }
    public void setImgFileName(MultipartFile imgFileName) {
        this.imgFileName = imgFileName.getOriginalFilename();
    }

    public int getCategoryInt() {
        return categoryInt;
    }

    public void setCategoryInt(int categoryInt) {
        this.categoryInt = categoryInt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getSamples() {
        return samples;
    }

    public void setSamples(int samples) {
        this.samples = samples;
    }





    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }
}
