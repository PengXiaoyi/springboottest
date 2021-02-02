package com.checkpeng.springboottest.controller;

import com.checkpeng.springboottest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/stock/deduct/withoutLock")
    public Object reduceStock(@RequestParam("id") int id) {

        orderService.reduceStock(id);

        return "ok:" + port;
    }

    @GetMapping("/stock/deduct/withRedisLock")
    public Object reduceStockWithoutRedisLock(@RequestParam("id") int id) {
        orderService.reduceStock(id);
        return "ok:" + port;
    }


    @GetMapping("/stock/deduct/withZKLock")
    public Object reduceStockWithoutZKLock(@RequestParam("id") int id) {
        orderService.reduceStock(id);
        return "ok:" + port;
    }


    @GetMapping("/stock/deduct/withSQLLock")
    public Object reduceStockWithSQLLock(@RequestParam("id") int id) {
        orderService.reduceStock(id);
        return "ok:" + port;
    }
}
