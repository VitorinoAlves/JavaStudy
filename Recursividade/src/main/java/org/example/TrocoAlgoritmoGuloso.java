package org.example;

import java.util.Arrays;
import java.util.Collections;

public class TrocoAlgoritmoGuloso {

    private static int calculateNumberCoins(Integer[] availableCoins, Integer changeValue) {
        Arrays.sort(availableCoins, Collections.reverseOrder());
        int numberOfCoins  = 0;
        int remainingChange  = changeValue;

        for (int coin : availableCoins) {
            while (remainingChange >= coin) {
                remainingChange -= coin;
                numberOfCoins++;
            }
        }

        if (remainingChange != 0) {
            return -1;
        }

        return numberOfCoins ;
    }

    public static void main(String[] args) {
        Integer[] availableCoins = {2, 5, 1};
        int changeValue = 18;
        System.out.println(calculateNumberCoins(availableCoins, changeValue));

        Integer[] availableCoinsSecond = {2, 5, 4};
        System.out.println(calculateNumberCoins(availableCoinsSecond, changeValue));
    }
}
