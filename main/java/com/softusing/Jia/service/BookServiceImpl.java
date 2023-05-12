package com.softusing.Jia.service;

import com.softusing.Jia.mapper.BookMapper;
import com.softusing.Jia.model.Book;
import com.softusing.Jia.model.BookExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookRepostory;

    /**
     * 查询所以的书单列表
     */
    public List<Book> findAll() {
        return bookRepostory.selectByExample(new BookExample());
    }

    /**
     * 新增一个书单信息
     *
     * @param book
     * @return
     */
    public int save(Book book) {
        return bookRepostory.updateByPrimaryKeySelective(book);
    }

    /**
     * 検査
     * @param id
     * @return

    public Book findOne(long id) {
        return bookRepostory.selectByPrimaryKey(id);
    }

    /**
     * 削除
     *
     * @param id
     */
    public int delete(long id) {
        return bookRepostory.deleteByPrimaryKey(id);
    }

    public Book findOne(long id){
        return bookRepostory.selectByPrimaryKey(id);
    }

    public int update(Book book){
        return bookRepostory.updateByPrimaryKey(book);
    }

    public List<Book> getAll(){
        return bookRepostory.selectByExample(new BookExample());
    }
}
