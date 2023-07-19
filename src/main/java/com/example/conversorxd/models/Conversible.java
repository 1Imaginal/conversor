package com.example.conversorxd.models;

import java.util.Map;

public abstract class Conversible {
    double tasaCambio = 1;
    public double conversion(double cantidad) {
        return cantidad * this.tasaCambio;
    };

    public void setTasaCambio(Map mapa, String divisaObjetivo) {
        if (mapa.containsKey(divisaObjetivo)) {
            tasaCambio = (double) mapa.get(divisaObjetivo);
        }
    }
}
