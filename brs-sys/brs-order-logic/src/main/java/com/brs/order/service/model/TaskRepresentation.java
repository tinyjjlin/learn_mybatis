package com.brs.order.service.model;

import lombok.Data;

/**
 * @author tiny lin
 * @date 2019/2/14
 */
@Data
public class TaskRepresentation {
    private String id;
    private String name;

    public TaskRepresentation(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
