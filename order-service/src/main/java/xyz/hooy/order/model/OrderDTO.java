package xyz.hooy.order.model;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDTO {

    private Long id;
    private String name;
    private Date date;
}
