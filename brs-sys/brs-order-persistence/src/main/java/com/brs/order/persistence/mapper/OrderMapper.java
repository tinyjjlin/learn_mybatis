package com.brs.order.persistence.mapper;

import com.brs.order.persistence.dto.NewOrderDto;
import org.apache.ibatis.annotations.Param;

/**
 * @author tiny lin
 * @date 2019/2/21
 */
public interface OrderMapper {

    void createNewOrder(@Param("newOrder") NewOrderDto newOrderDto) ;
}
