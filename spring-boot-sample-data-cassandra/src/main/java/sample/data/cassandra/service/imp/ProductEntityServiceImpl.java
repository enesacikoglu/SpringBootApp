package sample.data.cassandra.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.data.cassandra.entity.ProductEntity;
import sample.data.cassandra.repo.ProductEntityRepository;
import sample.data.cassandra.service.ProductEntityService;

/**
 * @author KAFEACIKOGLU
 *
 */
@Service
public class ProductEntityServiceImpl implements ProductEntityService {

   @Autowired
   private ProductEntityRepository productRepository;

   @Override
   public List<ProductEntity> findByProductId(String productId) {
      return productRepository.findByProductId(productId);
   }

   @Override
   public List<String> findDistinctByCategory(String category) {
      return productRepository.findDistinctByCategory(category);
   }

   @Override
   public List<ProductEntity> findByCategoryContainingIgnoreCase(String category) {
      return productRepository.findByCategoryContainingIgnoreCase(category);
   }

   @Override
   public List<String> findDistinctByCategoryAndBrand(String category, String brand) {
      return productRepository.findDistinctByCategoryAndBrand(category, brand);
   }

   @Override
   public List<ProductEntity> findByCategoryAndBrand(String category, String brand) {
      return productRepository.findByCategoryAndBrand(category, brand);
   }

   @Override
   public List<ProductEntity> findFirst10ByCategoryAndBrandAndTitleContainingIgnoreCase(String category, String brand,
         String title) {
      return productRepository.findFirst10ByCategoryAndBrandAndTitleContainingIgnoreCase(category, brand, title);
   }

   @Override
   public List<ProductEntity> findByCategoryAndBrandAndTitle(String category, String brand, String title) {
      return productRepository.findByCategoryAndBrandAndTitle(category, brand, title);
   }

   @Override
   public List<ProductEntity> findByCategoryContainingIgnoreCaseAndBrandContainingIgnoreCaseAndTitleContainingIgnoreCase(
         String category, String brand, String title) {
      // TODO Auto-generated method stub
      return productRepository
            .findByCategoryContainingIgnoreCaseAndBrandContainingIgnoreCaseAndTitleContainingIgnoreCase(category, brand,
                  title);
   }

}
