package sample.data.cassandra.data.transformer;

import java.util.List;
import java.util.stream.Collectors;

import sample.data.cassandra.entity.CustomerEntity;
import sample.data.cassandra.model.CustomerModel;

public class CustomerTransformer {

	public static List<CustomerModel> getCustomerListFromEntity(List<CustomerEntity> entityList) {

		return entityList.parallelStream().map(entity -> {

			CustomerModel customerModel = new CustomerModel();

			customerModel.setId(entity.getId().toString());
			customerModel.setFirstName(entity.getFirstName());
			customerModel.setLastName(entity.getLastName());

			return customerModel;

		}).collect(Collectors.toList());

	}

}
