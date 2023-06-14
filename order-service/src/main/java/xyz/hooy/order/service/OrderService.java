package xyz.hooy.order.service;

import java.util.Map;

public interface OrderService {

    String productName();

    String productModelNumber(String model, Integer number);

    Map<String, String> productParam(String name);
}
