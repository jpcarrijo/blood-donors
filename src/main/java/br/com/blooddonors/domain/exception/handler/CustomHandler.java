package br.com.blooddonors.domain.exception.handler;

import br.com.blooddonors.domain.exception.InternalServeException;
import br.com.blooddonors.domain.exception.RegisteredDonorException;
import br.com.blooddonors.domain.exception.RegisteredEmailException;
import br.com.blooddonors.domain.exception.details.ExceptionDetails;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomHandler {


    @ExceptionHandler(value = RegisteredEmailException.class)
    public ResponseEntity<ExceptionDetails> registeredUserException(RegisteredEmailException e,
								    HttpServletRequest req) {
	LocalDateTime date = LocalDateTime.now();
	ExceptionDetails details = new ExceptionDetails(
	    date.toString(),
	    HttpStatus.BAD_REQUEST.value(),
	    e.getMessage(),
	    req.getServletPath()
	);
	return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = RegisteredDonorException.class)
    public ResponseEntity<ExceptionDetails> registeredUserException(RegisteredDonorException e,
								    HttpServletRequest req) {
	LocalDateTime date = LocalDateTime.now();
	ExceptionDetails details = new ExceptionDetails(
	    date.toString(),
	    HttpStatus.BAD_REQUEST.value(),
	    e.getMessage(),
	    req.getServletPath()
	);
	return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = InternalServeException.class)
    public ResponseEntity<ExceptionDetails> registeredUserException(InternalServeException e,
								    HttpServletRequest req) {
	LocalDateTime date = LocalDateTime.now();
	ExceptionDetails details = new ExceptionDetails(
	    date.toString(),
	    HttpStatus.BAD_REQUEST.value(),
	    e.getMessage(),
	    req.getServletPath()
	);
	return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
