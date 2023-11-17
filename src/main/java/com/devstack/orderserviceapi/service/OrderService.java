package com.devstack.orderserviceapi.service;

import com.devstack.orderserviceapi.dto.OrderDto;
import com.devstack.orderserviceapi.dto.ResponseOrderDto;

import java.util.List;

public interface OrderService {
    public void makeOrder(OrderDto dto);
    public ResponseOrderDto loadOrdersByCustomer(Long id);
}
