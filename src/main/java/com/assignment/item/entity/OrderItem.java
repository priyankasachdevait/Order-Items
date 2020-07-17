package com.assignment.item.entity;

import com.assignment.item.constants.EntityConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = EntityConstants.ORDER_ITEM_TABLE)
public class OrderItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


//  @ToString.Exclude
//  @EqualsAndHashCode.Exclude
//  @ManyToOne(fetch = FetchType.LAZY, optional = false)
//  @JoinColumn(name = EntityConstants.ORDER_ID_MAPPING, nullable = false)
//  @JsonIgnore
//  private Order order;

  @Column
  private Long orderId;

  @Column
  private String productCode;

  @Column
  private String productName;

  @Column
  private int quantity;

}
