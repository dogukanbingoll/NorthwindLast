package com.etiya.northwind.ServiceTestes;

import com.etiya.northwind.Business.Abstracts.CustomerService;
import com.etiya.northwind.Business.Concretes.CustomerManager;
import com.etiya.northwind.Business.Responses.Customers.CustomerListResponse;
import com.etiya.northwind.Business.requests.customers.CreateCustomerRequest;
import com.etiya.northwind.DataAccess.Abstracts.CustomerRepository;
import com.etiya.northwind.DataAccess.Abstracts.mapping.ModelMapperManager;
import com.etiya.northwind.DataAccess.Abstracts.mapping.ModelMapperService;
import com.etiya.northwind.Entities.Concretes.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;


public class CustomerServiceTestes {
    private final CreateCustomerRequest createCustomerRequest = new CreateCustomerRequest();
    private final CustomerListResponse customerListResponse = new CustomerListResponse();

    private CustomerService customerService;
    private ModelMapper modelMapper;
    private ModelMapperService modelMapperService;
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setup() {
        modelMapper = new ModelMapper();
        modelMapperService = new ModelMapperManager(modelMapper);
        customerRepository = Mockito.mock(CustomerRepository.class);
        customerService = new CustomerManager(customerRepository, modelMapperService);

    }

    @Test
    public void add_customer_test() {
        customerService.addCustomer(createCustomerRequest);
        Mockito.verify(customerRepository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    public void update_customer_test() {
        Customer expected = modelMapperService.forRequest().map(customerListResponse, Customer.class);
        //Valkidasyon için
        Mockito.when(customerRepository.save(Mockito.any())).thenReturn(expected);
        customerService.updateCustomer(customerListResponse);


        Mockito.verify(customerRepository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    public void delete_customer_test() {
        customerService.deleteCustomer(Mockito.anyString());

        Mockito.verify(customerRepository, Mockito.times(1)).deleteById(Mockito.anyString());
    }

}


