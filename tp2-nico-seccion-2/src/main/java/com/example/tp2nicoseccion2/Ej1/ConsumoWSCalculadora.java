package com.example.tp2nicoseccion2.Ej1;
import com.example.tp2nicoseccion2.Ej1.cliente.UICalculadora;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Ejercicio 1 -  Consume servicio web "Calculadora"
 */
@Component
public class ConsumoWSCalculadora {
    private final UICalculadora uiCalculadora;

    @Autowired
    public ConsumoWSCalculadora(UICalculadora uiCalculadora) {
        this.uiCalculadora = uiCalculadora;
    }

    @PostConstruct
    public void iniciarInterfaz() {
        uiCalculadora.crearVentana();
    }

}
