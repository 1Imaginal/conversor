package com.example.conversorxd.models;

import java.util.HashMap;
import java.util.Map;

public class Divisas extends Conversible {
    public Divisas(String metricaInicial, String divisaObtejivo) {
        switch (metricaInicial) {

            case "MXN":
                Map<String, Double> peso = new HashMap<>();
                peso.put("USD", 0.059);
                peso.put("EUR", 0.053);
                peso.put("JPY" , 8.16);
                peso.put("GBP", 0.0045);
                peso.put("CAD", 0.078);
                setTasaCambio(peso, divisaObtejivo);
                break;

            case "USD":
                Map<String, Double> dolar = new HashMap<>();
                dolar.put("MXN", 17.04);
                dolar.put("EUR", 0.91);
                dolar.put("JPY" , 8.16);
                dolar.put("GBP", 0.0045);
                dolar.put("CAD", 0.078);
                setTasaCambio(dolar, divisaObtejivo);
                break;

            case "EUR":
                Map<String, Double> euro = new HashMap<>();
                euro.put("MXN", 18.78);
                euro.put("USD", 1.10);
                euro.put("JPY" , 8.16);
                euro.put("GBP", 0.0045);
                euro.put("CAD", 0.078);
                setTasaCambio(euro, divisaObtejivo);
                break;

            case "JPY":
                Map<String, Double> yen = new HashMap<>();
                yen.put("MXN", 0.12);
                yen.put("USD", 0.0072);
                yen.put("EUR" , 0.0064);
                yen.put("GBP", 0.0055);
                yen.put("CAD", 0.0095);
                setTasaCambio(yen, divisaObtejivo);;
                break;

            case "GBP":
                Map<String, Double> libra = new HashMap<>();
                libra.put("MXN", 21.92);
                libra.put("USD", 1.10);
                libra.put("EUR", 0.0045);
                libra.put("JPY" , 8.16);
                libra.put("CAD", 0.078);
                setTasaCambio(libra, divisaObtejivo);
                break;

            case "CAD":
                Map<String, Double> cad = new HashMap<>();
                cad.put("MXN", 18.78);
                cad.put("USD", 1.10);
                cad.put("EUR", 0.078);
                cad.put("JPY" , 8.16);
                cad.put("GBP", 0.0045);
                setTasaCambio(cad, divisaObtejivo);
                break;
        }
    }
}
