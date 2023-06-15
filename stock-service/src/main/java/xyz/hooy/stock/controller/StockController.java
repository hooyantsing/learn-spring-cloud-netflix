package xyz.hooy.stock.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/stock")
public class StockController {

    @GetMapping("/product/name")
    public String productName() {
        return "MacBook Pro";
    }

    @GetMapping("/product/model-number")
    public String productModelNumber(@RequestParam String model, @RequestParam String number) {
        return "MODEL:" + model + " NUMBER" + number;
    }

    @GetMapping("/product/param/{name}")
    public Map<String, String> productParam(@PathVariable String name) {
        Map<String, String> param = new HashMap<>();
        param.put("name", name);
        param.put("brand", "Apple");
        return param;
    }

    @PostMapping("/product/info")
    public Map<String, String> productInfo(@RequestBody Map<String, String> info) {
        info.put("key", "change");
        return info;
    }
}
