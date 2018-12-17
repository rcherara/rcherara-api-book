package ca.rcherara.api.book.controller;

import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import ca.rcherara.api.book.domain.Book;
import ca.rcherara.api.book.service.BookService;
import ca.rcherara.api.book.util.UserUtil;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
/**
 * @author rcherara
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {

    @Mock
    private BookService bookService;

    private BookController bookController;

    @Before
    public void setUp() throws Exception {
        bookController = new BookController(bookService);
    }

    @Test
    public void shouldCreateUser() throws Exception {
        final Book savedBook = stubServiceToReturnStoredBook();
        final Book book = UserUtil.createBook();
        Book returnedBook = bookController.saveBook(book);
        // verify book was passed to BookService
        verify(bookService, times(1)).saveBook(book);
        assertEquals("Returned book should come from the service", savedBook, returnedBook);
    }

    private Book stubServiceToReturnStoredBook() {
        final Book book = UserUtil.createBook();
        when(bookService.saveBook(any(Book.class))).thenReturn(book);
        return book;
    }


    @Test
    public void shouldListAllUsers() throws Exception {
        stubServiceToReturnExistingUsers(10);
        Collection<Book> books = bookController.listBooks();
        assertNotNull(books);
        assertEquals(10, books.size());
        // verify user was passed to BookService
        verify(bookService, times(1)).getList();
    }

    private void stubServiceToReturnExistingUsers(int howMany) {
        when(bookService.getList()).thenReturn(UserUtil.createBookList(howMany));
    }

}
