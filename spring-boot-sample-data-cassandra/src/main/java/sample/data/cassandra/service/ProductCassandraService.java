package sample.data.cassandra.service;

import java.util.List;

import sample.data.cassandra.entity.ProductCassandraEntity;
import sample.data.cassandra.model.ProductBarChart;


public interface ProductCassandraService {

	List<ProductCassandraEntity> findAll();
	
	void deleteCustomer(String id);
	
    List<ProductBarChart> getAllProductBarCharts();
    
    List<ProductBarChart> getProductBarChartById(String id);
		
}
