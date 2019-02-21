package com.brs.order.service;

import com.brs.order.persistence.dto.NewOrderDto;
import com.brs.order.persistence.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tiny lin
 * @date 2019/2/21
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private GenerateId generateId;


    @Override
    public void createNewOrder(NewOrderDto newOrderDto) {
        newOrderDto.setOrderId(generateId.generate());
            orderMapper.createNewOrder(newOrderDto);
    }
}
