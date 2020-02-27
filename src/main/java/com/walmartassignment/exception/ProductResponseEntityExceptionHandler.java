package com.walmartassignment.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.walmartassignment.resource.ProductResource;

@ControllerAdvice
@RestController
public class ProductResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	private static final Logger logger = LoggerFactory.getLogger(ProductResponseEntityExceptionHandler.class);
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleProductsExceptions(Exception ex, WebRequest request) throws Exception {

		if (ex instanceof ProductsPageSizeException) {
			ExceptionResponse response = new ExceptionResponse("Invalid page Size, should be between 1 and 20","http://localhost:8080/{pageNumber}/{pageSize}",400);
			logger.error("handleProductsExceptions ");
			return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
		}
		else
		{
			ExceptionResponse response = new ExceptionResponse("products Not Found Exception","http://localhost:8080/walmartproducts/{pageNumber}/{pageSize}",400);
			return new ResponseEntity(response, HttpStatus.NOT_FOUND);
		}
		
	}
}
