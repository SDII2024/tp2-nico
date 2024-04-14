package com.example.tp2nicoseccion2.Ej2.config;

import com.example.tp2nicoseccion2.Ej2.cliente.ClienteTemperatura;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class TemperaturaConfiguration {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.example.tp2nicoseccion2.Ej2.temperatura");
        return marshaller;
    }

    @Bean
    public ClienteTemperatura clienteTemperatura(Jaxb2Marshaller marshaller) {
        ClienteTemperatura client = new ClienteTemperatura();
        client.setDefaultUri("https://www.w3schools.com/xml/tempconvert.asmx");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
