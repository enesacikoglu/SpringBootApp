/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.data.cassandra;

import com.datastax.driver.core.utils.UUIDs;

import sample.data.cassandra.entity.CustomerEntity;
import sample.data.cassandra.entity.ProductCassandraEntity;
import sample.data.cassandra.repo.CustomerRepository;
import sample.data.cassandra.repo.ProductCassandraRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleCassandraApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	private ProductCassandraRepository productCassandraRepository;

	@Override
	public void run(String... args) throws Exception {
		this.repository.deleteAll();

		for (int i = 0; i < 1000; i++) {
			// save a couple of customers
			this.repository.save(new CustomerEntity(UUIDs.timeBased().toString(), "Alice", "Smith"));
			this.repository.save(new CustomerEntity(UUIDs.timeBased().toString(), "Bob", "Smith"));
		}
		
		/*
		Map<String, String> priceOnDateMap= new HashMap<>();
		
		priceOnDateMap.put("20170101", "126");
		priceOnDateMap.put("20170102", "127");
		priceOnDateMap.put("20170103", "128");
		priceOnDateMap.put("20170104", "112");
		priceOnDateMap.put("20170105", "3141");
		priceOnDateMap.put("20170106", "414");
		priceOnDateMap.put("20170107", "15151");
		priceOnDateMap.put("20170108", "151515");
		priceOnDateMap.put("20170109", "11111");
		priceOnDateMap.put("20170110", "62111");
		
		this.productCassandraRepository.save(new ProductCassandraEntity(UUIDs.timeBased().toString(),"1",priceOnDateMap));
     	
		
		
		
		for (ProductCassandraEntity product : this.productCassandraRepository.findAll()) {
			
			Set<String> keySet = product.getPriceOnDateMap().keySet();
			
			for (String string : keySet) {
				if (keySet.contains(string)) {
					System.out.println(product.getPriceOnDateMap().get(string));		
				}
			}
			
//			System.out.println(product);
		}
	
		*/
//*********************************************************************************************************//		
		
		/*
		
		// save a couple of customers
		this.repository.save(new CustomerEntity(UUIDs.timeBased(), "Alice", "Smith"));
		this.repository.save(new CustomerEntity(UUIDs.timeBased(), "Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (CustomerEntity customer : this.repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(this.repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (CustomerEntity customer : this.repository.findByLastName("Smith")) {
			System.out.println(customer);
		}
		
		*/
	}

	public static void main(String[] args) {
//		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(SampleCassandraApplication.class, args);
	}

}
