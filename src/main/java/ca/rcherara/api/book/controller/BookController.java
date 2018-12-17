package ca.rcherara.api.book.controller;

import org.springframework.web.bind.annotation.RestController;

import ca.rcherara.api.book.domain.Book;
import ca.rcherara.api.book.service.BookService;
import ca.rcherara.api.book.service.exception.BookAlreadyExistsException;
import io.swagger.annotations.Api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
/**
 * @author rcherara
 *
 */
@RestController
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of Books.")
public class BookController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);
    private final BookService bookService;

    @Autowired
    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST, consumes = {"application/json"})
    @ApiOperation("Creates a new book.")
    public Book saveBook(@RequestBody @Valid final Book book) {
        LOGGER.debug("Received request to create the {}", book);
        return bookService.saveBook(book);
    }

    @ApiOperation(value = "Returns list of all Books in the system.",  responseContainer = "List")
    @RequestMapping(value = "/books", method = RequestMethod.GET, produces = {"application/json"})
    public List<Book> listBooks() {
        LOGGER.debug("Received request to list all books");
        return bookService.getList();
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET, produces = {"application/json"})
    @ApiOperation("Returns a specific book by their identifier. 404 if does not exist.")
    public @ResponseBody
    Book singleBook(@ApiParam("Id of the book to be obtained. Cannot be empty.") @PathVariable Long id) {
        LOGGER.debug("Received request to list a specific book");
        return bookService.getBook(id);
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    @ApiOperation("Deletes a book from the system. 404 if the person's identifier is not found.")
    public void deleteBook(@ApiParam("Id of the book to be deleted. Cannot be empty.") @PathVariable Long id) {
        LOGGER.debug("Received request to delete a specific book");
        bookService.deleteBook(id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleUserAlreadyExistsException(BookAlreadyExistsException e) {
        return e.getMessage();
    }

}
