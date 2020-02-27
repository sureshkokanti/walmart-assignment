package com.walmartassignment.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.walmartassignment.exception.ProductsPageSizeException;
import com.walmartassignment.model.ProductResponse;

@RestController
@RequestMapping("/walmartproducts")
public class ProductResource {

	@Autowired
	private RestTemplate restTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductResource.class);

	@RequestMapping("/{pageNumber}/{pageSize}")
	@HystrixCommand(fallbackMethod = "getProductsFallBack")
	public ProductResponse getProducts(@PathVariable("pageNumber") Integer pageNumber,
			@PathVariable("pageSize") Integer pageSize) {
		
		logger.debug("Class ProductResource Method getProducts");
		ProductResponse products = restTemplate.getForObject(
				"https://mobile-tha-server-8ba57.firebaseapp.com/walmartproducts/" + pageNumber + "/" + pageSize,
				ProductResponse.class);
		return products;

	}

	@RequestMapping("exception/{pageNumber}/{pageSize}")
	public ProductResponse getProduct(@PathVariable("pageNumber") Integer pageNumber,
			@PathVariable("pageSize") Integer pageSize) {

		if (pageSize > 20)
			throw new ProductsPageSizeException();
		
		logger.debug("getProduct");
		ProductResponse products = restTemplate.getForObject(
				"https://mobile-tha-server-8ba57.firebaseapp.com/walmartproducts/" + pageNumber + "/" + pageSize,
				ProductResponse.class);
		return products;

	}

	public ProductResponse getProductsFallBack(Integer pageNumber, Integer pageSize) {

		logger.debug("fallbackMethod getProductsFallBack");
		
		ProductResponse products = restTemplate.getForObject(
				"http://localhost:8080/walmartproductsfallback/" + pageNumber + "/" + pageSize,
				ProductResponse.class);
		return products;
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
