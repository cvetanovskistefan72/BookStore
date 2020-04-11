package com.emt.lab1.service;

import com.emt.lab1.entity.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> getCategories();

    public Category getSingleCategory(int id);

    public void deleteCategory(int id);

    public void updateCategory();

    public void addCategory(Category category);
}
