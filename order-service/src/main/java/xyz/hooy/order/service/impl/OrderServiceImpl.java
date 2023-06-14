package xyz.hooy.order.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.hooy.order.feign.StockFeign;
import xyz.hooy.order.service.OrderService;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final StockFeign stockFeign;

    @Override
    public String productName() {
        return stockFeign.productName();
    }

    @Override
    public String productModelNumber(String model, Integer number){
        return stockFeign.productModelNumber(model,number);
    }

    public Map<String, String> productParam(String name){
        return stockFeign.productParam(name);
    }
}
