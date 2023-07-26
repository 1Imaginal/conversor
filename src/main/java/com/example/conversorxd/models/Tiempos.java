package com.example.conversorxd.models;

public class Tiempos extends Conversible{
    private double minutosASegundos(double cantidad) {
        return cantidad * 60.0;
    }

    private double minutosAHoras(double cantidad) {
        return cantidad / 60.0;
    }

    private double minutosADias(double cantidad) {
        return cantidad / 1440.0;
    }

    private double minutosAMeses(double cantidad) {
        return cantidad / 43800.0;
    }

    private double minutosAAnhos(double cantidad) {
        return cantidad / 525600;
    }

    public double conversion(String metricaInicial, String metricaObjetivo, double cantidad) {
        double cantidadEnMinutos = 0;
        switch(metricaInicial) {
            case "Segundos":
                cantidadEnMinutos = cantidad / 60.0;
                break;
            case "Minutos":
                cantidadEnMinutos = cantidad;
                break;
            case "Horas":
                cantidadEnMinutos = cantidad * 60.0;
                break;
            case "Dias":
                cantidadEnMinutos = cantidad * 1440.0;
                break;
            case "Meses":
                cantidadEnMinutos = cantidad * 43800.0;
                break;
            case "Años":
                cantidadEnMinutos = cantidad * 525600;
        }
        if (metricaObjetivo == "Segundos") {
            return minutosASegundos(cantidadEnMinutos);
        } else if (metricaObjetivo == "Horas") {
            return minutosAHoras(cantidadEnMinutos);
        } else if (metricaObjetivo == "Dias") {
            return minutosADias(cantidadEnMinutos);
        } else if (metricaObjetivo == "Meses") {
            return minutosAMeses(cantidadEnMinutos);
        } else if (metricaObjetivo == "Años") {
            return minutosAAnhos(cantidadEnMinutos);
        } else {
            return cantidadEnMinutos;
        }
    }
}
