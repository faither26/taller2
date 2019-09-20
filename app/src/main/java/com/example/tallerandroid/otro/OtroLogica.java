package com.example.tallerandroid.otro;

public class OtroLogica extends Otro{

    public int validacion(){
        if (getPreguntas().equals(getRespuestas())){
            return 0;

        }else {
            return 1;
        }


    }

}
