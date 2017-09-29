package sample.data.cassandra.service;

import java.util.List;

import sample.data.cassandra.entity.ProductEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProductEntityService.
 *
 * @author Enes
 */
public interface ProductEntityService {

   /**
    * Find by product id.
    *
    * @param productId
    *           the product id
    * @return the list
    */
   public List<ProductEntity> findByProductId(String productId);

   /**
    * Find distinct by category.
    *
    * @param category
    *           the category
    * @return the list
    */
   public List<String> findDistinctByCategory(String category);

   /**
    * Find by category.
    *
    * @param category
    *           the category
    * @return the list
    */
   public List<ProductEntity> findByCategoryContainingIgnoreCase(String category);

   /**
    * Find distinct by category and brand.
    *
    * @param category
    *           the category
    * @param brand
    *           the brand
    * @return the list
    */
   public List<String> findDistinctByCategoryAndBrand(String category, String brand);

   /**
    * Find by category and brand.
    *
    * @param category
    *           the category
    * @param brand
    *           the brand
    * @return the list
    */
   public List<ProductEntity> findByCategoryAndBrand(String category, String brand);

   /**
    * Find first 10 by category and brand and title containing ignore case.
    *
    * @param category
    *           the category
    * @param brand
    *           the brand
    * @param title
    *           the title
    * @return the list
    */
   public List<ProductEntity> findFirst10ByCategoryAndBrandAndTitleContainingIgnoreCase(String category, String brand,
         String title);

   /**
    * Find by category and brand and title.
    *
    * @param category
    *           the category
    * @param brand
    *           the brand
    * @param title
    *           the title
    * @return the list
    */
   public List<ProductEntity> findByCategoryAndBrandAndTitle(String category, String brand, String title);

   /**
    * Find by category containing ignore case and brand containing ignore case
    * and title containing ignore case.
    *
    * @param category
    *           the category
    * @param brand
    *           the brand
    * @param title
    *           the title
    * @return the list
    */
   public List<ProductEntity> findByCategoryContainingIgnoreCaseAndBrandContainingIgnoreCaseAndTitleContainingIgnoreCase(
         String category, String brand, String title);

}
