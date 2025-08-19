package org.example;

public class Fibonacci {

    private static final int MAX_ELEMENTOS =100;
    private static final long[] elementosFib = new long[MAX_ELEMENTOS];

    public static long encontrarElementoPD(int n) {
        for (int i = 0; i < MAX_ELEMENTOS; i++) {
            elementosFib[i] = -1;
        }

        return encontrarElemento(n);
    }

    //4 = encontrarElemento(3) + encontrarElemento(2)
    //3 = encontrarElemento(2) + encontrarElemento(1)
    //2 = encontrarElemento(1) + encontrarElemento(0)
    //1 = return 1;
    public static long encontrarElemento(int n) {
        if (elementosFib[n] == -1){
            if(n <= 1) {
                elementosFib[n] = n;
            } else {
                elementosFib[n] = encontrarElemento( n - 1) + encontrarElemento( n - 2);
            }
        }

        return elementosFib[n];

    }

    public static void main(String[] args) {
        int n= 50;

        System.out.println("Elemento " + n + ": " + encontrarElementoPD(n));
    }
}
