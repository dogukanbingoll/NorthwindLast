package com.etiya.northwind.ServiceTestes;

import com.etiya.northwind.Business.Abstracts.ProductService;
import com.etiya.northwind.Business.Concretes.ProductManager;
import com.etiya.northwind.Business.Responses.Products.ProductListResponse;
import com.etiya.northwind.Business.requests.products.CreateProductRequest;
import com.etiya.northwind.DataAccess.Abstracts.ProductRepository;
import com.etiya.northwind.DataAccess.Abstracts.mapping.ModelMapperManager;
import com.etiya.northwind.DataAccess.Abstracts.mapping.ModelMapperService;
import com.etiya.northwind.Entities.Concretes.Product;
import com.etiya.northwind.core.utilities.results.DataResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import java.util.Optional;

public class ProductServiceTestes {
    private final CreateProductRequest createProductRequest = new CreateProductRequest();
    private final ProductListResponse productListResponse = new ProductListResponse();
    private final  Product product = new Product();
    private ProductService productService;
    private ModelMapper modelMapper;
    private ModelMapperService modelMapperService;
    private ProductRepository productRepository;


    @BeforeEach
    public void setup(){
        modelMapper = new ModelMapper();
        modelMapperService = new ModelMapperManager(modelMapper);
        productRepository = Mockito.mock(ProductRepository.class);
        productService = new ProductManager(productRepository,modelMapperService);
    }


    @Test
    public void getById_product_test(){
        Product expected = product;
        ///Mockito.when(productRepository.getReferenceById(Mockito.anyInt())).thenReturn(expected);
        productService.getProductById(2);

        Mockito.verify(productRepository,Mockito.times(1)).getReferenceById(Mockito.anyInt());
    }

    @Test
    public void add_product_test(){

        productService.addProduct(createProductRequest);

        Product testProduct=modelMapperService.forRequest().map(createProductRequest,Product.class);

        Mockito.verify(productRepository,Mockito.times(1)).save(testProduct);
    }

    @Test
    public void update_product_test(){
        Product expected = modelMapperService.forRequest().map(productListResponse,Product.class);

        Mockito.when(productRepository.findById(Mockito.any())).thenReturn(Optional.of(expected));

        productService.updateProduct(productListResponse);

        Mockito.verify(productRepository,Mockito.times(1)).save(expected);
    }

    @Test
    public void delete_product_test(){
        Mockito.when(productRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(createProductRequest));

        productService.deleteProduct(2);

        Mockito.verify(productRepository,Mockito.times(1)).deleteById(Mockito.anyInt());
    }

    @Test
    public void getall_product_test(){
        productService.getAll();

        Mockito.verify(productRepository,Mockito.times(1)).findAll();
    }









}
