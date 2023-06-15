package xyz.hooy.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xyz.hooy.order.service.OrderService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/product/name")
    public String productName() {
        return orderService.productName();
    }

    @GetMapping("/product/model-number")
    public String productModelNumber() {
        return orderService.productModelNumber("A", 1528);
    }

    @GetMapping("/product/param")
    public Map<String, String> productParam() {
        return orderService.productParam("hooy");
    }

    @GetMapping("/product/info")
    public Map<String, String> productInfo() {
        Map<String, String> map = new HashMap<>();
        map.put("key", "no-change");
        map.put("value", "value");
        return orderService.productInfo(map);
    }
}
