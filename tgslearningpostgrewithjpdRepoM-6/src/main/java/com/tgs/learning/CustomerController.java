package com.tgs.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	@Autowired
	CustomerRepository repository;

	@GetMapping("/bulkcreate")
	public String bulkcreate() {
// save a single Customer
		repository.save(new Customer("Hary", "Chris"));

// save a list of Customers
		repository.saveAll(Arrays.asList(new Customer("Abhinav", "Kesarwani"), new Customer("Jitu", "Mishra"),
				new Customer("Rahul", "Kashyap"), new Customer("Khalid", "Zaman")));

		return "Customers are created";
	}

	@PostMapping("/create")
	public String create(@RequestBody CustomerUI customer) {
// save a single Customer
		repository.save(new Customer(customer.getFirstName(), customer.getLastName()));

		return "Customer is created";
	}

	@GetMapping("/findall")
	public List<CustomerUI> findAll() {

		List<Customer> customers = repository.findAll();
		List<CustomerUI> customerUI = new ArrayList<>();

		for (Customer customer : customers) {
			customerUI.add(new CustomerUI(customer.getFirstName(), customer.getLastName()));
		}

		return customerUI;
	}

	@RequestMapping("/search/{id}")
	public String search(@PathVariable long id) {
		String customer = "";
		customer = repository.findById(id).toString();
		return customer;
	}

	@RequestMapping("/searchbyfirstname/{firstname}")
	public List<CustomerUI> fetchDataByFirstName(@PathVariable String firstname) {

		List<Customer> customers = repository.findByFirstName(firstname);
		List<CustomerUI> customerUI = new ArrayList<>();
		for (Customer customer : customers) {
			customerUI.add(new CustomerUI(customer.getFirstName(), customer.getLastName()));
		}
		return customerUI;
	}

	@DeleteMapping("/deletebyid/{id}")
	public String deleteByID(@PathVariable Long id) {
		String customer = repository.findById(id).toString();
		repository.deleteById(id);
		return "Deleted Successfully " + customer;
	}

	@RequestMapping("/findbyname/{firstname}")
	public List<Customer> getUserByNamee(@PathVariable String firstname) {
		List<Customer> customers = repository.getUserByName(firstname);
		return customers;
	}

	@RequestMapping("/userwithgreaterid/{id}")
	public List<Customer> getUserWithGreaterId(@PathVariable long id) {
		List<Customer> customers = repository.getUserWithIDGreater(id);
		return customers;
	}
	
	@RequestMapping("/userwithidandlname/{id}/{name}")
	public List<Customer> getUserWithIdAndLname(@PathVariable long id,@PathVariable String name) {
		List<Customer> customers = repository.getUserWithIDandName(id, name);
		return customers;
	}
	

}