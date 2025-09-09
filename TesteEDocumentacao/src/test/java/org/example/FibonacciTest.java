package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciTest {

    @Test
    public void fibonacciElemento5Test() {
        Fibonacci fibonacci = new Fibonacci();
        assertEquals(5, fibonacci.encontrarElementoPD(5));
    }

    @Test
    public void fibonacciElemento8Test() {
        Fibonacci fibonacci = new Fibonacci();
        assertEquals(21, fibonacci.encontrarElementoPD(8));
    }

    @Test
    public void fibonacciElemento12Test() {
        Fibonacci fibonacci = new Fibonacci();
        assertEquals(144, fibonacci.encontrarElementoPD(12));
    }
}
