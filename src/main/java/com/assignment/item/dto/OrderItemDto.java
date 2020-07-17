package com.assignment.item.dto;

import lombok.Data;

@Data
public class OrderItemDto {

  private String productCode;
  private String productName;
  private int quantity;
  private Long orderId;
}
