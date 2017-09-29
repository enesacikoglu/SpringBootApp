package sample.data.cassandra.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.data.cassandra.entity.ProductCassandraEntity;
import sample.data.cassandra.model.ProductChartModel;
import sample.data.cassandra.repo.ProductCassandraRepository;
import sample.data.cassandra.service.ProductCassandraService;

@Service
public class ProductCassandraServiceImp implements ProductCassandraService {

   @Autowired
   private ProductCassandraRepository productCassandraRepo;

   public List<ProductChartModel> getProductBarChartById(String id) {

      List<ProductChartModel> timeChart = new ArrayList<>();

      Set<Entry<String, String>> entrySet = productCassandraRepo.findOne(id).getPriceOnDateMap().entrySet();

      for (Entry<String, String> entry : entrySet) {

         ProductChartModel barChart = new ProductChartModel();

         barChart.setDate(entry.getKey());
         barChart.setPrice(entry.getValue());

         timeChart.add(barChart);

      }

      // TODO Auto-generated method stub
      return timeChart;
   }

   @Override
   public List<ProductChartModel> findByProductId(String productId) {
      // TODO Auto-generated method stub

      return productCassandraRepo.findByProductId(productId).parallelStream()
            .filter(t -> t.getProductId().equals(productId)).findFirst().get().getPriceOnDateMap().entrySet()
            .parallelStream().map(t -> {

               ProductChartModel chartModel = new ProductChartModel();

               chartModel.setDate(t.getKey());
               chartModel.setPrice(t.getValue());

               return chartModel;

            }).collect(Collectors.toList());

   }

   @Override
   public ProductCassandraEntity findOne(String id) {
      // TODO Auto-generated method stub
      return productCassandraRepo.findOne(id);
   }

}
