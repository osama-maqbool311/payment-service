package com.daas.service;

import com.daas.client.BookingProxy;
import com.daas.dto.request.PaymentRequest;
import com.daas.dto.response.BookingResponse;
import com.daas.translator.PaymentTranslator;
import jakarta.enterprise.context.ApplicationScoped;

import com.daas.entity.Payment;
import com.daas.repository.PaymentRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PaymentService {

    @Inject
    PaymentRepository paymentRepository;

    @Inject
    PaymentTranslator paymentTranslator;


    @Transactional
    public Payment createPayment(final PaymentRequest paymentRequest) {
        Payment payment = paymentTranslator.toEntity(paymentRequest);
        paymentRepository.persist(payment);
        return payment;
    }
}
