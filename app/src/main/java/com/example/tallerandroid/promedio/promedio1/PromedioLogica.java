package com.example.tallerandroid.promedio.promedio1;

public class PromedioLogica extends Promedio {
    private double acum = 0;
    int a = 0;
    public double calcular() {

        if (a < this.getCantidad()) {

            acum = acum + this.getNotas();

            a++;
        }else {

            return acum / this.getCantidad();
        }
        return 0;
    }

}
