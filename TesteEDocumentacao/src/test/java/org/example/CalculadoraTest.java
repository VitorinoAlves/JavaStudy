package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {

    @Test
    public void adicionarTest(){
        Calculadora calculadora = new Calculadora();
        assertEquals(20, calculadora.adicionar(15, 5));
    }

    @Test
    public void subtrairTest(){
        Calculadora calculadora = new Calculadora();
        assertEquals(10, calculadora.subtrair(15, 5));
    }

    @Test
    public void multiplicarTest(){
        Calculadora calculadora = new Calculadora();
        assertEquals(25, calculadora.multiplicar(5, 5));
    }

    @Test
    public void dividirTest(){
        Calculadora calculadora = new Calculadora();
        assertEquals(5, calculadora.dividir(25, 5));
    }

    @Test
    public void divisaoByZeroTest(){
        Calculadora calculadora = new Calculadora();
        assertEquals(0, calculadora.dividir(25, 0));
    }
}
