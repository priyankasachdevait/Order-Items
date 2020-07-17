package com.assignment.item.service;

import com.assignment.item.dto.OrderItemDto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface OrderItemService {

  OrderItemDto findById(Long id);

  List<OrderItemDto> findAll();

  OrderItemDto createOrderItem(final OrderItemDto orderItemDto);
}
