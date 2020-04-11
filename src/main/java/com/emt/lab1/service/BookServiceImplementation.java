package com.emt.lab1.service;

import com.emt.lab1.dao.BooksDAO;
import com.emt.lab1.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImplementation implements BookService {

    private BooksDAO booksDAO;

    @Autowired
    public BookServiceImplementation(BooksDAO booksDAO) {
        this.booksDAO = booksDAO;
    }

    @Override
    public List<Book> getBooks() {
        return booksDAO.getBooks();
    }

    @Override
    public Book getSingleBook(int id) {
        return booksDAO.getSingleBook(id);
    }

    @Override
    public void deleteBook(int id) {
        booksDAO.deleteBook(id);
    }

    @Override
    public void updateBook(Book book) {
    booksDAO.updateBook(book);
    }

    @Override
    public void addBook(Book book) {
        booksDAO.addBook(book);
    }
}
