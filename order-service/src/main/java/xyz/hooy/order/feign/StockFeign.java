package xyz.hooy.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import xyz.hooy.order.model.OrderDTO;

import java.util.Map;

@FeignClient(value = "stock-service", path = "/stock")
public interface StockFeign {

    @GetMapping("/non-param")
    String nonParam();

    @GetMapping("/query-string")
    String queryString(@RequestParam String model, @RequestParam Integer number);

    @GetMapping("/path-string/{name}")
    Map<String, String> pathString(@PathVariable String name);

    @PostMapping("/body-map")
    Map<String, String> bodyMap(@RequestBody Map<String, String> info);

    @PostMapping("/body-model")
    OrderDTO bodyModel(@RequestBody OrderDTO order);
}
