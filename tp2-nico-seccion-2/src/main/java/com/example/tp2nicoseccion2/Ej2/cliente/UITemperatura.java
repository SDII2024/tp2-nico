package com.example.tp2nicoseccion2.Ej2.cliente;

import com.example.tp2nicoseccion2.Ej2.temperatura.CelsiusToFahrenheitResponse;
import com.example.tp2nicoseccion2.Ej2.temperatura.FahrenheitToCelsiusResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;


@Component
public class UITemperatura {
    static Logger logger = LogManager.getLogger(UITemperatura.class);
    private final ClienteTemperatura clienteTemperatura;
    private JTextField inputA;
    private ButtonGroup btnOperadores;
    private JLabel labelResultado;

    @Autowired
    public UITemperatura(ClienteTemperatura clienteTemperatura) {
        this.clienteTemperatura = clienteTemperatura;
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
        JLabel labelA = new JLabel("Temperatura:");
        labelResultado = new JLabel("  ", SwingConstants.LEFT);
        inputA = new JTextField();
        JButton btnConvertir = new JButton("Convertir");

        Box boxOperadores = Box.createHorizontalBox();
        btnOperadores = new ButtonGroup();
        for (String operador : new String[]{"A Celcius", "A Fahrenheit"}) {
            JToggleButton btnOperador = new JToggleButton(operador);
            btnOperador.setActionCommand(operador);
            boxOperadores.add(btnOperador);
            btnOperadores.add(btnOperador);
        }

        btnConvertir.addActionListener(e -> convertir());

        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(labelA)
                .addComponent(inputA)
                .addComponent(boxOperadores)
                .addComponent(btnConvertir)
                .addComponent(labelResultado));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(labelA)
                .addComponent(inputA)
                .addComponent(boxOperadores)
                .addComponent(btnConvertir)
                .addComponent(labelResultado));

        frame.add(panel);
    }

    private void convertir() {
        try {
            String temp = inputA.getText();

            if (temp.isEmpty()) {
                labelResultado.setText("Ingrese el valor");
                return;
            }

            String oper = btnOperadores.getSelection().getActionCommand();

            String resultado;
            switch (oper) {
                case "A Celcius" -> {
                    FahrenheitToCelsiusResponse responseFtoC = clienteTemperatura.getCelsius(temp);
                    resultado = responseFtoC.getFahrenheitToCelsiusResult();
                }
                case "A Fahrenheit" -> {
                    CelsiusToFahrenheitResponse responseCtoF = clienteTemperatura.getFahrenheit(temp);
                    resultado = responseCtoF.getCelsiusToFahrenheitResult();
                }
                default -> {
                    labelResultado.setText("Operador no valido");
                    return;
                }
            }

            labelResultado.setText("Resultado: " + resultado);
        } catch (NumberFormatException ex) {
            labelResultado.setText("Los valores deben ser numeros");
        } catch (RuntimeException ex) {
            logger.error("Error al realizar la operacion: {}", ex.getMessage());
            labelResultado.setText("Error al realizar la operacion");
        }
    }
}
