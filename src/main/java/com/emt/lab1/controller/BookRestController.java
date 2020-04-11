package com.emt.lab1.controller;


import com.emt.lab1.entity.Book;
import com.emt.lab1.entity.Category;
import com.emt.lab1.service.BookService;
import com.emt.lab1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/")
public class BookRestController {

    Random random;
    public BookService bookService;
    public CategoryService categoryService;
    String path;
    Category category;
    @Autowired
    public BookRestController(BookService bookService, CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService=categoryService;
        random= new Random();

    }
    @PostConstruct
    public void setCategoriesInBooks(){
         category = new Category(0,"Mystery",
                "Mystery fiction is a genre of fiction usually" +
                        " involving a mysterious death or a crime to be solved.");



        Category category2 = new Category(1,"Thriller",
                "Thriller is a genre of fiction, having numerous, often overlapping subgenres. " +
                        "Thrillers are characterized and defined by the moods they elicit.");
        categoryService.addCategory(category);
        categoryService.addCategory(category2);


        Book book=new Book(0,"Angels & Demons",5,category,0);
        Book book2=new Book(1,"The Da Vinci Code",6,category2,1) ;
        Book book3=new Book(2,"Inferno",10,category,0);
        book.setImgFileName2("angels.jpg");
        book2.setImgFileName2("davinci.jpg");
        book3.setImgFileName2("inferno.jpg");

        bookService.addBook(book);
        bookService.addBook(book2);
        bookService.addBook(book3);

        Path resourceDirectory = Paths.get("src","main","resources","static");

        path = resourceDirectory.toFile().getAbsolutePath();

        System.out.println(path);
    }

    @InitBinder
    public void  initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @GetMapping("/booksForm")
    public String booksForm(Model model){
        Book book=new Book();
        List<Category>categories = categoryService.getCategories();
        model.addAttribute("book",book);
        model.addAttribute("categories",categories);
        return "/books-new";
    }


    @GetMapping("/books")
    public String getBooks(Model model){
        List<Book> books = bookService.getBooks();

        model.addAttribute("books",books);
        return "/books";
    }
    @GetMapping("/books/edit/{id}")
    public String getBook(@PathVariable("id") int id,Model model){
        List<Category>categories = categoryService.getCategories();

        model.addAttribute("categories",categories);
         Book book= bookService.getSingleBook(id);
        model.addAttribute("book",book);
        model.addAttribute("categories",categories);
        return "/books-old";
    }



    @PostMapping("/books/save")
    public String addBook(@Valid @ModelAttribute("book")  Book book,BindingResult bindingResult) throws IOException {

        if (bindingResult.hasErrors()) {
            return "/books-new";
        }
        else{
            if(book.getImg()!=null){

                MultipartFile multipartFile=book.getImg();
                byte[] bytes = multipartFile.getBytes();

                Path path2  = Paths.get(path+"/"+multipartFile.getOriginalFilename());
                Files.write(path2,bytes);

                book.setImgFileName2(multipartFile.getOriginalFilename());



            }
            book.setId(bookService.getBooks().size());
            book.setCategory( categoryService.getSingleCategory(book.getCategoryInt()));
            bookService.addBook(book);
            return "redirect:/books";
        }


    }
    @PostMapping("/books/edit")
    public String updateBook(@Valid @ModelAttribute("book")  Book book,BindingResult bindingResult) throws IOException {

        if(bindingResult.hasErrors()){
            return "/books-old";
        }else{
            Book book1=bookService.getSingleBook((int) book.getId());




            book1.setCategory( categoryService.getSingleCategory(book.getCategoryInt()));
            book1.setBookName(book.getBookName());
            book1.setSamples(book.getSamples());
        }

        return "redirect:/books";
    }
    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable("id") int id){
        bookService.deleteBook(id);
        return "redirect:/books";
    }



}
