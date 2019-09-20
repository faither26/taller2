package com.example.tallerandroid.promedio.promedio1;

public class Promedio {
    int cantidad;
    double notas;
    int a = 0;

    public int getA() {
        return a;
    }

    public Promedio() {
        this.cantidad = 0;
        this.notas = 0;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getNotas() {
        return notas;
    }

    public void setNotas(double notas) {
        this.notas = notas;
    }
}
