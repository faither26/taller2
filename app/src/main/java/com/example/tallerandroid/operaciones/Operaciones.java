package com.example.tallerandroid.operaciones;

public class Operaciones {
    private double numero1;
    private double numero2;
    private double resultado;
    private double operacion;

    public Operaciones() {
        this.numero1 = 0;
        this.numero2 = 0;
        this.operacion = 0;
        this.resultado = 0;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public double getNumero1() {
        return numero1;
    }

    public void setNumero1(double numero1) {
        this.numero1 = numero1;
    }

    public double getNumero2() {
        return numero2;
    }

    public void setNumero2(double numero2) {
        this.numero2 = numero2;
    }

    public double getOperacion() {
        return operacion;
    }

    public void setOperacion(double operacion) {
        this.operacion = operacion;
    }
}
