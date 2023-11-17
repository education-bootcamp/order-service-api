package com.devstack.orderserviceapi.api;

import com.devstack.orderserviceapi.dto.OrderDto;
import com.devstack.orderserviceapi.service.OrderService;
import com.devstack.orderserviceapi.util.StandardResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    /*
    * long code, String description, double unitPrice, int qtyOnHand
    * */
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping
    public ResponseEntity<StandardResponseEntity> makeOrder(
            @RequestBody OrderDto orderDto
            ){
        orderService.makeOrder(orderDto);
        return new ResponseEntity<>(
                new StandardResponseEntity(201,"Order saved!",orderDto),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/get-by-customer-id/{id}")
    public List<OrderDto> findOrdersByCustomer(
            @PathVariable Long id
    ){
        return orderService.loadOrdersByCustomer(id);
    }

}
