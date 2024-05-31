package br.com.blooddonors.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;
import java.io.Serializable;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RegisteredEmailException extends RuntimeException implements Serializable {


    @Serial
    private static final long serialVersionUID = 1L;

    public RegisteredEmailException(String message) {
	super(message);
    }
}
