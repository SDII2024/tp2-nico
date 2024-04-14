package com.example.tp2nicoseccion2.Ej2.cliente;

import com.example.tp2nicoseccion2.Ej1.calculadora.Add;
import com.example.tp2nicoseccion2.Ej1.calculadora.AddResponse;
import com.example.tp2nicoseccion2.Ej2.temperatura.CelsiusToFahrenheit;
import com.example.tp2nicoseccion2.Ej2.temperatura.CelsiusToFahrenheitResponse;
import com.example.tp2nicoseccion2.Ej2.temperatura.FahrenheitToCelsius;
import com.example.tp2nicoseccion2.Ej2.temperatura.FahrenheitToCelsiusResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class ClienteTemperatura  extends WebServiceGatewaySupport {
    private static final String URL = "https://www.w3schools.com/xml/tempconvert.asmx";

    private static final Logger log = LoggerFactory.getLogger(ClienteTemperatura.class);

    public CelsiusToFahrenheitResponse getFahrenheit(String celsius) {
        CelsiusToFahrenheit request = new CelsiusToFahrenheit();
        request.setCelsius(celsius);

        log.info("Invocando servicio de Celcius to Fahrenheit");

        String soapAction = "";

        return (CelsiusToFahrenheitResponse) getWebServiceTemplate()
                .marshalSendAndReceive(URL, request,
                        new SoapActionCallback(soapAction));
    }

    public FahrenheitToCelsiusResponse getCelsius(String fahrenheit) {
        FahrenheitToCelsius request = new FahrenheitToCelsius();
        request.setFahrenheit(fahrenheit);

        log.info("Invocando servicio de Fahrenheit to Celcius");

        String soapAction = "";

        return (FahrenheitToCelsiusResponse) getWebServiceTemplate()
                .marshalSendAndReceive(URL, request,
                        new SoapActionCallback(soapAction));
    }

}
