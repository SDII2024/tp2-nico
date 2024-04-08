package com.example.tp2nicoseccion1.ej3.endpoint;

import com.example.tp2nicoseccion1.ej3.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.webservicesoap.login.Login;
import org.webservicesoap.login.LoginResponse;
@Endpoint
public class LoginEndpoint {
    private static final String NAMESPACE = "http://www.webservicesoap.org/login";

    @Autowired
    private LoginService service = new LoginService();

    @PayloadRoot(localPart = "Login", namespace = NAMESPACE)
    @ResponsePayload
    public LoginResponse Login(@RequestPayload Login request) {
        return service.validar(request);
    }
}
