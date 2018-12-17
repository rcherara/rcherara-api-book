package ca.rcherara.api.book.service;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import ca.rcherara.api.book.domain.Book;

import java.util.List;

/**
 * @author rcherara
 *
 */
public interface BookService {

    Book saveBook(@NotNull @Valid final Book book);

    List<Book> getList();

    Book getBook(Long bookId);

    void deleteBook(final Long bookId);
}