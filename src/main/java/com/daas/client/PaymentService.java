package com.daas.client;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/payment")
public class PaymentService {


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "DAAS :: Payment Service Payment successfully processed.";

    }

}
