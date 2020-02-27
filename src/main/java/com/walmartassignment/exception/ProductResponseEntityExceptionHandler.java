package com.walmartassignment.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class ProductResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(ProductResponseEntityExceptionHandler.class);

	@Value("${productservice.errormessage}")
	private String productServiceErrorMsg;

	@Value("${productnotfound.errormessage}")
	private String productNotFoundErrorMsg;

	@Value("${productservicefull.url}")
	private String productServiceUrl;

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleProductsExceptions(Exception ex, WebRequest request) throws Exception {

		if (ex instanceof ProductsPageSizeException) {
			ExceptionResponse response = new ExceptionResponse(productServiceErrorMsg, productServiceUrl, 400);
			logger.error("handleProductsExceptions ");
			return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
		} else {
			ExceptionResponse response = new ExceptionResponse(productNotFoundErrorMsg , productServiceUrl, 400);
			return new ResponseEntity(response, HttpStatus.NOT_FOUND);
		}

	}
}
