package com.example.tp2nicoseccion2.Ej1.cliente;

import org.tp2.seccion2.ejercicio1.calculadora.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;


public class CalculadoraCliente extends WebServiceGatewaySupport{

    private static final Logger log = LoggerFactory.getLogger(CalculadoraCliente.class);

    public AddResponse sumar(int nro1, int nro2) {
        Add request = new Add();

        request.setIntA(nro1);
        request.setIntB(nro2);

        log.info("Suma para: nro1=" + nro1 + " y nro2=" + nro2);

        AddResponse response = (AddResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", request,
                        new SoapActionCallback(
                                "http://tempuri.org/Add"));

        return response;
    }
    public SubtractResponse restar(int nro1, int nro2) {
        Subtract request = new Subtract();

        request.setIntA(nro1);
        request.setIntB(nro2);

        log.info("Resta para: nro1=" + nro1 + " y nro2=" + nro2);

        SubtractResponse response = (SubtractResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", request,
                        new SoapActionCallback(
                                "http://tempuri.org/Subtract"));

        return response;
    }
    public MultiplyResponse multiplicar(int nro1, int nro2) {
        Multiply request = new Multiply();

        request.setIntA(nro1);
        request.setIntB(nro2);

        log.info("Multiplicacion para: nro1=" + nro1 + " y nro2=" + nro2);

        MultiplyResponse response = (MultiplyResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", request,
                        new SoapActionCallback(
                                "http://tempuri.org/Multiply"));

        return response;
    }
    public DivideResponse dividir(int nro1, int nro2) {
        Divide request = new Divide();

        request.setIntA(nro1);
        request.setIntB(nro2);

        log.info("Divicion para: nro1=" + nro1 + " y nro2=" + nro2);

        DivideResponse response = (DivideResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", request,
                        new SoapActionCallback(
                                "http://tempuri.org/Divide"));

        return response;
    }
}
