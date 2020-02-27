package com.walmartassignment.exception;

public class ProductsPageSizeException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2386787693259703202L;

	public ProductsPageSizeException() {
		super();
	}

	public ProductsPageSizeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ProductsPageSizeException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductsPageSizeException(String message) {
		super(message);
	}

	public ProductsPageSizeException(Throwable cause) {
		super(cause);
	}

}
