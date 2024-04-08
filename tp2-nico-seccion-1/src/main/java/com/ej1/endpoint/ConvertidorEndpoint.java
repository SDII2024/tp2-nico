package com.ej1.endpoint;

import com.ej1.service.ConvertidorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import org.webservicesoap.convertidor.*;
@Endpoint
public class ConvertidorEndpoint {
    private static final String NAMESPACE = "http://www.webservicesoap.org/convertidor";

    @Autowired
    private ConvertidorService service;

    @PayloadRoot(localPart = "PesoDolar", namespace = NAMESPACE)
    @ResponsePayload
    public PesoDolarResponse PesoDolar(@RequestPayload PesoDolar request) {
        return service.pesoDolar(request);
    }

    @PayloadRoot(localPart = "DolarPeso", namespace = NAMESPACE)
    @ResponsePayload
    public DolarPesoResponse DolarPeso(@RequestPayload DolarPeso request) {
        return service.dolarPeso(request);
    }
}
