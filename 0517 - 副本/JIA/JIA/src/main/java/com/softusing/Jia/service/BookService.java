package com.softusing.Jia.service;

import com.softusing.Jia.entity.myPage;
import com.softusing.Jia.model.Book;

import java.util.List;

public interface BookService {

    Book findOne(long id);

    int save(Book book);

    int delete(long id);

    int update(Book book);

    List<Book> getAll();
    List<Book> queryBookByArray(int currPage, int pageSize, myPage myPage);
}
