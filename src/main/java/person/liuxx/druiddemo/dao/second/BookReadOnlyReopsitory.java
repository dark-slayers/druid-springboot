package person.liuxx.druiddemo.dao.second;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import person.liuxx.druiddemo.domain.second.BookReadOnly;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年12月25日 下午2:43:54
 * @since 1.0.0
 */
public interface BookReadOnlyReopsitory extends JpaRepository<BookReadOnly, Long>
{
    Optional<BookReadOnly> findByBookName(String bookName);
}
