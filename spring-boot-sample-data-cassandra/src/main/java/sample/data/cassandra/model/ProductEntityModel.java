package sample.data.cassandra.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ProductEntityModel {

	
	@JsonProperty("DT_RowId")
	private String dtRowid;
	
	private String productId;
    
    private String title;
    
    private String brand;
    
    private String category;
    
    private String url;

	public String getDtRowid() {
		return dtRowid;
	}

	public void setDtRowid(String dtRowid) {
		this.dtRowid = dtRowid;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
    
    
    
}
