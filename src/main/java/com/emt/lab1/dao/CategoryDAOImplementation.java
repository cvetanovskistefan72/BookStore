package com.emt.lab1.dao;

import com.emt.lab1.entity.Book;
import com.emt.lab1.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



@Repository
public class CategoryDAOImplementation implements CategoryDAO {

    private List<Category> categories;

    public CategoryDAOImplementation(){
        categories = new ArrayList<>();



    }


    @Override
    public List<Category> getCategories() {
        return categories;
    }

    @Override
    public Category getSingleCategory(int id) {
        Category category = categories.get(id);
        return  category;
    }

    @Override
    public void deleteCategory(int id) {
        categories.remove(id);
    }

    @Override
    public void updateCategory() {

    }

    @Override
    public void addCategory(Category category) {
        categories.add(category);
    }
}
