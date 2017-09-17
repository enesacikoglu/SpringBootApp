package sample.data.cassandra.conf;


import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.datastax.driver.core.utils.UUIDs;


import sample.data.cassandra.entity.ProductCassandraEntity;
import sample.data.cassandra.entity.ProductEntity;
import sample.data.cassandra.repo.ProductCassandraRepository;
import sample.data.cassandra.repo.ProductEntityRepository;

import sample.data.cassandra.xml.model.ProductList;
import sample.data.cassandra.xml.model.ProductType;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ProductCimriLoader implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
    private ProductEntityRepository productRepository;
	
	@Autowired
	private ProductCassandraRepository cassandraRepository;
	
	@Autowired
	private ApplicationProperties properties;
    
	
    public String getSITE_I_URL() {
		return properties.getSiteIUrl();
	}

	public String getSITE_II_URL() {
		return properties.getSiteIIUrl();
	}

	public String getSITE_III_URL() {
		return properties.getSiteIIIUrl();
	}

	public String getSITE_IV_URL() {
		return properties.getSiteIVUrl();
	}

	private Logger log = Logger.getLogger(ProductCimriLoader.class);



    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

    	ProductList products=new ProductList();
		  try {
			
			
			/*
			//Save site_I PRODUCTS
			products = XMLUnmarshaller.unmarshlall(getSITE_I_URL(), products);  
			saveProducts(products,getSITE_I_URL());		
			//SaveCassandra for site_IV PRODUCTS
			parseProductForCassandra(products,getSITE_I_URL());
			
			//Save site_II PRODUCTS
			products = XMLUnmarshaller.unmarshlall(getSITE_II_URL(), products);  
			saveProducts(products,getSITE_II_URL());
			//SaveCassandra for site_IV PRODUCTS
			parseProductForCassandra(products,getSITE_II_URL());
		
			//Save site_III PRODUCTS
			products = XMLUnmarshaller.unmarshlall(getSITE_III_URL(), products);  
			saveProducts(products,getSITE_III_URL());
			//SaveCassandra for site_IV PRODUCTS
			parseProductForCassandra(products,getSITE_III_URL());
			
			//Save site_IV PRODUCTS
			products = XMLUnmarshaller.unmarshlall(getSITE_IV_URL(), products);  
			saveProducts(products,getSITE_IV_URL());
			//SaveCassandra for site_IV PRODUCTS
			parseProductForCassandra(products,getSITE_IV_URL());
			
			*/
			  
			    products = XMLUnmarshaller.unmarshlall(getSITE_II_URL(), products);  
				saveProducts(products,getSITE_II_URL());
				//SaveCassandra for site_IV PRODUCTS
				parseProductForCassandra(products,getSITE_II_URL());
	
		      } 
		  catch (Exception e) {
			  log.error("Error " +e.getMessage(),e);
		      }
 
    }
    
    private List<ProductEntity> saveProducts(ProductList productList,String url){
    	List<ProductEntity> products=new ArrayList<>();
    	try {
           products=productList.getRowsList().parallelStream().map(product->{
        		
        		ProductEntity entity=new ProductEntity();
        		
        		entity.setProductId(product.getId());
        		entity.setBrand(product.getBrand());
        		entity.setCategory(product.getCategory());
        		entity.setTitle(product.getTitle());
        		entity.setUrl(product.getUrl());
        		
        		return productRepository.save(entity);
        		
        	}).collect(Collectors.toList());
		} catch (Exception e) {
			log.error("Error on saving product with url " +url,e);
		}
    	
    	log.debug("All products saved on url " +url);
    	return products;

    }
    
	private ProductList parseProduct(ProductList productList,String url){
		
		List<ProductType> rowsList = productList.getRowsList();
		for (ProductType productModel : rowsList) {
			
			String[] dates = productModel.getDates().get(0).split(",");
			productModel.getDates().clear();
			for (String date : dates) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTimeInMillis(Long.valueOf(date));
				productModel.getDates().add(calendar.getTime().toGMTString());
			}
			
			String[] prices = productModel.getPrices().get(0).split(",");
			productModel.getPrices().clear();
			for (String price : prices) {
				productModel.getPrices().add(price);
			}
		}
		
		return productList;
	}
	
	
	private List<ProductCassandraEntity> parseProductForCassandra(ProductList productList,String url){
		
		
		
		 List<ProductCassandraEntity> collect = productList.getRowsList().stream().map(product->{
			
			ProductCassandraEntity cassandraEntity=new ProductCassandraEntity();
			Map<String,String> priceOnDateMap=new HashMap<>();
			
			
			String[] dates = product.getDates().get(0).split(",");

			String[] prices = product.getPrices().get(0).split(",");
			
			for (int i = 0; i < prices.length; i++) {
				priceOnDateMap.put(dates[i],prices[i]);
			}

			cassandraEntity.setId(UUIDs.timeBased().toString());
			cassandraEntity.setProductId(product.getId());
			cassandraEntity.setPriceOnDateMap(priceOnDateMap);
			
			System.out.println(cassandraEntity);
			
			return  cassandraRepository.save(cassandraEntity);
			
		}).collect(Collectors.toList());
		
		log.debug("Product cassandra fnished with url " +url);
		return collect ;
    
	}
}
