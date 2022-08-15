package com.etiya.northwind.ServiceTestes;

import com.etiya.northwind.Business.Concretes.CustomerManager;
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


    CustomerManager customerManager;

    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;

    @BeforeEach
    public void setup(){
        customerRepository= Mockito.mock(CustomerRepository.class);
        modelMapperService=Mockito.mock(ModelMapperService.class);
        customerManager=new CustomerManager(customerRepository,modelMapperService);

    }
    @Test
    public void testSaveCustomer(){
/**
*       Arrange----------------------------------------------------------------------
**/
        CreateCustomerRequest createCustomerRequestTest=new CreateCustomerRequest();
        createCustomerRequestTest.setCustomerId("TEST-CUSTOMER_ID");
        createCustomerRequestTest.setCompanyName("TEST-COMPANY_NAME");
        createCustomerRequestTest.setContactName("TEST-CONTACT_NAME");


/**
 *       Action------------------------------------------------------------------------
 **/
        Mockito.when(modelMapperService.forRequest().map(createCustomerRequestTest,Customer.class)).thenReturn()
/**
 *       Assert------------------------------------------------------------------------
 **/
        Assertions.assertEquals(createCustomerRequestTest.getContactName());



    }

}
