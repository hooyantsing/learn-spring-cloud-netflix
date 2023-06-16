package xyz.hooy.order.feign.fallback;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExceptionStockFeignFallbackFactoryService implements FallbackFactory<ExceptionStockFeignFallbackService> {

    private final ExceptionStockFeignFallbackService exceptionStockFeignFallbackService;

    @Override
    public ExceptionStockFeignFallbackService create(Throwable cause) {
        System.err.println(cause.getMessage());
        return exceptionStockFeignFallbackService;
    }
}
