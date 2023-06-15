package net.youssfi.customerdataservice.web;

import lombok.AllArgsConstructor;
import net.youssfi.customerdataservice.dto.CustomerRequest;
import net.youssfi.customerdataservice.entities.Customer;
import net.youssfi.customerdataservice.mapper.CustomerMapper;
import net.youssfi.customerdataservice.repository.CustomerRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class CustomerGraphQLController {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;
    @QueryMapping
    public List<Customer> allCustomers(){
        return customerRepository.findAll();
    }
    @QueryMapping
    public Customer customerById(@Argument Long id){
        Customer customer = customerRepository.findById(id).orElse(null);
        if(customer==null) throw new RuntimeException(String.format("Customer %s not found",id));
        return customer;
    }
    @MutationMapping
    public Customer saveCustomer(@Argument CustomerRequest customer){
        Customer c = customerMapper.from(customer);
        return customerRepository.save(c);
    }
}
