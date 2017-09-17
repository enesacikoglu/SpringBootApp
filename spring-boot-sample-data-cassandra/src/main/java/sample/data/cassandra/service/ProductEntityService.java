package sample.data.cassandra.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sample.data.cassandra.entity.ProductEntity;
import sample.data.cassandra.model.CustomerModel;
import sample.data.cassandra.model.ProductBarChart;
import sample.data.cassandra.model.ProductEntityModel;

public interface ProductEntityService {
    Iterable<ProductEntity> listAllProducts();

    ProductEntity getProductById(Integer id);

    ProductEntity saveProduct(ProductEntity product);

    void deleteProduct(Integer id);

//    Page<ProductEntity> findAll(Pageable pageable);
    
    List<ProductEntityModel> findAll();
    
}
