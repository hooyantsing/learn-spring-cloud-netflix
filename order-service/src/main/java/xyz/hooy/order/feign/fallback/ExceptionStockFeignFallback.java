package xyz.hooy.order.feign.fallback;

import org.springframework.stereotype.Component;
import xyz.hooy.order.feign.ExceptionStockFeign;

@Component
public class ExceptionStockFeignFallback implements ExceptionStockFeign {

    @Override
    public String timeout() {
        return "timeout exception [fallback]";
    }

    @Override
    public String serviceException() {
        return "service exception [fallback]";
    }
}
