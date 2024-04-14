package com.example.tp2nicoseccion2.Ej3;

import com.example.tp2nicoseccion2.Ej3.cliente.UIPaises;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Ejercicio 3 -  Consume servicio web "Paises"
 */
@Component
public class ConsumoWSPaises {
    private final UIPaises uiPaises;

    @Autowired
    public ConsumoWSPaises(UIPaises uiPaises) {
        this.uiPaises = uiPaises;
    }

    @PostConstruct
    public void iniciarInterfaz() {
        uiPaises.crearVentana();
    }
}
