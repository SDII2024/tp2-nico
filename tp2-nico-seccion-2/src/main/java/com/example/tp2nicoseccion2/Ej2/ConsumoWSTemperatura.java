package com.example.tp2nicoseccion2.Ej2;

import com.example.tp2nicoseccion2.Ej2.cliente.UITemperatura;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Ejercicio 2 -  Consume servicio web "Temperatura"
 */
@Component
public class ConsumoWSTemperatura {
    private final UITemperatura uiTemperatura;

    @Autowired
    public ConsumoWSTemperatura(UITemperatura uiTemperatura) {
        this.uiTemperatura = uiTemperatura;
    }

    @PostConstruct
    public void iniciarInterfaz() {
        uiTemperatura.crearVentana();
    }

}
