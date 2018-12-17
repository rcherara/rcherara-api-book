package ca.rcherara.api.book.service.exception;

/**
 * @author rcherara
 *
 */

@SuppressWarnings("serial")
public class BookAlreadyExistsException extends RuntimeException {

    public BookAlreadyExistsException(final String message) {
        super(message);
    }
}
