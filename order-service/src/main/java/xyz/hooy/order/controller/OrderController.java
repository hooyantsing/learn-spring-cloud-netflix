package xyz.hooy.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xyz.hooy.order.model.OrderDTO;
import xyz.hooy.order.service.OrderService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/non-param")
    public String testNonParam() {
        return orderService.nonParam();
    }

    @GetMapping("/query-string")
    public String testQueryString() {
        return orderService.queryString("A", 1528);
    }

    @GetMapping("/path-string")
    public Map<String, String> testPathString() {
        return orderService.pathString("hooy");
    }

    @GetMapping("/body-map")
    public Map<String, String> testBodyMap() {
        Map<String, String> map = new HashMap<>();
        map.put("key", "no-change");
        map.put("value", "value");
        return orderService.bodyMap(map);
    }

    @GetMapping("/body-model")
    public OrderDTO testBodyModel() {
        OrderDTO order = new OrderDTO();
        order.setId(1L);
        order.setName("hooy");
        order.setDate(new Date());
        return orderService.bodyModel(order);
    }
}
