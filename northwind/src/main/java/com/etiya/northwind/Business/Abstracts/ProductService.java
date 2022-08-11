package com.etiya.northwind.Business.Abstracts;

import com.etiya.northwind.Business.Responses.Orders.OrderListResponse;
import com.etiya.northwind.Business.Responses.Products.ProductListResponse;
import com.etiya.northwind.Business.requests.products.CreateProductRequest;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    DataResult<List<ProductListResponse>> getAll();
    void updateProduct(ProductListResponse productListResponse);
    void deleteProduct(int productId);
    ProductListResponse getProductById(int productId);
    Result addProduct(CreateProductRequest createProductRequest);

    Page<ProductListResponse> getAllByPage(int page, int size);
    Page<ProductListResponse>  getAllByPageWithField(int page,int size,String field);
    Page<ProductListResponse>  getAllByPageWithOrder(int page,int size,String field,String order);

}
