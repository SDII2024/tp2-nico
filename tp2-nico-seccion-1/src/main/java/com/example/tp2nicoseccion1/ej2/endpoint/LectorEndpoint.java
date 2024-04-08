package com.example.tp2nicoseccion1.ej2.endpoint;

import com.example.tp2nicoseccion1.ej2.service.LectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.webservicesoap.lector.Lector;
import org.webservicesoap.lector.LectorResponse;
@Endpoint
public class LectorEndpoint {
    private static final String NAMESPACE = "http://www.webservicesoap.org/lector";

    @Autowired
    private LectorService service = new LectorService();

    @PayloadRoot(localPart = "Lector", namespace = NAMESPACE)
    @ResponsePayload
    public LectorResponse Lector(@RequestPayload Lector request) {
        return service.consulta(request);
    }

}
