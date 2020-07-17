package com.assignment.item.controller;

import com.assignment.item.constants.ApiConstants;
import com.assignment.item.dto.OrderItemDto;
import com.assignment.item.service.OrderItemService;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping(value = ApiConstants.ORDER_ITEM_API, produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderItemController {

  @Autowired
  OrderItemService orderItemService;

  @GetMapping("/{id}")
  public ResponseEntity<OrderItemDto> findById(@PathVariable Long id){
    return new ResponseEntity<OrderItemDto>(orderItemService.findById(id), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<OrderItemDto>> findAll(){
    return new ResponseEntity<List<OrderItemDto>>(orderItemService.findAll(), HttpStatus.CREATED);
  }

  @PostMapping
  public ResponseEntity<OrderItemDto> createOrder(@RequestBody @Valid final OrderItemDto orderItemDto){
    final OrderItemDto itemDto = orderItemService.createOrderItem(orderItemDto);
    return new ResponseEntity<>(itemDto, HttpStatus.CREATED);
  }

}
