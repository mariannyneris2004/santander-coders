package com.example.calculadora.model;

import org.junit.Test;
import org.junit.Assert;
public class CalculadoraTest {

    @Test
    public void somaCorretamente(){
        Calculadora calculadora = new Calculadora(10, 20);
        Assert.assertEquals((Integer) 30, calculadora.somar());
    }

    @Test
    public void subtraiCorretamente(){
        Calculadora calculadora = new Calculadora(10, 20);
        Assert.assertNotEquals((Integer) 30, calculadora.subtrair());
    }

    @Test
    public void divideCorretamente(){
        Calculadora calculadora = new Calculadora(40, 20);
        Assert.assertNotNull(calculadora.dividir());
    }

    @Test
    public void multiplicaCorretamente(){
        Calculadora calculadora = new Calculadora(10, 20);
        Assert.assertEquals((Integer) 30, calculadora.somar());
    }

    @Test
    public void comparaCorretamente(){
        Calculadora calculadora = new Calculadora(30, 20);

        Assert.assertTrue(calculadora.comparacao());
    }

    @Test
    public void comparaCorretamenteException(){
        Calculadora calculadora = new Calculadora(10, 20);

        try {
            calculadora.comparacao();
            Assert.fail();
        } catch (Exception e) {
            Assert.assertEquals("O número b é maior que o número a.", e.getMessage());
        }
    }
}
