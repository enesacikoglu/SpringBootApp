package sample.data.cassandra.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sample.data.cassandra.entity.ProductEntity;
import sample.data.cassandra.model.ProductChartModel;
import sample.data.cassandra.model.ProductJsonModel;
import sample.data.cassandra.service.ProductCassandraService;
import sample.data.cassandra.service.ProductEntityService;

@RestController
@RequestMapping("/api/product")
public class ProductAutoCompleteController {

   @Autowired
   private ProductEntityService productEntityService;

   @Autowired
   private ProductCassandraService productCassandraService;

   @RequestMapping(value = "/findProductById", method = RequestMethod.GET)
   public List<ProductEntity> findProductById(@RequestParam("productId") String productId) {
      return productEntityService.findByProductId(productId);
   }

   @RequestMapping(value = "/findByCategory", method = RequestMethod.GET)
   public List<ProductEntity> findByCategoryContainingIgnoreCase(@RequestParam("category") String category) {

      return productEntityService.findByCategoryContainingIgnoreCase(category);
   }

   @RequestMapping(value = "/findDistinctByCategory", method = RequestMethod.GET)
   public List<ProductJsonModel> findByCategory(@RequestParam("category") String category) {

      List<ProductJsonModel> models = new ArrayList<>();

      productEntityService.findDistinctByCategory(category).parallelStream().forEach(t -> {

         ProductJsonModel model = new ProductJsonModel();
         if (t != null) {
            model.setDescription(t);
         }

         models.add(model);

      });

      return models;
   }

   @RequestMapping(value = "/findDistinctByCategoryAndBrand", method = RequestMethod.GET)
   public List<ProductJsonModel> findByCategoryAndBrand(@RequestParam("category") String category,
         @RequestParam("brand") String brand) {

      List<ProductJsonModel> models = new ArrayList<>();

      productEntityService.findDistinctByCategoryAndBrand(category, brand).parallelStream().forEach(t -> {
         ProductJsonModel jsonModel = new ProductJsonModel();

         if (t != null) {
            jsonModel.setDescription(t);
         }

         models.add(jsonModel);
      });

      return models;

   }

   @RequestMapping(value = "/findFirst10ByCategoryAndBrandAndTitle", method = RequestMethod.GET)
   public List<ProductJsonModel> findByCategoryAndBrandAndTitle(@RequestParam("category") String category,
         @RequestParam("brand") String brand, @RequestParam("title") String title) {

      List<ProductJsonModel> models = new ArrayList<>();
      productEntityService.findFirst10ByCategoryAndBrandAndTitleContainingIgnoreCase(category, brand, title)
            .parallelStream().forEach(t -> {
               ProductJsonModel jsonModel = new ProductJsonModel();

               jsonModel.setProductId(t.getProductId());
               jsonModel.setDescription(t.getTitle());

               models.add(jsonModel);
            });

      return models;
   }

   @RequestMapping(value = "/findAllWithIgnoreCase", method = RequestMethod.GET)
   public List<ProductEntity> findAllWithIgnoreCase(@RequestParam("category") String category,
         @RequestParam("brand") String brand, @RequestParam("title") String title) {
      return productEntityService.findByCategoryContainingIgnoreCaseAndBrandContainingIgnoreCaseAndTitleContainingIgnoreCase(category, brand, title);

   }

   @RequestMapping("/findByProductId")
   public List<ProductChartModel> getAllProductsByProductId(@RequestParam("productId") String productId) {
      return productCassandraService.findByProductId(productId);
   }

   @RequestMapping("/findById")
   public List<ProductChartModel> getAllProductsById(@RequestParam("id") String id) {
      return productCassandraService.getProductBarChartById(id);
   }

}
