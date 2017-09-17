package sample.data.cassandra.service.imp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import sample.data.cassandra.data.transformer.ModelTransformer;
import sample.data.cassandra.entity.ProductEntity;
import sample.data.cassandra.model.ProductBarChart;
import sample.data.cassandra.model.ProductEntityModel;
import sample.data.cassandra.repo.ProductEntityRepository;
import sample.data.cassandra.repo.ProductRepository;
import sample.data.cassandra.service.ProductEntityService;
import sample.data.cassandra.service.ProductService;

@Service
public class ProductEntityServiceImpl implements ProductEntityService {
	
	@Autowired
    private ProductEntityRepository productRepository;


    @Override
    public Iterable<ProductEntity> listAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductEntity getProductById(Integer id) {
        return productRepository.findOne(id);
    }

    @Override
    public ProductEntity saveProduct(ProductEntity product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.delete(id);
    }

    @Override
    public List<ProductEntityModel> findAll() {
        return  ModelTransformer.getProductListFromEntity((List<ProductEntity>) productRepository.findAll());
    }

}
