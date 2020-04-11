package com.emt.lab1.dao;

import com.emt.lab1.entity.Book;

import java.util.List;

public interface BooksDAO {
    public List<Book>  getBooks();

    public Book getSingleBook(int id);

    public void deleteBook(int id);

    public void updateBook(Book book);

    public void addBook(Book book);


}
