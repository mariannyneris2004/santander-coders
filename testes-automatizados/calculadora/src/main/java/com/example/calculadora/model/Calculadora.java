package com.example.calculadora.model;

import com.example.calculadora.exceptions.ComparacaoException;

public class Calculadora {
    private Integer a;
    private Integer b;

    public Calculadora(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    public Integer somar(){
        return a + b;
    }

    public Integer subtrair(){
        return a - b;
    }

    public Integer dividir(){
        Double ad = (double) a;
        Double bd = (double) b;
        if (ad/bd > a/b){
            return null;
        }
        return a / b;
    }

    public Integer multiplicar(){
        return a * b;
    }

    public Double potencia(){
        return (Double) Math.pow(a, b);
    }

    public boolean comparacao(){
        if (a > b){
            return true;
        }
        throw new ComparacaoException("O número b é maior que o número a.");
    }
}
