package sample.data.cassandra.service;

import java.util.List;

import sample.data.cassandra.entity.ProductCassandraEntity;
import sample.data.cassandra.model.ProductChartModel;

public interface ProductCassandraService {

   public List<ProductChartModel> findByProductId(String productId);

   public ProductCassandraEntity findOne(String id);

   public List<ProductChartModel> getProductBarChartById(String id);

}
