package sample.data.cassandra.service;

import java.util.List;


import sample.data.cassandra.model.CustomerModel;

public interface CustomerService {

	List<CustomerModel> findAll();
		
}
