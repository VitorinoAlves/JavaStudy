package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtracking {

    public static List<List<Integer>> findSubsets(int [] s, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(s, n, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] s, int n, int start, List<Integer> currentSubset, List<List<Integer>> result) {
        // Caso base: Se o subconjunto atual tem o tamanho desejado.
        if (currentSubset.size() == n) {
            result.add(new ArrayList<>(currentSubset));
            return;
        }

        // Se o subconjunto atual + os elementos restantes não podem formar um subconjunto de tamanho n,
        // paramos a busca nesse ramo.
        if (currentSubset.size() + (s.length - start) < n) {
            return;
        }

        for (int i = start; i < s.length; i++) {
            currentSubset.add(s[i]);

            backtrack(s, n, i + 1, currentSubset, result);

            currentSubset.remove(currentSubset.size() -1);
        }


    }

    public static void main(String[] args) {
        // Exemplo 1
        int[] s1 = {1, 2, 3};
        int n1 = 2;
        System.out.println("Entrada: S = [1, 2, 3], n = 2");
        System.out.println("Saída: " + findSubsets(s1, n1));

        // Exemplo 2
        int[] s2 = {1, 2, 3, 4};
        int n2 = 1;
        System.out.println("\nEntrada: S = [1, 2, 3, 4], n = 1");
        System.out.println("Saída: " + findSubsets(s2, n2));

        // Exemplo 3
        int[] s3 = {1, 2, 3, 4, 5, 6};
        int n3 = 3;
        System.out.println("\nEntrada: S = [1, 2, 3, 4], n = 1");
        System.out.println("Saída: " + findSubsets(s3, n3));
    }
}



