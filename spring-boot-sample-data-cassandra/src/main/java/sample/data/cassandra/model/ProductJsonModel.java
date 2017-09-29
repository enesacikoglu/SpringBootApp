package sample.data.cassandra.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductJsonModel {


	@JsonProperty(value="label")
    private String productId;
    
	@JsonProperty(value="value")
    private String description;
    
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    
    

}
