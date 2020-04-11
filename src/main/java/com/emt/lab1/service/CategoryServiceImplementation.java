package com.emt.lab1.service;

import com.emt.lab1.dao.CategoryDAO;
import com.emt.lab1.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImplementation implements CategoryService {

    private CategoryDAO categoryDAO;

    @Autowired
    public CategoryServiceImplementation(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    public List<Category> getCategories() {
        return categoryDAO.getCategories();
    }

    @Override
    public Category getSingleCategory(int id) {
        return categoryDAO.getSingleCategory(id);
    }

    @Override
    public void deleteCategory(int id) {
        categoryDAO.deleteCategory(id);
    }

    @Override
    public void updateCategory() {

    }

    @Override
    public void addCategory(Category category) {
        categoryDAO.addCategory(category);
    }
}
