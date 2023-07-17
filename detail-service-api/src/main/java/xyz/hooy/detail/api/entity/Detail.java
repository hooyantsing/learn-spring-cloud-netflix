package xyz.hooy.detail.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Detail implements Serializable {

    private Long id;
    private Long orderId;
    private String name;
    private String introduction;
}
