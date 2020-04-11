package com.emt.lab1.dao;

import com.emt.lab1.entity.Book;
import com.emt.lab1.entity.Category;
import com.emt.lab1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@Repository

public class BooksDAOImplementation implements BooksDAO{

    private List<Book> books;

    public BooksDAOImplementation(){
        books=new ArrayList<>();




    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Book getSingleBook(int id) {
        Book book = books.get(id);

        return book;
    }

    @Override
    public void deleteBook(int id) {


        books.remove(id);
    }

    @Override
    public void updateBook(Book book) {



    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }
}
