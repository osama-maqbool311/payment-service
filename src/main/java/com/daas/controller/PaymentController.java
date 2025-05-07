package com.daas.controller;

import com.daas.dto.request.PaymentRequest;
import com.daas.service.PaymentService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path("/payment")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class PaymentController {

    private final PaymentService paymentService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPayment(final PaymentRequest paymentRequest) {
        return Response.ok(paymentService.createPayment(paymentRequest)).build();
    }
}
