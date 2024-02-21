package com.edu.uptc.parcial.services;

import com.edu.uptc.parcial.entities.Customer;
import com.edu.uptc.parcial.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll(){
        return  customerRepository.findAll();
    }

    public Customer findById(Integer id){
        Optional<Customer> optional = customerRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    public Customer save (Customer customer){
        return customerRepository.save(customer);
    }

    public void delete (Customer customer){
        customerRepository.delete(customer);
    }
}
