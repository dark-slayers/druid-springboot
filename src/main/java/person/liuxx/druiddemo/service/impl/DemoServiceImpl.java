package person.liuxx.druiddemo.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import person.liuxx.druiddemo.dao.master.BookReopsitory;
import person.liuxx.druiddemo.dao.second.BookReadOnlyReopsitory;
import person.liuxx.druiddemo.domain.master.Book;
import person.liuxx.druiddemo.domain.second.BookReadOnly;
import person.liuxx.druiddemo.service.DemoService;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年12月25日 下午2:47:46
 * @since 1.0.0
 */
@Service
public class DemoServiceImpl implements DemoService
{
    private Logger log = LoggerFactory.getLogger(DemoServiceImpl.class);
    @Autowired
    private BookReopsitory bookDao1;
    @Autowired
    private BookReadOnlyReopsitory bookDao2;

    @Override
    public String demo()
    {
        List<Book> bookList = bookDao1.findAll();
        if (bookList.size() < 1)
        {
            log.info("数据库没有数据，创建新的DEMO数据");
            Book book = new Book();
            book.setBookName("Effective Java");
            book.setAuthor("Joshua Bloch");
            book.setPublicationDate(LocalDate.of(2015, 10, 1));
            log.info("创建Book：{}", book);
            bookDao1.save(book);
            log.info("添加Book：{}", book);
        }
        bookList = bookDao1.findAll();
        for (Book book : bookList)
        {
            Optional<BookReadOnly> bookOptional = bookDao2.findByBookName(book.getBookName());
            if (!bookOptional.isPresent())
            {
                BookReadOnly b = mapBook(book);
                bookDao2.save(b);
            }
        }
        List<BookReadOnly> bookList2 = bookDao2.findAll();
        return bookList2.toString();
    }

    private BookReadOnly mapBook(Book book)
    {
        log.info("使用Book对象{}创建BookReadOnly对象", book);
        BookReadOnly b = new BookReadOnly();
        BeanUtils.copyProperties(book, b);
        b.setId(null);
        return b;
    }
}
