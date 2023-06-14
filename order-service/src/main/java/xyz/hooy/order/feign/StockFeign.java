package xyz.hooy.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "stock-service", path = "/stock")
public interface StockFeign {

    @GetMapping("/product/name")
    String productName();

    @GetMapping("/product/model-number")
    String productModelNumber(@RequestParam String model, @RequestParam Integer number);

    @GetMapping("/product/{name}")
    Map<String, String> productParam(@PathVariable String name);
}
