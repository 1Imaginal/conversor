package com.example.conversorxd;

import com.example.conversorxd.models.Distancias;
import com.example.conversorxd.models.Divisas;
import com.example.conversorxd.models.Temperaturas;
import com.example.conversorxd.models.Tiempos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.util.converter.DoubleStringConverter;

import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

public class MainController implements Initializable {
    @FXML
    private Label tituloLabel;
    @FXML
    private Label metricaInicialLabel;
    @FXML
    private Label metricaObjetivoLabel;
    @FXML
    private Label resultadoLabel;

    @FXML
    private Spinner<Double> cantidad;

    @FXML
    private ChoiceBox<String> metricaInicialChoiceBox;
    @FXML
    private ChoiceBox<String> metricaObjetivoChoiceBox;

    private String[] opciones = {"MXN", "USD", "EUR", "JPY"};
    private String opcion = "Divisas";
    public void cambiarEscenaDistancias (ActionEvent event) throws IOException {
        opcion = "Distancias";
        tituloLabel.setText("Conversor de " + opcion);
        metricaInicialLabel.setText("Seleccione la distancia inicial");
        metricaObjetivoLabel.setText("Seleccione la distancia objetivo");
        metricaInicialChoiceBox.setValue(null);
        metricaObjetivoChoiceBox.setValue(null);
        String[] distancias = {"Centimetros", "Metros", "Kilometros", "Pulgadas", "Pies", "Millas"};
        opciones = distancias;
        metricaInicialChoiceBox.getItems().setAll(opciones);
        metricaObjetivoChoiceBox.getItems().setAll(opciones);
        metricaInicialChoiceBox.setValue("Metros");
        metricaObjetivoChoiceBox.setValue("Kilometros");
        resultadoLabel.setText("");
    }

    public void cambiarEscenaTemperaturas (ActionEvent event) throws IOException {
        opcion = "Temperaturas";
        tituloLabel.setText("Conversor de " + opcion);
        metricaInicialLabel.setText("Seleccione la temperatura inicial");
        metricaObjetivoLabel.setText("Seleccione la temperatura objetivo");
        metricaInicialChoiceBox.setValue(null);
        metricaObjetivoChoiceBox.setValue(null);
        String[] temperaturas = {"Celsios", "Farenheit", "Kelvin"};
        opciones = temperaturas;
        metricaInicialChoiceBox.getItems().setAll(opciones);
        metricaObjetivoChoiceBox.getItems().setAll(opciones);
        metricaInicialChoiceBox.setValue("Celsios");
        metricaObjetivoChoiceBox.setValue("Farenheit");
        resultadoLabel.setText("");
    }

    public void cambiarEscenaDivisas (ActionEvent event) throws IOException {
        opcion = "Divisas";
        tituloLabel.setText("Conversor de " + opcion);
        metricaInicialLabel.setText("Seleccione la divisa inicial");
        metricaObjetivoLabel.setText("Seleccione la divisa objetivo");
        metricaInicialChoiceBox.setValue(null);
        metricaObjetivoChoiceBox.setValue(null);
        String[] divisas = {"MXN", "USD", "EUR", "JPY", "GBP", "CAD"};
        opciones = divisas;
        metricaInicialChoiceBox.getItems().setAll(opciones);
        metricaObjetivoChoiceBox.getItems().setAll(opciones);
        metricaInicialChoiceBox.setValue("MXN");
        metricaObjetivoChoiceBox.setValue("USD");
        resultadoLabel.setText("");
    }
    public void cambiarEscenaTiempos (ActionEvent event) throws IOException {
        opcion = "Tiempos";
        tituloLabel.setText("Conversor de " + opcion);
        metricaInicialLabel.setText("Seleccione el tiempo inicial");
        metricaObjetivoLabel.setText("Seleccione el tiempo objetivo");
        metricaInicialChoiceBox.setValue(null);
        metricaObjetivoChoiceBox.setValue(null);
        String[] tiempos = {"Segundos", "Minutos", "Horas", "Dias", "Meses", "Años"};
        opciones = tiempos;
        metricaInicialChoiceBox.getItems().setAll(opciones);
        metricaObjetivoChoiceBox.getItems().setAll(opciones);
        metricaInicialChoiceBox.setValue("Segundos");
        metricaObjetivoChoiceBox.setValue("Minutos");
        resultadoLabel.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        metricaInicialChoiceBox.getItems().addAll(opciones);
        metricaInicialChoiceBox.setOnAction(this::getOpcionInicial);
        metricaInicialChoiceBox.setValue("MXN");
        metricaObjetivoChoiceBox.getItems().addAll(opciones);
        metricaObjetivoChoiceBox.setOnAction(this::getOpcionObjetivo);
        metricaObjetivoChoiceBox.setValue("USD");

        SpinnerValueFactory<Double> valueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(0.1,
                100000.0);
        valueFactory.setValue(1.0);
        NumberFormat format = NumberFormat.getNumberInstance();
        UnaryOperator<TextFormatter.Change> filter = cantidad -> {
            if (cantidad.isContentChange()) {
                ParsePosition parsePosition = new ParsePosition(0);
                format.parse(cantidad.getControlNewText(), parsePosition);
                if (parsePosition.getIndex() < cantidad.getControlNewText().length()) {
                    return null;
                }
            }
            return cantidad;
        };
        TextFormatter<Double> formatter = new TextFormatter<Double>(
                new DoubleStringConverter(),0.1, filter);
        cantidad.setValueFactory(valueFactory);
        cantidad.getEditor().setTextFormatter(formatter);
    }


    public void getOpcionInicial(ActionEvent event) {
        String opcion = metricaInicialChoiceBox.getValue();
        metricaInicialLabel.setText(opcion);
    }

    public void getOpcionObjetivo(ActionEvent event) {
        String opcion = metricaObjetivoChoiceBox.getValue();
        metricaObjetivoLabel.setText(opcion);
    }

    public void getResultado(KeyEvent event) {
        double resultado = 0;
        String metricaInicial = metricaInicialChoiceBox.getValue();
        String metricaObjetivo = metricaObjetivoChoiceBox.getValue();
        if (opcion == "Divisas") {
            Divisas conversion = new Divisas(metricaInicial, metricaObjetivo);
            resultado = conversion.conversion(cantidad.getValue());
        } else if (opcion == "Distancias") {
            Distancias conversion = new Distancias(metricaInicial, metricaObjetivo);
            resultado = conversion.conversion(cantidad.getValue());
        } else if (opcion == "Temperaturas"){
            Temperaturas conversion = new Temperaturas();
            resultado = conversion.conversion(cantidad.getValue(), metricaInicial, metricaObjetivo);
        } else {
            Tiempos conversion = new Tiempos();
            resultado = conversion.conversion(metricaInicial, metricaObjetivo, cantidad.getValue());
        }
        resultado = Double.parseDouble(String.format("%.4f", resultado));
        resultadoLabel.setText("El resultado es: " + resultado + " " + metricaObjetivo + "(s)");
    }
}
