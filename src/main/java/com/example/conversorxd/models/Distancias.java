package com.example.conversorxd.models;

import java.util.HashMap;
import java.util.Map;

public class Distancias  extends Conversible {
    public Distancias(String metricaInicial, String metricaObjetivo) {
        switch (metricaInicial) {

            case "Centimetros":
                Map<String, Double> centimetros = new HashMap<>();
                centimetros.put("Metros", 0.01);
                centimetros.put("Kilometros", 0.00001);
                centimetros.put("Millas",  0.0000062137119223733);
                centimetros.put("Pies", 0.0328084);
                centimetros.put("Pulgadas", 0.393701);
                setTasaCambio(centimetros, metricaObjetivo);
                break;

            case "Metros":
                Map<String, Double> metros = new HashMap<>();
                metros.put("Centimetros", 100.0);
                metros.put("Kilometros", 0.001);
                metros.put("Millas", 0.000621371);
                metros.put("Pies", 3.281);
                metros.put("Pulgadas", 39.37);
                setTasaCambio(metros, metricaObjetivo);
                break;

            case "Kilometros":
                Map<String, Double> kilometros = new HashMap<>();
                kilometros.put("Centimetros", 100000.0);
                kilometros.put("Metros", 1000.0);
                kilometros.put("Millas", 0.621371);
                kilometros.put("Pies", 3281.0);
                kilometros.put("Pulgadas", 39370.0);
                setTasaCambio(kilometros, metricaObjetivo);
                break;

            case "Millas":
                Map<String, Double> millas = new HashMap<>();
                millas.put("Centimetros", 160900.0);
                millas.put("Metros", 1609.34);
                millas.put("Kilometros", 1.60934);
                millas.put("Pies", 5280.0);
                millas.put("Pulgadas", 63360.0);
                setTasaCambio(millas, metricaObjetivo);
                break;

            case "Pies":
                Map<String, Double> pies = new HashMap<>();
                pies.put("Centimetros", 30.48);
                pies.put("Metros", 0.3048);
                pies.put("Kilometros", 0.0003048);
                pies.put("Millas", 0.000189394);
                pies.put("Pulgadas", 100.0);
                setTasaCambio(pies, metricaObjetivo);
                break;

            case "Pulgadas":
                Map<String, Double> pulgadas = new HashMap<>();
                pulgadas.put("Centimetros", 2.54);
                pulgadas.put("Metros", 0.0254);
                pulgadas.put("Kilometros", 0.0000254);
                pulgadas.put("Millas", 0.0000157828);
                pulgadas.put("Pies", 0.0833333);
                setTasaCambio(pulgadas, metricaObjetivo);
                break;
        }
    }
}
