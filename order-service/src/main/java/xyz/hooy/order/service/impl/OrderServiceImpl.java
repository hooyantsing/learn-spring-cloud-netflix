package xyz.hooy.order.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.hooy.order.feign.StockFeign;
import xyz.hooy.order.model.OrderDTO;
import xyz.hooy.order.service.OrderService;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final StockFeign stockFeign;

    @Override
    public String nonParam() {
        return stockFeign.nonParam();
    }

    @Override
    public String queryString(String model, Integer number) {
        return stockFeign.queryString(model, number);
    }

    @Override
    public Map<String, String> pathString(String name) {
        return stockFeign.pathString(name);
    }

    @Override
    public Map<String, String> bodyMap(Map<String, String> info) {
        return stockFeign.bodyMap(info);
    }

    @Override
    public OrderDTO bodyModel(OrderDTO order) {
        return stockFeign.bodyModel(order);
    }
}
