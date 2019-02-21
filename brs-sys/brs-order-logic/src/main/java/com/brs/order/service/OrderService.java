package com.brs.order.service;

import com.brs.order.persistence.dto.NewOrderDto;

/**
 * @author tiny lin
 * @date 2019/2/21
 */
public interface OrderService {
    /**
     * create new order
     * @param newOrderDto
     */
    void createNewOrder(NewOrderDto newOrderDto);
}
