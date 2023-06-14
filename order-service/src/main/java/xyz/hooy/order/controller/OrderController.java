package xyz.hooy.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.hooy.order.service.OrderService;

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
    Map<String, String> productParam() {
        return orderService.productParam("hooy");
    }
}
