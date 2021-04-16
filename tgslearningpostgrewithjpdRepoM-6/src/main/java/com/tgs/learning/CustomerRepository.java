
package com.tgs.learning;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByFirstName(String FirstName);

	List<Customer> findAll();
	
	@Query("from Customer  where id = :n and lastname = :name")
	List<Customer> getUserWithIDandName(@Param("n") long n,@Param("name") String name);

	@Query("from Customer  where id > :n")
	List<Customer> getUserWithIDGreater(@Param("n") long n);
	
	@Query("from Customer  where firstname =:n")
	List<Customer> getUserByName(@Param("n") String name);
	
	

}