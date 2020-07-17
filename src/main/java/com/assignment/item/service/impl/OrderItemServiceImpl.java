package com.assignment.item.service.impl;

import com.assignment.item.constants.ErrorMessageConstants;
import com.assignment.item.dto.OrderItemDto;
import com.assignment.item.entity.OrderItem;
import com.assignment.item.exception.ApplicationException;
import com.assignment.item.repository.OrderItemRepository;
import com.assignment.item.service.OrderItemService;
import com.assignment.item.service.mapper.OrderMapper;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class OrderItemServiceImpl implements OrderItemService {

  @Autowired
  OrderItemRepository orderItemRepository;

  @Override
  public OrderItemDto findById(Long id) {
    Optional<OrderItem> orderItem = this.orderItemRepository.findById(id);
    if (!orderItem.isPresent()) {
      throw new ApplicationException(
          String.format(ErrorMessageConstants.ORDER_ITEM_NOT_FOUND));
    }
    return OrderMapper.orderItemDtoMapper(orderItem.get());
  }

  @Override
  public List<OrderItemDto> findAll() {
    List<OrderItem> orderItems = this.orderItemRepository.findAll();
    if (CollectionUtils.isEmpty(orderItems)) {
      throw new ApplicationException(
          String.format(ErrorMessageConstants.NO_ORDERS_ITEM_FOUND));
    }
    List<OrderItemDto> orderItemDto = orderItems.stream()
        .map(e -> OrderMapper.orderItemDtoMapper(e)).collect(Collectors.toList());
    return orderItemDto;
  }

  @Override
  @Transactional
  public OrderItemDto createOrderItem(final OrderItemDto orderItemDto) {
    final OrderItem item =this.orderItemRepository.save(OrderMapper.orderItemMapper(orderItemDto));
    return OrderMapper.orderItemDtoMapper(item);
  }
}
