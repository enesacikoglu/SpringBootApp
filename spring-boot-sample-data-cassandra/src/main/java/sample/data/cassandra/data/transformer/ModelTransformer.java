package sample.data.cassandra.data.transformer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import sample.data.cassandra.entity.CustomerEntity;
import sample.data.cassandra.entity.ProductEntity;
import sample.data.cassandra.model.CustomerModel;
import sample.data.cassandra.model.ProductEntityModel;

public class ModelTransformer {

	public static List<CustomerModel> getCustomerListFromEntity(List<CustomerEntity> entityList) {

		List<CustomerModel> models = new ArrayList<>();

		// return entityList.parallelStream().map(entity -> {
		//
		// int i=1;
		// CustomerModel customerModel = new CustomerModel();
		//
		// customerModel.setId(entity.getId().toString());
		// customerModel.setDT_RowId("row_"+i);
		// customerModel.setFirstName(entity.getFirstName());
		// customerModel.setLastName(entity.getLastName());
		// i++;
		// return customerModel;
		//
		// }).collect(Collectors.toList());

		int i = 1;
		for (CustomerEntity entity : entityList) {
			CustomerModel customerModel = new CustomerModel();

			customerModel.setId(entity.getId());
			customerModel.setDtRowid(entity.getId());
			customerModel.setFirstName(entity.getFirstName());
			customerModel.setLastName(entity.getLastName());
			models.add(customerModel);
			i++;
		}

		return models;

	}

	public static List<ProductEntityModel> getProductListFromEntity(List<ProductEntity> entityList) {

		List<ProductEntityModel> models = new ArrayList<>();

		int i = 1;
		for (ProductEntity entity : entityList) {

			ProductEntityModel entityModel = new ProductEntityModel();

			entityModel.setBrand(entity.getBrand());
			entityModel.setCategory(entity.getCategory());
			entityModel.setDtRowid("row_" + i);
			entityModel.setProductId(entity.getProductId());
			entityModel.setTitle(entity.getTitle());
			entityModel.setUrl(entity.getUrl());

			models.add(entityModel);
			i++;
		}

		return models;

	}
}
