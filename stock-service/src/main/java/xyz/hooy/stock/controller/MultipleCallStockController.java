package xyz.hooy.stock.controller;

import org.springframework.web.bind.annotation.*;
import xyz.hooy.stock.model.OrderDTO;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/producer")
public class MultipleCallStockController {

    @GetMapping("/non-param")
    public String nonParam() {
        return "MacBook Pro";
    }

    @GetMapping("/query-string")
    public String queryString(@RequestParam String model, @RequestParam String number) {
        return "MODEL:" + model + " NUMBER" + number;
    }

    @GetMapping("/path-string/{name}")
    public Map<String, String> pathString(@PathVariable String name) {
        Map<String, String> param = new HashMap<>();
        param.put("name", name);
        param.put("brand", "Apple");
        return param;
    }

    @PostMapping("/body-map")
    public Map<String, String> bodyMap(@RequestBody Map<String, String> info) {
        info.put("key", "change");
        return info;
    }

    @PostMapping("/body-model")
    public OrderDTO bodyModel(@RequestBody OrderDTO order) {
        order.setName("change");
        return order;
    }
}
