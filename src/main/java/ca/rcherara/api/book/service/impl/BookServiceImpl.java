package ca.rcherara.api.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import ca.rcherara.api.book.domain.Book;
import ca.rcherara.api.book.repository.BookRepository;
import ca.rcherara.api.book.service.BookService;
import ca.rcherara.api.book.service.exception.BookAlreadyExistsException;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
/**
 * @author rcherara
 *
 */
@Service
@Validated
public class BookServiceImpl implements BookService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);
    private final BookRepository repository;

    @Autowired
    public BookServiceImpl(final BookRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Book saveBook(@NotNull @Valid final Book book) {
        LOGGER.debug("Creating {}", book);
        Optional<Book> existing = repository.findById(book.getId());
        if (existing == null) {
         //   throw new BookAlreadyExistsException(
         //           String.format("There already exists a book with id=%s", book.getId()));
        }
        return repository.save(book);
        
        
     
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> getList() {
        LOGGER.debug("Retrieving the list of all users");
        return repository.findAll();
    }

    @Override
    public Book getBook(Long bookId) {

    	Optional<Book> existing = repository.findById(bookId);; // returns java8 optional
        if (existing.isPresent()) {
            return existing.get();
        } else {      	
            // handle not found, return null or throw
        	  throw new BookAlreadyExistsException(
                      String.format("Inexistent book with id=%s",bookId));   
        }

    }

    @Override
    @Transactional
    public void deleteBook(final Long bookId) {
        LOGGER.debug("deleting {}", bookId);
        repository.deleteById(bookId);
    }

}
