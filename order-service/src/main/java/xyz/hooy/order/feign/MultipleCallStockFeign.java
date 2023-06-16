package xyz.hooy.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import xyz.hooy.order.model.OrderDTO;

import java.util.Map;

@FeignClient(value = "stock-service", path = "/producer", contextId = "multipleCallStockFeign")
public interface MultipleCallStockFeign {

    /**
     * 无参调用
     */
    @GetMapping("/non-param")
    String nonParam();

    /**
     * QueryString 调用
     * 参数注解：@RequestParam
     */
    @GetMapping("/query-string")
    String queryString(@RequestParam String model, @RequestParam Integer number);

    /**
     * PathString 调用
     * 参数注解：@PathVariable
     */
    @GetMapping("/path-string/{name}")
    Map<String, String> pathString(@PathVariable String name);

    /**
     * RequestBody Map 调用
     * 参数注解：@RequestBody
     */
    @PostMapping("/body-map")
    Map<String, String> bodyMap(@RequestBody Map<String, String> info);

    /**
     * RequestBody JavaBean 调用
     * 参数注解：@RequestBody / @SpringQueryMap
     */
    @PostMapping("/body-model")
    OrderDTO bodyModel(@RequestBody OrderDTO order);
}
