package com.softusing.Jia.web;

import com.softusing.Jia.entity.myPage;
import com.softusing.Jia.exception.BookNotFoundException;
import com.softusing.Jia.model.Book;
import com.softusing.Jia.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController1 {
    @Autowired
    private BookService bookService;

//    @GetMapping("/books")
//    public String list() {
//        return "books";
//    }

    @GetMapping("/books/{id}")
    public String detail(@PathVariable long id, Model model) {

        Book book = bookService.findOne(id);
        if (book == null) {
            throw new BookNotFoundException("书单信息不存在");

        }
        model.addAttribute("book", book);
        return "book";
    }

//    @GetMapping("/books")
//    public String list(Model model) {
//        List<Book> book = bookService.getAll();
//        model.addAttribute("book", book);
//        return "books";
//    }

    /**
     * 跳转input提交页面
     *
     * @param model
     * @return
     */
    @GetMapping("/books/input")
    public String inputPage(Model model) {
        model.addAttribute("book", new Book());
        return "input";
    }

    /**
     * 跳转到更新页面input
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/books/{id}/input")
    public String inputEditPage(@PathVariable long id, Model model) {
        Book book = bookService.findOne(id);
        model.addAttribute("book", book);
        return "input";
    }

    @PostMapping("/books")
    public String post(Book book, final RedirectAttributes attributes) {
        if (book.getId() == null) {
            attributes.addFlashAttribute("message", "<" + book.getName() + ">信息提交成功");
            bookService.save(book);
        }
        attributes.addFlashAttribute("message", "<" + book.getName() + ">信息提交成功");
        bookService.update(book);
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String getBootByArray(@RequestParam(defaultValue = "1") int currPage,
                                 @RequestParam(defaultValue = "3") int pageSize,
                                 myPage myPage,
                                 Model model) {
        List<Book> books = bookService.queryBookByArray(currPage, pageSize,myPage);
        model.addAttribute("books", books);
        myPage.setThisPage(currPage);
        myPage.setPageSize(pageSize);
        model.addAttribute("page",myPage);
        return "books";
    }

}
