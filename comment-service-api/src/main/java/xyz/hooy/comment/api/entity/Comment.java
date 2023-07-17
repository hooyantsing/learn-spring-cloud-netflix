package xyz.hooy.comment.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment implements Serializable {

    private Long id;
    private Long detailId;
    private String name;
    private String content;
    private LocalDateTime timestamp;
}
