package org.example;

public class Fatorial {

    public static long calculaFatorial(int n) {
        if (n == 1) {
            return n;
        }

        return calculaFatorial(n-1) * n;
    }

    public static void main(String[] args) {
        int n= 6;

        System.out.println("Elemento " + n + ": " + calculaFatorial(n));
    }
}
