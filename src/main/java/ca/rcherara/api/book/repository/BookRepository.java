package ca.rcherara.api.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.rcherara.api.book.domain.Book;
/**
 * @author rcherara
 *
 */

public interface BookRepository extends JpaRepository<Book, Long> {
}
