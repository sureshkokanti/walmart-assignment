package com.walmartassignment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.walmartassignment.exception.ProductsPageSizeException;
import com.walmartassignment.model.ProductResponse;
import com.walmartassignment.resource.ProductResource;

@Service
public class ProductService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${productservice.url}")
	private String productServiceUrl;

	@Value("${fallbackurl.url}")
	private String fallBackUrl;

	private static final Logger logger = LoggerFactory.getLogger(ProductResource.class);

	@Autowired
	RestTemplate template;

	public ProductService() {
	}

	public ProductResponse getProducts(Integer pageNumber, Integer pageSize) {
		logger.debug("getProducts");
		ProductResponse products = restTemplate.getForObject(productServiceUrl + "/" + pageNumber + "/" + pageSize,
				ProductResponse.class);
		return products;

	}

	public ProductResponse getProduct(Integer pageNumber, Integer pageSize) {

		if (pageSize > 20)
			throw new ProductsPageSizeException();

		logger.debug("getProduct");
		ProductResponse products = restTemplate.getForObject(productServiceUrl + "/" + pageNumber + "/" + pageSize,
				ProductResponse.class);
		return products;

	}

	public ProductResponse getProductsFallBack(Integer pageNumber, Integer pageSize) {

		logger.debug("fallbackMethod getProductsFallBack");

		ProductResponse products = restTemplate.getForObject(fallBackUrl + "/" + pageNumber + "/" + pageSize,
				ProductResponse.class);
		return products;
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
