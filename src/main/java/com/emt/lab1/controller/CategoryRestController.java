package com.emt.lab1.controller;


import com.emt.lab1.entity.Book;
import com.emt.lab1.entity.Category;
import com.emt.lab1.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class CategoryRestController {

    private CategoryService categoryService;
    Random random;


    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
        random = new Random();
    }

    @PostConstruct
    public void addCategories(){
    Category category = new Category(2,"Romance","In the strictest academic terms," +
            " a romance is a narrative genre in literature that involves a mysterious, adventurous");

    categoryService.addCategory(category);

    }

    @GetMapping("/categories")
    public List<Category> getCategories(){

        return categoryService.getCategories();

    }

    @GetMapping("/categories/{id}")
    public Category getBook(@PathVariable("id") int id){

        return categoryService.getSingleCategory(id);
    }

    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@PathVariable("id") int id){
        categoryService.deleteCategory(id);
    }
    @PostMapping("/categories")
    public void addBook(@RequestBody  Category category){
        category.setId(categoryService.getCategories().size()+1);
        categoryService.addCategory(category);
    }
}
