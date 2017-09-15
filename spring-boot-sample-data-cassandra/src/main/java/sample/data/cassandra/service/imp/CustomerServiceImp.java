package sample.data.cassandra.service.imp;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.data.cassandra.data.transformer.CustomerTransformer;
import sample.data.cassandra.entity.CustomerEntity;
import sample.data.cassandra.model.CustomerModel;
import sample.data.cassandra.repo.CustomerRepository;
import sample.data.cassandra.service.CustomerService;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public List<CustomerModel> findAll() {
		return CustomerTransformer.getCustomerListFromEntity((List<CustomerEntity>) customerRepo.findAll());
	}

	@Override
	public void deleteCustomer(String id) {
		
		CustomerEntity findOne = customerRepo.findOne(id);
		System.out.println("Fail:"+findOne);
		if (findOne != null) {
			System.out.println("Succ:"+findOne);
			customerRepo.delete(findOne);
		}
	}

}
