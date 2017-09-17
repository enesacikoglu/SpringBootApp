package sample.data.cassandra.repo;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import sample.data.cassandra.entity.ProductEntity;

public interface ProductEntityRepository extends CrudRepository<ProductEntity, Integer>{
 
	
}
