package com.daas.service;

import com.daas.dto.request.PaymentRequest;
import com.daas.translator.PaymentTranslator;
import jakarta.enterprise.context.ApplicationScoped;

import com.daas.entity.Payment;
import com.daas.repository.PaymentRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentTranslator paymentTranslator;

    @Transactional
    public Payment createPayment(final PaymentRequest paymentRequest) {
        Payment payment = paymentTranslator.toEntity(paymentRequest);
        paymentRepository.persist(payment);
        return payment;
    }
}
