package com.example.tp2nicoseccion1.ej1.service;

import org.springframework.stereotype.Service;

import org.webservicesoap.convertidor.*;
@Service
public class ConvertidorService {
    public PesoDolarResponse pesoDolar(PesoDolar request){
        PesoDolarResponse PesoDolarResponse = new PesoDolarResponse();
        PesoDolarResponse.setDolar((request.getPeso()/1000));
        return PesoDolarResponse;
    }

    public DolarPesoResponse dolarPeso(DolarPeso request){
        DolarPesoResponse DolarPesoResponse = new DolarPesoResponse();
        DolarPesoResponse.setPeso((request.getDolar()*1000));
        return DolarPesoResponse;
    }
}
