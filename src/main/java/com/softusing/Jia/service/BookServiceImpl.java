package com.softusing.Jia.service;

import com.softusing.Jia.entity.myPage;
import com.softusing.Jia.exception.BookNotFoundException;
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
        return bookRepostory.insertSelective(book);
    }

    /**
     * 検査
     *
     * @param id
     * @param id
     * @return public Book findOne(long id) {
     * return bookRepostory.selectByPrimaryKey(id);
     * }
     * <p>
     * /**
     * 削除
     */
    public int delete(long id) {
        return bookRepostory.deleteByPrimaryKey(id);
    }

    public Book findOne(long id) {
        return bookRepostory.selectByPrimaryKey(id);
    }

    public int update(Book book) {
        return bookRepostory.updateByPrimaryKey(book);
    }

    public List<Book> getAll() {
        return bookRepostory.selectByExample(new BookExample());
    }

    @Override
    public List<Book> queryBookByArray(int currPage, int pageSize, myPage myPage) {
        //查询全部数据
        List<Book> books = bookRepostory.queryBookByArray();
        myPage.setTotalPage((int) Math.ceil(books.size() * 1.0 / pageSize));
        //从第几条数据开始
        int firstIndex = (currPage - 1) * pageSize;
        //到第几条数据结束
        int lastIndex;
        if (currPage < myPage.getTotalPage()) {
            lastIndex = currPage * pageSize;
        } else {
            lastIndex = books.size();
        }
        return books.subList(firstIndex, lastIndex); //直接在list中截取
    }


}
