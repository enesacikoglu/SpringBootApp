/*
 * Copyright 2012-2013 the original author or authors.
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

package sample.data.cassandra.repo;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;


import sample.data.cassandra.entity.CustomerEntity;

public interface CustomerRepository extends CrudRepository<CustomerEntity, String> {
	
	@Query("Select * from customer where firstname=?0")
	public CustomerEntity findByFirstName(String firstName);

	@Query("Select * from customer where lastname=?0")
	public List<CustomerEntity> findByLastName(String lastName);

}
