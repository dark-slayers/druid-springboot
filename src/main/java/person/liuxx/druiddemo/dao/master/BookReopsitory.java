package person.liuxx.druiddemo.dao.master;

import org.springframework.data.jpa.repository.JpaRepository;

import person.liuxx.druiddemo.domain.master.Book;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年12月25日 下午2:43:54
 * @since 1.0.0
 */
public interface BookReopsitory extends JpaRepository<Book, Long>
{
}
