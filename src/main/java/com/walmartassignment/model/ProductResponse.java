package com.walmartassignment.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Product> products;
	private Integer totalProducts;
	private Integer pageNumber;
	private Integer pageSize;
	private Integer statusCode;
	
	public ProductResponse() {
		super();
	}
	public ProductResponse(List<Product> products, Integer totalProducts, Integer pageNumber, Integer pageSize,
			Integer statusCode) {
		super();
		this.products = products;
		this.totalProducts = totalProducts;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.statusCode = statusCode;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Integer getTotalProducts() {
		return totalProducts;
	}
	public void setTotalProducts(Integer totalProducts) {
		this.totalProducts = totalProducts;
	}
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pageNumber == null) ? 0 : pageNumber.hashCode());
		result = prime * result + ((pageSize == null) ? 0 : pageSize.hashCode());
		result = prime * result + ((products == null) ? 0 : products.hashCode());
		result = prime * result + ((statusCode == null) ? 0 : statusCode.hashCode());
		result = prime * result + ((totalProducts == null) ? 0 : totalProducts.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductResponse other = (ProductResponse) obj;
		if (pageNumber == null) {
			if (other.pageNumber != null)
				return false;
		} else if (!pageNumber.equals(other.pageNumber))
			return false;
		if (pageSize == null) {
			if (other.pageSize != null)
				return false;
		} else if (!pageSize.equals(other.pageSize))
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		if (statusCode == null) {
			if (other.statusCode != null)
				return false;
		} else if (!statusCode.equals(other.statusCode))
			return false;
		if (totalProducts == null) {
			if (other.totalProducts != null)
				return false;
		} else if (!totalProducts.equals(other.totalProducts))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Products=" + products + ", totalProducts=" + totalProducts + ", pageNumber=" + pageNumber
				+ ", pageSize=" + pageSize + ", statusCode=" + statusCode + "]";
	}
	
}
