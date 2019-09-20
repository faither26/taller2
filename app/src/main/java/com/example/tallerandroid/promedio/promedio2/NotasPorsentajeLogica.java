package com.example.tallerandroid.promedio.promedio2;

public class NotasPorsentajeLogica extends NotasPorsentaje {
    private double acum = 0;
    int a = 0;

     public double calcularPorsentaje(){
         if (a< this.getCantidad()){
             acum = acum + this.getNotaa();

             a++;
         }else{
             return acum;
         }
         return 0;
     }
}
