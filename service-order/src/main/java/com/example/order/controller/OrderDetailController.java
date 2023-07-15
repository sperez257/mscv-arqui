package com.example.order.controller;

import com.example.order.dto.OrderInput;
import com.example.order.dto.TransactionDetails;
import com.example.order.entity.OrderDetail;
import com.example.order.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping("/orders/{userName}/{isSingleProductCheckout}")
    public void placeOrder(@PathVariable(name="userName") String userName, @PathVariable(name = "isSingleProductCheckout") boolean isSingleProductCheckout,
                           @RequestBody OrderInput orderInput) {
        orderDetailService.placeOrder(userName, orderInput, isSingleProductCheckout);
    }

    @GetMapping("/orders/{userName}")
    public List<OrderDetail> getOrderDetails(@PathVariable(name="userName") String userName) {
        return orderDetailService.getOrderDetails(userName);
    }

    @GetMapping("/orders/status/{status}")
    public List<OrderDetail> getAllOrderDetails(@PathVariable(name = "status") String status) {
        return orderDetailService.getAllOrderDetails(status);
    }

    @PutMapping("/orders/{orderId}/deliver")
    public void markOrderAsDelivered(@PathVariable(name = "orderId") Integer orderId) {
        orderDetailService.markOrderAsDelivered(orderId);
    }

    @PostMapping("/transactions/{amount}")
    public TransactionDetails createTransaction(@PathVariable(name = "amount") Double amount) {
        return orderDetailService.createTransaction(amount);
    }
}
