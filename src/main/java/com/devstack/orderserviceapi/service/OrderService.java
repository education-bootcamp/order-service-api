package com.devstack.orderserviceapi.service;

import com.devstack.orderserviceapi.dto.OrderDto;

import java.util.List;

public interface OrderService {
    public void makeOrder(OrderDto dto);
    public List<OrderDto> loadOrdersByCustomer(Long id);
}
