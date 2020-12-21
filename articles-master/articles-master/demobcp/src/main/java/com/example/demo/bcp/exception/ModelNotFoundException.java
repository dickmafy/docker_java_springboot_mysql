package com.example.demo.bcp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModelNotFoundException extends RuntimeException {
   
	private static final long serialVersionUID = 4403577120176228200L;

	public ModelNotFoundException(String mensaje) {
        super(mensaje);
    }

}
