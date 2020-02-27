package com.walmartassignment.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.walmartassignment.exception.ProductsPageSizeException;
import com.walmartassignment.model.ProductResponse;
import com.walmartassignment.service.ProductService;

@RestController
@RequestMapping("/walmartproducts")
public class ProductResource {

	private static final Logger logger = LoggerFactory.getLogger(ProductResource.class);

	@Autowired
	private ProductService productService;

	@RequestMapping("/{pageNumber}/{pageSize}")
	@HystrixCommand(fallbackMethod = "getProductsFallBack")
	public ProductResponse getProducts(@PathVariable("pageNumber") Integer pageNumber,
			@PathVariable("pageSize") Integer pageSize) {

		logger.debug("getProducts");
		return productService.getProducts(pageNumber, pageSize);

	}

	@RequestMapping("exception/{pageNumber}/{pageSize}")
	public ProductResponse getProduct(@PathVariable("pageNumber") Integer pageNumber,
			@PathVariable("pageSize") Integer pageSize) {

		if (pageSize > 20)
			throw new ProductsPageSizeException();

		logger.debug("getProduct");
		return productService.getProduct(pageNumber, pageSize);

	}

	public ProductResponse getProductsFallBack(Integer pageNumber, Integer pageSize) {

		logger.debug("fallbackMethod getProductsFallBack");
		return productService.getProductsFallBack(pageNumber, pageSize);
	}
}
