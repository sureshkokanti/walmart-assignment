package com.walmartassignment.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walmartassignment.model.Product;
import com.walmartassignment.model.ProductResponse;

@RestController
@RequestMapping("/walmartproductsfallback")
public class ProductFallBackResource {

	@RequestMapping("/{pageNumber}/{pageSize}")
	public ProductResponse getProducts(@PathVariable("pageNumber") Integer pageNumber,
			@PathVariable("pageSize") Integer pageSize) {

		Product product = new Product();
		product.setProductId("0ff4d723-9973-4450-8f3b-f98bfb8ebd10");
		product.setProductName("SquareTrade 4-Year TV Protection Plan");
		product.setShortDescription(
				"<ul> <li>Protection against mechanical/electrical failures from normal use</li> <li>PLUS members receive an additional 12 months of coverage</li> <li>100% parts &amp; labor, no deductibles</li> <li>On-site service for TVs 37&rdquo; and above, free 2-way shipping for smaller TVs</li> <li>24/7 customer support</li> </ul> ");
		product.setPrice("$49.00");
		product.setProductImage("/images/image7.jpeg");
		product.setReviewRating(0.0);
		product.setReviewCount(0);
		product.setInStock(false);
		List<Product> products = new ArrayList<Product>();
		products.add(product);
		products.add(product);
		return new ProductResponse(products, 2, 1, 2, 200);
	}
}
