package com.example.tp2nicoseccion2.Ej3.config;

import com.example.tp2nicoseccion2.Ej3.cliente.ClientePaises;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class PaisesConfiguration {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.example.tp2nicoseccion2.Ej3.paises");
        return marshaller;
    }

    @Bean
    public ClientePaises clientePaises(Jaxb2Marshaller marshaller) {
        ClientePaises client = new ClientePaises();
        client.setDefaultUri("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
