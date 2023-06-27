package xyz.hooy.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import xyz.hooy.order.feign.fallback.ExceptionStockFeignFallback;

@FeignClient(value = "stock-service", path = "/producer", contextId = "exceptionStockFeign", fallback = ExceptionStockFeignFallback.class)
public interface ExceptionStockFeign {

    @GetMapping("/timeout")
    String timeout();

    @GetMapping("/service-exception")
    String serviceException();
}
