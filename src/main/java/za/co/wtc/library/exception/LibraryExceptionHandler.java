package za.co.wtc.library.exception;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class LibraryExceptionHandler extends ResponseEntityExceptionHandler {

  private static final Logger logger = LoggerFactory.getLogger(LibraryExceptionHandler.class);

  @ExceptionHandler({RuntimeException.class})
  public ResponseEntity<Object> handleRuntimeException(final RuntimeException ex) {
    logger.error("Runtime Error", ex);
    return new ResponseEntity<>(
        new GenericError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()),
        new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
