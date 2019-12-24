package com.gzz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping
    public Order test1() {
        Order order = new Order();
        order.setPayTime(LocalDateTime.now());
        return order;
    }
}
