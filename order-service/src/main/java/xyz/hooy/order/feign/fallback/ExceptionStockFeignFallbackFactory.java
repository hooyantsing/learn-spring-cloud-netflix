package xyz.hooy.order.feign.fallback;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExceptionStockFeignFallbackFactory implements FallbackFactory<ExceptionStockFeignFallback> {

    private final ExceptionStockFeignFallback exceptionStockFeignFallback;

    @Override
    public ExceptionStockFeignFallback create(Throwable cause) {
        System.err.println(cause.getMessage());
        return exceptionStockFeignFallback;
    }
}
