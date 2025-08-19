package org.example;

public class FatorialProgDinamica {

    private static final int MAX_ELEMENTOS =100;
    private static final long[] fatorialCache = new long[MAX_ELEMENTOS];

    public static long calculaFatorialPD(int n) {
        for (int i = 0; i < MAX_ELEMENTOS; i++) {
            fatorialCache[i] = -1;
        }

        return calculaFatorial(n);
    }

    public static long calculaFatorial(int n) {
        if (n == 1) {
            return n;
        }

        if (fatorialCache[n] != -1) {
            return fatorialCache[n];
        }

        fatorialCache[n] = calculaFatorial(n - 1) * n;

        return fatorialCache[n];
    }

    public static void main(String[] args) {
        int n= 6;

        System.out.println("Elemento " + n + ": " + calculaFatorialPD(n));
    }
}
