package com.assignment.item.service.mapper;

import com.assignment.item.dto.OrderItemDto;
import com.assignment.item.entity.OrderItem;

public class OrderMapper {

  public static OrderItem orderItemMapper(final OrderItemDto orderItemDto) {
    OrderItem item = new OrderItem();
    item.setProductCode(orderItemDto.getProductCode());
    item.setProductName(orderItemDto.getProductName());
    item.setQuantity(orderItemDto.getQuantity());
    item.setOrderId(orderItemDto.getOrderId());
    return item;

  }

  public static OrderItemDto orderItemDtoMapper(final OrderItem orderItem) {
    OrderItemDto item = new OrderItemDto();
    item.setProductCode(orderItem.getProductCode());
    item.setProductName(orderItem.getProductName());
    item.setQuantity(orderItem.getQuantity());
    item.setOrderId(orderItem.getOrderId());
    return item;
  }

}
