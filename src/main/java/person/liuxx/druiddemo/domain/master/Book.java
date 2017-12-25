package person.liuxx.druiddemo.domain.master;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年12月25日 下午2:15:29
 * @since 1.0.0
 */
@Entity
@Table(name = "BOOK")
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "BOOK_NAME")
    private String bookName;
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "PUBLICATION_DATE")
    private LocalDate publicationDate;

    public Book()
    {
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getBookName()
    {
        return bookName;
    }

    public void setBookName(String bookName)
    {
        this.bookName = bookName;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public LocalDate getPublicationDate()
    {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate)
    {
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString()
    {
        return "Book [id=" + id + ", bookName=" + bookName + ", author=" + author
                + ", publicationDate=" + publicationDate + "]";
    }
}
