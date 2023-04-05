package my.goldgshok.life_tree.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.goldgshok.life_tree.exception.ValidateException;
import my.goldgshok.life_tree.infrastructure.LocaleProvider;
import org.postgresql.util.PSQLException;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalControllerExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleRuntime(RuntimeException e) {
        log.error("Some thing wrong: ", e);
        return ResponseEntity
                .badRequest()
                .contentType(MediaType.APPLICATION_JSON)
                .build();
    }

    @ExceptionHandler({ DataAccessException.class, PSQLException.class})
    protected ResponseEntity<Object> handleDataAccess(DataAccessException e) {
        log.error("Database error occurred. ", e);
        return ResponseEntity
                .internalServerError()
                .contentType(MediaType.APPLICATION_JSON)
                .build();
    }

    @ExceptionHandler(ValidateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleValidateException(ValidateException e) {
        log.error("Some thing wrong: ", e);
        var message = messageSource.getMessage(e.getErrorCode(), e.getArgs(), LocaleProvider.getLocale());
        return ResponseEntity
                .badRequest()
                .contentType(MediaType.APPLICATION_JSON)
                .body(message);
    }
}