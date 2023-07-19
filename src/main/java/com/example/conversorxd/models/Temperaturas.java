package com.example.conversorxd.models;

import java.util.Objects;

public class Temperaturas {
    public double conversion(double cantidad, String metricaInicial, String metricaObjetivo) {
        switch (metricaInicial) {
            case "Celsios":
                if (Objects.equals(metricaObjetivo, "Farenheit")) {
                    return (cantidad * (9.0/5) + 32);
                } else if (Objects.equals(metricaObjetivo, "Kelvin")) {
                    return cantidad + 273.15;
                }

            case "Farenheit":
                if (Objects.equals(metricaObjetivo, "Celsios")) {
                    return (cantidad - 32) * (5.0 /9);
                } else if (Objects.equals(metricaObjetivo, "Kelvin")) {
                    return (cantidad - 32) * (5.0 / 9) + 273.15;
                }

            case "Kelvin":
                if (Objects.equals(metricaObjetivo, "Celsios")) {
                    return cantidad - 273.15;
                } else if (Objects.equals(metricaObjetivo, "Farenheit")) {
                    return  (cantidad - 273.15) * (9.0/5) + 32;
                }
        }
        return cantidad;
    }

}