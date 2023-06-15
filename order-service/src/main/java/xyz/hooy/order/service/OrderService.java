package xyz.hooy.order.service;

import xyz.hooy.order.model.OrderDTO;

import java.util.Map;

public interface OrderService {

    String nonParam();

    String queryString(String model, Integer number);

    Map<String, String> pathString(String name);

    Map<String, String> bodyMap(Map<String, String> info);

    OrderDTO bodyModel(OrderDTO order);
}
