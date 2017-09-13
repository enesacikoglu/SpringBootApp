package sample.data.cassandra.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sample.data.cassandra.entity.Product;

public interface ProductService {
    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);

    Page<Product> findAll(Pageable pageable);
}
