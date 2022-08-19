package com.etiya.northwind.ServiceTestes;


import com.etiya.northwind.Business.Abstracts.OrderService;
import com.etiya.northwind.Business.Concretes.OrderManager;
import com.etiya.northwind.Business.Responses.Orders.OrderListResponse;
import com.etiya.northwind.Business.requests.orders.CreateOrderRequest;
import com.etiya.northwind.DataAccess.Abstracts.OrderRepository;
import com.etiya.northwind.DataAccess.Abstracts.mapping.ModelMapperManager;
import com.etiya.northwind.DataAccess.Abstracts.mapping.ModelMapperService;
import com.etiya.northwind.Entities.Concretes.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

public class OrderServiceTestes {
    private final CreateOrderRequest createOrderRequest = new CreateOrderRequest();
    private final OrderListResponse orderListResponse = new OrderListResponse();
    private OrderService orderService;
    private ModelMapper modelMapper;
    private ModelMapperService modelMapperService;
    private OrderRepository orderRepository;



    @BeforeEach
    public void setup(){
        modelMapper = new ModelMapper();
        modelMapperService = new ModelMapperManager(modelMapper);
        orderRepository = Mockito.mock(OrderRepository.class);
        orderService = new OrderManager(orderRepository,modelMapperService);
    }

    @Test
    public void add_order(){
        Order testOrder=modelMapperService.forRequest().map(createOrderRequest,Order.class);

        orderService.addOrder(createOrderRequest);

        Mockito.verify(orderRepository,Mockito.times(1)).save(testOrder);
    }

    @Test
    public void update_order_test(){
        Order expected = modelMapperService.forRequest().map(orderListResponse,Order.class);

         orderService.updateOrder(orderListResponse);

        Mockito.verify(orderRepository,Mockito.times(1)).save(Mockito.any());
    }

    @Test
    public void delete_order_test(){
        orderService.deleteOrder(Mockito.anyInt());
        Mockito.verify(orderRepository,Mockito.times(1)).deleteById(Mockito.anyInt());
    }

    @Test
    public void getall_order_test(){
        orderService.getAll();

        Mockito.verify(orderRepository,Mockito.times(1)).findAll();
    }



}
