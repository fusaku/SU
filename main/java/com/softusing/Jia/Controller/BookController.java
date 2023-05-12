package com.softusing.Jia.Controller;

import com.softusing.Jia.model.Book;
import com.softusing.Jia.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping("/create")
    public void save(@RequestBody Book book) {
        bookService.save(book);
    }
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        bookService.delete(id);
    }
    @PostMapping("/update")
    public void update(@RequestBody Book book) {
        bookService.update(book);
    }
//    @GetMapping("/select/{id}")
//    public Book getById(@PathVariable("id") Long id) {
//        return bookService.getById(id);
//    }
    @GetMapping("/selectall")
    public List<Book> getAll() {
        return bookService.getAll();
    }
}
