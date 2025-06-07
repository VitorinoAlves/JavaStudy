package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe a lista de pessoas seguindo esse formato 'Nome Pessoa - M, Nome Pessoa Dois - F':");
        String pessoasString = scanner.nextLine();

        List<String> listaMulheres = Arrays.stream(pessoasString.split(","))
                .map(String::trim)
                .filter(pessoa -> pessoa.endsWith("F"))
                .toList();

        System.out.println(listaMulheres);
        //Test Name One - M, Test Name Two - F, Test Name Three - M, Test Name Four - F, Test Name Five - F

    }
}