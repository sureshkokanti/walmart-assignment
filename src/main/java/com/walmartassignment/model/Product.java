package com.walmartassignment.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class Product implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2773153570020899193L;
	
	private String productId;
	private String productName;
	private String shortDescription;
	private String longDescription;
	private String price;
	private String productImage;
	private Double reviewRating;
	private Integer reviewCount;
	private Boolean inStock;
	
	public Product() {
		super();
	}
	public Product(String productId, String productName, String shortDescription, String longDescription, String price,
			String productImage, Double reviewRating, Integer reviewCount, Boolean inStock) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.price = price;
		this.productImage = productImage;
		this.reviewRating = reviewRating;
		this.reviewCount = reviewCount;
		this.inStock = inStock;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getLongDescription() {
		return longDescription;
	}
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public Double getReviewRating() {
		return reviewRating;
	}
	public void setReviewRating(Double reviewRating) {
		this.reviewRating = reviewRating;
	}
	public Integer getReviewCount() {
		return reviewCount;
	}
	public void setReviewCount(Integer reviewCount) {
		this.reviewCount = reviewCount;
	}
	public Boolean getInStock() {
		return inStock;
	}
	public void setInStock(Boolean inStock) {
		this.inStock = inStock;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inStock == null) ? 0 : inStock.hashCode());
		result = prime * result + ((longDescription == null) ? 0 : longDescription.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productImage == null) ? 0 : productImage.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((reviewCount == null) ? 0 : reviewCount.hashCode());
		result = prime * result + ((reviewRating == null) ? 0 : reviewRating.hashCode());
		result = prime * result + ((shortDescription == null) ? 0 : shortDescription.hashCode());
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
		Product other = (Product) obj;
		if (inStock == null) {
			if (other.inStock != null)
				return false;
		} else if (!inStock.equals(other.inStock))
			return false;
		if (longDescription == null) {
			if (other.longDescription != null)
				return false;
		} else if (!longDescription.equals(other.longDescription))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productImage == null) {
			if (other.productImage != null)
				return false;
		} else if (!productImage.equals(other.productImage))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (reviewCount == null) {
			if (other.reviewCount != null)
				return false;
		} else if (!reviewCount.equals(other.reviewCount))
			return false;
		if (reviewRating == null) {
			if (other.reviewRating != null)
				return false;
		} else if (!reviewRating.equals(other.reviewRating))
			return false;
		if (shortDescription == null) {
			if (other.shortDescription != null)
				return false;
		} else if (!shortDescription.equals(other.shortDescription))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "productId=" + productId + ", productName=" + productName + ", shortDescription="
				+ shortDescription + ", longDescription=" + longDescription + ", price=" + price + ", productImage="
				+ productImage + ", reviewRating=" + reviewRating + ", reviewCount=" + reviewCount + ", inStock="
				+ inStock + "]";
	}
	
}
