package sample.data.cassandra.service.imp;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import sample.data.cassandra.entity.ProductCassandraEntity;
import sample.data.cassandra.model.ProductBarChart;
import sample.data.cassandra.repo.ProductCassandraRepository;
import sample.data.cassandra.service.ProductCassandraService;

@Service
public class ProductCassandraServiceImp implements ProductCassandraService {

	@Autowired
	private ProductCassandraRepository productCassandraRepo;

	@Override
	public List<ProductCassandraEntity> findAll() {
		return (List<ProductCassandraEntity>) productCassandraRepo.findAll();
	}

	@Override
	public void deleteCustomer(String id) {
		
		ProductCassandraEntity findOne = productCassandraRepo.findOne(id);
		System.out.println("Fail:"+findOne);
		if (findOne != null) {
			System.out.println("Succ:"+findOne);
			productCassandraRepo.delete(findOne);
		}
	}

	@Override
	public List<ProductBarChart> getAllProductBarCharts() {
		
	
		
		return null;
	}

	@Override
	public List<ProductBarChart> getProductBarChartById(String id) {
		
		List<ProductBarChart> barCharts= new ArrayList<>();
		
	Iterable<ProductCassandraEntity> findAll = productCassandraRepo.findAll();
		
		for (ProductCassandraEntity productCassandraEntity : findAll) {
			
			if(productCassandraEntity.getProductId().equals(id)){
				
				Set<Entry<String, String>> entrySet = productCassandraEntity.getPriceOnDateMap().entrySet();
				
				for (Entry<String, String> entry : entrySet) {
	             
					ProductBarChart barChart= new ProductBarChart();
					
					barChart.setDate(entry.getKey());
					barChart.setPrice(entry.getValue());
					
					barCharts.add(barChart);

				}
				
			}
			
			
		}
		
		// TODO Auto-generated method stub
		return barCharts;
	}

}
