package sample.data.cassandra.data.transformer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import sample.data.cassandra.entity.CustomerEntity;
import sample.data.cassandra.model.CustomerModel;

public class CustomerTransformer {

	public static List<CustomerModel> getCustomerListFromEntity(List<CustomerEntity> entityList) {

		 List<CustomerModel> models=new ArrayList<>();
		
//		return entityList.parallelStream().map(entity -> {
//
//			int i=1;
//			CustomerModel customerModel = new CustomerModel();
//
//			customerModel.setId(entity.getId().toString());
//			customerModel.setDT_RowId("row_"+i);
//			customerModel.setFirstName(entity.getFirstName());
//			customerModel.setLastName(entity.getLastName());
//            i++;
//			return customerModel;
//
//		}).collect(Collectors.toList());
		
		int i=1;
		for (CustomerEntity entity : entityList) {
			CustomerModel customerModel = new CustomerModel();

			customerModel.setId(entity.getId().toString());
			customerModel.setDtRowid("row_"+i);
			customerModel.setFirstName(entity.getFirstName());
			customerModel.setLastName(entity.getLastName());
			models.add(customerModel);
			i++;
		}
		
		return models;

	}

}
