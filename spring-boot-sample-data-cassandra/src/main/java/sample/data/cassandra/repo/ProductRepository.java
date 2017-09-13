package sample.data.cassandra.repo;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import sample.data.cassandra.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
    Page<Product> findAll(Pageable pageable);
}
