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
import sample.data.cassandra.repo.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleCassandraApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	@Override
	public void run(String... args) throws Exception {
		this.repository.deleteAll();

		for (int i = 0; i < 1000; i++) {
			// save a couple of customers
			this.repository.save(new CustomerEntity(UUIDs.timeBased(), "Alice", "Smith"));
			this.repository.save(new CustomerEntity(UUIDs.timeBased(), "Bob", "Smith"));
		}
     
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
