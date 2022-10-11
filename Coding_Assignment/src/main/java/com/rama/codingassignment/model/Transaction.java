package com.rama.codingassignment.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Transaction {
    private BigDecimal amount;
    private LocalDateTime dateTime;
    private String customerId;
}
