package sample.data.cassandra.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import sample.data.cassandra.entity.ProductEntity;

public interface ProductEntityRepository extends CrudRepository<ProductEntity, Integer> {

   public List<ProductEntity> findByProductId(String productId);

   @Query(value = "select distinct(u.category) from product_entity u where lower(u.category) like lower(concat('%', :category,'%'))",
          nativeQuery = true)
   public List<String> findDistinctByCategory(@Param("category") String category);

   public List<ProductEntity> findByCategoryContainingIgnoreCase(String category);

   @Query(value = "select distinct(u.brand) from product_entity u where u.category=:category and lower(u.brand) like lower(concat('%', :brand,'%'))",
          nativeQuery = true)
   public List<String> findDistinctByCategoryAndBrand(@Param("category") String category, @Param("brand") String brand);

   public List<ProductEntity> findByCategoryAndBrand(String category, String brand);

   public List<ProductEntity> findFirst10ByCategoryAndBrandAndTitleContainingIgnoreCase(String category, String brand,
         String title);

   public List<ProductEntity> findByCategoryAndBrandAndTitle(String category, String brand, String title);

   public List<ProductEntity> findByCategoryContainingIgnoreCaseAndBrandContainingIgnoreCaseAndTitleContainingIgnoreCase(
         String category, String brand, String title);

}
