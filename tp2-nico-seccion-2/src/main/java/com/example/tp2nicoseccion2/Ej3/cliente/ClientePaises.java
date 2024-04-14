package com.example.tp2nicoseccion2.Ej3.cliente;

import com.example.tp2nicoseccion2.Ej2.cliente.ClienteTemperatura;
import com.example.tp2nicoseccion2.Ej2.temperatura.CelsiusToFahrenheit;
import com.example.tp2nicoseccion2.Ej2.temperatura.CelsiusToFahrenheitResponse;
import com.example.tp2nicoseccion2.Ej3.paises.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class ClientePaises  extends WebServiceGatewaySupport {

    private static final String URL = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso";

    private static final Logger log = LoggerFactory.getLogger(ClientePaises.class);

    public ListOfCountryNamesByNameResponse paisesPorNombre() {
        ListOfCountryNamesByName request = new ListOfCountryNamesByName();

        log.info("Invocando servicio de Paises por Nombre");

        String soapAction = "";

        return (ListOfCountryNamesByNameResponse) getWebServiceTemplate()
                .marshalSendAndReceive(URL, request,
                        new SoapActionCallback(soapAction));
    }

    public CapitalCityResponse capital(String cod) {
        CapitalCity request = new CapitalCity();

        log.info("Invocando servicio de Capital de Ciudad");

        request.setSCountryISOCode(cod);

        String soapAction = "";

        return (CapitalCityResponse) getWebServiceTemplate()
                .marshalSendAndReceive(URL, request,
                        new SoapActionCallback(soapAction));
    }

    public CountryCurrencyResponse moneda(String cod) {
        CountryCurrency request = new CountryCurrency();

        log.info("Invocando servicio de Moneda de Pais");

        request.setSCountryISOCode(cod);

        String soapAction = "";

        return (CountryCurrencyResponse) getWebServiceTemplate()
                .marshalSendAndReceive(URL, request,
                        new SoapActionCallback(soapAction));
    }

    public CountryFlagResponse bandera(String cod) {
        CountryFlag request = new CountryFlag();

        log.info("Invocando servicio de Bandera de Pais");

        request.setSCountryISOCode(cod);

        String soapAction = "";

        return (CountryFlagResponse) getWebServiceTemplate()
                .marshalSendAndReceive(URL, request,
                        new SoapActionCallback(soapAction));
    }

    public CountryIntPhoneCodeResponse codigoTelefono(String cod) {
        CountryIntPhoneCode request = new CountryIntPhoneCode();

        log.info("Invocando servicio de Codigo Telefonico de Pais");

        request.setSCountryISOCode(cod);

        String soapAction = "";

        return (CountryIntPhoneCodeResponse) getWebServiceTemplate()
                .marshalSendAndReceive(URL, request,
                        new SoapActionCallback(soapAction));
    }

}
