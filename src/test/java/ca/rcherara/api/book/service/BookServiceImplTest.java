package ca.rcherara.api.book.service;


import static org.junit.Assert.assertEquals;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import ca.rcherara.api.book.repository.BookRepository;
import ca.rcherara.api.book.service.impl.BookServiceImpl;
 


/**
 * @author rcherara
 *
 */
// TODO : To be completed
@RunWith(MockitoJUnitRunner.class)
public class BookServiceImplTest {
	@Mock
    private BookRepository bookRepository;

     private BookService bookService;

    @Before
	public void before() throws Exception {
		System.out.println("Before");
		bookService = new BookServiceImpl(bookRepository);
		bookService.getList();
 
	}

	@After
	public void after() {
		System.out.println("After");
	}

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Class");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("After Class");
	}


    @Test
    public void EmptyTest() {
    	assertEquals("Skip","Skip");
    }
    

    
  

}
