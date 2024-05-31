package br.com.blooddonors.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;
import java.io.Serializable;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServeException extends RuntimeException implements Serializable {


    @Serial
    private static final long serialVersionUID = 1L;

    public InternalServeException(String message) {
	super(message);
    }
}
