package com.example.tp2nicoseccion2.Ej3.cliente;


import com.example.tp2nicoseccion2.Ej3.paises.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;


@Component
public class UIPaises {
    static Logger logger = LogManager.getLogger(UIPaises.class);
    private final ClientePaises clientePaises;
    private JTextField inputA;
    private ButtonGroup btnOperadores;
    private JLabel labelResultado;

    @Autowired
    public UIPaises(ClientePaises clientePaises) {
        this.clientePaises = clientePaises;
    }


    public void crearVentana() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Convertidor Temperatura");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            iniciarComponentes(frame);
            frame.setSize(250, 250);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private void iniciarComponentes(JFrame frame) {
        JLabel labelA = new JLabel("Codigo Pais:");
        labelResultado = new JLabel("  ", SwingConstants.LEFT);
        inputA = new JTextField();
        JButton btnConsultar = new JButton("Consultar");

        Box boxOperadores = Box.createHorizontalBox();
        btnOperadores = new ButtonGroup();
        for (String operador : new String[]{"Lista Paises","Capital","Moneda","Codigo Telefono", "Bandera"}) {
            JToggleButton btnOperador = new JToggleButton(operador);
            btnOperador.setActionCommand(operador);
            boxOperadores.add(btnOperador);
            btnOperadores.add(btnOperador);
        }

        btnConsultar.addActionListener(e -> resultado());

        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(labelA)
                .addComponent(inputA)
                .addComponent(boxOperadores)
                .addComponent(btnConsultar)
                .addComponent(labelResultado));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(labelA)
                .addComponent(inputA)
                .addComponent(boxOperadores)
                .addComponent(btnConsultar)
                .addComponent(labelResultado));

        frame.add(panel);
    }

    private void resultado() {
        try {
            String cod = inputA.getText();

            if (cod.isEmpty()) {
                labelResultado.setText("Ingrese el codigo");
                return;
            }

            String oper = btnOperadores.getSelection().getActionCommand();

            String resultado;
            switch (oper) {
                case "Lista Paises" -> {
                    ListOfCountryNamesByNameResponse responseListCountry = clientePaises.paisesPorNombre();
                    labelResultado.setText("Resultado: " + responseListCountry.getListOfCountryNamesByNameResult());
                }
                case "Capital" -> {
                    CapitalCityResponse responseCapital = clientePaises.capital(cod);
                    resultado = responseCapital.getCapitalCityResult();
                    labelResultado.setText("Resultado: " + resultado);
                }
                case "Moneda" -> {
                    CountryCurrencyResponse responseCurrencey = clientePaises.moneda(cod);
                    resultado = String.valueOf(responseCurrencey.getCountryCurrencyResult());
                    labelResultado.setText("Resultado: " + resultado);
                }
                case "Codigo Telefono" -> {
                    CountryIntPhoneCodeResponse responseCodePhone = clientePaises.codigoTelefono(cod);
                    resultado = responseCodePhone.getCountryIntPhoneCodeResult();
                    labelResultado.setText("Resultado: " + resultado);
                }
                case "Bandera" -> {
                    CountryFlagResponse responseFlag = clientePaises.bandera(cod);
                    resultado = responseFlag.getCountryFlagResult();
                    labelResultado.setText("Resultado: " + resultado);
                }
                default -> {
                    labelResultado.setText("Operador no valido");
                    return;
                }
            }
        } catch (NumberFormatException ex) {
            labelResultado.setText("Los valores deben ser numeros");
        } catch (RuntimeException ex) {
            logger.error("Error al realizar la operacion: {}", ex.getMessage());
            labelResultado.setText("Error al realizar la operacion");
        }
    }
}
