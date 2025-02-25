package com.systems.payment.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payments")
@Getter
@Setter
public class Payments extends BaseAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId; // Reference to Order
    private String method; // e.g., CREDIT_CARD, PAYPAL
    private Double amount;
    private String status; // e.g., SUCCESS, FAILED, PENDING
}

