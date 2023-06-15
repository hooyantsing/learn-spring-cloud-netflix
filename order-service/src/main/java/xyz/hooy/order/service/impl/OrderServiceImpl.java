package xyz.hooy.order.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.hooy.order.feign.ExceptionStockFeign;
import xyz.hooy.order.feign.MultipleCallStockFeign;
import xyz.hooy.order.model.OrderDTO;
import xyz.hooy.order.service.OrderService;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MultipleCallStockFeign multipleCallStockFeign;

    private final ExceptionStockFeign exceptionStockFeign;

    @Override
    public String nonParam() {
        return multipleCallStockFeign.nonParam();
    }

    @Override
    public String queryString(String model, Integer number) {
        return multipleCallStockFeign.queryString(model, number);
    }

    @Override
    public Map<String, String> pathString(String name) {
        return multipleCallStockFeign.pathString(name);
    }

    @Override
    public Map<String, String> bodyMap(Map<String, String> info) {
        return multipleCallStockFeign.bodyMap(info);
    }

    @Override
    public OrderDTO bodyModel(OrderDTO order) {
        return multipleCallStockFeign.bodyModel(order);
    }

    @Override
    public String timeout() {
        return exceptionStockFeign.timeout();
    }

    @Override
    public String serviceException() {
        return exceptionStockFeign.serviceException();
    }
}
