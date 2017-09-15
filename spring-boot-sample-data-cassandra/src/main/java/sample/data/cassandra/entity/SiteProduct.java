package sample.data.cassandra.entity;

import javax.persistence.*;
import java.util.Map;

@Entity
public class SiteProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private String productId;
    
    private String title;
    
    private String brand;
    
    @ElementCollection
    private Map<String,String> dateWithPrice;
    
    private String category;
    
    private String url;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
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
	public Map<String, String> getDateWithPrice() {
		return dateWithPrice;
	}
	public void setDateWithPrice(Map<String, String> dateWithPrice) {
		this.dateWithPrice = dateWithPrice;
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
