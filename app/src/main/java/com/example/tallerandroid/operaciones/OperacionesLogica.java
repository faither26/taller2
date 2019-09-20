package com.example.tallerandroid.operaciones;

public class OperacionesLogica extends Operaciones {
    public boolean mate() {

        boolean bandera;
        switch ((int) this.getOperacion()) {
            case 0:
                if (this.getResultado() == (this.getNumero1() + getNumero2())) {
                    return bandera = true;
                } else {
                    return bandera = false;
                }
            case 1:
                if (this.getResultado() == (this.getNumero1() - getNumero2())) {
                    return bandera = true;
                } else {
                    return bandera = false;
                }

            case 2:
                if (this.getResultado() == (this.getNumero1() * getNumero2())) {
                    return bandera = true;
                } else {
                    return bandera = false;
                }
            case 3:
                if (this.getResultado() == (this.getNumero1() / getNumero2())) {
                    return bandera = true;
                } else {
                    return bandera = false;
                }
            default:
                break;
        }
        return bandera = false;
    }





}
